package com.chris.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Chris on 2017/11/7.
 */
public class ReaderDemo {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("/Volumes/Chris/a.txt");
        int len = 0;
//        while ((len=fr.read()) != -1) {
//            System.out.print((char) len);
//        }
        //方式二：
        char[] c = new char[1024];
        while ((len=fr.read(c)) != -1) {
            System.out.print(new String(c,0,len));
        }

        fr.close();
    }
}
