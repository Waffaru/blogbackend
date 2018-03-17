package fi.pizzalovers.blogbackend;

import org.springframework.data.repository.CrudRepository;

public interface MyRepo extends CrudRepository<BlogPost, Integer> {
}
