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

public class mainPanelImplementation extends JPanel{

	public void paint(Graphics g){
		suceedPaint(g);
	}
	
	private void suceedPaint(Graphics g){
		Graphics2D  g2d = (Graphics2D) g;
		setLayout(new GridLayout(6, 2));
		Dimension size = getSize();
		System.out.println(size.width+":"+size.height);
		g2d.setColor(Color.ORANGE);
		//g2d.fillRect(0, 0, size.width, size.height);
		g2d.setColor(Color.BLACK);
		JLabel l = new JLabel("no details available yet");
		JButton b = new JButton("trst");
		this.add(l);
	}
	
}
