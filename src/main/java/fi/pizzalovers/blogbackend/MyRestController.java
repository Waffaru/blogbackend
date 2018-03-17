package fi.pizzalovers.blogbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MyRestController {

    @Autowired
    MyRepo blogPostRepo;

    // TODO muokkaa valuet kun tiedetään mitä tarvitaan
    //curl -v -H "Content-type: application/json" -X POST -d "{}" http://localhost:8080/blogpost
    @RequestMapping(value = "/blogpost", method = RequestMethod.POST)
    public synchronized void SaveBlogPost(@RequestBody BlogPost x){
        blogPostRepo.save(x);
    }
    //curl -v http://localhost:8080/blogPost
    @RequestMapping(value = "/blogpost", method = RequestMethod.GET)
    public Iterable<BlogPost> get(){
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


}
