package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.context.practic.entity.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Integer> {
}
