package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.context.practic.entity.Marks;

public interface MarksRepository extends JpaRepository<Marks, Integer> {
}
