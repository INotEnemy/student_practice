package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.context.practic.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
