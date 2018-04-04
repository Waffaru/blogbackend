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
		userDatabase.save(ryhis);
		User gonza = new User("Gonza","Salasana");
		gonza.adminRights = true;
		userDatabase.save(gonza);
		commentDatabase.save(new Comment("Hei kaikki","Ryhis",2l));
        commentDatabase.save(new Comment("kaikki on kivaa","Ryhis",2l));
        commentDatabase.save(new Comment("pinky & brain","Ryhis",2l));
        commentDatabase.save(new Comment("kummeli on paras","Ryhis",2l));
        commentDatabase.save(new Comment("Eka???!?","Ryhis",2l));
        commentDatabase.save(new Comment("Gonza","Ryhis",2l));
        commentDatabase.save(new Comment("Juhannus on kesällä?","Ryhis",2l));

	}
}
