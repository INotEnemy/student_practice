package ru.context.practic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.context.practic.entity.Marks;
import ru.context.practic.entity.Student;
import ru.context.practic.repository.*;
import ru.context.practic.service.StudentService;
import ru.context.practic.service.StudentStatisticService;
import java.util.List;

@RestController
@RequestMapping("/student")
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

    @PostMapping(path = "/add")
    public Student add(@RequestBody Student student) {
     return  studentService.add(student);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStud(@PathVariable("id") Long id) {
        studentService.delete(id);
    }

    @PutMapping(path = "/up/{id}")
    public Student updateStud(@PathVariable("id") Long id,@RequestBody Student student){
        student.setId(id);
        return studentService.update(student);
    }

    @GetMapping(path = "/stat/{id},{mode}")
    public List<Marks> showStatistic(@PathVariable("id") Long id,@PathVariable("mode") boolean mode) {
        return studentStatisticService.showMarks(id,mode);
    }

    @GetMapping(path = "/stat/averge/{id}")
    public String showStatistic(@PathVariable("id") Long id) {
        return studentStatisticService.averageMark(id);
    }

    @GetMapping(path = "/stat/was/{id}")
    public String attendance(@PathVariable("id") Long id) {
        return studentStatisticService.attendance(id);
    }

}
