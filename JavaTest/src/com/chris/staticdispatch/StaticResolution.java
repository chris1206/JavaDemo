package com.chris.staticdispatch;

/**
 * Created by Chris on 2018/7/13.
 */
public class StaticResolution {

    public static void sayHello(){
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
    

    //切换到out目录执行： javap -verbose StaticResolution 查看该段程序的字节码
}
