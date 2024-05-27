package com.fishman.software_experiment.test1;

public class Triangle {
    public static boolean isValidTriangle(int a, int b, int c) {
        if (a < 1 || a > 100 || b < 1 || b > 100 || c < 1 || c > 100) {
            return false;
        }
        if (a >= b + c || b >= a + c || c >= a + b) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidTriangle(3, 4, 5)); // true
        System.out.println(isValidTriangle(1, 2, 3)); // false
        System.out.println(isValidTriangle(10, 10, 10)); // true
        System.out.println(isValidTriangle(100, 1, 1)); // false
    }
}
