package com.fishman.security.proxy;


public class JdkProxy implements MyHello {

    private Object target;

    public JdkProxy(Object target) {
        this.target=target;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("Hello, I am a JdkProxy!");
        return name;
    }
}
