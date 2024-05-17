package com.fishman.security.factory;

public class SingleFactory {

    public static SingleFactory instance =new SingleFactory();

    private SingleFactory() {

    }

    public static SingleFactory getInstance() {

        return SingleFactory.instance;
    }

    public Object randomInstance() {
        return instance;
    }


    /*
    双检索机制
    1. 第一次检查，instance是否为null，如果为null，则创建实例并赋值给instance
    2. 第二次检查，instance是否为null，如果不为null，则直接返回instance

    优点：
    1. 保证线程安全
    2. 避免了多线程竞争问题
    public static SingleFactory getInstance() {
        if (instance == null) {
            synchronized (SingleFactory.class) {
                if (instance == null) {
                    instance = new SingleFactory();
                }
            }
        }
        return instance;
    }
    就是检验两次null
     */


}
