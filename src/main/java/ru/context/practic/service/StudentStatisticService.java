package ru.context.practic.service;

import ru.context.practic.entity.Marks;

import java.util.List;

public interface StudentStatisticService {

    List<Marks> showMarks(Long id, boolean mode);

    String averageMark(Long id);

    String attendance(Long id);
}
