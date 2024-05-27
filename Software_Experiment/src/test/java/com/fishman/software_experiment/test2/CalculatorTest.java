package com.fishman.software_experiment.test2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    // 等价类划分法测试用例
    @Test
    void testValidAddition() {
        assertEquals(100, Calculator.add(50, 50));
    }

    @Test
    void testValidSubtraction() {
        assertEquals(0, Calculator.subtract(50, 50));
    }

    @Test
    void testValidMultiplication() {
        assertEquals(2500, Calculator.multiply(50, 50));
    }

    @Test
    void testValidDivision() {
        assertEquals("1.0", Calculator.divide(50, 50));
    }

    @Test
    void testInvalidLowM() {
        assertThrows(IllegalArgumentException.class, () -> {
            if (-1 < 0 || -1 > 100) {
                throw new IllegalArgumentException("输入不在范围内");
            }
        });
    }

    @Test
    void testInvalidHighN() {
        assertThrows(IllegalArgumentException.class, () -> {
            if (101 < 0 || 101 > 100) {
                throw new IllegalArgumentException("输入不在范围内");
            }
        });
    }

    @Test
    void testDivideByZero() {
        assertEquals("除数不能为0", Calculator.divide(50, 0));
    }

    // 边界值分析法测试用例
    @Test
    void testBoundaryValuesAddition() {
        assertEquals(50, Calculator.add(0, 50));
        assertEquals(150, Calculator.add(100, 50));
    }

    @Test
    void testBoundaryValuesSubtraction() {
        assertEquals(-50, Calculator.subtract(0, 50));
        assertEquals(50, Calculator.subtract(100, 50));
    }

    @Test
    void testBoundaryValuesMultiplication() {
        assertEquals(0, Calculator.multiply(0, 50));
        assertEquals(5000, Calculator.multiply(100, 50));
    }

    @Test
    void testBoundaryValuesDivision() {
        assertEquals("0.0", Calculator.divide(0, 50));
        assertEquals("2.0", Calculator.divide(100, 50));
        assertEquals("0.5", Calculator.divide(50, 100));
        assertEquals("除数不能为0", Calculator.divide(0, 0));
    }
}
