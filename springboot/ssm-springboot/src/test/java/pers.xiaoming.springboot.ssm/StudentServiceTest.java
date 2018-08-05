package pers.xiaoming.springboot.ssm;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xiaoming.springboot.ssm.entity.Student;
import pers.xiaoming.springboot.ssm.service.IStudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private IStudentService service;

    private static Student student;

    @BeforeClass
    public static void createStudent() {
        student = new Student("Mike", 98.5);
    }

    @Test
    public void testCURD() {
        service.createStudent(student);
        int id = student.getId();

        Student studentGetFromDB = service.getStudent(id);

        Assert.assertEquals(student, studentGetFromDB);
    }
}
