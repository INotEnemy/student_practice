package ru.context.practic.service;

import ru.context.practic.entity.Profession;

public interface ProfessionService  {

    Profession add (Profession profession);

    void delete (Integer id);

    Profession update(Profession profession);

    Profession getById(Integer id);
}
