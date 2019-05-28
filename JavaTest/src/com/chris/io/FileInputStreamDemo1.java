package com.chris.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chris on 2017/11/7.
 * 读取文件-调用read方法，读取一个字符后会自动调下一个read方法
 * 数组的作用-缓冲，提高效率
 */
public class FileInputStreamDemo1 {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("/Volumes/Chris/c.txt");
        //字节流转为字符流的桥梁
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        byte[] bytes = new byte[1024];//-缓冲，提高效率
        System.out.println("bytes="+bytes.length+" "+bytes[0]+" "+bytes[1]);

        int len = 0;
        //int len = fis.read(bytes);//读到多少个有效的字节个数

//        while ((len=fis.read(bytes))!=-1) {
//            System.out.print(new String(bytes));
//        }

        while ((len=fis.read(bytes))!=-1) {
            System.out.print(new String(bytes,0,len));
        }

        //以下代码演示的是fis读取文件内容的规则
        /*System.out.println(new String(bytes));
        System.out.println(len);

        int len1 = fis.read(bytes);

        System.out.println(new String(bytes));
        System.out.println(len1);

        int len2 = fis.read(bytes);

        System.out.println(new String(bytes));
        System.out.println(len2);

        int len3 = fis.read(bytes);

        System.out.println(new String(bytes));
        System.out.println(len3);*/

        fis.close();
    }
}
