package com.student;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StudentTable implements Serializable {

    private static final long serialVersionUID = -464686003990229987L;

    public Map<Integer,Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getId(),student);
    }

    public void showStudent() {
        for (Student integer : students.values()) {
            System.out.println(integer);
        }
    }
}
