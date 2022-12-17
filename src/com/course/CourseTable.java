package com.course;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CourseTable implements Serializable {
    private static final long serialVersionUID = -9135921486376510774L;
    public Map<Integer,Course> courses = new HashMap<>();
    public void addCourse(Course course) {
        courses.put(course.getId(),course);
    }

    public void showCourse() {
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }
}
