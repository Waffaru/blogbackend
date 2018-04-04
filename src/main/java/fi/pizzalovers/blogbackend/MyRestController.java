package fi.pizzalovers.blogbackend;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MyRestController {
    @Configuration
    public class MyConfiguration {

        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurerAdapter() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
                }
            };
        }
    }

    @Autowired
    MyRepoBlogPost blogPostRepo;
    @Autowired
    MyRepoUser usersRepo;
    @Autowired
    MyRepoComment commentRepo;
    @Autowired
    MyRepoLogin loginRepo;
    //TODO fix that you cant create empty users or blogposts

    //curl -v -H "Content-type: application/json" -X POST -d "{}" http://localhost:8080/blogpost
    @RequestMapping(value = "/blogpost", method = RequestMethod.POST)
    public synchronized void SaveBlogPost(@RequestBody BlogPost x){
        if(x.getBody() != null){
            blogPostRepo.save(x);
        }
    }

    //curl -v http://localhost:8080/blogpost
    @RequestMapping(value = "/blogpost", method = RequestMethod.GET)
    public Iterable<BlogPost> getBlog(){
        return blogPostRepo.findAll();
    }

    //curl -v http://localhost:8080/blogPost/2
    @RequestMapping(value = "/blogpost/{blogId}", method = RequestMethod.GET)
    public Optional<BlogPost> getBlog(@PathVariable long blogId){
        return blogPostRepo.findById(blogId);
    }

    //curl -X DELETE http://localhost:8080/blogpost/2
    @RequestMapping(value = "/blogpost/{blogId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable long blogId){
        blogPostRepo.deleteById(blogId);
    }

    @RequestMapping(value = "/blogpost/{blogId}/edit", method = RequestMethod.POST)
    public void updatePost(@PathVariable long blogId, @RequestBody BlogPost tmp) {
        BlogPost postToUpdate = blogPostRepo.getOne(blogId);
        if(tmp.getTitle() != null) {
            postToUpdate.setTitle(tmp.getTitle());
        }
        if(tmp.getBody() != null) {
            postToUpdate.setBody(tmp.getBody());
        }
        blogPostRepo.save(postToUpdate);
    }

    //curl -v -H "Content-type: application/json" -X POST -d "{\"username\": \"teukkaa\",\"password\": \"kolmonen\"}" http://localhost:8080/user
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public synchronized void SaveUser(@RequestBody User x){
        if(x.getUsername() == null || x.password == null){

        }else{
            usersRepo.save(x);
        }
    }

    //curl -v http://localhost:8080/user
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Iterable<User> getUsers(){
        return usersRepo.findAll();
    }

    //curl -v http://localhost:8080/user/2
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Optional<User> getUser(@PathVariable long userId){
        return usersRepo.findById(userId);
    }

    //curl -v -H "Content-type: application/json" -X POST -d "{\"username\": \"teukkaa\",\"password\": \"kolmonen\"}" http://localhost:8080/user
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public synchronized void saveComment(@RequestBody Comment x){
        commentRepo.save(x);
    }

    //curl -v http://localhost:8080/user
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public Iterable<Comment> getComments(){
        return commentRepo.findAll();
    }

    //curl -v http://localhost:8080/user/2
    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.GET)
    public Optional<Comment> getCommentByCommentId(@PathVariable long commentId){
        return commentRepo.findById(commentId);
    }
    @RequestMapping(value = "/comment/byPostId/{postId}", method = RequestMethod.POST)
    public List<Comment> getCommentByPostId(@PathVariable long postId, @RequestBody Comment tmp){
        tmp.getBlogpostId();
        List<Comment> e = new ArrayList<>();
        for(Comment x :commentRepo.findAll()){
            if(x.getBlogpostId() == postId){
                e.add(x);
            }
        }
        return e;
    }
    //curl -v http://localhost:8080/comment/3/dislike
    @RequestMapping(value = "/comment/{commentId}/dislike", method = RequestMethod.GET)
    public void setdislike(@PathVariable long commentId){

        Comment temp = commentRepo.getOne(commentId);
        temp.setDislikes(temp.getDislikes() + 1l);
        commentRepo.save(temp);
    }

    //curl -v http://localhost:8080/user
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public synchronized boolean login(@RequestBody User x) {
        if(x.username.equals("Ryhis")&&x.password.equals("salasana") || x.username.equals("Gonza")&&x.password.equals("salasana") ){
            return true;
        }else{
            return false;
        }
    }


}
