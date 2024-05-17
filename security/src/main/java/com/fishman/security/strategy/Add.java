package com.fishman.security.strategy;

public class Add implements Calculator {


    private int a;
    private int b;

    public Add(int a,int b) {
            this.a = a;
            this.b = b;
    }

    @Override
    public void jisuan(double count) {
        System.out.println("加法计算结果："+count +  (a + b));
    }


}
