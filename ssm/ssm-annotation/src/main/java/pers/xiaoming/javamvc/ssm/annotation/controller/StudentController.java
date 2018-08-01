package pers.xiaoming.javamvc.ssm.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.xiaoming.javamvc.ssm.annotation.entity.Student;
import pers.xiaoming.javamvc.ssm.annotation.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    private IStudentService service;

    @Autowired
    public StudentController(IStudentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(String name, double score) {
        Student student = new Student(name, score);
        service.createStudent(student);

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateStudent(String name, double score) {

        Student student = new Student(name, score);
        service.updateStudent(student);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(int id) {
        Student student = service.getStudent(id);

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteStudent(int id) {
        boolean del = service.deleteStudent(id);

        return new ResponseEntity<Boolean>(del, HttpStatus.OK);
    }
}
