package com.allen.spring.singleton.pattern;

public final class DoubleCheckSingleton {

	/**
	 * 禁止JVM指令重排;
	 * 被volatile修饰的变量的值，将不会被本地线程缓存;
	 * 所有对该变量的读写都是直接操作共享内存，从而确保多个线程能正确的处理该变量
	 */
    private static volatile DoubleCheckSingleton singleton = null;

	private DoubleCheckSingleton() {
		super();
	}

	public static DoubleCheckSingleton getInstance() {
		// 检查实例是否存在
		if (singleton == null) {
			// 只有当第一次创建时才会进入
			synchronized (DoubleCheckSingleton.class) {
				// 进入同步代码块,如果还是null,创建实例
				if (singleton == null) {
					singleton = new DoubleCheckSingleton();
				}
			}
		}
		return singleton;
	}

}
