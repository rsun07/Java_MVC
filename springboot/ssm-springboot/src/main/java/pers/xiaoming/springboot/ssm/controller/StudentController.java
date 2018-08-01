package pers.xiaoming.springboot.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.xiaoming.springboot.ssm.entity.Student;
import pers.xiaoming.springboot.ssm.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    private IStudentService service;

    @Autowired
    public StudentController(IStudentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createStudent(String name, double score) {
        Student student = new Student(name, score);
        service.createStudent(student);

        return student.toString();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateStudent(String name, double score) {

        Student student = new Student(name, score);
        service.updateStudent(student);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getStudent(int id) {
        Student student = service.getStudent(id);

        return student.toString();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean deleteStudent(int id) {
        return service.deleteStudent(id);
    }
}
