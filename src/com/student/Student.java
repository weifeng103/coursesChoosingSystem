package com.student;


import java.io.Serializable;

public class Student implements Serializable {


    private static final long serialVersionUID = 394684814113783163L;
    private int id;
    private String name;
    private String gender;
    private int age;
    private String major;

    public Student() {
    }

    public Student(int id, String name, String gender, int age, String major) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "学号=" + id +
                ", 姓名='" + name + '\'' +
                ", 性别='" + gender + '\'' +
                ", 年龄=" + age +
                ", 专业='" + major + '\'' +
                '}';
    }
}
