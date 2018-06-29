package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.context.practic.entity.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
}
