package edu.neu.info6205.algo;

public class Service 
{
	private static Service service;
	private static VirtualMachine[] machines = new VirtualMachine[5];
	private static Thread[] threads = new Thread[machines.length];
	private int inProcCount = 0;
	private int processedCount = 0;
	private int serversInProccess = 0;
	
	
	public int getServersInProccess() {
		return serversInProccess;
	}

	public void setServersInProccess(int serversInProccess) {
		this.serversInProccess = serversInProccess;
	}

	public int getProcessedCount() {
		return processedCount;
	}

	public void setProcessedCount(int processedCount) {
		this.processedCount = processedCount;
	}

	public int getInProcCount() {
		return inProcCount;
	}

	public void setInProcCount(int inProcCount) {
		this.inProcCount = inProcCount;
	}

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

	public VirtualMachine availableVM(){
		if(!machines[0].isEmployed())
		{
			System.out.println(">>>>>>>>>>first machine employed");
			inProcCount++;
			employVM(machines[0]);
			threads[0] = new Thread(machines[0]);
			threads[0].start();
			return machines[0];
		}else if(!(machines[0].getVmQueue()).isFull()){
			inProcCount++;
			return machines[0];
		}
		for(int i = 1; i < machines.length; i++)
		{
			if(machines[i].isEmployed())
				{
					if(!((machines[i].getVmQueue()).isFull())){
						inProcCount++;
						return machines[i];
					}
				}
			else 
				{
					System.out.println(">>>>>>>>>>new machine employed");
					inProcCount++;
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
		serversInProccess++;
	}
	
	public void releaseVM(VirtualMachine vm)
	{
		if(serversInProccess > 1){
			serversInProccess--;
			vm.setEmployed(false);
		}
	}
}
