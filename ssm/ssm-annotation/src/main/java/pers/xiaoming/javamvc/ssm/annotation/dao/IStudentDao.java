package pers.xiaoming.javamvc.ssm.annotation.dao;

import pers.xiaoming.javamvc.ssm.annotation.entity.Student;

public interface IStudentDao {
    int create(Student student);

    void update(Student student);

    Student get(int id);

    void delete(int id);
}
