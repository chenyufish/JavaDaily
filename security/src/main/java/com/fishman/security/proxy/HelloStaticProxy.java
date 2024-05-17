package com.fishman.security.proxy;

public class HelloStaticProxy implements MyHello{

    private MyHello myHello;


    public HelloStaticProxy(MyHello myHello){
        this.myHello = myHello;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("Hello, I am a static proxy!");
        String result=myHello.sayHello(name);
        return result;
    }



}
