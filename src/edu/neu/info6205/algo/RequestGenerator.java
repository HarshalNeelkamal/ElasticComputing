package edu.neu.info6205.algo;

import java.util.Timer;
import java.util.TimerTask;

public class RequestGenerator{

	Timer timer = new Timer();
	
	public void startGeneratingRequestAtRate(int r){
		int period = 1000/r;
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				//send out requests to dispatcher
				Request req = new Request();
				Dispatcher.getInstance().queueRequest(req);				
			}
		}, 0, period);
	}
	
	public void stopGeneratingRequests(){
		timer.cancel();
	}
	
	public void changeRateTo(int r){
		int period = 1000/r;
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				//send out requests to dispatcher
				Request req = new Request();
				Dispatcher.getInstance().queueRequest(req);
			}
		}, 0, period);
	}
	
	public void stopGeneration(){
		timer.cancel();
	}
}
