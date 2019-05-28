package com.chris.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chris on 2017/11/6.
 * 集合工具类
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        func3();
    }
    static void func1(){
        List<String> list = new ArrayList<String>();
        list.add("ae");
        list.add("ber");
        list.add("wiqp");
        list.add("vlva");
        list.add("gjk");
        list.add("elva");
        list.add("ojk");

//        for (String str:list) {
            System.out.println(list);
//        }
        Collections.sort(list);//集合升序排列
        System.out.println(list);
    }

    static void func2() {
        List<Integer> list = new ArrayList<Integer>();
        list.clear();
        list.add(10);
        list.add(8);
        list.add(35);
        list.add(98);
        list.add(14);
        list.add(57);
        list.add(22);
        //二分查找
        int index = Collections.binarySearch(list, 22);
        System.out.println(index);
    }

    static void func3() {
        List<Integer> list = new ArrayList<Integer>();
        list.clear();
        list.add(10);
        list.add(8);
        list.add(35);
        list.add(98);
        list.add(14);
        list.add(57);
        list.add(22);
        //随机排序
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);


    }


}
