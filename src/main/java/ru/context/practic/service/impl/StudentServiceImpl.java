package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        Student byLastName = studentRepository.getByLastName(name);
        return  byLastName;
    }

    @Override
    public Student updateStudent(Student student) {
        if(!studentRepository.exists(Example.of(student))){
            return studentRepository.save(student);
        }
        else {
            throw new RuntimeException("Invalid");
        }
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.getById(id);
    }
}
