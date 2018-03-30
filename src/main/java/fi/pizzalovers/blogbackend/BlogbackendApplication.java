package fi.pizzalovers.blogbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.Date;

@SpringBootApplication
public class BlogbackendApplication implements CommandLineRunner {

	@Autowired
	EntityManager entityManager;
	@Autowired
	MyRepoBlogPost blogDatabase;
    @Autowired
    MyRepoUser userDatabase;

	public static void main(String[] args) {
		SpringApplication.run(BlogbackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		blogDatabase.save(new BlogPost("Test","This is test content", "Jack"));
		userDatabase.save(new User("teukka1","kolme1"));
	}
}
