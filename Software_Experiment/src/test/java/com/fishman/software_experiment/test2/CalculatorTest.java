package com.fishman.software_experiment.test2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

public class CalculatorTest {

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
    @Test
    public void testValidInput() {
        provideInput("50\n25\n");
        Scanner scanner = new Scanner(System.in);
        assertEquals(75, Calculator.add(50, 25));
        assertEquals(25, Calculator.subtract(50, 25));
        assertEquals(1250, Calculator.multiply(50, 25));
        assertEquals("2.0", Calculator.divide(50, 25));
    }
    @Test
    public void testBoundaryValues() {
        provideInput("0\n0\n");
        Scanner scanner = new Scanner(System.in);
        assertEquals(0, Calculator.add(0, 0));
        assertEquals(0, Calculator.subtract(0, 0));
        assertEquals(0, Calculator.multiply(0, 0));
        assertEquals("除数不能为0", Calculator.divide(0, 0));
        provideInput("100\n100\n");
        assertEquals(200, Calculator.add(100, 100));
        assertEquals(0, Calculator.subtract(100, 100));
        assertEquals(10000, Calculator.multiply(100, 100));
        assertEquals("1.0", Calculator.divide(100, 100));
    }
    @Test
    public void testZeroDivision() {
        provideInput("50\n0\n");
        Scanner scanner = new Scanner(System.in);
        assertEquals(50, Calculator.add(50, 0));
        assertEquals(50, Calculator.subtract(50, 0));
        assertEquals(0, Calculator.multiply(50, 0));
        assertEquals("除数不能为0", Calculator.divide(50, 0));
    }
}
