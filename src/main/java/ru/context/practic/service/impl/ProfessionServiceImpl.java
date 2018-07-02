package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import ru.context.practic.entity.Profession;
import ru.context.practic.repository.ProfessionRepository;
import ru.context.practic.service.ProfessionService;

public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    ProfessionRepository professionRepository;

    @Override
    public Profession add(Profession profession) {
        return professionRepository.saveAndFlush(profession);
    }

    @Override
    public void delete(Integer id) {
        professionRepository.delete(professionRepository.getOne(id));
    }

    @Override
    public Profession update(Profession profession) {
        if(!professionRepository.exists(Example.of(profession))){
            return professionRepository.save(profession);
        }
        else {
            throw new RuntimeException("Invalid");
        }
    }

    @Override
    public Profession getById(Integer id) {
        return professionRepository.getOne(id);
    }
}
