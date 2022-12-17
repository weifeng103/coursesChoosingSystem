package com.util;

import com.main.ElectiveCourseInformationManagement;
import com.operation.ChoiceOfOperation;

import java.io.IOException;
import java.util.Scanner;

public class Authentication {
    static Scanner scanner = new Scanner(System.in);

    public static void verify() throws IOException, InterruptedException, ClassNotFoundException {
        System.out.println("请输入管理员密码:");
        String next = scanner.next();
        String password = "admin";
        int num;
        if (next.equals(password)) {
            administrator();
        } else {
            System.out.println("密码不正确!");
            while (true) {
                System.out.print("1:重新输入\r\n" +
                                 "2:返回主菜单\r\n" +
                                 "3:退出\r\n" +
                                 "请选择您要进行的操作:");
                num = InputOfJudgment.readNumber();
                switch (num) {
                    case 1:
                        verify();
                        break;
                    case 2:
                        ElectiveCourseInformationManagement.start();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("输入有误,请重新输入!");
                }
            }
        }
    }
    public static void administrator() throws InterruptedException, IOException, ClassNotFoundException {
        int num;
        while (true) {
            System.out.print("**欢迎来到信息管理系统**\r\n" +
                             "1:查询信息\r\n" +
                             "2:添加信息\r\n" +
                             "3:修改信息\r\n" +
                             "4:删除信息\r\n" +
                             "5:退出\r\n" +
                             "请选择您要进行的操作:");
            num = InputOfJudgment.readNumber();
            switch (num) {
                case 1:
                    ChoiceOfOperation.query();
                    break;
                case 2:
                    ChoiceOfOperation.add();
                    break;
                case 3:

                    break;
                case 4:
                    ChoiceOfOperation.delete();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误,请重新输入!");
                    Thread.sleep(1000);
            }
        }
    }
    public static void student() throws IOException, ClassNotFoundException, InterruptedException {
        int num;
        while (true) {
            System.out.print("**欢迎来到学生系统**\r\n" +
                             "1:查询信息\r\n" +
                             "2:添加选课\r\n" +
                             "3:返回主菜单\r\n" +
                             "4:退出\r\n" +
                             "请选择您要进行的操作:");
            num = InputOfJudgment.readNumber();
            switch (num) {
                case 1:
                    ChoiceOfOperation.studentQuery();
                    break;
                case 2:

                    break;
                case 3:
                    ElectiveCourseInformationManagement.start();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误,请重新输入!");
                    Thread.sleep(1000);
            }
        }
    }
}
