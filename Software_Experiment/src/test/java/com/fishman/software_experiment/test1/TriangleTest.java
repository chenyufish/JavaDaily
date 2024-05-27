package com.fishman.software_experiment.test1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void testValidTriangles() {
        assertTrue(Triangle.isValidTriangle(3, 4, 5));
        assertTrue(Triangle.isValidTriangle(10, 10, 10));
    }

    @Test
    void testInvalidTriangles() {
        assertFalse(Triangle.isValidTriangle(1, 2, 3));
        assertFalse(Triangle.isValidTriangle(100, 1, 1));
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
}
