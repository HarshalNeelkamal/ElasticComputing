package edu.neu.info6205.algo;

import edu.neu.info6205.dataStructure.VMQueue;

public class VirtualMachine implements Runnable
{
	private VMQueue vmQueue;
	private boolean employed;
	
	public VirtualMachine() 
	{
		vmQueue = new VMQueue();
		employed = false;
	}

	synchronized public VMQueue getVmQueue() 
	{
		return vmQueue;
	}

	public void setVmQueue(VMQueue vmQueue) 
	{
		this.vmQueue = vmQueue;
	}

	synchronized public boolean isEmployed() 
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
		try 
		{
			Thread.sleep(Service.getInstance().getProccessTime());
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		request.setProcesssed(true);
		releaseRequest(request);
	}
	
	public void releaseRequest(Request request)
	{
		Request r = request.getVm().getVmQueue().deque();
		Service service = Service.getInstance();
		service.setInProcCount(service.getInProcCount()-1);
		service.setProcessedCount(service.getProcessedCount() + 1);

		if(request.getVm().getVmQueue().isEmpty())
		{
			service.releaseVM(request.getVm());
		}
		
		if(r != null)
		{
			long time_temp = System.currentTimeMillis() - r.getRequestTime(); 
			long avgProcTimeTotal_service = service.getAvgProccessTimeStorage();
			int proccessedCount_service = service.getProcessedCount();
			if(proccessedCount_service > 100)
			{
				service.setAvgProccessTimeStorage(avgProcTimeTotal_service - service.getAvgProccessTime() + time_temp);
				service.setAvgProccessTime(service.getAvgProccessTimeStorage()/100);
			}
			else
			{
				service.setAvgProccessTimeStorage(avgProcTimeTotal_service + time_temp);
				service.setAvgProccessTime(service.getAvgProccessTimeStorage()/proccessedCount_service);
			}
		}
	}

	@Override
	public void run() 
	{
		while (isEmployed())
		{
			if(getVmQueue().isEmpty())
			{}
			else
			{
				Request request = getVmQueue().peek();
				if(request != null)
					processCurrentRequest(request);
			}
		}
	}
}