package com.fishman.security.config;

public class Jvmconfig {
    public static void setMemoryParams(String initialHeap, String maxHeap) {
        // 设置初始堆大小和最大堆大小
        System.setProperty("java.vm.args", initialHeap + " " + maxHeap);
    }

}
