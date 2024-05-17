package com.fishman.security.strategy;

public class CalculatorProcessor {

    private Calculator calculator;

    public CalculatorProcessor(Calculator calculator) {
        this.calculator = calculator;
    }

    public void jisuan(double count){
        calculator.jisuan(count);
    }

}
