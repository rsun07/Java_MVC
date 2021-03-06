package pers.xiaoming.javamvc.ssm.annotation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pers.xiaoming.javamvc.ssm.annotation.entity.Student;
import pers.xiaoming.javamvc.ssm.annotation.service.IStudentService;

@Controller
@Slf4j
@RequestMapping(value = "/student")
public class StudentController {
    private IStudentService service;

    @Autowired
    public StudentController(IStudentService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createStudent(String name, double score) {
        Student student = new Student(name, score);
        service.createStudent(student);

        return new ResponseEntity<>(student.toString(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateStudent(String name, double score) {

        Student student = new Student(name, score);
        service.updateStudent(student);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getStudent(int id) {
        Student student = service.getStudent(id);
        log.info(student.toString());
//        return new ResponseEntity<>(student.toString(), HttpStatus.OK);
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteStudent(int id) {
        boolean del = service.deleteStudent(id);

        return new ResponseEntity<>(del, HttpStatus.OK);
    }
}
