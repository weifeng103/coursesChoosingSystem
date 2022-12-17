package com.course;

import java.io.Serializable;

public class Course implements Serializable {
    private static final long serialVersionUID = 1543247975557135421L;
    private int id;
    private String courseName;
    private String teacherName;
    private int credits;

    public Course(int id, String courseName, String teacherName, int credits) {
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
               "课程编号=" + id +
               ", 课程名称='" + courseName + '\'' +
               ", 授课教师='" + teacherName + '\'' +
               ", 学分=" + credits +
               '}';
    }
}
