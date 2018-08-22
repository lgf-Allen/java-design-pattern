package com.allen.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringBootMultithreadingApplication extends Thread {

    public SpringBootMultithreadingApplication(String string) {
        super(string);
    }
    public static void main(String[] args) throws InterruptedException {
        // SpringApplication.run(SpringBootMultithreadingApplication.class, args);
        SpringBootMultithreadingApplication thread = new SpringBootMultithreadingApplication("MyThread");
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);//主线程等待,选择MytRed
        System.out.println(Thread.currentThread().getName());
        System.out.println("我离开thread对象也不再打印了，也就是停止了！");
    }

    private int i = 0;
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
