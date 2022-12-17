package com.operation;

import com.course.Course;
import com.course.CourseTable;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.Scanner;

public class OperationCourseTable implements OperationTable {
    ObjectOutputStream objectOutputStream = null;
    ObjectInputStream objectInputStream = null;
    CourseTable courseTable = null;
    String file = "E:\\course.bat";

    public OperationCourseTable() {
    }

    @Override
    public boolean add(Object course) throws IOException, ClassNotFoundException {
        File file = new File(this.file);
        if (file.exists()) {
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            courseTable = (CourseTable) objectInputStream.readObject();
        }
        if (objectInputStream == null) {
            courseTable = new CourseTable();
            courseTable.addCourse((Course) course);
            objectOutputStream = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            objectOutputStream.writeObject(courseTable);
            System.out.println("添加成功!");
            closeStream();
            return true;
        } else {
            if (isExistCourse(((Course)course).getId()) == null) {
                courseTable.addCourse((Course) course);
                objectOutputStream = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
                objectOutputStream.writeObject(courseTable);
                System.out.println("添加成功!");
                closeStream();
                return true;
            } else {
                System.out.println("该课程编号已存在,请重新输入!");
                closeStream();
                return false;
            }
        }
    }

    @Override
    public void deleteTable() {
        System.out.println("确认是否删除课程表?(输入确认删除,输入其他取消操作)");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        File file = new File(this.file);
        if (file.exists()) {
            if (str.equals("确认")) {
                boolean result = file.delete();
                if (result){
                    System.out.println("删除表成功！");
                }else {
                    System.out.println("删除表失败！");
                }
            } else {
                System.out.println("删除表失败！");
            }
        } else {
            System.out.println("没有创建课程表!");
        }
    }

    @Override
    public boolean deleteById(int id) throws IOException, ClassNotFoundException {
        File file = new File(this.file);
        if (file.exists()) {
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            courseTable = (CourseTable) objectInputStream.readObject();
        }
        if (objectInputStream == null) {
            System.out.println("没有创建课程信息表!");
            return false;
        } else {
            if (courseTable.courses.isEmpty()) {
                System.out.println("课程表为空");
                closeStream();
                return false;
            } else if (isExistCourse(id) == null) {
                System.out.println("不存在该课程编号,请重新输入!");
                closeStream();
                return false;
            } else {
                courseTable.courses.remove(isExistCourse(id));
                objectOutputStream = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
                objectOutputStream.writeObject(courseTable);
                System.out.println("删除成功!");
                closeStream();
                return true;
            }
        }
    }

    @Override
    public void show() throws IOException, ClassNotFoundException {
        File file = new File(this.file);
        if (!file.exists()) {
            System.out.println("没有创建课程信息表!");
        } else {
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            courseTable = (CourseTable) objectInputStream.readObject();
            if (courseTable.courses.isEmpty()) {
                System.out.println("课程表为空");
                closeStream();
            } else {
                courseTable.showCourse();
                System.out.println("共有"+courseTable.courses.size()+"门课程");
                closeStream();
            }
        }
    }

    @Override
    public void findById(int id) throws IOException, ClassNotFoundException {
        File file = new File(this.file);
        if (file.exists()) {
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            courseTable = (CourseTable) objectInputStream.readObject();
        }
        if (objectInputStream == null) {
            System.out.println("没有创建课程信息表!");
        } else {
            if (courseTable.courses.isEmpty()) {
                System.out.println("课程表为空");
                closeStream();
            } else {
                Course existCourse = isExistCourse(id);
                if (existCourse == null) {
                    System.out.println("不存在该课程编号,请重新输入!");
                    closeStream();
                } else {
                    System.out.println(existCourse);
                    closeStream();
                }
            }
        }
    }

    public Course isExistCourse(int id) throws IOException, ClassNotFoundException {
        File file = new File(this.file);
        if (file.exists()) {
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            courseTable = (CourseTable) objectInputStream.readObject();
        }
            if (courseTable.courses.containsKey(id)) {
                return courseTable.courses.get(id);
            }
        return null;
    }

    public void closeStream() throws IOException {
        if (objectOutputStream != null) {
            objectOutputStream.close();
        }
        if (objectInputStream != null) {
            objectInputStream.close();
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OperationCourseTable operation = new OperationCourseTable();
//        operation.add(new Course(13, "小李", "软件",1));
//        operation.show();
//        operation.deleteById(1);
//        operation.deleteTable();
//        operation.findById(13);
    }
}
