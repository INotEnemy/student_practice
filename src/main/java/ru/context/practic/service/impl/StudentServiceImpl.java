package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.context.practic.entity.Student;
import ru.context.practic.repository.StudentRepository;
import ru.context.practic.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public Student add(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Transactional
    public void delete(Long id) {
        studentRepository.delete(studentRepository.getOne(id));
    }

    @Transactional
    public Student getByLastName(String name) {
        Student byLastName = studentRepository.getByLastName(name);
        return  byLastName;
    }

    @Transactional
    public Student update(Student student) {
        if(!studentRepository.exists(Example.of(student))){
            return studentRepository.save(student);
        }
        else {
            throw new RuntimeException("Invalid");
        }
    }

    @Transactional
    public Student getById(Long id) {
        return studentRepository.getById(id);
    }
}
