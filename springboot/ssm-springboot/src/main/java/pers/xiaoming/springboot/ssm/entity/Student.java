package pers.xiaoming.springboot.ssm.entity;

public class Student {
    private int id;
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }
}
