package com.arnas.core;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Main {
	
	public static void main(String[] args) {
		try {
			new Main(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		} catch (ArrayIndexOutOfBoundsException e) {
			new Main(3, 0);
		}
	}
	
	public Main(int minutes, int seconds) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice screen = ge.getDefaultScreenDevice();
		
		if (!screen.isFullScreenSupported()) {
			System.out.println("Full screen mode not supported");
			System.exit(1);
		} else {
			screen.setFullScreenWindow(new EyeSaver(minutes, seconds));
		}

	}
	
}
