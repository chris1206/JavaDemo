package com.chris.Thread;

/**
 * Created by Chris on 2017/11/9.
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLockRunnable dlr = new DeadLockRunnable();
        Thread t = new Thread(dlr);
        t.start();
    }
}
