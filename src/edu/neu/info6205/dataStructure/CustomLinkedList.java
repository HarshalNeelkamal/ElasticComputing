package edu.neu.info6205.dataStructure;

import edu.neu.info6205.algo.Request;

public class CustomLinkedList {

	class Node{
		Request data;
		Node next;
		
		Node(Request data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	Node head = null;
	Node rear = null;
	
	public void add(Request data)
	{
		Node n = new Node(data, null);
		if(head == null){
			head = n;
			rear = head;
		}else{
			rear.next = n;
			rear = rear.next;
		}
	}
	
	// probably wont be required
	public Request dequeRequest(){
		Request returnableValue = head.data;
		head = head.next;
		return returnableValue;
	}
	
}
