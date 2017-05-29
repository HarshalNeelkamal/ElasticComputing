package edu.neu.info6205.dataStructure;

public class LinkedQueue extends CustomQueue{

	//add header and rear
	CustomLinkedList list = new CustomLinkedList();
	int count = 0;
	
	@Override
	public boolean enque(int data) {
		// TODO Auto-generated method stub
		try{
			list.add(data);
			count++;
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public int deque() {
		// TODO Auto-generated method stub
		if(list.head == null){
			System.out.println("UnderFlow in Linked Stack");
			return Integer.MAX_VALUE;
		}else{
			int ret = list.head.data;
			list.head = list.head.next;
			count--;
			return ret;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (list.head == null);
	}

	@Override
	public int peek() {
		// TODO Auto-generated method stub
		if(list.head != null){
			return list.head.data;
		}
		return Integer.MAX_VALUE;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

}
