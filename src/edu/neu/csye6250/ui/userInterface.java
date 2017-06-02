package edu.neu.csye6250.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import javax.management.Descriptor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.neu.info6205.algo.Dispatcher;
import edu.neu.info6205.algo.RequestGenerator;
import edu.neu.info6205.algo.Service;

public class userInterface extends Observable
{

	JFrame frame = new JFrame("Elastic Computing Simulator");
	JPanel panel = new JPanel(new GridLayout(3, 1));
	JLabel requestRate_label = new JLabel(" Requests/Sec");
	JTextField requestRate_field = new JTextField();
	JLabel processingTime_label = new JLabel(" Processing Time in ms");
	JTextField processingTime_field = new JTextField();
	JPanel innerPanel = new JPanel(new GridLayout(4, 6));
	JButton startButton = new JButton("Start Simulation");
	JPanel lowerPannel = new JPanel(new GridLayout(4, 1));
	JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
	mainPanelImplementation detailPanel_center = new mainPanelImplementation();
	JButton changeButton = new JButton("Change");
	
	static RequestGenerator requestGen = new RequestGenerator();
	Thread generatorThread;// = new Thread(requestGen);
	//instansiate server side too 

	JButton stopButton = new JButton("Stop Simulation");
	
	Timer timer;
	
	userInterface(){
		System.out.println("Initailized");
	}
	
	public void run(){
		frame.setSize(500, 500);
		frame.setLayout(new BorderLayout());
		panel.setSize(new Dimension(500, 500));
		panel.setBackground(Color.WHITE);
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		requestRate_label.setSize(60, 30);
		requestRate_field.setSize(60, 30);
		innerPanel.add(requestRate_label);
		innerPanel.add(requestRate_field);
		innerPanel.add(changeButton);
		innerPanel.add(processingTime_label);
		innerPanel.add(processingTime_field);
		innerPanel.add(new Label());
		innerPanel.add(new Label());
		innerPanel.add(new Label());
		innerPanel.add(new Label());

		buttonPanel.add(new Label());
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(new Label());
		lowerPannel.add(new Label());
		lowerPannel.add(buttonPanel);
		panel.add(innerPanel, 0);
		panel.add(detailPanel_center.panel,1);
		panel.add(lowerPannel, 2);
		
		setActions();
		
		changeButton.setEnabled(false);
		frame.setVisible(true);
	}
	
	private void setActions(){
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				changeButton.setEnabled(true);
				
				//test ***********************
				
				generatorThread = null;
				generatorThread = new Thread(requestGen);
				//     ***********************
				
				//trigger the server first
				Dispatcher.getInstance().startDispatching();//next goes the dispatcher 
				setChanged();
				notifyObservers((requestRate_field.getText()+" "+processingTime_field.getText()));
				Service.getInstance().setProccessTime(Integer.parseInt(processingTime_field.getText()));
				generatorThread.start();
				startDetailTimer();
			}
		});
		
		stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				changeButton.setEnabled(false);
				requestGen.stopMethod();
				Dispatcher.getInstance().stopDispatchingRequests();//next goes the dispatcher 
				//stop the server at the very end
				endDetailTimer();
				Service.getInstance().cleareQueues();
			}
		});
		
		changeButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setChanged();
				notifyObservers((requestRate_field.getText()+" "+processingTime_field.getText()));
				Service.getInstance().setProccessTime(Integer.parseInt(processingTime_field.getText()));
			}
		});
	}
	
	public static void main(String[] args)
	{
		userInterface obj = new userInterface();
		obj.addObserver(requestGen);
		obj.run();
	}
	
	public void startDetailTimer()
	{
		timer = new Timer();
		timer.schedule(new TimerTask() 
		{	
			@Override
			public void run() 
			{
				detail();
			}
		}, 500, 500);
	}
	
	public void endDetailTimer()
	{
		timer.cancel();
		timer = null;
	}

	synchronized public void detail()
	{
		int noOfservers = Service.getInstance().getServersInProccess();// get no of servers in use
		int reqInQueue = Dispatcher.getInstance().queue.size();
		int inProc = Service.getInstance().getInProcCount();//get requests in proccess
		int proc = Service.getInstance().getProcessedCount();//get proccesed requests
		int[] serverSizes = Service.getInstance().getServerSizes();
		long avgProcTime = Service.getInstance().getAvgProccessTime(); 
		detailPanel_center.updateDetails(noOfservers, reqInQueue, inProc, proc, avgProcTime, serverSizes);
	}
	
}