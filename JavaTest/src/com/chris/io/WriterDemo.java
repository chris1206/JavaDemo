package com.chris.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Chris on 2017/11/7.
 * 字符输出流-仅能操作文字
 */
public class WriterDemo {
    public static void main(String[] args) throws IOException{
        FileWriter fw = new FileWriter("/Volumes/Chris/a.txt");
        fw.write(100);
        fw.flush();
        char[] c = {'a','b','c','d','e'};
        fw.write(c);
        fw.flush();
        fw.write(c,2,2);
        fw.flush();
        fw.write("hello");
        fw.flush();

        fw.close();
    }
}
