package ru.context.practic.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.context.practic.PracticApplicationTests;
import ru.context.practic.entity.Teacher;
import ru.context.practic.service.impl.TeacherServiceImpl;

public class TeacherRepositoryTest extends PracticApplicationTests {

    @Autowired
    private TeacherServiceImpl teacherServiceIml;

    @Qualifier("teacherRepository")
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testSelect() {
        Assert.assertEquals("Ожидаем, что в таблице n записей", 1, teacherRepository.count());
    }

    @Test
    public void testSelectByLastName() {
        Teacher lastName = teacherRepository.getByLastName("lastName");
        Assert.assertEquals("lastName", lastName.getLastName());
    }

    @Test
    public void testSelectById() {
        Long id = new Long(1);
        Teacher ivanov = teacherRepository.getById(id);
        Assert.assertEquals(id, ivanov.getId());
    }

    @Test
    public void testDelTeacherById() {
        Long id = new Long(1);
        teacherServiceIml.delete(id);
    }

    @Test
    public void testAddTeacher() {
        teacherServiceIml.addTeacher(new Teacher(new Long(1), "senya", "yaf", 1.0));
    }

    @Test
    public void testEditTeacher() {
        Teacher senya2 = teacherServiceIml.addTeacher(new Teacher(new Long(2), "senya2", "yaf2", 2.0));
        teacherServiceIml.editTeacher(senya2);
    }
}