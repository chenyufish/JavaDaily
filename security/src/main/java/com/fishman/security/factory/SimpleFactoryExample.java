package com.fishman.security.factory;

public class SimpleFactoryExample {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car sedan = carFactory.createCar("Sedan");
        Car truck = carFactory.createCar("Truck");
        sedan.drive();
        truck.drive();
    }
}
