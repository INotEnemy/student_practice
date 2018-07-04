package ru.context.practic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.context.practic.entity.Teacher;
import ru.context.practic.repository.TeacherRepository;
import ru.context.practic.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@Secured("ROLE_ADMIN")
public class TeacherRestController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherService teacherService;

    @GetMapping(path = "/findAll")
    public Iterable<Teacher> getAllTeachers() {
        // This returns a JSON or XML with the users
        return teacherRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long id) {
        return teacherRepository.getById(id);
    }

    @PostMapping(path = "/{id}")
    public Teacher add(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PutMapping(path = "/{id}")
    public Teacher update(@PathVariable("id") Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
       return teacherService.editTeacher(teacher);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id){
        teacherService.delete(id);
    }

}
