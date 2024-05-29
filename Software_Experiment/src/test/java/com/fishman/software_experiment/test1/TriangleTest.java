package com.fishman.software_experiment.test1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void testValidTriangles() {
        assertTrue(Triangle.isValidTriangle(3, 4, 5));//合法三角形
        assertTrue(Triangle.isValidTriangle(10, 10, 10));//等边三角形
    }

    @Test
    void testInvalidTriangles() {
        assertFalse(Triangle.isValidTriangle(1, 2, 3));//非法三角形
        assertFalse(Triangle.isValidTriangle(100, 1, 1));//长边大于等于短边
        assertFalse(Triangle.isValidTriangle(0, 50, 50)); // a < 1
        assertFalse(Triangle.isValidTriangle(101, 50, 50)); // a > 100
        assertFalse(Triangle.isValidTriangle(50, 0, 50)); // b < 1
        assertFalse(Triangle.isValidTriangle(50, 101, 50)); // b > 100
        assertFalse(Triangle.isValidTriangle(50, 50, 0)); // c < 1
        assertFalse(Triangle.isValidTriangle(50, 50, 101)); // c > 100
        assertFalse(Triangle.isValidTriangle(1, 2, 3)); // a >= b + c
        assertFalse(Triangle.isValidTriangle(3, 1, 1)); // b >= a + c
        assertFalse(Triangle.isValidTriangle(1, 1, 3)); // c >= a + b
    }
    @Test
    void testIsRightTriangle() {
        assertTrue(Triangle.isValidTriangle(99, 99, 99));//极限边长
        assertTrue(Triangle.isValidTriangle(50, 99, 99));//等腰三角形
    }
}
