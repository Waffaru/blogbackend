package fi.pizzalovers.blogbackend;

import org.springframework.data.jpa.repository.JpaRepository;
public interface MyRepo extends JpaRepository<BlogPost, Long> {

}
