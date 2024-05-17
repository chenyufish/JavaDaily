package com.fishman.security.builder;

import java.util.ArrayList;

import com.fishman.security.factory.Car;
import com.fishman.security.factory.Sedan;

public class BuilderPattern {

    public ArrayList<Car> buildCars=new ArrayList<>();

    public BuilderPattern(int count){
        for(int i=0;i<count;i++){
            buildCars.add(new Sedan());        
        }
    }


}
