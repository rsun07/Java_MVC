package pers.xiaoming.javamvc.ssm.annotation.dao;

import org.springframework.stereotype.Repository;
import pers.xiaoming.javamvc.ssm.annotation.entity.Student;

@Repository("IStudentDao")
public interface IStudentDao {
    int create(Student student);

    void update(Student student);

    Student get(int id);

    void delete(int id);
}
