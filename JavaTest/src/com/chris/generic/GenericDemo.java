package com.chris.generic;

import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Chris on 2018/3/13.
 * 展示泛型的常用方法
 * 泛型有三种使用方式，分别为：泛型类、泛型接口、泛型方法
 */
public class GenericDemo {

    public GenericDemo() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
    }

    public static void main(String[] args) {

    }

    //===================泛型类=========================

    /**
     * 下面的例子可以证明，在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，只在编译阶段有效。
     */
    @Test
    public void genericTest() {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if (classStringArrayList.equals(classIntegerArrayList)) {
            System.out.println(classStringArrayList.toGenericString());
            System.out.println(classStringArrayList.toString());
            System.out.println("泛型测试:" + "类型相同");
        }
    }

    public class Generic<T> {
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }

    }

    //泛型类使用-可传入泛型实参
    @Test
    public void testSimpleGenericClass() {
        Generic<Integer> genericInteger = new Generic<>(1234);
        Generic<String> genericString = new Generic<>("hello");
        System.out.println(genericInteger.getKey());
        System.out.println(genericString.getKey());
    }

    //注意：泛型的类型参数只能是类类型，不能是简单类型。
    @Test
    public void testNoParameterClass() {
        Generic generic = new Generic("11111");
        Generic generic1 = new Generic(2222);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        System.out.println(generic.getKey());
        System.out.println(generic1.getKey());
        System.out.println(generic2.getKey());
        System.out.println(generic3.getKey());
    }

    //===================泛型接口=========================
    public interface IGeneric<T> {
        T next();
    }

    //该泛型类实现泛型接口必须声明<T>,固定格式
    class FruitGeneric<T> implements IGeneric<T> {

        @Override
        public T next() {
            return null;
        }

    }

    //定义传入实参的类
    class FruitGeneric2 implements IGeneric<String> {

        private String[] fruits = new String[]{"apple, orange, pear"};

        @Override
        public String next() {
            Random rand = new Random();
            return fruits[1];
        }
    }

    //泛型通配符
    public void showKeyValue(Generic<Number> obj) {
        System.out.println("泛型测试key value is " + obj.getKey());
    }

    @Test
    public void test() {

        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);

        //Generic<Integer>不能被看作为`Generic<Number>的子类,不同版本的泛型类实例是不兼容的
        showKeyValue(gNumber);

        showKeyValue1(gInteger);
    }

    /**
     * 我们需要一个在逻辑上可以表示同时是Generic<Integer>和Generic<Number>父类的引用类型。由此类型通配符应运而生
     * 此处’？’是类型实参，而不是类型形参 ！再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，
     * 可以把？看成所有类型的父类。是一种真实的类型
     */
    public void showKeyValue1(Generic<?> obj) {
        System.out.println("泛型测试key value is " + obj.getKey());
    }

    //=============================泛型方法================================
    /**
     * 泛型类，是在实例化类的时候指明泛型的具体类型；泛型方法，是在调用方法的时候指明泛型的具体类型
     */
    /**
     * 泛型方法的基本介绍
     *
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     * 1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * 4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass) throws InstantiationException,
            IllegalAccessException {
        T instance = tClass.newInstance();
        return instance;
    }

//    Object obj = genericMethod(Class.forName("com.test.test"));

    /**
     * 这才是一个真正的泛型方法。
     * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置.
     * 泛型的数量也可以为任意多个
     * 如：public <T,K> K showKeyName(Generic<T> container){
     * ...
     * }
     */
    public <T> T showKeyName(Generic<T> container) {
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }

    //类中的泛型方法
    class GenerateTest1<T> {
        public void show_1(T t) {
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
        //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
        public <E> void show_3(E t) {
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
        public <T> void show_2(T t) {
            System.out.println(t.toString());
        }
    }


    class Fruit {
        @Override
        public String toString() {
            return "fruit";
        }
    }

    class Apple extends Fruit {
        @Override
        public String toString() {
            return "apple";
        }
    }

    class Person {
        @Override
        public String toString() {
            return "Person";
        }
    }

    class GenerateTest<T> {
        public void show_1(T t) {
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
        //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
        public <E> void show_3(E t) {
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
        public <T> void show_2(T t) {
            System.out.println(t.toString());
        }
    }

    @Test
    public void main1() {
        Apple apple = new Apple();
        Person person = new Person();

        GenerateTest<Fruit> generateTest = new GenerateTest<Fruit>();
        //apple是Fruit的子类，所以这里可以
        generateTest.show_1(apple);
        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
//        generateTest.show_1(person);

        //使用这两个方法都可以成功
        generateTest.show_2(apple);
        generateTest.show_2(person);

        //使用这两个方法也都可以成功
        generateTest.show_3(apple);
        generateTest.show_3(person);
    }

    //泛型方法与可变长参数
    public <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println(t.toString());
        }
    }

    @Test
    public void test2() {
        printMsg("aaa", 12, 'c', 16.24, "bbb");
        List<String> list = new ArrayList<>();
        list.add("aaa");
    }

    //如果静态方法要使用泛型的话，必须将静态方法也定义成泛型方法

//    public class StaticGenerator<T> {
        /**
         * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
         * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
         * 如：public static void show(T t){..},此时编译器会提示错误信息：
         "StaticGenerator cannot be refrenced from static context"
         */
        public static <T> void show(T t){

        }
//    }

    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
    //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName2(Generic<T> container){
//    public <T> T showKeyName(Generic<T extends Number> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }

    //泛型数组-不能创建一个确切的泛型类型的数组,说白了就是不允许创建确切类型的泛型数组
//    List<String>[] ls = new ArrayList<String>[10];
    List<?>[] ls1 = new ArrayList<?>[10];
    List<String>[] ls2 = new ArrayList[10];

    @Test
    public void test3(){
//        List<String>[] lsa = new List<String>[10]; // Not really allowed.
//        Object o = lsa;
//        Object[] oa = (Object[]) o;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        oa[1] = li; // Unsound, but passes run time store check
//        String s = lsa[1].get(0); // Run-time error: ClassCastException.
    }

    //Demo

    class student
    {
        private Map<String,Integer> score ;

    }

    @Test
    public void test4() throws NoSuchFieldException {
        Class<student> clazz = student.class;

        Field f = clazz.getDeclaredField("score");

        //通过getType方法只能获得普通类型
        System.out.println("score的类型是：" + f.getType()); //打印Map

        AnnotatedType annotatedType = f.getAnnotatedType();

        //1. 获得f的泛型类型
        Type gType = f.getGenericType();

        //2.如果gType是泛型类型对像
        if(gType instanceof ParameterizedType)
        {
            ParameterizedType pType = (ParameterizedType)gType;
            //获取原始类型
            Type rType = pType.getRawType();
            System.out.println("原始类型是: " + rType);

            //获得泛型类型的泛型参数
            Type[] gArgs = pType.getActualTypeArguments();
            //打印泛型参数
            for(int i=0; i < gArgs.length; i ++)
            {
                System.out.println("第"+ i +"个泛型类型是：" + gArgs[i]);
            }
        }
        else{
            System.out.println("获取泛型信息失败");
        }
    }


}
