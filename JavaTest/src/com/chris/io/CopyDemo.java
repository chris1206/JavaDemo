package com.chris.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Chris on 2017/11/7.
 * 实现简单的文件复制
 */
public class CopyDemo {

    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("/Volumes/Chris/c.txt");
            fos = new FileOutputStream("/Users/Chris/Desktop/c.txt");
//            int len = 0;
//            while ((len=fis.read())!=-1){
//                fos.write(len);
//            }
            //方式2，用字节数组循环写入
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("文件复制失败");
        }finally {
            try {
                if (fos != null)
                    fos.close();
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException("释放资源失败");
            }finally {
                try{
                if (fis != null)
                    fis.close();
                }catch (IOException e){
                    System.out.println(e);
                    throw new RuntimeException("释放资源失败");
                }
            }
        }
    }


}
