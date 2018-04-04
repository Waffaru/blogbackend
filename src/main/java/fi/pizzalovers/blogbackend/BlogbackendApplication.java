package fi.pizzalovers.blogbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class BlogbackendApplication implements CommandLineRunner {

	@Autowired
	EntityManager entityManager;
	@Autowired
	MyRepoBlogPost blogDatabase;
    @Autowired
    MyRepoUser userDatabase;
    @Autowired
    MyRepoComment commentDatabase;

	public static void main(String[] args) {
		SpringApplication.run(BlogbackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		blogDatabase.save(new BlogPost("Test","This is test content", "Jack"));
		User ryhis = new User("Ryhis","Salasana");
		ryhis.adminRights = true;
        System.out.println(ryhis.password);
		userDatabase.save(ryhis);
		User gonza = new User("Gonza","Salasana");
		gonza.adminRights = true;
		userDatabase.save(gonza);
	}
}
