package com.allen.spring.primary;

public class MyThread extends Thread {

    private int count = 5;
    
    
    public MyThread() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MyThread(String name) {
        this.setName(name);
    }

    @Override
    public synchronized void  run() {
        super.run();
        while(count >0) { count--;
        System.out.println("由"+ MyThread.currentThread().getName()+"计算，count = "+count);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread , "A");
        Thread b = new Thread(myThread , "B");
        Thread c = new Thread(myThread , "C");
        b.start();
        a.start();
        c.start();
    }
}
