


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * When run as a program, this class opens a window on the screen that shows a
 * large number of colored disks. The positions of the disks are selected at
 * random, and the color is randomly selected from red, green, or blue. A black
 * outline is drawn around each disk. The picture changes every three seconds.
 */
public class Superman extends JPanel implements ActionListener {

	/**
	 * Draws 500 disks with random colors and locations. Each disk has a radius
	 * of 50 pixels. This subroutine is called every three seconds, giving a new
	 * set of disks.
	 */
	public void drawFrame(Graphics g, int frameNumber, int width, int height) {

		int glavaX = frameNumber % (11 * width / 10); // The x-coord of the center of a disk.
		int glavaY = 50 + frameNumber % 4; // The y-coord of the center of a disk.
		int glavaW = 100;
		int glavaH = 80;
		int vratX = glavaX - glavaW / 10;
		int vratY = glavaY + 11 * glavaH / 10;
		int trticaX = vratX - 2 * glavaW;
		int trticaY = vratY;
		int pozicijaKockeX = 0;
		int pozicijaKockeY = 600;
		int moreX = 1500;
		int moreY= 500;

		
		
		
		
		//MORE
		g.setColor(Color.blue);
		g.fillRect(pozicijaKockeX, pozicijaKockeY, moreX, moreY);
		g.drawRect(pozicijaKockeX, pozicijaKockeY, moreX, moreY);
		
		
		//talasi
		g.setColor(Color.CYAN);
		g.drawLine(pozicijaKockeX+20, pozicijaKockeY+20, pozicijaKockeX+200, pozicijaKockeY+20);
		
		
		
		//GLAVA
		g.setColor(Color.ORANGE);
		g.fillOval(glavaX, glavaY, glavaW, glavaH);
		g.setColor(Color.BLACK);
		g.drawOval(glavaX, glavaY, glavaW, glavaH);
		g.drawOval(glavaX + 3 * glavaW / 4, glavaY + 2 * glavaH / 4, glavaW / 10, glavaH / 10);
		g.drawLine(glavaX + glavaW / 2, glavaY + glavaH, glavaX + glavaW / 3, glavaY + 2 * glavaH / 3);
		
		//VRAT
		g.drawLine(glavaX + glavaW / 4, glavaY +  3 * glavaH / 4, vratX, vratY);
		
		//TIJELO
		g.drawLine(vratX, vratY, trticaX, trticaY);
		
		//RUKE
		g.drawLine(vratX, vratY, vratX + 2 * glavaW, vratY);
		g.drawLine(vratX, vratY, vratX - 14 * glavaW / 10, vratY + glavaH / 3);
		g.drawLine(vratX - 14 * glavaW / 10, vratY + glavaH / 3, vratX, vratY + glavaH / 3);
		
		//NOGE
		g.drawLine(trticaX, trticaY, trticaX - 2 * glavaW, trticaY + glavaH / 10);
		g.drawLine(trticaX, trticaY, trticaX - 2 * glavaW, trticaY - glavaH / 10);
		
		//PLAST
		g.setColor(Color.RED);
		g.drawLine(vratX, vratY, trticaX - glavaW, trticaY - glavaH / 4 + (int)((glavaH / 4) * Math.random()));
		g.drawLine(vratX, vratY, trticaX - glavaW, trticaY - glavaH / 4 + (int)((glavaH / 4) * Math.random()));
		g.drawLine(vratX, vratY, trticaX - glavaW, trticaY - glavaH / 4 + (int)((glavaH / 4) * Math.random()));
		g.setColor(Color.YELLOW);
		g.drawLine(vratX, vratY, trticaX - glavaW, trticaY - glavaH / 4 + (int)((glavaH / 4) * Math.random()));
	}

	// ------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------

	public static void main(String[] args) {

		/*
		 * NOTE: The string in the following statement goes in the title bar of
		 * the window.
		 */
		JFrame window = new JFrame("Superman");

		/*
		 * NOTE: If you change the name of this class, you must change the name
		 * of the class in the next line to match!
		 */
		Superman drawingArea = new Superman();

		drawingArea.setBackground(Color.WHITE);
		window.setContentPane(drawingArea);

		/*
		 * NOTE: In the next line, the numbers 500 and 500 give the initial
		 * width and height of the drawing array. You can change these numbers
		 * to get a different size.
		 */
		drawingArea.setPreferredSize(new Dimension(1500, 800));

		window.pack();
		window.setLocation(5, 5);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * Note: In the following line, you can change false to true. This will
		 * prevent the user from resizing the window, so you can be sure that
		 * the size of the drawing area will not change. It can be easier to
		 * draw the frames if you know the size.
		 */
		window.setResizable(true);

		/*
		 * NOTE: In the next line, the number 3000 gives the time between calls
		 * to drawFrame(). The time is given in milliseconds, where one second
		 * equals 1000 milliseconds. You can change the number to control the
		 * animation speed.
		 */
		Timer frameTimer = new Timer(5, drawingArea);

		window.setVisible(true);
		frameTimer.start();

	} // end main

	private int frameNum;

	public void actionPerformed(ActionEvent evt) {
		frameNum++;
		repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawFrame(g, frameNum, getWidth(), getHeight());
	}

}