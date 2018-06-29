package ru.context.practic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.context.practic.entity.Student;
import ru.context.practic.repository.StudentRepository;
import ru.context.practic.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @GetMapping(path = "/findAll")
    public Iterable<Student> getAllStudents() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }

    @GetMapping(path = "/findById")
    public Student getStudentById() {
        Long id = new Long(1);
        return studentRepository.getById(id);
    }

    @PostMapping(path = "/addH")
    public void addH() {
        studentService.addStudent(new Student(new Long(3), "Harry", "Potter"));
    }

    @PostMapping(path = "/addR")
    public void addR() {
        studentService.addStudent(new Student(new Long(2), "Ronald", "Weasley"));
    }

    @DeleteMapping(path = "/del")
    public void deleteStud() {
        studentService.delete(new Long(3));
    }
}
