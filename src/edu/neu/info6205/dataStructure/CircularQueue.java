package edu.neu.info6205.dataStructure;

public class CircularQueue extends CustomQueue{

	//create header and rear as integer pointers and array for queue implementation 
	int header = 0;
	int rear = 0;
	int count = 0;
	Integer queue[] = new Integer[50]; 
	
	@Override
	public boolean enque(int data) {
		// TODO Auto-generated method stub
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
	public int deque() {
		// TODO Auto-generated method stub
		if(header == rear){
			System.out.println("UnderFlow");
			return Integer.MAX_VALUE;
		}else{
			count--;
			header = (header + 1)%queue.length;
			return queue[header];
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (header == rear);
	}

	@Override
	public int peek() {
		return queue[header+1];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

}
