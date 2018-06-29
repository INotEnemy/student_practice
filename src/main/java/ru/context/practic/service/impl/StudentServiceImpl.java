package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.context.practic.entity.Student;
import ru.context.practic.repository.StudentRepository;
import ru.context.practic.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void delete(Long id) {
        Student studentToDelete = studentRepository.getOne(id);
        studentRepository.delete(studentToDelete);
    }

    @Override
    public Student getByLastName(String name) {
        return null;
    }

    @Override
    public Student editStudent(Student student) {
        return null;
    }

    @Override
    public Student getById(Long id) {
        return null;
    }
}
