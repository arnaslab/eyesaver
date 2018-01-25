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
			
			Thread.sleep(1000);
			
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, getWidth(), getHeight());
			
			g2d.setFont(new Font("Arial", Font.BOLD, 50));
			FontMetrics fm = g2d.getFontMetrics();
			
			g2d.setColor(Color.WHITE);
			String text = "REST YOUR EYES";
			int x = ((getWidth() - fm.stringWidth(text)) / 2);
			int y = ((getHeight() - fm.getHeight()) / 3) + fm.getAscent();
			g2d.drawString(text, x, y);
			
			g2d.setFont(new Font("Arial", Font.BOLD, 200));
			fm = g2d.getFontMetrics();
			
			String separator = ":";
			x = ((getWidth() - fm.stringWidth(separator)) / 2);
			y = ((getHeight() - fm.getHeight()) * 2 / 3) + fm.getAscent();
			g2d.drawString(separator, x, y);
			
			for (int i = m; i >= 0; i--) {

				String minute = (i < 10) ? "0" + i : Integer.toString(i);
				int xM = x - fm.stringWidth(minute);
				
				g2d.setColor(Color.WHITE);
				g2d.drawString(minute, xM, y);
				
				for (int j = s; j >=0; j--) {
					
					String second = (j < 10) ? "0" + j : Integer.toString(j);
					int xS = x + fm.stringWidth(separator);
					
					g2d.setColor(Color.WHITE);
					g2d.drawString(second, xS, y);
					
					Thread.sleep(1000);
					g2d.setColor(Color.BLACK);
					g2d.drawString(second, xS, y);
					
				}
				g2d.drawString(minute, xM, y);
				s = 59;
			}
			
		} catch(Exception e) {
			
			System.exit(0);
			
		} finally {
			
			g2d.dispose();
			System.exit(0);
			
		}
		
	}
	
}
