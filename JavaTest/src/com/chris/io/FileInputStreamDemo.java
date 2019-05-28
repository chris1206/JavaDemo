package com.chris.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Chris on 2017/11/7.
 * 读取文件-调用read方法，读取一个字符后会自动调下一个read方法
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("/Volumes/Chris/c.txt");
        int len = 0;
        //fis.read()返回的是ascii码值data
        while ((len=fis.read()) != -1){
            System.out.print((char)len);
        }
        fis.close();
    }
}
