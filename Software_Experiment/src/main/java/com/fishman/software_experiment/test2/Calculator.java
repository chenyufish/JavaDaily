package com.fishman.software_experiment.test2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = 0, n = 0;

        while (true) {
            System.out.print("请输入第一个整数（0-100）：");
            m = scanner.nextInt();
            if (m >= 0 && m <= 100) {
                break;
            } else {
                System.out.println("输入不在范围内，请重新输入。");
            }
        }

        while (true) {
            System.out.print("请输入第二个整数（0-100）：");
            n = scanner.nextInt();
            if (n >= 0 && n <= 100) {
                break;
            } else {
                System.out.println("输入不在范围内，请重新输入。");
            }
        }

        System.out.println("加法结果: " + add(m, n));
        System.out.println("减法结果: " + subtract(m, n));
        System.out.println("乘法结果: " + multiply(m, n));

        if (n != 0) {
            System.out.println("除法结果: " + divide(m, n));
        } else {
            System.out.println("除数不能为0，无法进行除法运算。");
        }
    }

    public static int add(int m, int n) {
        return m + n;
    }

    public static int subtract(int m, int n) {
        return m - n;
    }

    public static int multiply(int m, int n) {
        return m * n;
    }

    public static String divide(int m, int n) {
        if (n == 0) {
            return "除数不能为0";
        }
        return String.valueOf(m / (double)n);
    }
}
