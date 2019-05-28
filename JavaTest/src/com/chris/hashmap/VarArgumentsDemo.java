package com.chris.hashmap;

/**
 * Created by Chris on 2017/11/6.
 * 可变参数一般只有一个，有多参数时，只能写在最后面
 */
public class VarArgumentsDemo {
    public static void main(String[] args) {
        int sum_val = sum(1,3,5,62,23,56);
        System.out.println(sum_val);
    }

    private static int sum(int a, int b,int... array) {
        int sum_v = 0;
        for(int i:array){
            sum_v = sum_v + i;
        }
        return sum_v;
    }


}
