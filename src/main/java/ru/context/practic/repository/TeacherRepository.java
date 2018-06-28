package ru.context.practic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.context.practic.entity.Teacher;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

       @Query("select t from Teacher t where t.lastName = :lastName")
       Teacher getByLastName(@Param("lastName") String lastName);

       Teacher getById (Long id);

}
