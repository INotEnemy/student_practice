package ru.context.practic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.context.practic.entity.Student;
import ru.context.practic.repository.AttendanceRepository;
import ru.context.practic.repository.MarksRepository;
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

    @Autowired
    MarksRepository marksRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @GetMapping(path = "/findAll")
    public Iterable<Student> getAllStudents() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentRepository.getById(id);
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
     return  studentService.add(student);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStud(@PathVariable("id") Long id) {
        studentService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Student updateStud(@PathVariable("id") Long id,@RequestBody Student student){
        student.setId(id);
        return studentService.update(student);
    }
}
