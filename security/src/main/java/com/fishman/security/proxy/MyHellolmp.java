package com.fishman.security.proxy;

public class MyHellolmp implements MyHello{

    @Override
    public String sayHello(String name){
        String result = "Hello " + name + "!";
        System.out.println(result);
        String str = "实现了 " + result + "!";
        return str;
    }

}
