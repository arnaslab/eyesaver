package com.arnas.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;

public class EyeSaver extends Window {

	private static final long serialVersionUID = -6336972660170917246L;

	private int m;
	private int s;
	
	public EyeSaver(int minutes, int seconds) {
		super(new Frame());
		
		m = minutes;
		s = seconds;
	}
	

	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		try {
			for (int i = m; i >= 0; i--) {
				for (int j = s; j >=0; j--) {
					Thread.sleep(1000);
					stampBackground(g2d);
					stampTime(g2d, i, j);
				}
				s = 59;
			}
		} catch(Exception e) {
			System.exit(0);
		} finally {
			g2d.dispose();
			System.exit(0);
		}
		
	}
	
	private void stampBackground(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.setFont(new Font("Arial", Font.BOLD, 50));
		FontMetrics fm = g2d.getFontMetrics();
		
		g2d.setColor(Color.WHITE);
		String text = "REST YOUR EYES";
		int x = ((getWidth() - fm.stringWidth(text)) / 2);
		int y = ((getHeight() - fm.getHeight()) / 3) + fm.getAscent();
		g2d.drawString(text, x, y);
	}
	
	private void stampTime(Graphics2D g2d, int minute, int second) {
		g2d.setFont(new Font("Arial", Font.BOLD, 200));
		FontMetrics fm = g2d.getFontMetrics();
		
		String separator = ":";
		int x = ((getWidth() - fm.stringWidth(separator)) / 2);
		int y = ((getHeight() - fm.getHeight()) * 2 / 3) + fm.getAscent();
		g2d.drawString(separator, x, y);
		
		String minuteString = (minute < 10) ? "0" + minute : Integer.toString(minute);
		int xM = x - fm.stringWidth(minuteString);
		
		g2d.setColor(Color.WHITE);
		g2d.drawString(minuteString, xM, y);
		
		String secondString = (second < 10) ? "0" + second : Integer.toString(second);
		int xS = x + fm.stringWidth(separator);
		
		g2d.setColor(Color.WHITE);
		g2d.drawString(secondString, xS, y);
	}
	
}
