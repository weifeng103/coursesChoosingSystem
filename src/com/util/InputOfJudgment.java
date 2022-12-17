package com.util;

import java.util.Scanner;

public class InputOfJudgment {
    public static int readNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                return num;
            } else {
                System.out.println("输入有误，请输入数字!");
                scanner.nextLine();  // 清空缓存
            }
        }
    }
}
