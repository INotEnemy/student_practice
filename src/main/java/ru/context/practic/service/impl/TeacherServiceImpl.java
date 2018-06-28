package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.context.practic.entity.Teacher;
import ru.context.practic.repository.TeacherRepository;
import ru.context.practic.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher addTeacher(Teacher techer) {
        return teacherRepository.saveAndFlush(techer);
    }

    @Override
    public void delete(Long id) {
        Teacher teacherToDelete = teacherRepository.getOne(id);
        teacherRepository.delete(teacherToDelete);
    }

    @Override
    public Teacher getByLastName(String lastName) {
        return teacherRepository.getByLastName(lastName);
    }

    @Override
    public Teacher editTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public Teacher getById(Long id) {
        return teacherRepository.getOne(id);
    }
}
