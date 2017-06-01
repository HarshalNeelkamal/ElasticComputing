package edu.neu.info6205.algo;

import java.util.Observable;
import java.util.Observer;

public class RequestGenerator implements Runnable, Observer{

	int period = 100;
	int processingTime = 100;
	boolean stop = false;
	boolean pause = false;

	synchronized public void stopMethod(){
		stop = true;
	}
	
	@Override
	public void run() {
		stop = false;
		while(!stop){
			if(!pause){
				Request req = new Request();
				req.setProcessTime(processingTime);
				Dispatcher.getInstance().queueRequest(req);
				System.out.println(period);
			}
			try {
				Thread.sleep(period);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("stopped");
	}

	@Override
	synchronized public void update(Observable o, Object arg) {
		String argsArr[] = arg.toString().split(" ");
		if(argsArr[0].equals("0")){
			pause = true;
		}else{
			pause = false;
			period = 1000/(Integer.parseInt(argsArr[0]));
		}
		processingTime = Integer.parseInt(argsArr[1]);
	}
}
