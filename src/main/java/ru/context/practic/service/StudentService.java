package ru.context.practic.service;

import ru.context.practic.entity.Attendance;
import ru.context.practic.entity.Marks;
import ru.context.practic.entity.Profession;
import ru.context.practic.entity.Student;


public interface StudentService {

    Student addStudent(Student student);

    void delete(Long id);

    Student getByLastName(String name);

    Student updateStudent(Student student);

    Student getById(Long id);
}

