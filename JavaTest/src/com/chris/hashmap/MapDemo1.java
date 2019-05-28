package com.chris.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Chris on 2017/11/5.
 */
public class MapDemo1 {
    public static void main(String[] args) {
        function5();
    }

    private static void function1() {
        Map<String,Integer> hm = new HashMap<>();
        hm.put("a",1);
        hm.put("b",2);
        hm.put("c",3);
        hm.put("d",4);
        hm.put("d",6);

        hm.remove("c");
        System.out.println(hm);
        System.out.println(hm.get("d"));
    }

    private static void function2() {
        Map<String, Integer> hm2 = new HashMap<>();
        hm2.put("a", 1);
        hm2.put("b", 2);
        hm2.put("c", 3);
        hm2.put("d", 4);
        hm2.put("e", 5);

        Set<String> keyset = hm2.keySet();
        for(String key:keyset){
            System.out.println(key+"...."+hm2.get(key));
        }
    }

    private static void function3() {
        Map<String, Integer> hm1 = new HashMap<>();
        hm1.put("a", 1);
        hm1.put("b", 2);
        hm1.put("c", 3);
        hm1.put("d", 4);

        Set<Map.Entry<String, Integer>> entryset = hm1.entrySet();
        for(Map.Entry entry:entryset){
            System.out.println(entry.getKey()+"...."+entry.getValue());
        }
    }

    private static void function4(){
        Map<String, Person> map = new HashMap<>();
        map.put("北京", new Person("a",20));
        map.put("上海", new Person("b", 18));
        map.put("广州", new Person("c",25));
        map.put("深圳", new Person("d", 19));

        for(String key:map.keySet()) {
            Person person = map.get(key);
            System.out.println(key+"..." + person);
        }
    }

    private static void function5(){
        Map<Person, String> map = new HashMap<>();
        map.put(new Person("a",20),"北京");
        map.put(new Person("b", 18),"上海");
        map.put(new Person("b", 18),"上海1");
        map.put(new Person("c",25),"广州");
        map.put(new Person("d", 19),"深圳");

        for(Map.Entry<Person, String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+"..." + entry.getValue());
        }
    }


}
