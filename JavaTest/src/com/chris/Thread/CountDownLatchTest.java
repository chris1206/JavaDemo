package com.chris.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Chris on 2018/5/18.
 */
public class CountDownLatchTest {
    private static int LATCH_SIZE = 5;

    public static void main(String[] args) {

        try {
            CountDownLatch latch = new CountDownLatch(LATCH_SIZE);

            // 新建5个任务
            for (int i = 0; i < LATCH_SIZE; i++) {
                new InnerThread(latch).start();
            }

            System.out.println("主线程等待.");
            // "主线程"等待线程池中5个任务的完成
            latch.await();
            System.out.println("主线程继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class InnerThread extends Thread {

        CountDownLatch mLatch;

        public InnerThread(CountDownLatch latch) {
            mLatch = latch;
        }

        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " 执行操作.");
                // 将CountDownLatch的数值减1
                mLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
