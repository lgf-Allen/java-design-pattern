package com.allen.spring.singleton.pattern;

public enum SingletonEnum {

	//定义一个枚举类型的元素,它就是SingletonEnum的一个实例
	INSTANCE;
		
	public void fun() {
		System.out.println("Do something.");
	}
}
