package edu.neu.info6205.algo;

public class Request 
{
	int requestId;
	int processTime;
	long requestTime;
	boolean processsed = false;
	
	public int getRequestId() 
	{
		return requestId;
	}
	
	public void setRequestId(int requestId) 
	{
		this.requestId = requestId;
	}
	
	public int getProcessTime() 
	{
		return processTime;
	}
	
	public void setProcessTime(int processTime) 
	{
		this.processTime = processTime;
	}
	
	

	public long getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}

	public boolean isProcesssed() 
	{
		return processsed;
	}

	public void setProcesssed(boolean processsed) 
	{
		this.processsed = processsed;
	}
}