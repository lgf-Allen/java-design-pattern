/**
 * 
 */
package com.allen.spring.multithreading;

/**
 * @author first
 *
 */
public class MyThread extends Thread {

    public MyThread() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MyThread(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        System.out.println("Thread name is " + MyThread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread("MyThread");
        myThread.start();
    }
}
