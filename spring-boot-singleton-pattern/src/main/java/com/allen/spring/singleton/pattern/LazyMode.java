/**
 * 
 */
package com.allen.spring.singleton.pattern;

/**
 * @author meng
 *
 */
public class LazyMode {

	private static LazyMode mode = null;

	private LazyMode() {
		super();
	}
	
	public LazyMode getInstance() {
		if(mode == null) {
			mode = new LazyMode();
		}
		return mode;
	}
	
	
}
