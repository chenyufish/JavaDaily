package com.fishman.security.factory;

public class CarFactory {
    public Car createCar(String CarType){
        if(CarType.equals("Sedan")) {
            return new Sedan();
    }else if(CarType.equals("Truck")) {
        return new Truck();
    }else {
        System.out.println("请输入正确的汽车类型！");
        return null;
    }

    }

}
