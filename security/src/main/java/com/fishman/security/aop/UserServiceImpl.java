package com.fishman.security.aop;

public class UserServiceImpl implements UserService {


    @Override
    public void add(){
        System.out.println("add user: ");
    }

    @Override
    public void delete() {
        System.out.println("delete user: " );
    }

    @Override
    public void update() {
        System.out.println("update user: " );
    }
    @Override
    public void search() {
        System.out.println("query user: ");
    }

}
