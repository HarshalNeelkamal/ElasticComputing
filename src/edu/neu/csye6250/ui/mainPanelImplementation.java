package edu.neu.csye6250.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainPanelImplementation {

	JPanel panel = new JPanel(new GridLayout(5, 1));
	
	JLabel serverCountLabel = new JLabel(" No of Servers in Use: N/A");
	JLabel requestsQueueLabel = new JLabel(" No of requests in Queue: N/A");
	JLabel totalDisapatchesLabel = new JLabel(" No of requests in Proccess: N/A");
	JLabel totalProcessedLabel = new JLabel(" Processed Requests: N/A");
	JLabel avgProcTimeLabel = new JLabel(" Avg Processing Time: N/A");

	
	public mainPanelImplementation(){
		panel.setBackground(Color.WHITE);
		panel.add(serverCountLabel);
		panel.add(requestsQueueLabel);
		panel.add(totalDisapatchesLabel);
		panel.add(totalProcessedLabel);
		panel.add(avgProcTimeLabel);

	}
	
	public void updateDetails(int serCount, int QueueCount, int reqInProc, int procReq, long avgProcTime){
		serverCountLabel.setText(" No of Servers in Use: "+ serCount+"/5");
		requestsQueueLabel.setText(" No of requests in Queue: "+ QueueCount);
		totalDisapatchesLabel.setText(" No of requests in Proccess: "+ reqInProc);
		totalProcessedLabel.setText(" Processed Requests: "+ procReq);
		avgProcTimeLabel.setText(" Avg Processing Time: "+ avgProcTime);
	}
	
}
