package com.chris.math;

import org.junit.Test;

/**
 * Created by Chris on 2018/6/26.
 */
public class MathTest {
    @Test
    public void test(){
        System.out.println(1>>>1);
        System.out.println(-1>>>1);
        System.out.println(-2>>>1);
        System.out.println(10>>>24);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(10<<1));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-6));


        char c = 'a';
        char a = '^';
        System.out.println((byte)c +"  "+ (byte)a);
    }
}
