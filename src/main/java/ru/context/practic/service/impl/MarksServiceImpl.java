package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import ru.context.practic.entity.Marks;
import ru.context.practic.repository.MarksRepository;
import ru.context.practic.service.MarksService;

public class MarksServiceImpl implements MarksService {

    @Autowired
    MarksRepository marksRepository;

    @Override
    public Marks addMarks(Marks marks) {
       return marksRepository.saveAndFlush(marks);
    }

    @Override
    public void delete(Long id) {
        marksRepository.delete(marksRepository.getOne(id));
    }

    @Override
    public Marks updateMarks(Marks marks) {
        if(!marksRepository.exists(Example.of(marks))){
            return marksRepository.save(marks);
        }
        else {
            throw new RuntimeException("Invalid");
        }
    }

    @Override
    public Marks getById(Long id) {
        return marksRepository.getOne(id);
    }
}
