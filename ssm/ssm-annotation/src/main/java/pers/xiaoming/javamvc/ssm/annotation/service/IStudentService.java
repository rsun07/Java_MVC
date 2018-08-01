package pers.xiaoming.javamvc.ssm.annotation.service;

import pers.xiaoming.javamvc.ssm.annotation.entity.Student;

public interface IStudentService {
    Student createStudent(Student student);

    void updateStudent(Student student);

    Student getStudent(int id);

    boolean deleteStudent(int id);
}
