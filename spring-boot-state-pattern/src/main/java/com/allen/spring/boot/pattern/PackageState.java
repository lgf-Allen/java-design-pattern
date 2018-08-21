/**
 * 
 */
package com.allen.spring.boot.pattern;

/**
 * @author meng
 *
 */
public interface PackageState {

	void next(Package pkg);

    void prev(Package pkg);

    void printStatus();
}
