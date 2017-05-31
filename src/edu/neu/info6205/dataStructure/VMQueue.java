package edu.neu.info6205.dataStructure;

import edu.neu.info6205.algo.Request;

public class VMQueue extends CustomQueue{

	//create header and rear as integer pointers and array for queue implementation 
	int header = 0;
	int rear = 0;
	int count = 0;
	Request queue[] = new Request[50]; 
	
	@Override
	public boolean enque(Request data) 
	{
		if((rear+1) % queue.length != header){
			count++;
			rear = (rear+1) % queue.length;
			queue[rear] = data;
			return true; 
		}else{
			System.out.println("OverFlow");
			return false;
		}
	}

	@Override
	public Request deque() 
	{
		if(header == rear){
			System.out.println("UnderFlow");
			return null;
		}else{
			count--;
			header = (header + 1)%queue.length;
			return queue[header];
		}
	}

	@Override
	public boolean isEmpty() 
	{
		return (header == rear);
	}

	@Override
	public Request peek() {
		return queue[header+1];
	}

	@Override
	public int size() 
	{
		return count;
	}
	
	public boolean isFull()
	{
		return false;
	}

}