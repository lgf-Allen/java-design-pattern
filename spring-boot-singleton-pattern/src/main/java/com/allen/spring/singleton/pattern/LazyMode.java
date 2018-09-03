/**
 * 
 */
package com.allen.spring.singleton.pattern;

/**
 * @author meng
 *
 */
public final class LazyMode {

	private static LazyMode mode = null;

	private LazyMode() {
		super();
	}

	public LazyMode getInstance() {
		if (mode == null) {
			mode = new LazyMode();
		}
		return mode;
	}

	// Optimize method1:method add synchronized keyword.
	public synchronized LazyMode getInstanceOptimize1() {
		if (mode == null) {
			mode = new LazyMode();
		}
		return mode;
	}

	// Optimize method2:add synchronized block.
	public LazyMode getInstanceOptimize2() {
		synchronized (LazyMode.class) {
			if (mode == null) {
				mode = new LazyMode();
			}
		}
		return mode;
	}

}
