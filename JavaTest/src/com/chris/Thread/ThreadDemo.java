package com.chris.Thread;

/**
 * Created by Chris on 2017/11/9.
 */
public class ThreadDemo implements  Runnable{
    public static void main(String[] args) {
        NameThread nt = new NameThread();
        nt.setName("大王");
        nt.start();

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+" "+thread.getId());

        new Thread(() -> System.out.println("aaa")).start();

    }

    @Override
    public void run() {

    }
}
