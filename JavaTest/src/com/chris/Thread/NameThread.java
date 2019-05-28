package com.chris.Thread;

/**
 * Created by Chris on 2017/11/9.
 */
public class NameThread extends Thread {
    public NameThread(){
        super("小强");
    }
    @Override
    public void run() {
        System.out.println(getName());
    }
}
