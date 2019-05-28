package com.chris.annotation;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by Chris on 2018/3/13.
 *
 * Field的getModifiers()方法返回int类型值表示该字段的修饰符
 * PUBLIC: 1
 PRIVATE: 2
 PROTECTED: 4
 STATIC: 8
 FINAL: 16
 SYNCHRONIZED: 32
 VOLATILE: 64
 TRANSIENT: 128
 NATIVE: 256
 INTERFACE: 512
 ABSTRACT: 1024
 STRICT: 2048
 */
public class AnnotaionTest {

    @Test
    public void test(){
        Class<?> clazz = DemoBean.class;
        Field[] fields = clazz.getDeclaredFields();//拿到它定义的所有字段
        for(Field field:fields){
            if(field.isAnnotationPresent(AnnotationDemo.class)){
                System.out.println("有注解");
            }
            AnnotationDemo annotationDemo = field.getAnnotation(AnnotationDemo.class);
            if(annotationDemo != null){
                System.out.println("注解 name："+annotationDemo.name());
                System.out.println("注解 value："+annotationDemo.value());
            }
            System.out.println("属性："+field.getName()+"   "+field.getModifiers());
        }
    }
}
