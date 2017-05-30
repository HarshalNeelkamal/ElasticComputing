package edu.neu.info6205.algo;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class RequestGenerator {//implements Runnable, Observer{

	Timer timer = new Timer();
	int period = 100;
	
	public void startGeneratingRequestAtRate(int r){
		int period = 1000/r;
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				//send out requests to dispatcher
				Request req = new Request();
				Dispatcher.getInstance().queueRequest(req);	
				System.out.println(period);
			}
		}, 0, period);
	}
	
	public void stopGeneratingRequests(){
		timer.cancel();
	}
	
	public void changeRateTo(int r){
		int period = 1000/r;
		timer.cancel();
		timer = null;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				//send out requests to dispatcher
				Request req = new Request();
				Dispatcher.getInstance().queueRequest(req);
				System.out.println(period);
			}
		}, 0, period);
	}
	
//	public void stopGeneration(){
//		timer.cancel();
//	}
//
//	@Override
//	public void run() {
//		while(true){
//			Request req = new Request();
//			Dispatcher.getInstance().queueRequest(req);
//			System.out.println(period);
//			try {
//				Thread.sleep(period);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//
//	@Override
//	synchronized public void update(Observable o, Object arg) {
//		
//		
//	}
}
