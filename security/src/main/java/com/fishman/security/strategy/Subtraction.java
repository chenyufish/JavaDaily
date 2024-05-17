package com.fishman.security.strategy;

public class Subtraction implements Calculator {

    private int a=5;
    private int b=2; 

    public Subtraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void jisuan(double count) {
        System.out.println("計算結果："+count+(a - b));
    }


}
