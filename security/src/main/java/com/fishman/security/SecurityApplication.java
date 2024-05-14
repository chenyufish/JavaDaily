package com.fishman.security;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication {

public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
        // 每333毫秒创建150线程，每个线程创建一个512kb的对象，最多一秒同时存在450线程，占用内存225m，查看6C的情况
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            new Thread(() -> {
                for (int i = 0; i < 150; i++) {
                    try {
                        //  不干活，专门创建512kb的小对象
                        byte[] temp = new byte[1024 * 512];
                        Thread.sleep(new Random().nextInt(100)); // 随机睡眠200毫秒秒以内
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }, 1000, 333, TimeUnit.MILLISECONDS);
    }

}
