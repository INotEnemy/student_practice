package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.context.practic.entity.Marks;
import ru.context.practic.entity.Student;
import ru.context.practic.repository.MarksRepository;
import ru.context.practic.service.StudentService;
import ru.context.practic.service.StudentStatisticService;

import java.util.Collections;
import java.util.List;
@Service
public class StudentStatisticServiceImpl implements StudentStatisticService {
    @Autowired
    MarksRepository marksRepository;

    @Autowired
    StudentService studentService;

    @Override
    public List<Marks> showMarks(Long id, boolean increase) {

        List<Marks> marksList = studentService.getById(id).getBestMarkToday();

        if (increase){
            Collections.sort(marksList, Marks.COMPARE_MARK);
            return marksList;

        } else {
            Collections.sort(marksList, Collections.reverseOrder(Marks.COMPARE_MARK));
            return marksList;
        }
    }

    @Override
    public String averageMark(Long id) {
        List<Marks> marksList = studentService.getById(id).getBestMarkToday();
        double averge = 0.0;
        for (Marks m: marksList) {
            averge += m.getMark();
        }
        return studentService.getById(id).getLastName() + "'s averge mark: " + averge/marksList.size();
    }

    @Override
    public String attendance(Long id) {
        List<Marks> marksList = studentService.getById(id).getBestMarkToday();
        int wasTimesTmp = 0;
        for (Marks m: marksList) {
            if(m.getAttendance())
                wasTimesTmp++;
        }
        return "Student " + studentService.getById(id).getLastName() + " was at the class " + wasTimesTmp +
                " times out of " + marksList.size() + " possible.";
    }
}
