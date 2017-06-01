package edu.neu.info6205.algo;

import java.util.Timer;
import java.util.TimerTask;

import edu.neu.info6205.dataStructure.VMQueue;

public class VirtualMachine implements Runnable
{
	private synchronized VMQueue vmQueue;
	private boolean employed;
	private Timer timer;
	 
	public VirtualMachine() 
	{
		vmQueue = new VMQueue();
		timer = new Timer();
		employed = false;
	}

	public VMQueue getVmQueue() 
	{
		return vmQueue;
	}

	public void setVmQueue(VMQueue vmQueue) 
	{
		this.vmQueue = vmQueue;
	}

	public boolean isEmployed() 
	{
		return employed;
	}

	public void setEmployed(boolean employed) 
	{
		this.employed = employed;
	}

	public void processCurrentRequest(Request request)
	{
		//process request for some time
		
		timer.schedule(new TimerTask() 
		{
			
			@Override
			public void run() 
			{
				
			}
		}, 200, request.getProcessTime());
		request.setProcesssed(true);
		releaseRequest(request);
	}
	
	public void releaseRequest(Request request)
	{
		Request r = request.getVm().getVmQueue().deque();
		Service service = Service.getInstance();
		if(request.getVm().getVmQueue().isEmpty())
			service.releaseVM(request.getVm());
	}

	@Override
	public void run() 
	{
		while (isEmployed())
		{
			Request request = getVmQueue().peek();
			processCurrentRequest(request);
		}
	}
}