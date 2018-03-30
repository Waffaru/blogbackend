package fi.pizzalovers.blogbackend;

import org.springframework.data.jpa.repository.JpaRepository;

interface MyRepoBlogPost extends JpaRepository<BlogPost, Long> {

}
