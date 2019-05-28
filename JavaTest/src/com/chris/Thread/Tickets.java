package com.chris.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Chris on 2017/11/9.
 */
public class Tickets implements Runnable {
    private int tickets = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            payTicket1();
        }
    }

    public synchronized void payTicket(){
        saleTicket();
    }

    private void saleTicket() {
        if(tickets>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 出售第"+ tickets-- +"张票");
        }
    }

    public void payTicket1(){
        lock.lock();
        saleTicket();
        lock.unlock();
    }

}
