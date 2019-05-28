package com.chris.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by Chris on 2017/11/7.
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException{
        //构造方法会主动根据文件路径创建文件，如果文件已存在，则会直接覆盖文件内容
        FileOutputStream fos = new FileOutputStream("/Volumes/Chris/b.txt");
        //字符流转为字节流的桥梁
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        //100会转为一个字节写入eg:01011000,最终会转为ASCII码值存储在文件中
        fos.write(100);
        byte[] bytes = {65,66,67,68};
        fos.write(bytes);
        fos.write(bytes,1,2);
        fos.write("hello\r\nchris龙".getBytes());
        //关闭流
        fos.close();

    }


}
