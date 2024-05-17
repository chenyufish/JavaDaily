package com.fishman.security.proxy;

public class ProxyPattern {
    public static void main(String[] args) {
        String name = "Tom";
        MyHello myHello = new MyHellolmp();
        String result = myHello.sayHello(name);
        System.out.println(result);



        MyHello helloStaticProxy = new HelloStaticProxy(new MyHellolmp());
        String resultStaticProxy = helloStaticProxy.sayHello(name);
        System.out.println(resultStaticProxy);
    }
}
