package com.fishman.security.builder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuilderPatternTest {
    
    @Test
    void testBuilderPattern() {
        BuilderPattern builderPattern = new BuilderPattern(10);
        System.out.println(builderPattern.buildCars);
    }
}
