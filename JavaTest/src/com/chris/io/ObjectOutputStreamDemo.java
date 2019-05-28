package com.chris.io;

import com.chris.hashmap.Person;

import java.io.*;

/**
 * Created by Chris on 2017/11/9.
 * 静态的成员变量不能序列化
 */
public class ObjectOutputStreamDemo{
    public static void main(String[] args) throws IOException {
//        writeObj();
        readObj();
    }
    public static void readObj() throws IOException{
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            fis = new FileInputStream("/Volumes/Chris/person.txt");
            ois = new ObjectInputStream(fis);
            try {
                Object ob = ois.readObject();
                System.out.println(ob);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            ois.close();
            fis.close();
        }
    }
    public static void writeObj() throws IOException{
        try {
            FileOutputStream fos = new FileOutputStream("/Volumes/Chris/person.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Person person = new Person("Chris",27);
            oos.writeObject(person);

            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
