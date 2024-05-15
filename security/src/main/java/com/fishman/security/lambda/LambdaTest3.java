package com.fishman.security.lambda;
/**
 * function
 
 */

 interface MyFunction {
    void printValue();
}

interface Shape {
    void draw();
}


public class LambdaTest3 {
    public static void main(String[] args) {
        int x=10;
        MyFunction myFunction = new MyFunction() {
            @Override
            public void printValue() {
                System.out.println(x);
            }
        };
        myFunction.printValue();

        final int y = 20;
        Shape shape = new Shape() {

            @Override
            public void draw() {
                System.out.println(y);
            }
        };
        shape.draw();

    }

}
