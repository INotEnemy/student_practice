package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.context.practic.entity.Profession;
@RepositoryRestResource(collectionResourceRel = "profession", path = "profession")
public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
}
