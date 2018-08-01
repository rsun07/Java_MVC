package pers.xiaoming.springmvc.ssm.annotation.dao;

import pers.xiaoming.springmvc.ssm.annotation.entity.Student;

public interface IStudentDao {
    int create(Student student);

    void update(Student student);

    Student get(int id);

    void delete(int id);
}
