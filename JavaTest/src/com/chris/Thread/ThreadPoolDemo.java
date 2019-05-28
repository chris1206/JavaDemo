package com.chris.Thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by Chris on 2017/11/9.
 * Java通过Executors提供四种线程池，分别为：
 newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序
 (FIFO, LIFO, 优先级)执行。
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws Exception{
        func();
//        func1();
    }

    static void func(){
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new ThreadPoolRunnable());
        es.submit(new ThreadPoolRunnable());
        es.submit(new ThreadPoolRunnable());

        es.shutdown();
    }

    static void func1() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<String> f = es.submit(new ThreadPoolCallable());
        String value = f.get();
        System.out.println(value);
    }

    //两个计算任务
    static void add(){

    }

    /**
    * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程
    * */
    @Test
    public void newCachedThreedPool(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
    @Test
    public void newFixedThreadPool(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            System.out.println("index="+index);
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //创建一个定长线程池，支持定时及周期性任务执行
    @Test
    public void newScheduledThreadPool(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }

    //表示延迟1秒后每3秒执行一次
    @Test
    public void scheduledThreadPool(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        System.out.println("shcdule start");
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
        System.out.println("shcdule end");
    }

    //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
    @Test
    public void newSingleThreadPool() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println("index=" + index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
