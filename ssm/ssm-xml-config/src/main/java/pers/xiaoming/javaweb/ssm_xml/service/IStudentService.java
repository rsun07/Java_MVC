package pers.xiaoming.javaweb.ssm_xml.service;

import pers.xiaoming.javaweb.ssm_xml.entity.Student;

public interface IStudentService {
    int createStudent(Student student);

    void updateStudent(Student student);

    Student getStudent(int id);

    boolean deleteStudent(int id);
}
