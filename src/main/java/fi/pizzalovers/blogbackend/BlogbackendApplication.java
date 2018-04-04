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
		User ryhis = new User("Ryhis","salasana");
		ryhis.adminRights = true;
        System.out.println(ryhis.password);
		userDatabase.save(ryhis);
		User gonza = new User("Gonza","salasana");
		gonza.adminRights = true;
		userDatabase.save(gonza);
		commentDatabase.save(new Comment("moi1","testi1",12l));
        commentDatabase.save(new Comment("moi2","testi2",12l));
        commentDatabase.save(new Comment("moi3","testi3",13l));
        commentDatabase.save(new Comment("moi4","testi4",13l));
        commentDatabase.save(new Comment("moi5","testi5",12l));
        commentDatabase.save(new Comment("moi6","testi6",15l));
        commentDatabase.save(new Comment("moi7","testi7",15l));
        commentDatabase.save(new Comment("moi8","testi8",15l));


	}
}
