/**
 * 
 */
package com.allen.spring.multithreading.create;

/**
 * @author first
 *
 */
public class MyRunnable implements Runnable {

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
       System.out.println("Thread name is "+ Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable, "MyRunnable");
        thread.start();
    }

}
