package com.chris.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Chris on 2017/11/9.
 */
public class CommonIODemo {
    public static void main(String[] args) throws IOException {
//        String extension = FilenameUtils.getExtension("abc.java");
//        System.out.println(extension);
        FileUtils.copyFile(new File("/Volumes/Chris/a.txt"), new File("/Users/Chris/Desktop/a.txt"));
    }
}
