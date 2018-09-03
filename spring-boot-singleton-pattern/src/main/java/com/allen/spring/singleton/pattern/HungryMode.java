/**
 * 
 */
package com.allen.spring.singleton.pattern;

/**
 * 饿汉模式实现单例模式
 * @author meng
 *
 */
public final class HungryMode {

	private static HungryMode hungryMode = new HungryMode();

	private HungryMode() {

	}
	
	public static HungryMode getInstance() {
		return hungryMode;
	}
	
}
