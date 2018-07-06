package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.context.practic.entity.Timetable;
import ru.context.practic.service.TeacherService;
import ru.context.practic.service.TeacherStatisticService;

import java.util.List;

@Service
public class TeacherStatisticServiceImpl implements TeacherStatisticService {
    @Autowired
    TeacherService teacherService;
    @Override
    public String  getAllLoad(Long id) {
        List<Timetable> timetable = teacherService.getById(id).getTimetable();
            double hours = 0.0;
            double minutes = 0.0;

        for (Timetable t: timetable) {
            hours += t.getEndTime().getHours() - t.getStartTime().getHours();
            minutes += t.getEndTime().getMinutes() - t.getStartTime().getMinutes();
        }
        teacherService.getById(id).setLoad(hours);
        return teacherService.getById(id).getLastName() + "'s load: " + hours + "h " + minutes + "m";
    }
}
