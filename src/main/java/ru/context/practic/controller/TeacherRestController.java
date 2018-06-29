package ru.context.practic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.context.practic.entity.Teacher;
import ru.context.practic.repository.TeacherRepository;

@RestController
@RequestMapping("/teacher")
public class TeacherRestController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping(path = "/findAll")
    public Iterable<Teacher> getAllTeachers() {
        // This returns a JSON or XML with the users
        return teacherRepository.findAll();
    }

    @GetMapping(path = "/findById")
    public Teacher getTeacherById() {
        Long id = new Long(1);
        return teacherRepository.getById(id);
    }
}
