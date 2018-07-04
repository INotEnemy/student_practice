package ru.context.practic.service;

import ru.context.practic.entity.Marks;

public interface MarksService {

    Marks addMarks(Marks marks);

    void delete(Long id);

    Marks updateMarks(Marks marks);

    Marks getById(Long id);
}
