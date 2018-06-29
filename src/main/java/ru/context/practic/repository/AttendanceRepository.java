package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.context.practic.entity.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long > {
}
