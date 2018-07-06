package ru.context.practic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.context.practic.entity.Teacher;
import ru.context.practic.repository.TeacherRepository;
import ru.context.practic.service.TeacherService;
import ru.context.practic.service.TeacherStatisticService;

@RestController
@RequestMapping("/teacher")
public class TeacherRestController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherService teacherService;

    @Autowired
    TeacherStatisticService statisticService;

    @GetMapping(path = "/findAll")
    public Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long id) {
        return teacherRepository.getById(id);
    }

    @PostMapping(path = "/add")
    public Teacher add(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PutMapping(path = "/up/{id}")
    public Teacher update(@PathVariable("id") Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
       return teacherService.editTeacher(teacher);
    }

    @DeleteMapping(path = "/del/{id}")
    public void delete(@PathVariable("id") Long id){
        teacherService.delete(id);
    }

    @GetMapping(path = "/stat/{id}")
    public String load(@PathVariable("id") Long id) {
        return statisticService.getAllLoad(id) ;
    }

}
