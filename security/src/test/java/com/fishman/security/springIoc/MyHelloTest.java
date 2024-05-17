package com.fishman.security.springIoc;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyHelloTest {

    @Test
    public void test(){
   //解析beans.xml文件 , 生成管理相应的Bean对象
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
   //getBean : 参数即为spring配置文件中bean的id .
    MyHello myHello = (MyHello) context.getBean("hello");
    myHello.show();
}

}
