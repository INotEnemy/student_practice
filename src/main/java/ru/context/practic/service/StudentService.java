package ru.context.practic.service;

import ru.context.practic.entity.Student;


public interface StudentService {

    Student addStudent(Student student);

    void delete(Long id);

    Student getByLastName(String name);

    Student editStudent(Student student);

    Student getById(Long id);
}

