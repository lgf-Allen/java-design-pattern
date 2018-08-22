/**
 * 
 */
package com.allen.spring.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author first
 *
 */
public class ThreadPool {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        // 创建多个有返回值的任务
//        List<Future> futures = new ArrayList<Future>(10);
//        for (int i = 1; i < 5; i++) {
//            Callable c = new Callable<Future>() {
//                @Override
//                public Future call() throws Exception {
//                    return null;
//                }
//            };
//            Future f = threadPool.submit(c);
//            futures.add(f);
//        }
        
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Create ThreadPool thread is " + Thread.currentThread().getName());
            }
        });
        // 关闭线程池
        threadPool.shutdown();

    }

}
