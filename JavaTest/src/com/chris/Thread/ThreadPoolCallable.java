package com.chris.Thread;

import java.util.concurrent.Callable;

/**
 * Created by Chris on 2017/11/9.
 */
public class ThreadPoolCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "abc";
    }
}
