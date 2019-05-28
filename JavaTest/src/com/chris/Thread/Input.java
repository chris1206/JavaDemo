package com.chris.Thread;

/**
 * Created by Chris on 2017/11/9.
 */
public class Input implements Runnable {
    Resources r;
    int i=0;
    public Input(Resources r){
        this.r = r;
    }
    @Override
    public void run() {
        while (true){
            synchronized (r) {
                //如果flag=true，代表输出还未结束，赋值需要无限等待
                if(r.flag){
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
                if (i % 2 == 0) {
                    r.name = "张三";
                    r.sex = "男";
                } else {
                    r.name = "lisi";
                    r.sex = "nv";
                }

                r.flag = true;
                r.notify();
            }
            i++;
        }
    }
}
