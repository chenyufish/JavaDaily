package com.fishman.security.lambda;

import java.util.Arrays;
import java.util.List;

public class Lambda {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        numbers.stream().filter(a -> a % 2 == 0).forEach(a -> System.out.println(a));//用流来过滤
 
        // Lambda表达式作为参数传递给forEach方法
        numbers.forEach(number -> System.out.print(number+" "));
        numbers.forEach(number->{
            int result = number * 2;
            System.out.println(result+number);
        });
    }

}
