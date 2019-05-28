package com.chris.reflect;

import com.chris.hashmap.Person;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Chris on 2017/11/10.
 * 三种拿到class文件对象的方式
 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        //对象获取方式
        Person person = new Person("tom",12);
        Class c1 = person.getClass();
        System.out.println(c1);
        //类调用静态方法方式
        Class c2 = Person.class;
        System.out.println(c2);
        //反射获取
        Class c3 = Class.forName("com.chris.hashmap.Person");
        System.out.println(c3);
        System.out.println(c1==c2);
        System.out.println(c2.equals(c3));

    }

    //获取空参构造器
    @Test
    public void test1() throws Exception {
        Class c = Class.forName("com.chris.hashmap.Person");
        Constructor con = c.getConstructor();
        Object object = con.newInstance();
        System.out.println(object.toString());
        Person p = (Person)object;
        p.eat();

        //如果有空参构造器，并且是public的，则可以用简单点的方式调用
        Object obj = c.newInstance();
        System.out.println(obj);
    }

    //根据参数类型获取指定构造器
    @Test
    public void test2() throws Exception {
        Class c = Class.forName("com.chris.hashmap.Person");
        Constructor con = c.getConstructor(String.class, int.class);
        Person p = (Person) con.newInstance("张三", 18);
        System.out.println(p);
    }

    //演示反射暴力破解私有构造方法
    @Test
    public void test3() throws Exception {
        Class c = Class.forName("com.chris.hashmap.Person");
        Constructor con = c.getDeclaredConstructor(int.class, String.class);
        con.setAccessible(true);
        Person p = (Person) con.newInstance(20, "LISA");
        System.out.println(p);
    }

    //反射获取成员变量
    @Test
    public void test4() throws Exception {
        Class c = Class.forName("com.chris.hashmap.Person");
//        Field[] fieldss = c.getFields();//返回所有public类型的成员变量
//        for (Field field:fieldss){
//            System.out.println(field);
//        }
        Object object = c.newInstance();

        Field field = c.getField("name");
        field.set(object, "mark");

        System.out.println(object);
    }

    //反射获取成员方法
    @Test
    public void test5() throws Exception {
        Class c = Class.forName("com.chris.hashmap.Person");
//        Method[] methods = c.getMethods();//返回所有public类型的成员变量
//        for (Method method:methods){
//            System.out.println(method);
//        }
        Object object = c.newInstance();

        Method method = c.getMethod("eat");
        method.invoke(object);

        Method method1 = c.getMethod("play", double.class, String.class);
        method1.invoke(object, 12,"我今年");

    }

    //演示泛型擦除-绕过编译
    @Test
    public void test6() throws Exception {

        ArrayList<String> list = new ArrayList<>();
        list.add("a");

        Class c = list.getClass();
        Method method = c.getMethod("add", Object.class);
        method.invoke(list, 123);
        method.invoke(list, 456);

        System.out.println(list);

    }

    //通过配置文件，不调用具体的类名和方法名
    @Test
    public void test7() throws Exception {
//        FileReader fr = new FileReader("config.properties");
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream
                ("config.properties"));
        Class c = Class.forName(properties.getProperty("className"));
        Object obj = c.newInstance();
        Method method = c.getMethod(properties.getProperty("methodName"));
        method.invoke(obj);

    }
}

