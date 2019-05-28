package com.chris.Thread;

/**
 * Created by Chris on 2017/11/9.
 */
public class Output implements Runnable {
    Resources r;
    public Output(Resources r){
        this.r = r;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (r) {
                if(!r.flag){
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(r.name + ".." + r.sex);

                r.flag = false;
                r.notify();
            }
        }
    }
}
