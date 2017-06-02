package edu.neu.info6205.algo;

public class Request 
{
	private int requestId;
	private int processTime = 2000;
	private long requestTime;
	private boolean processsed = false;
	private VirtualMachine vm;
	private static int count = 0; 
	
	public Request()
	{
		count ++;
		requestId = count;
		requestTime = System.currentTimeMillis();
	}
	
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

	public long getRequestTime() 
	{
		return requestTime;
	}

	public void setRequestTime(long requestTime) 
	{
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

	public VirtualMachine getVm() 
	{
		return vm;
	}

	public void setVm(VirtualMachine vm) 
	{
		this.vm = vm;
	}

	public static int getCount() 
	{
		return count;
	}
}