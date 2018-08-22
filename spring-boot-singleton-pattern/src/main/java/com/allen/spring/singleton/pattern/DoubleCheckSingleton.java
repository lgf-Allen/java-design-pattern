package com.allen.spring.singleton.pattern;

public class DoubleCheckSingleton {

	// 禁止JVM指令重排
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
