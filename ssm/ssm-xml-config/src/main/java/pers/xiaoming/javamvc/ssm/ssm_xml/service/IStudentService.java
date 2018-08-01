package pers.xiaoming.javamvc.ssm.ssm_xml.service;

import pers.xiaoming.javamvc.ssm.ssm_xml.entity.Student;

public interface IStudentService {
    Student createStudent(Student student);

    void updateStudent(Student student);

    Student getStudent(int id);

    boolean deleteStudent(int id);
}
