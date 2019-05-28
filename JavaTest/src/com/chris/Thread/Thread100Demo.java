package com.chris.Thread;

/**
 * Created by Chris on 2018/5/17.
 */
public class Thread100Demo {

    public static void main(String[] args) {
        /*只有一个TestThread对象*/
        TestThread t = new TestThread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }

}

class TestThread implements Runnable {
    int i = 1;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
        /*指代的为 t,因为使用的是implements方式。若使用继承Thread类的方式，慎用this*/
            synchronized (this) {
            /*唤醒另外一个线程，注意是this的方法，而不是Thread*/
                notify();
                try {
            /*使其休眠100毫秒，放大线程差异*/
                    //Thread,currentThread().sleep(0,100);使其休眠100纳秒
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (i <= 100) {

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                    /*放弃资源，等待*/
                        wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
