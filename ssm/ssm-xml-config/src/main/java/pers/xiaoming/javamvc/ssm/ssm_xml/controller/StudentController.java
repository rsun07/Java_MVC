package pers.xiaoming.javamvc.ssm.ssm_xml.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import pers.xiaoming.javamvc.ssm.ssm_xml.entity.Student;
import pers.xiaoming.javamvc.ssm.ssm_xml.service.IStudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentController extends MultiActionController {
    private IStudentService service;

    public void setService(IStudentService service) {
        this.service = service;
    }

    public ModelAndView createStudent(HttpServletRequest request,
                                      HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String scoreStr = request.getParameter("score");
        double score = Double.valueOf(scoreStr);

        Student student = new Student(name, score);
        service.createStudent(student);

        response.getWriter().printf(student.toString());
        return null;
    }

    public ModelAndView updateStudent(HttpServletRequest request,
                                                 HttpServletResponse response) {
        String name = request.getParameter("name");
        String scoreStr = request.getParameter("score");
        double score = Double.valueOf(scoreStr);

        Student student = new Student(name, score);
        service.updateStudent(student);

        return null;
    }

    public ModelAndView getStudent(HttpServletRequest request,
                                                 HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        int id = Integer.valueOf(idStr);

        Student student = service.getStudent(id);

        response.getWriter().printf(student.toString());
        return null;
    }

    public ModelAndView deleteStudent(HttpServletRequest request,
                                                 HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        int id = Integer.valueOf(idStr);

        boolean del = service.deleteStudent(id);

        response.getWriter().printf(String.valueOf(del));
        return null;
    }
}
