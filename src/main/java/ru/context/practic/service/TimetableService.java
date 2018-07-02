package ru.context.practic.service;

import ru.context.practic.entity.Timetable;

public interface TimetableService {

    Timetable add(Timetable timetable);

    void delete(Integer id);

    Timetable update(Timetable timetable);

    Timetable getById(Integer id);
}
