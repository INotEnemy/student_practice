package ru.context.practic.service;

import ru.context.practic.entity.Marks;

import java.util.List;

public interface StudentStatisticService {

    List<Marks> showMarks(boolean mode);

    double averageMark();
}
