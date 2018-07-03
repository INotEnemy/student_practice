package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.context.practic.entity.Timetable;
import ru.context.practic.repository.TimetableRepository;
import ru.context.practic.service.TimetableService;
@Service
public class TimetableServiceImpl implements TimetableService {
    @Autowired
    TimetableRepository timetableRepository;
    @Override
    public Timetable add(Timetable timetable) {
        return timetableRepository.saveAndFlush(timetable);
    }

    @Override
    public void delete(Integer id) {
        timetableRepository.delete(timetableRepository.getOne(id));
    }

    @Override
    public Timetable update(Timetable timetable) {
        if(!timetableRepository.exists(Example.of(timetable))){
         return  timetableRepository.save(timetable);
        }
        else {
            throw new RuntimeException("invalid");
        }
    }

    @Override
    public Timetable getById(Integer id) {
        return timetableRepository.getOne(id);
    }
}
