package com.fishman.security.aop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

public class UserServiceTest {
    @Test
    public void test(){
        ApplicationContext context = newClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.search();
   }

    private ApplicationContext newClassPathXmlApplicationContext(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newClassPathXmlApplicationContext'");
    }
}
