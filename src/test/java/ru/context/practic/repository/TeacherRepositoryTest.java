package ru.context.practic.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.context.practic.PracticApplicationTests;

import static org.junit.Assert.*;

public class TeacherRepositoryTest extends PracticApplicationTests {


    @Qualifier("teacherRepository")
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testSelect() {
        Assert.assertEquals("Ожидаем, что таблица пустая", 1, teacherRepository.count());
    }

}