package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.context.practic.entity.Marks;
import ru.context.practic.repository.MarksRepository;
import ru.context.practic.service.StudentStatisticService;

import java.util.Collections;
import java.util.List;
@Service
public class StudentStatisticServiceImpl implements StudentStatisticService {
    @Autowired
    MarksRepository marksRepository;

    @Override
    public List<Marks> showMarks(boolean increase) {
        List<Marks> marksList = marksRepository.findAll();

        if (increase){
            Collections.sort(marksList, Marks.COMPARE);
            return marksList;

        } else {
            Collections.sort(marksList, Collections.reverseOrder(Marks.COMPARE));
            return marksList;
        }
    }

    @Override
    public double averageMark() {
        List<Marks> marksList = marksRepository.findAll();
        double averge = 0.0;
        for (Marks m: marksList) {
            averge += m.getMark();
        }
        return averge/marksList.size();
    }
}
