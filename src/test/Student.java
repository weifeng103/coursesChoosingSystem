package test;

import java.io.Serializable;

public class Student  implements Serializable {

    private static final long serialVersionUID = -1963435134312321224L;
    private int id;
    private String name;
    private String major;

    public Student() {
    }

    public Student(int id, String name, String major) {
        this.id = id;
        this.name = name;
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

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "学号:" + id +
                ", 姓名:'" + name + '\'' +
                ", 专业:'" + major + '\'' +
                '}';
    }
}
