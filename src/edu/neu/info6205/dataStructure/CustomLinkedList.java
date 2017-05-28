package edu.neu.info6205.dataStructure;

public class CustomLinkedList {

	class Node{
		int data;
		Node next;
		
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	Node head = null;
	Node rear = null;
	
	public void add(int data){
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
	public int dequeRequest(){
		int returnableValue = head.data;
		head = head.next;
		return returnableValue;
	}
	
}
