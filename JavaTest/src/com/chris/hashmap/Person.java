package com.chris.hashmap;

import java.io.Serializable;

/**
 * Created by Chris on 2017/11/6.
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 1L;

    public String name;

    private /*transient 阻止成员序列化的 */ int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void eat(){
        System.out.println("人吃饭");
    }

    private void play(){
        System.out.println("人在打游戏");
    }

    public void play(double h, String str){
        System.out.println(str+"..."+h);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
