package test;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StudentTable implements Serializable {

    private static final long serialVersionUID = 5366836053604719056L;
    Map<Integer,Student> students = new HashMap<>();
    public void addStudent(Student student) {
        students.put(student.getId(),student);
    }
    public void showStudent(){
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
}
