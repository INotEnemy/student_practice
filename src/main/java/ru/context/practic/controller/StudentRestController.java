package ru.context.practic.controller;

import org.hibernate.bytecode.spi.ProxyFactoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.context.practic.entity.Profession;
import ru.context.practic.entity.Student;
import ru.context.practic.repository.ProfessionRepository;
import ru.context.practic.repository.StudentRepository;
import ru.context.practic.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfessionRepository professionRepository;

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
        Profession wizard = new Profession("wizard");
        Profession profession = professionRepository.saveAndFlush(wizard);
        studentService.addStudent(new Student(new Long(3), "Harry", "Potter", profession, 1, 5.0));
    }

//    @PostMapping(path = "/addR")
//    public void addR() {
//        studentService.addStudent(new Student(new Long(2), "Ronald", "Weasley",, 1, 4.9));
//    }

    @DeleteMapping(path = "/del/{id}")

    public void deleteStud() {
        studentService.delete(new Long(2));
    }
}
