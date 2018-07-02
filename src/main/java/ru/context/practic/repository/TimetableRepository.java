package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.context.practic.entity.Timetable;
@RepositoryRestResource(collectionResourceRel = "timetable", path = "timetable")
public interface TimetableRepository extends JpaRepository<Timetable, Integer> {
}
