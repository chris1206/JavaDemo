package com.chris.Thread;

/**
 * Created by Chris on 2017/11/9.
 * 实现线程依次赋值取值操作-wait()与notify()需要锁对象调用才行
 */
public class ObjectLockDemo {
    public static void main(String[] args) {
        Resources r = new Resources();
        Input i = new Input(r);
        Output o = new Output(r);
        Thread tin = new Thread(i);
        Thread tout = new Thread(o);
        tin.start();
        tout.start();
    }
}
