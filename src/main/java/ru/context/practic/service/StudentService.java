package ru.context.practic.service;

import ru.context.practic.entity.Student;


public interface StudentService {

    Student add(Student student);

    void delete(Long id);

    Student getByLastName(String name);

    Student update(Student student);

    Student getById(Long id);

}

