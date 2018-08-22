package com.allen.spring.multithreading.sample;

public class DaemonThread extends Thread {

	private int i = 1;

	public DaemonThread() {
		super();
	}

	public DaemonThread(String name) {
		super(name);
	}

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

	public static void main(String[] args) throws InterruptedException {

		DaemonThread thread = new DaemonThread("MyThread");
		thread.setDaemon(true);// 将该线程设置为伴随线程
		thread.start();
		Thread.sleep(500);// 主线程5000ms后结束，伴随线程也结束。
		System.out.println(Thread.currentThread().getName());
		System.out.println("主线程停止了,伴随线程也停止了。");
	}

}
