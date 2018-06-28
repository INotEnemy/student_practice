package ru.context.practic.service;

import ru.context.practic.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher addTeacher(Teacher techer);
    void delete (Long id);
    Teacher getByLastName(String name);
    Teacher editTeacher(Teacher teacher);
    Teacher getById (Long id);
}
