package edu.neu.info6205.algo;

import java.util.Timer;
import java.util.TimerTask;

import edu.neu.info6205.dataStructure.DispatcherQueue;

public class Dispatcher
{
	//Singleton
	private static Dispatcher instance = null;
	public static DispatcherQueue queue = new DispatcherQueue();
	private int dispatchPeriod = 2; //despatch period is 2ms
	private Timer dispatchTimer = new Timer();
	
	private Dispatcher()
	{}
	
	public void startDispatching()
	{
		queue.cleareQueue();
		dispatchTimer.scheduleAtFixedRate(new TimerTask() 
		{
			@Override
			public void run()
			{
				if(!queue.isEmpty())
				{
					dispatchRequest();
				}
			}
		}, dispatchPeriod, dispatchPeriod);
	}
	
	public void stopDispatchingRequests()
	{
		dispatchTimer.cancel();
		dispatchTimer = null;
		dispatchTimer = new Timer();
	}
	
	public static Dispatcher getInstance()
	{
		if(instance == null)
			instance = new Dispatcher();
		return instance;
	}
	
	public void queueRequest(Request request)
	{
		queue.enque(request);
	}
	
	public void dispatchRequest()
	{
		if(!queue.isEmpty())
		{
			VirtualMachine vm = Service.getInstance().availableVM();
			if(vm == null)
			{
				System.out.println("All available virtual machines are at their capacity.");
			}
			else
			{
				Request temp = queue.deque();
				temp.setVm(vm);
				vm.getVmQueue().enque(temp);
				// send temp to service layer
			}
		}
	}
	
}