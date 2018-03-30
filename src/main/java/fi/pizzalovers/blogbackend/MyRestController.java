package fi.pizzalovers.blogbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

    //curl -v -H "Content-type: application/json" -X POST -d "{}" http://localhost:8080/blogpost
    @RequestMapping(value = "/blogpost", method = RequestMethod.POST)
    public synchronized void SaveBlogPost(@RequestBody BlogPost x){
        blogPostRepo.save(x);
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

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public synchronized void SaveUser(@RequestBody User x){
        usersRepo.save(x);
    }
    //curl -v http://localhost:8080/blogpost
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Iterable<User> getUser(){
        return usersRepo.findAll();
    }
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Optional<User> getUser(@PathVariable long userId){
        return usersRepo.findById(userId);
    }

}
