package com.fishman.security.springIoc;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.fishman.security.config.MyConfig;

public class MyHelloTest {
    @Test
    public void test(){
    AnnotationConfigApplicationContext applicationContext =
           new AnnotationConfigApplicationContext(MyConfig.class);
    MyHello dog = (MyHello) applicationContext.getBean("dog");
    System.out.println(dog.name);
    }

}

