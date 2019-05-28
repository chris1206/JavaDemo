package com.chris.io;

import java.io.*;

/**
 * Created by Chris on 2017/11/9.
 */
public class PrintWriterDemo {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        copy();
    }

    static void copy() throws IOException{
        //源数据
        BufferedReader bf = new BufferedReader(new FileReader("/Volumes/Chris/c.txt"));
        //目的数据
        PrintWriter pw = new PrintWriter(new FileWriter("/Volumes/Chris/d.txt"));
        String line = null;
        while ((line = bf.readLine())!=null){
            pw.println(line);
        }
        pw.close();
        bf.close();

    }

    static void func1() throws IOException{
        File file = new File("/Volumes/Chris/1.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println("你好a");//会原样输出
        pw.write(100);
        pw.close();
    }
}
