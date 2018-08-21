/**
 * 
 */
package com.allen.spring.boot.pattern;

/**
 * @author meng
 *
 */
public class Package {

	private PackageState state = new OrderedState();
	
	

	public void previousState() {
		state.prev(this);
	}

	public void nextState() {
		state.next(this);
	}

	public void printStatus() {
		state.printStatus();
	}

	public void setState(OrderedState orderedState) {
		// TODO Auto-generated method stub
		
	}

	public void setState(ReceivedState receivedState) {
		// TODO Auto-generated method stub
		
	}

	public void setState(DeliveredState deliveredState) {
		// TODO Auto-generated method stub
		
	}
}
