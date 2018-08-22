/**
 * 
 */
package com.allen.spring.multithreading.create;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author first
 *
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("MyCallable thread start...");
//        Thread.sleep(2000);
        return 1;
    }
    public static void main(String[] args) {
        // 创建一个Callable的引用指向Callable实现类
        Callable<Integer> call = new MyCallable();
        // 创建一个FutureTask，指定Callable对象，做为线程任务。
        FutureTask<Integer> futureTask = new FutureTask<Integer>(call);
        // 创建一个线程,指定线程任务
        Thread thread = new Thread(futureTask);
        //启动线程
        thread.start();
    }

}
