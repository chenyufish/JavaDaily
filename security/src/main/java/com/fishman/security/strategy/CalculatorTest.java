package com.fishman.security.strategy;

public class CalculatorTest {

    public static void main(String[] args) {

        CalculatorProcessor calculatorProcessor = new CalculatorProcessor(new Add(3,8));
        calculatorProcessor.jisuan(8);
        CalculatorProcessor calculatorProcessor2 = new CalculatorProcessor(new Subtraction(10,5));
        calculatorProcessor2.jisuan(10);
    }
}
