package fi.pizzalovers.blogbackend;

import org.springframework.data.jpa.repository.JpaRepository;

interface MyRepoLogin extends JpaRepository<User, Long> {

}