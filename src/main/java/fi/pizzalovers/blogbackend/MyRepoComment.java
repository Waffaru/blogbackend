package fi.pizzalovers.blogbackend;

import org.springframework.data.jpa.repository.JpaRepository;

interface MyRepoComment extends JpaRepository<Comment, Long> {

}
