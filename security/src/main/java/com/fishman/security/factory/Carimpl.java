package com.fishman.security.factory;

class Sedan implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a sedan car.");
    }
}

// 具体的卡车类
class Truck implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a truck.");
    }
}

