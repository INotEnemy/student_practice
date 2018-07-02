package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.context.practic.entity.Faculty;
@RepositoryRestResource(collectionResourceRel = "faculty", path = "faculty")
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
