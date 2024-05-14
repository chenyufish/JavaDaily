package com.fishman.security.config;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

@SpringBootTest
public class JvmconfigTest {
    @Test
    public void testMemoryParams() {
        Jvmconfig.setMemoryParams("-Xms1m", "-Xmx20m");
        // 创建一个集合来模拟内存占用
        List<byte[]> memoryList = new ArrayList<>();
        StopWatch watch = new StopWatch();
        watch.start();
        try {
            // 模拟内存占用，直到发生内存溢出
            while (true) {
                memoryList.add(new byte[1024 * 1024]); // 每次添加 1MB 的字节数组
            }
        } catch (OutOfMemoryError e) {
            watch.stop();
            System.out.println("耗时：" + watch.getTotalTimeMillis() + " ms");
            // 捕获内存溢出异常并输出信息
            System.out.println("内存溢出，占用内存大小：" + memoryList.size() + " MB");
        }
        }
    }
