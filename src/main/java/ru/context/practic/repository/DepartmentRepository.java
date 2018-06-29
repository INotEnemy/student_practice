package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.context.practic.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
