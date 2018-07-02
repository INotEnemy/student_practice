package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.context.practic.entity.Post;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "post", path = "post")
public interface PostRepository extends JpaRepository<Post, Integer> {
    /**
     * Поиск по имени
     * @param name
     * @return
     */
    List<Post> findByName(@Param("name") String name);
}
