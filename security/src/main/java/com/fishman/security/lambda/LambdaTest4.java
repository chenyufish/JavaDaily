package com.fishman.security.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

public class LambdaTest4 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        fruits.forEach(fruit -> System.out.println("I like " + fruit));

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
 
        numbers.removeIf(n -> n % 2 == 0); // 移除所有偶数
        System.out.println(numbers);

        List<String> fruits1 = Arrays.asList("Apple", "Banana", "Orange");
 
        Spliterator<String> spliterator = fruits1.spliterator();
        spliterator.forEachRemaining(fruit -> System.out.println(fruits1));

        List<String> names = Arrays.asList("Charlie", "Bob", "Alice", "David", "Emma");

        // 使用Stream API和Lambda表达式进行数据处理

        // 示例1: 过滤出名字长度大于4的人名，并打印输出
        System.out.println("名字长度大于4的人名:");
        names.stream()
             .filter(name -> name.length() > 4)
             .forEach(System.out::println);

        // 示例2: 将所有名字转换为大写，并打印输出
        System.out.println("\n所有名字转换为大写:");
        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);

        // 示例3: 统计名字长度大于4的人数
        long count = names.stream()
                          .filter(name -> name.length() > 4)
                          .count();
        System.out.println("\n名字长度大于4的人数: " + count);
 
        names.sort((name1, name2) -> name1.compareToIgnoreCase(name2)); // 根据名称的字母顺序排序，忽略大小写
 
        System.out.println(names);
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 80);
        scores.put("Charlie", 95);
 
        scores.forEach((name, score) -> System.out.println(name + ": " + score));


    }
    

}
