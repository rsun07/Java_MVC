package pers.xiaoming.javaweb.ssm_xml.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import pers.xiaoming.javaweb.ssm_xml.entity.Student;
import pers.xiaoming.javaweb.ssm_xml.service.IStudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends MultiActionController {
    private IStudentService service;

    public void setService(IStudentService service) {
        this.service = service;
    }

    public ResponseEntity<Student> createStudent(HttpServletRequest request,
                                        HttpServletResponse response) {
        String name = request.getParameter("name");
        String scoreStr = request.getParameter("score");
        double score = Double.valueOf(scoreStr);

        Student student = new Student(name, score);
        service.createStudent(student);

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    public ResponseEntity<Void> updateStudent(HttpServletRequest request,
                                                 HttpServletResponse response) {
        String name = request.getParameter("name");
        String scoreStr = request.getParameter("score");
        double score = Double.valueOf(scoreStr);

        Student student = new Student(name, score);
        service.updateStudent(student);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Student> getStudent(HttpServletRequest request,
                                                 HttpServletResponse response) {
        String idStr = request.getParameter("id");
        int id = Integer.valueOf(idStr);

        Student student = service.getStudent(id);

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteStudent(HttpServletRequest request,
                                                 HttpServletResponse response) {
        String idStr = request.getParameter("id");
        int id = Integer.valueOf(idStr);

        boolean del = service.deleteStudent(id);

        return new ResponseEntity<Boolean>(del, HttpStatus.OK);
    }
}
