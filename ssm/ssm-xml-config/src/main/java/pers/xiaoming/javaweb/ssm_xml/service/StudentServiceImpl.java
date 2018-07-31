package pers.xiaoming.javaweb.ssm_xml.service;

import pers.xiaoming.javaweb.ssm_xml.dao.IStudentDao;
import pers.xiaoming.javaweb.ssm_xml.entity.Student;

public class StudentServiceImpl implements IStudentService {
    private IStudentDao dao;

    public void setDao(IStudentDao dao) {
        this.dao = dao;
    }

    public int createStudent(Student student) {
        return dao.create(student);
    }

    public void updateStudent(Student student) {
        dao.update(student);
    }

    public Student getStudent(int id) {
        return dao.get(id);
    }

    public boolean deleteStudent(int id) {
        dao.delete(id);
        return true;
    }
}
