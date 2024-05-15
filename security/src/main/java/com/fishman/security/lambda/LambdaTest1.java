package com.fishman.security.lambda;

 
// 定义一个函数式接口
@FunctionalInterface
interface Task {
    void perform();
 
    default void washVegetables() {
        System.out.println("助理2，帮我洗菜即可");
    }
}
 
public class LambdaTest1 {
    public static void main(String[] args) {
        // 创建一个助手对象，使用Lambda表达式实现任务
        Task assistant1 = () -> {
            System.out.println("助手1正在切洋葱...");
            Task assistant2 = new Task() {
                @Override
                public void perform() {
                    washVegetables();
                }
            };
            assistant2.perform();
        };
 
        // 调用厨师的方法，传递助手对象执行任务
        cookMeal(assistant1);
    }
 
    public static void cookMeal(Task task) {
        // 准备食材
        prepareIngredients();
 
        // 执行任务
        task.perform();
 
        // 煮菜
        startCooking();
    }
 
    public static void prepareIngredients() {
        System.out.println("准备食材...");
    }
 
    public static void startCooking() {
        System.out.println("开始烹饪...");
    }
}
