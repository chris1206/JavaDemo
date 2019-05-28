package com.chris.Thread;

/**
 * Created by Chris on 2017/11/9.
 */
public class ThreadTicketDemo {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Thread thread0 = new Thread(tickets);
        Thread thread1 = new Thread(tickets);
        Thread thread2 = new Thread(tickets);
        thread0.start();
        thread1.start();
        thread2.start();
    }
}
