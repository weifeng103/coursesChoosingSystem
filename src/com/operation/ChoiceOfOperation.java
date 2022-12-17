package com.operation;

import com.course.Course;
import com.util.Authentication;
import com.student.Student;
import com.util.InputOfJudgment;

import java.io.IOException;
import java.util.Scanner;

public class ChoiceOfOperation {
    static Scanner scanner = new Scanner(System.in);

    public static void add() throws InterruptedException, IOException, ClassNotFoundException {
        int num;
        while (true) {
            System.out.print("**添加菜单**\r\n" +
                             "1:添加学生信息\r\n" +
                             "2:添加课程信息\r\n" +
                             "3:返回上一级\r\n" +
                             "请选择您要进行的操作:");
            num = InputOfJudgment.readNumber();
            switch (num) {
                case 1:
                    OperationStudentTable operationStudentTable = new OperationStudentTable();
                    System.out.println("请输入您要添加的人数:");
                    int amount = InputOfJudgment.readNumber();
                    for (int i = 0; i < amount; ) {
                        System.out.println("请输入学号,姓名,性别,年龄,专业(用空格分开)");
                        while (true) {
                            int id = InputOfJudgment.readNumber();
                            int age = InputOfJudgment.readNumber();
                            boolean isAddSucceed = operationStudentTable.add(new Student(id, scanner.next(), scanner.next(), age, scanner.next()));
                            if (isAddSucceed) {
                                i++;
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    OperationCourseTable operationCourseTable = new OperationCourseTable();
                    System.out.println("请输入您要添加的课程数:");
                    int amount2 = InputOfJudgment.readNumber();
                    for (int i = 0; i < amount2; ) {
                        System.out.println("请输入课程编号,课程名称,授课教师,学分(用空格分开)");
                        while (true) {
                            int id = InputOfJudgment.readNumber();
                            int credits = InputOfJudgment.readNumber();
                            boolean isAddSucceed = operationCourseTable.add(new Course(id, scanner.next(), scanner.next(), credits));
                            if (isAddSucceed) {
                                i++;
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    Authentication.administrator();
                    break;
                default:
                    System.out.println("输入有误,请重新输入!");
                    Thread.sleep(1000);
            }
        }
    }

    public static void query() throws IOException, ClassNotFoundException, InterruptedException {
        int num;
        while (true) {
            System.out.print("**查询菜单**\r\n" +
                             "1:查询全部学生信息\r\n" +
                             "2:查询单个学生信息\r\n" +
                             "3:查询全部课程信息\r\n" +
                             "4:查询单门课程信息\r\n" +
                             "3:返回上一级\r\n" +
                             "请选择您要进行的操作:");
            num = InputOfJudgment.readNumber();
            switch (num) {
                case 1:
                    OperationStudentTable operationStudentTable = new OperationStudentTable();
                    operationStudentTable.show();
                    break;
                case 2:
                    OperationStudentTable operationStudentTable2 = new OperationStudentTable();
                    System.out.println("请输入您要查询的学生学号:");
                    operationStudentTable2.findById(InputOfJudgment.readNumber());
                    break;
                case 3:
                    OperationCourseTable operationCourseTable = new OperationCourseTable();
                    operationCourseTable.show();
                    break;
                case 4:
                    OperationCourseTable operationCourseTable2 = new OperationCourseTable();
                    System.out.println("请输入您要查询的课程学号:");
                    operationCourseTable2.findById(InputOfJudgment.readNumber());
                    break;
                case 5:
                    Authentication.administrator();
                    break;
                default:
                    System.out.println("输入有误,请重新输入!");
                    Thread.sleep(1000);
            }
        }
    }

    public static void delete() throws IOException, InterruptedException, ClassNotFoundException {
        int num;
        while (true) {
            System.out.print("**删除菜单**\r\n" +
                             "1:删除学生表\r\n" +
                             "2:删除单个学生信息\r\n" +
                             "3:删除课程表\r\n" +
                             "4:删除单门课程信息\r\n" +
                             "5:返回上一级\r\n" +
                             "请选择您要进行的操作:");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    OperationStudentTable operationStudentTable = new OperationStudentTable();
                    operationStudentTable.deleteTable();
                    break;
                case 2:
                    OperationStudentTable operationStudentTable2 = new OperationStudentTable();
                    System.out.println("请输入你要删除的学生学号:");
                    operationStudentTable2.deleteById(InputOfJudgment.readNumber());
                    break;
                case 3:
                    OperationCourseTable operationCourseTable = new OperationCourseTable();
                    operationCourseTable.deleteTable();
                    break;
                case 4:
                    OperationCourseTable operationCourseTable2 = new OperationCourseTable();
                    System.out.println("请输入你要删除的课程编号:");
                    operationCourseTable2.deleteById(InputOfJudgment.readNumber());
                    break;
                case 5:
                    Authentication.administrator();
                    break;
                default:
                    System.out.println("输入有误,请重新输入!");
                    Thread.sleep(1000);
            }
        }
    }

    public static void studentQuery() throws IOException, ClassNotFoundException, InterruptedException {
        int num;
        while (true) {
            System.out.print(
                    "1:查询个人信息\r\n" +
                    "2:查询全部课程信息\r\n" +
                    "3:查询单门课程信息\r\n" +
                    "4:查询成绩\r\n" +
                    "5:返回上一级\r\n" +
                    "请选择您要进行的操作:");
            num = InputOfJudgment.readNumber();
            switch (num) {
                case 1:
                    int id;
                    OperationStudentTable operationStudentTable2 = new OperationStudentTable();
                    System.out.println("请输入您的学号与姓名(用空格分开):");
                    Student student = operationStudentTable2.isExistStudent(id = InputOfJudgment.readNumber());
                    if (student == null) {
                        System.out.println("不存在该学号!");
                    } else {
                        if (student.getName().equals(scanner.next())) {
                            operationStudentTable2.findById(id);
                        } else {
                            System.out.println("姓名与学号不匹配!");
                        }
                    }
                    break;
                case 2:
                    OperationCourseTable operationCourseTable = new OperationCourseTable();
                    operationCourseTable.show();
                    break;
                case 3:
                    OperationCourseTable operationCourseTable2 = new OperationCourseTable();
                    System.out.println("请输入您要查询的课程学号:");
                    operationCourseTable2.findById(InputOfJudgment.readNumber());
                    break;
                case 4:

                    break;
                case 5:
                    Authentication.student();
                    break;
                default:
                    System.out.println("输入有误,请重新输入!");
                    Thread.sleep(1000);
            }
        }
    }


}
