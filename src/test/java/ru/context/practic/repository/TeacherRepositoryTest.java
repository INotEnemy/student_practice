package ru.context.practic.repository;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.context.practic.PracticApplicationTests;
import ru.context.practic.entity.Teacher;

import static org.junit.Assert.*;

public class TeacherRepositoryTest extends PracticApplicationTests {


    @Qualifier("teacherRepository")
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testSelect() {
        Assert.assertEquals("Ожидаем, что в таблице n записей", 3, teacherRepository.count());
    }

    @Test
    public void  testSelectByLastName() {
        Teacher ivanov = teacherRepository.getByLastName("yasilev");
        Assert.assertEquals("yasilev", ivanov.getLastName());
    }

    @Test
    public void  testSelectById() {
        Long id = new Long(1);
        Teacher ivanov = teacherRepository.getById(id);
        Assert.assertEquals(id, ivanov.getId());
    }

//    @Test
//    public void testDelTeacherById() {
//        Long id = new Long(2);
//        Assert.
//                //TODO узнать как сделать тесты на удаление
//    }






}