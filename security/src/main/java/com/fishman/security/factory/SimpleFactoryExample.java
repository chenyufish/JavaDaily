package com.fishman.security.factory;

public class SimpleFactoryExample {
    public static void main(String[] args) {
        CarController carController = new SedanFactory();
        Car car = carController.providerCar();
        car.drive();
    }
}
