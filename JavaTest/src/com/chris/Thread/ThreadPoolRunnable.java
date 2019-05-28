package com.chris.Thread;

/**
 * Created by Chris on 2017/11/9.
 */
public class ThreadPoolRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 提交线程任务");
    }
}
