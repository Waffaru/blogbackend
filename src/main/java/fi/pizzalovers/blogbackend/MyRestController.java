package fi.pizzalovers.blogbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MyRestController {

    @Autowired
    MyRepo blogPostRepo;

    // TODO muokkaa valuet kun tiedetään mitä tarvitaan
    //curl -v -H "Content-type: application/json" -X POST -d "{\"name\":\"jampperi9\"}" http://localhost:8080/customers
    @RequestMapping(value = "/blogPost", method = RequestMethod.POST)
    public synchronized void SaveBlogPost(@RequestBody BlogPost x){
        blogPostRepo.save(x);
    }
    //curl -v http://localhost:8080/blogPost
    @RequestMapping(value = "/blogPost", method = RequestMethod.GET)
    public Iterable<BlogPost> get(){
        return blogPostRepo.findAll();
    }
    //curl -v http://localhost:8080/blogPost/2
    @RequestMapping(value = "/blogPost/{blogId}", method = RequestMethod.GET)
    public Optional<BlogPost> getBlog(@PathVariable int blogId){
        return blogPostRepo.findById(blogId);
    }
    //curl -X DELETE http://localhost:8080/blogPost/2
    @RequestMapping(value = "/blogPost/{blogId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int blogId){
        blogPostRepo.deleteById(blogId);
    }


}
