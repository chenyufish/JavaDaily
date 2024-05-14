package com.fishman.security.config;

import java.io.IOException;

public class Jvmconfig {
    public static void setMemoryParams(String initialHeap, String maxHeap) {
        // 设置初始堆大小和最大堆大小
        System.setProperty("java.vm.args", initialHeap + " " + maxHeap);
        String runCmd = String.format("java -Xmx256m -Dfile.encoding=UTF-8 -cp %s Main %s");
        try {
            Process runProcess = Runtime.getRuntime().exec(runCmd);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
