package com.chris.iterator;

import java.util.*;

/**
 * Created by Chris on 2017/11/4.
 */
public class IteratorDemo {

    public static void main(String[] args){
        Collection<String> coll = new LinkedHashSet<String>();
        coll.add("a1");
        coll.add("a2");
        coll.add("a3");
        coll.add("a6");
        coll.add("a5");
        System.out.println(coll);

        Iterator<String> it = coll.iterator();
        while (it.hasNext()){
            String obj = it.next();
            System.out.println(obj);
        }
    }


    @Override
    public String toString() {
        return "IteratorDemo{}";
    }
}
