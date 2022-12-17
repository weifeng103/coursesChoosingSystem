package com.main;

import com.util.Authentication;
import com.util.InputOfJudgment;
import java.io.IOException;

public class ElectiveCourseInformationManagement {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        start();
    }

    public static void start() throws IOException, InterruptedException, ClassNotFoundException {
        int num;
        while (true) {
            System.out.print("**主菜单**\r\n" +
                             "1:选课信息管理人员\r\n" +
                             "2:学生\r\n" +
                             "3:退出\r\n" +
                             "请选择您的身份:");
            num = InputOfJudgment.readNumber();
            switch (num) {
                case 1:
                    Authentication.verify();
                    break;
                case 2:
                    Authentication.student();
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