package fi.pizzalovers.blogbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class BlogbackendApplication {

	@Autowired
	EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(BlogbackendApplication.class, args);
	}
}
