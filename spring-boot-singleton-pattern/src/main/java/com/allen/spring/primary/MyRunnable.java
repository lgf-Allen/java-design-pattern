/**
 * 
 */
package com.allen.spring.primary;

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
        System.out.println("My Runnable");
    }
    public static void main(String[] args) {
        Runnable run = new MyRunnable();
        Thread thread = new Thread(run);
        thread.start();
    }

}
