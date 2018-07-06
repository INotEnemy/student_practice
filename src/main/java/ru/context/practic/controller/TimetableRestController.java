package ru.context.practic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.context.practic.entity.Timetable;
import ru.context.practic.repository.TimetableRepository;
import ru.context.practic.service.TimetableService;


@RestController
@RequestMapping(path = "/tt")
public class TimetableRestController {

    @Autowired
    TimetableService timetableService;

    @Autowired
    TimetableRepository timetableRepository;

    @GetMapping(path = "/findAll")
    public Iterable<Timetable> getAllTeachers() {
        return timetableRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Timetable getTimetableById(@PathVariable("id") Integer id) {
        return timetableService.getById(id);
    }

    @PostMapping(path = "/add")
    public Timetable add(@RequestBody Timetable timetable) {
        return timetableService.add(timetable);
    }

    @PutMapping(path = "/up/{id}")
    public Timetable update(@PathVariable("id") Integer id, @RequestBody Timetable timetable) {
        timetable.setId(id);
        return timetableService.update(timetable);
    }
}
