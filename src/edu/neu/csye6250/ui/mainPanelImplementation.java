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

public class mainPanelImplementation 
{

	JPanel panel = new JPanel(new GridLayout(5, 2));
	
	JLabel serverCountLabel = new JLabel(" No of Servers in Use: N/A");
	JLabel server1Processing = new JLabel("Requests at Server 1: N/A");

	JLabel requestsQueueLabel = new JLabel(" No of requests in Queue: N/A");
	JLabel server2Processing = new JLabel("Requests at Server 2: N/A");

	JLabel totalDisapatchesLabel = new JLabel(" No of requests in Proccess: N/A");
	JLabel server3Processing = new JLabel("Requests at Server 3: N/A");

	JLabel totalProcessedLabel = new JLabel(" Processed Requests: N/A");
	JLabel server4Processing = new JLabel("Requests at Server 4: N/A");

	JLabel avgProcTimeLabel = new JLabel(" Avg Processing Time: N/A");
	JLabel server5Processing = new JLabel("Requests at Server 5: N/A");
	
	
	public mainPanelImplementation()
	{
		panel.setBackground(Color.WHITE);
		panel.add(serverCountLabel);
		panel.add(server1Processing);

		panel.add(requestsQueueLabel);
		panel.add(server2Processing);

		panel.add(totalDisapatchesLabel);
		panel.add(server3Processing);

		panel.add(totalProcessedLabel);
		panel.add(server4Processing);

		panel.add(avgProcTimeLabel);
		panel.add(server5Processing);
	}
	

	public void updateDetails(int serCount, int QueueCount, int reqInProc, int procReq, long avgProcTime, int[] serverSizes){
		serverCountLabel.setText(" No of Servers in Use: "+ serCount+"/5");
		requestsQueueLabel.setText(" No of requests in Queue: "+ QueueCount);
		totalDisapatchesLabel.setText(" No of requests in Proccess: "+ reqInProc);
		totalProcessedLabel.setText(" Processed Requests: "+ procReq);
		avgProcTimeLabel.setText(" Avg Processing Time: "+ avgProcTime);
		server1Processing.setText(" Requests at Server 1: "+ serverSizes[0]);
		server2Processing.setText(" Requests at Server 2: "+ serverSizes[1]);
		server3Processing.setText(" Requests at Server 3: "+ serverSizes[2]);
		server4Processing.setText(" Requests at Server 4: "+ serverSizes[3]);
		server5Processing.setText(" Requests at Server 5: "+ serverSizes[4]);
	}
	
}