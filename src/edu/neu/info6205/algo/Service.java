package edu.neu.info6205.algo;

public class Service 
{
	private static Service service;
	private static VirtualMachine[] machines = new VirtualMachine[5];
	private static Thread[] threads = new Thread[machines.length];
	
	private Service() 
	{	
		for (int i = 0; i < machines.length; i++)
			{
				machines[i] = new VirtualMachine();
			}
	}
	
	public static Service getInstance() 
	{
		if(service == null)
			service = new Service();
		return service;
	}

	public VirtualMachine availableVM()
	{
		for(int i = 0; i < machines.length; i++)
		{
			if(machines[i].isEmployed())
				{
					if(!((machines[i].getVmQueue()).isFull()))
						return machines[i];
				}
			else 
				{
					employVM(machines[i]);
					threads[i] = new Thread(machines[i]);
					threads[i].start();
					return machines[i];
				}					
		}
		
		return null;
	}
	
	public void employVM(VirtualMachine vm)
	{
		vm.setEmployed(true);
		
	}
	
	public void releaseVM(VirtualMachine vm)
	{
		vm.setEmployed(false);
	}
}
