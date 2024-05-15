package com.fishman.security.factory;


public class SedanFactory implements CarController{

    @Override
    public Car providerCar() {
       return new Sedan();
    }
}

