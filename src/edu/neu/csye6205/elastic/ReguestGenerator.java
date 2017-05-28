package edu.neu.csye6205.elastic;

import java.sql.Time;
import java.util.EventListener;
import java.util.Timer;
import java.util.TimerTask;

public class ReguestGenerator implements EventListener{
	
	Timer t = new Timer();
	ObjectDispatcher dispatcher = new ObjectDispatcher();
	
	
	public void run(long rate){
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				long mills = System.currentTimeMillis();
				dispatcher.handelRequest(mills);
			}
		}, 100, rate);
	}
	
	
}
