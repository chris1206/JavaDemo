package com.chris.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Chris on 2017/11/7.
 */
public class FileOutputStreamDemo1 {
    public static void main(String[] args){
        File file;
        FileOutputStream fos = null;
        try {
            file = new File("/Volumes/Chris/c.txt");
            //构造方法会主动根据文件路径创建文件，如果文件已存在，则会直接覆盖文件内容
            fos = new FileOutputStream(file, true);
            //100会转为一个字节写入eg:01011000,最终会转为ASCII码值存储在文件中
            fos.write(100);
            byte[] bytes = {65, 66, 67, 68};
            fos.write(bytes);
            fos.write(bytes, 1, 2);
            fos.write("hello\r\nchris龙".getBytes());
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("文件写入异常，请重试~");
        }finally {
            //关闭流
            try {
                //注意点，需要对fos是否创建成功进行判定,决定是否释放资源
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("文件关闭失败！");
            }
        }


    }


}
