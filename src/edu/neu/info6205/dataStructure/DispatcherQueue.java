package edu.neu.info6205.dataStructure;

import edu.neu.info6205.algo.Request;

public class DispatcherQueue extends CustomQueue
{
	//add header and rear
	CustomLinkedList list = new CustomLinkedList();
	int count = 0;
	
	@Override
	public boolean enque(Request data) 
	{
		try
		{
			list.add(data);
			count++;
		}
		
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public Request deque() 
	{
		if(list.head == null)
		{
			System.out.println("UnderFlow in Linked Stack");
			return null;
		}
		else
		{
			Request ret = list.head.data;
			list.head = list.head.next;
			count--;
			return ret;
		}
	}

	@Override
	public boolean isEmpty() 
	{
		return (list.head == null);
	}

	@Override
	public Request peek() 
	{
		if(list.head != null)
		{
			return list.head.data;
		}
		return null;
	}

	@Override
	public int size() 
	{
		return count;
	}
}