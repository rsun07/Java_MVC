package pers.xiaoming.springmvc.ssm.annotation.service;

import pers.xiaoming.springmvc.ssm.annotation.entity.Student;

public interface IStudentService {
    Student createStudent(Student student);

    void updateStudent(Student student);

    Student getStudent(int id);

    boolean deleteStudent(int id);
}
