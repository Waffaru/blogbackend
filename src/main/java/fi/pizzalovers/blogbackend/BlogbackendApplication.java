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
		blogDatabase.save(new BlogPost("Make Pizza lika a pro","Sed ultricies, augue id pharetra tempor, mi ex finibus neque, et varius arcu augue id diam. Vivamus commodo non leo at gravida. Suspendisse tempor, nibh sed tristique dictum, enim augue ultricies lorem, vitae scelerisque dui massa sed risus. Donec dignissim, odio vitae lacinia fringilla, nisl sem varius arcu, quis posuere nisl tellus sed nunc. Nulla auctor, eros non imperdiet feugiat, libero nisi pulvinar velit, vitae sollicitudin ligula ante vitae sapien. Sed vulputate orci ut neque eleifend condimentum. Nullam eget libero congue, euismod turpis vel, mattis augue. Aliquam consequat diam nibh, in ullamcorper nunc rhoncus nec. Proin turpis mi, pulvinar a est nec, aliquam lacinia ante. Maecenas eleifend turpis mauris, sit amet dapibus erat sollicitudin pretium. Nulla cursus iaculis dapibus. Sed bibendum maximus ante eu ullamcorper.", "Jack"));
		blogDatabase.save(new BlogPost("10 things to know while making pizza","Sed ultricies, augue id pharetra tempor, mi ex finibus neque, et varius arcu augue id diam. Vivamus commodo non leo at gravida. Suspendisse tempor, nibh sed tristique dictum, enim augue ultricies lorem, vitae scelerisque dui massa sed risus. Donec dignissim, odio vitae lacinia fringilla, nisl sem varius arcu, quis posuere nisl tellus sed nunc. Nulla auctor, eros non imperdiet feugiat, libero nisi pulvinar velit, vitae sollicitudin ligula ante vitae sapien. Sed vulputate orci ut neque eleifend condimentum. Nullam eget libero congue, euismod turpis vel, mattis augue. Aliquam consequat diam nibh, in ullamcorper nunc rhoncus nec. Proin turpis mi, pulvinar a est nec, aliquam lacinia ante. Maecenas eleifend turpis mauris, sit amet dapibus erat sollicitudin pretium. Nulla cursus iaculis dapibus. Sed bibendum maximus ante eu ullamcorper.", "Jack"));
		blogDatabase.save(new BlogPost("DO THIS when baking pizza dough","Sed ultricies, augue id pharetra tempor, mi ex finibus neque, et varius arcu augue id diam. Vivamus commodo non leo at gravida. Suspendisse tempor, nibh sed tristique dictum, enim augue ultricies lorem, vitae scelerisque dui massa sed risus. Donec dignissim, odio vitae lacinia fringilla, nisl sem varius arcu, quis posuere nisl tellus sed nunc. Nulla auctor, eros non imperdiet feugiat, libero nisi pulvinar velit, vitae sollicitudin ligula ante vitae sapien. Sed vulputate orci ut neque eleifend condimentum. Nullam eget libero congue, euismod turpis vel, mattis augue. Aliquam consequat diam nibh, in ullamcorper nunc rhoncus nec. Proin turpis mi, pulvinar a est nec, aliquam lacinia ante. Maecenas eleifend turpis mauris, sit amet dapibus erat sollicitudin pretium. Nulla cursus iaculis dapibus. Sed bibendum maximus ante eu ullamcorper.", "Jack"));
		blogDatabase.save(new BlogPost("Why Ryhänen is pizza god","Sed ultricies, augue id pharetra tempor, mi ex finibus neque, et varius arcu augue id diam. Vivamus commodo non leo at gravida. Suspendisse tempor, nibh sed tristique dictum, enim augue ultricies lorem, vitae scelerisque dui massa sed risus. Donec dignissim, odio vitae lacinia fringilla, nisl sem varius arcu, quis posuere nisl tellus sed nunc. Nulla auctor, eros non imperdiet feugiat, libero nisi pulvinar velit, vitae sollicitudin ligula ante vitae sapien. Sed vulputate orci ut neque eleifend condimentum. Nullam eget libero congue, euismod turpis vel, mattis augue. Aliquam consequat diam nibh, in ullamcorper nunc rhoncus nec. Proin turpis mi, pulvinar a est nec, aliquam lacinia ante. Maecenas eleifend turpis mauris, sit amet dapibus erat sollicitudin pretium. Nulla cursus iaculis dapibus. Sed bibendum maximus ante eu ullamcorper.", "Jack"));
		blogDatabase.save(new BlogPost("Did Ryhänen drive Gonzalo to condemnation by showing him easy way to make pizza","Sed ultricies, augue id pharetra tempor, mi ex finibus neque, et varius arcu augue id diam. Vivamus commodo non leo at gravida. Suspendisse tempor, nibh sed tristique dictum, enim augue ultricies lorem, vitae scelerisque dui massa sed risus. Donec dignissim, odio vitae lacinia fringilla, nisl sem varius arcu, quis posuere nisl tellus sed nunc. Nulla auctor, eros non imperdiet feugiat, libero nisi pulvinar velit, vitae sollicitudin ligula ante vitae sapien. Sed vulputate orci ut neque eleifend condimentum. Nullam eget libero congue, euismod turpis vel, mattis augue. Aliquam consequat diam nibh, in ullamcorper nunc rhoncus nec. Proin turpis mi, pulvinar a est nec, aliquam lacinia ante. Maecenas eleifend turpis mauris, sit amet dapibus erat sollicitudin pretium. Nulla cursus iaculis dapibus. Sed bibendum maximus ante eu ullamcorper.", "Jack"));
		blogDatabase.save(new BlogPost("I ran out of ideas, something something","Sed ultricies, augue id pharetra tempor, mi ex finibus neque, et varius arcu augue id diam. Vivamus commodo non leo at gravida. Suspendisse tempor, nibh sed tristique dictum, enim augue ultricies lorem, vitae scelerisque dui massa sed risus. Donec dignissim, odio vitae lacinia fringilla, nisl sem varius arcu, quis posuere nisl tellus sed nunc. Nulla auctor, eros non imperdiet feugiat, libero nisi pulvinar velit, vitae sollicitudin ligula ante vitae sapien. Sed vulputate orci ut neque eleifend condimentum. Nullam eget libero congue, euismod turpis vel, mattis augue. Aliquam consequat diam nibh, in ullamcorper nunc rhoncus nec. Proin turpis mi, pulvinar a est nec, aliquam lacinia ante. Maecenas eleifend turpis mauris, sit amet dapibus erat sollicitudin pretium. Nulla cursus iaculis dapibus. Sed bibendum maximus ante eu ullamcorper.", "Jack"));
		User ryhis = new User("Ryhis","salasana");
		ryhis.adminRights = true;
		userDatabase.save(ryhis);
		User gonza = new User("Gonza","salasana");
		gonza.adminRights = true;
		userDatabase.save(gonza);
		User test = new User("","");
		test.adminRights = true;
		userDatabase.save(test);

	}
}
