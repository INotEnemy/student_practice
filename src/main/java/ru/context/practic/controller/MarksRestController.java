package ru.context.practic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.context.practic.entity.Marks;
import ru.context.practic.repository.MarksRepository;
import ru.context.practic.service.MarksService;

@RestController
@RequestMapping(path = "/marks")
public class MarksRestController {
    @Autowired
    MarksRepository marksRepository;

    @Autowired
    MarksService marksService;

    @GetMapping(path = "/findAll")
    public Iterable<Marks> getAllStudents() {
        return marksRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Marks getMarksById(@PathVariable("id") Long id) {
        return marksService.getById(id);
    }

    @PostMapping(path = "/add")
    public Marks add(@RequestBody Marks marks) {
        return  marksService.addMarks(marks);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteMark(@PathVariable("id") Long id) {
        marksService.delete(id);
        return "Mark, wich has id: " +id + " deleted" ;
    }

    @PutMapping(path = "/up/{id}")
    public Marks updateStud(@PathVariable("id") Long id,@RequestBody Marks marks) {
        marks.setId(id);
        return marksService.updateMarks(marks);
    }
}
