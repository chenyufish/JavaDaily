package com.fishman.security.aop;

public class Host implements Rent{

    @Override
    public void rent(){
        System.out.println("Host is renting");
    }

}
