package com.chris.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Chris on 2017/11/4.
 * 泛型通配符的用法
 */
public class GenericDemo {
    public static void main(String[] args) {
        Collection<String> array1 = new ArrayList<String>();
        array1.add("123");
        array1.add("456");
        Collection<Integer> hs = new HashSet<Integer>();
        hs.add(789);
        hs.add(890);

        iterator(array1);
        iterator(hs);
    }

    private static void iterator(Collection<?> array) {
        Iterator<?> it = array.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
