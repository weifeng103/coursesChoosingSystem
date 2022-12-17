package com.operation;

import com.student.Student;
import com.student.StudentTable;

import java.io.*;
import java.nio.file.Files;

public class OperationStudentTable implements OperationTable {
    ObjectOutputStream objectOutputStream = null;
    ObjectInputStream objectInputStream = null;
    StudentTable studentTable = null;
    String file = "E:\\student.bat";

    public OperationStudentTable() {
    }

    @Override
    public boolean add(Object student) throws IOException, ClassNotFoundException {
        File file = new File(this.file);
        if (file.exists()) {
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            studentTable = (StudentTable) objectInputStream.readObject();
        }
        if (objectInputStream == null) {
            studentTable = new StudentTable();
            studentTable.addStudent((Student) student);
            objectOutputStream = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            objectOutputStream.writeObject(studentTable);
            System.out.println("添加成功!");
            closeStream();
            return true;
        } else {
            if (isExistStudent(((Student)student).getId()) == null) {
                studentTable.addStudent((Student) student);
                objectOutputStream = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
                objectOutputStream.writeObject(studentTable);
                System.out.println("添加成功!");
                closeStream();
                return true;
            } else {
                System.out.println("该学号已存在,请重新输入!");
                closeStream();
                return false;
            }
        }
    }

    @Override
    public void deleteTable() {
        File file = new File(this.file);
        if (file.exists()) {
            boolean result = file.delete();
            if (result) {
                System.out.println("删除表成功！");
            } else {
                System.out.println("删除表失败！");
            }
        } else {
            System.out.println("没有创建学生表!");
        }
    }

    @Override
    public boolean deleteById(int id) throws IOException, ClassNotFoundException {
        File file = new File(this.file);
        if (file.exists()) {
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            studentTable = (StudentTable) objectInputStream.readObject();
        }
        if (objectInputStream == null) {
            System.out.println("没有创建学生信息表!");
            return false;
        } else {
            if (studentTable.students.isEmpty()) {
                System.out.println("学生表为空");
                closeStream();
                return false;
            } else if (isExistStudent(id) == null) {
                System.out.println("不存在该学号,请重新输入!");
                closeStream();
                return false;
            } else {
                studentTable.students.remove(isExistStudent(id));
                objectOutputStream = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
                objectOutputStream.writeObject(studentTable);
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
            System.out.println("没有创建学生信息表!");
        } else {
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            studentTable = (StudentTable) objectInputStream.readObject();
            if (studentTable.students.isEmpty()) {
                System.out.println("学生表为空");
                closeStream();
            } else {
                studentTable.showStudent();
                System.out.println("共有"+studentTable.students.size()+"名学生");
                closeStream();
            }
        }
    }

    @Override
    public void findById(int id) throws IOException, ClassNotFoundException {
        File file = new File(this.file);
        if (file.exists()) {
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            studentTable = (StudentTable) objectInputStream.readObject();
        }
        if (objectInputStream == null) {
            System.out.println("没有创建学生信息表!");
        } else {
            if (studentTable.students.isEmpty()) {
                System.out.println("学生表为空");
                closeStream();
            } else {
                Student existStudent = isExistStudent(id);
                if (existStudent == null) {
                    System.out.println("不存在该学号,请重新输入!");
                    closeStream();
                } else {
                    System.out.println(existStudent);
                    closeStream();
                }
            }
        }
    }

    public Student isExistStudent(int id) throws IOException, ClassNotFoundException {
        File file = new File(this.file);
        if (file.exists()) {
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            studentTable = (StudentTable) objectInputStream.readObject();
        }
            if (studentTable.students.containsKey(id)) {
                return studentTable.students.get(id);
            }
        return null;
    }

    public void closeStream() throws IOException {
//        System.gc();
        if (objectOutputStream != null) {
            objectOutputStream.close();
        }
        if (objectInputStream != null) {
            objectInputStream.close();
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OperationStudentTable operation = new OperationStudentTable();
        operation.add(new Student(13, "小李", "软件",1,"大声道"));
        operation.add(new Student(14, "小李", "软件",1,"大声道"));
        operation.add(new Student(15, "小李", "软件",1,"大声道"));
//        operation.add(new Student(13, "小李", "软件"));
        operation.show();
//        operation.deleteById(1);
//        operation.deleteTable();
//        operation.findById(13);
    }
}
