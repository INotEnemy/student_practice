package ru.context.practic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.context.practic.entity.Marks;
import ru.context.practic.entity.Student;
import ru.context.practic.repository.*;
import ru.context.practic.service.StudentService;
import ru.context.practic.service.StudentStatisticService;
import java.util.List;

@RestController
@RequestMapping("/student")
@Secured("ROLE_USER")
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    StudentStatisticService studentStatisticService;

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

    @GetMapping(path = "/stat/{mode}")
    public List<Marks> showStatistic(@PathVariable("mode") boolean mode) {
        return studentStatisticService.showMarks(mode);
    }

    @GetMapping(path = "/stat/averge")
    public double showStatistic() {
        return studentStatisticService.averageMark();
    }

}
