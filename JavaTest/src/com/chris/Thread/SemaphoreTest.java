package com.chris.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Chris on 2018/5/18.
 */
public class SemaphoreTest {
    static int time = 0;

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {

                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(" 剩余许可 : "
                                + semaphore.availablePermits());
                        Thread.sleep(2000);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
