package edu.neu.info6205.dataStructure;

import edu.neu.info6205.algo.Request;

public abstract class CustomQueue {
	
	public abstract boolean enque(Request data);
	public abstract Request deque();
	public abstract boolean isEmpty();
	public abstract Request peek();
	public abstract int size();
	
}
