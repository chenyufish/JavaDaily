package com.fishman.security.lambda;

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
void test(int a,int b);
}
//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
int test();
}
//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
int test(int a,int b);
}


public class LambdaTest2 {
    public static void main(String[] args) {
        // 无参数无返回值的函数式接口
        NoParameterNoReturn noParameterNoReturn = () -> {
            System.out.println("无参数无返回值");
        };
        noParameterNoReturn.test();
        // 无参数有返回值的函数式接口
        OneParameterNoReturn oneParameterNoReturn = (int a) -> {
            System.out.println("一个参数无返回值：" + a);
        };
        oneParameterNoReturn.test(10);


        MoreParameterNoReturn moreParameterNoReturn = (int a, int b) -> {
            System.out.println("多个参数无返回值：" + a + " " + b);
        };
        moreParameterNoReturn.test(20, 30);


        NoParameterReturn noParameterReturn = () -> {
            System.out.println("有返回值无参数！");
            return 40;
        };
        int ret = noParameterReturn.test();
        System.out.println(ret);

        
        OneParameterReturn oneParameterReturn = (int a) -> {
            System.out.println("有返回值有一个参数！");
            return a;
        };
       int ret1 = oneParameterReturn.test(50);
        System.out.println(ret1);
        MoreParameterReturn moreParameterReturn = (int a, int b) -> {
            System.out.println("有返回值多个参数！");
            return a + b;
        };
        int ret2 = moreParameterReturn.test(60, 70);
        System.out.println(ret2);

    }
     
}