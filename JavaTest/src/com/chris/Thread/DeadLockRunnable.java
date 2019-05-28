package com.chris.Thread;

/**
 * Created by Chris on 2017/11/9.
 */
public class DeadLockRunnable implements Runnable{

    int index = 0;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (index % 2 == 0) {
                synchronized (LockA.lockA) {
                    System.out.println("if...locka");
                    synchronized (LockB.lockB) {
                        System.out.println("if...lockb");
                    }
                }
            } else {
                synchronized (LockB.lockB) {
                    System.out.println("else...lockb");
                    synchronized (LockA.lockA) {
                        System.out.println("else...locka");
                    }
                }
            }
            index++;
        }
    }
}
