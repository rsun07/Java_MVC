package pers.xiaoming.javamvc.ssm.ssm_xml.entity;

public class Student {
    private int id;
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public Student(Integer id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
