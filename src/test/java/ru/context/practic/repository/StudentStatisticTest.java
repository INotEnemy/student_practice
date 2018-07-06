package ru.context.practic.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.context.practic.service.StudentStatisticService;

public class StudentStatisticTest {
    @Qualifier("studentStatisticService")
    @Autowired
    StudentStatisticService studentStatisticService;

    @Test
    public void testSelect() {
        Long id = new Long(1);
        Assert.assertEquals((double) 2, studentStatisticService.attendance(id));
    }
}
