package com.chris.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Chris on 2018/5/18.
 */
public class TicketServerLock {
    ReentrantLock mLock = new ReentrantLock();
    private volatile int ticketCount = 0;

    public void release(int count) {
        ticketCount += count;
    }

    public void sellTicket() {
        mLock.lock();
        try {
            if (ticketCount > 0) {
                sleep10Ms();
                System.out.println(Thread.currentThread().getName() + ", 余票为 : " + ticketCount);
                ticketCount--;
                showTickets();
            }
        } finally {
            mLock.unlock();
        }
    }

    Condition mCondition = mLock.newCondition();

    public void sellTicketWait() {
        mLock.lock();
        try {
            if (ticketCount > 0) {
                sleep10Ms();
                System.out.println(Thread.currentThread().getName() + ", 余票为 : " + ticketCount);
                ticketCount--;
                showTickets();
            }
        } finally {
            mLock.unlock();
        }
    }

    private void sleep10Ms() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getTicketCount() {
        try {
            mLock.lock();
            if (ticketCount == 0) {
                mCondition.await(3, TimeUnit.SECONDS);
                ticketCount += 3;
                mCondition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }

        return ticketCount;
    }

    private void showTickets() {
        System.out.println("卖出一张后,票数为 : " + ticketCount);
    }
}
