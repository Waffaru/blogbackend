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
		blogDatabase.save(new BlogPost("CSS on helppoa ja kivaa","Kannattaa opiskella, saa hienoja värejä aikaan", "Jack"));
		User ryhis = new User("Ryhis","salasana");
		ryhis.adminRights = true;
        System.out.println(ryhis.password);
		userDatabase.save(ryhis);
		User gonza = new User("Gonza","salasana");
		gonza.adminRights = true;
		userDatabase.save(gonza);
		commentDatabase.save(new Comment("Tää on ihan paras!","Mikko",1l));
        commentDatabase.save(new Comment("En tue maailmankatsomustasi","Maija",1l));
        commentDatabase.save(new Comment("@2 elä itke","Tuija",1l));
        commentDatabase.save(new Comment("EKA!","Paavo",1l));
        commentDatabase.save(new Comment("Paljo viive?","Taneli",1l));



	}
}
