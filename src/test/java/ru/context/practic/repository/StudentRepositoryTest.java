package ru.context.practic.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.context.practic.PracticApplicationTests;
import ru.context.practic.entity.Student;
import ru.context.practic.service.StudentService;

public class StudentRepositoryTest extends PracticApplicationTests {

    @Autowired
    private StudentService studentService;

    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testSelect() {
        Assert.assertEquals("Ожидаем, что в таблице n записей",
                4, studentRepository.count());
    }

    @Test
    public void testSelectByLastName() {
        Student lastName = studentRepository.getByLastName("Potter");
        Assert.assertEquals("Potter", lastName.getLastName());
    }

    @Test
    public void testSelectById() {
        Long id = new Long(1);
        Student ivanov = studentRepository.getById(id);
        Assert.assertEquals(id, ivanov.getId());
    }

    @Test
    public void testDelById() {
        Long id = new Long(4);
        studentService.delete(id);
    }
}
//    @Test
//    public void testAdd() {
//            studentService.addStudent(new Student(new Long(3), "Harry", "Potter", "wizard", 1, 5.0));
//        }
//
//    }

//    @Test
//    public void testEdit() {
//        studentService.editStudent();
//    }

