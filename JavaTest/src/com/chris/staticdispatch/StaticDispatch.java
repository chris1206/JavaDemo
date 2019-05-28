package com.chris.staticdispatch;

import org.junit.Test;

/**
 * Created by Chris on 2018/7/13.
 */
public class StaticDispatch {
    abstract class Human{
    }
    class Man extends Human{
    }
    class Woman extends Human{
    }
    public void sayHello(Human guy){
        System.out.println("hello, guy!");
    }
    public void sayHello(Man guy){
        System.out.println("hello, man");
    }
    public void sayHello(Woman guy){
        System.out.println("hello, woman");
    }

    public static void main(String[] args) {
//        Human man = new Man();
//        Human woman = new Woman();
//        StaticDispatch sd = new StaticDispatch();
//        sd.sayHello(man);
//        sd.sayHello(woman);
    }
    @Test
    public void test(){
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }
    /**
     * 打印结果为
     * hello, guy!
     * hello, guy!
     * why?函数重载取决于参数个数和参数类型，但编译器会根据参数的静态类型决定具体使用哪个版本，但可以根据强转使用
     *
     */
}
