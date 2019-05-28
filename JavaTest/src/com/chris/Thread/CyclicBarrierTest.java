package com.chris.Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Chris on 2018/5/18.
 * // 1或者多个线程相互等待
 */
public class CyclicBarrierTest {
    private static int SIZE = 5;
    private static CyclicBarrier mCyclicBarrier;//循环栅栏

    public static void main(String[] args) {

        mCyclicBarrier = new CyclicBarrier(SIZE, new Runnable() {
            public void run() {
                System.out.println(" ---> 满足条件,执行特定操作。 参与者: " + mCyclicBarrier.getParties());
            }
        });

        // 新建5个任务
        for (int i = 0; i < SIZE; i++) {
            new WorkerThread().start();
        }
    }

    static class WorkerThread extends Thread {
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " 等待 CyclicBarrier.");

                // 将mCyclicBarrier的参与者数量加1
                mCyclicBarrier.await();
                // mCyclicBarrier的参与者数量等于5时，才继续往后执行
                System.out.println(Thread.currentThread().getName() + " 继续执行.");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
