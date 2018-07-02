package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.context.practic.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
