package pers.xiaoming.javamvc.ssm.ssm_xml.dao;

import pers.xiaoming.javamvc.ssm.ssm_xml.entity.Student;

public interface IStudentDao {
    int create(Student student);

    void update(Student student);

    Student get(int id);

    void delete(int id);
}
