package com.fishman.software_experiment.test1;

public class Triangle {
    public static boolean isValidTriangle(int a, int b, int c) {
        //边长设置在1-100之间
        if (a < 1 || a > 100 || b < 1 || b > 100 || c < 1 || c > 100) {
            return false;
        }
        if (a >= b + c || b >= a + c || c >= a + b) {
            return false;
        }
        return true;
    }
}
