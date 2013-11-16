package drumPro;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements ActionListener, KeyListener {
	
	String[] song;
	Timer timer;
	int msInterval;
	int numSixteenthNotes = 0;
	int current;
	int initCount = 0;
	int keyCode = 0;
	boolean missedU, missedL, missedR, missedD, isUpPressed, 
			isLeftPressed, isRightPressed, isDownPressed = false;
	
	Row r1 = new Row("HiHat.wav", "Up", 7);
	Row r2 = new Row("MidTom.wav", "Left", 164);
	Row r3 = new Row("Snare.wav", "Right", 321);
	Row r4 = new Row("Bass.wav", "Down", 478);
	//ScoreRow sr = new ScoreRow(635);
	
	// Board Constructor
	public Board(String[] ary, int bpm) {
		
		song = ary;
		msInterval = 60000/(bpm*2);
		setBackground(Color.white);
		setLayout(null);
		
		add(r1);
		add(r2);
		add(r3);
		add(r4);
		//add(sr);
		addKeyListener(this);
		
		setDoubleBuffered(true);
		setFocusable(true);
		setVisible(true);
		
		timer = new Timer(msInterval, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.white);
		g2d.setStroke(new BasicStroke(7));
		
		// Draw the target box lines
		g2d.drawLine(90, 0, 90, 650);
		g2d.drawLine(260, 0, 260, 650);
		
		g.dispose();
	}
	
	public void keyPressed(KeyEvent e) {
		keyCode = e.getKeyCode();
		
		// This switch statement accounts for the difference between
		// the current note (left side of screen) and the most 
		// recent note to be drawn (right side), and allows the game
		// to repeat each "song" 4 times
		while(initCount >= 6) {
			switch(numSixteenthNotes) {
				case 0: current = 26;
						break;
				case 1: current = 27;
						break;
				case 2: current = 28;
						break;
				case 3: current = 29;
						break;
				case 4: current = 30;
						break;
				case 5: current = 31;
						break;
				default: current = (numSixteenthNotes - 6);
						break;
			}
		
			if(keyCode == 38) {
				if(song[current].charAt(0) == '1' && !isUpPressed) {
					r1.playDrumSound();
					isUpPressed = true;
				} else {
					missedU = true;
				}
			}
		
			if(keyCode == 37) {
				if(song[current].charAt(1) == '1' && !isLeftPressed) {
					r2.playDrumSound();
					isLeftPressed = true;
				} else {
					missedL = true;
				}
			}
		
			if(keyCode == 39) {
				if(song[current].charAt(2) == '1' && !isRightPressed) {
					r3.playDrumSound();
					isRightPressed = true;
				} else {
					missedR = true;
				}
			}
		
			if(keyCode == 40) {
				if(song[current].charAt(3) == '1' && !isDownPressed) {
					r4.playDrumSound();
					isDownPressed = true;
				} else {
					missedD = true;
				}
			}
			return;
		}
	}
	
	public void keyTyped(KeyEvent e) {  }
	public void keyReleased(KeyEvent e) {  }
	
	public void actionPerformed(ActionEvent e) {
		
	// changes background color
	// plays song 128 notes (4 times through the song)
	// (the 136 is so there will be some empty space displayed
	// after the final note)
	while(initCount < 136)	{
		if(!missedU) {
			r1.setBackgroundColor(0);
		} 
		if(missedU == true) {
			r1.setBackgroundColor(1);
			missedU = false;
		}
		if(!missedL) {
			r2.setBackgroundColor(0);
		} 
		if(missedL == true) {
			r2.setBackgroundColor(1);
			missedL = false;
		}
		if(!missedR) {
			r3.setBackgroundColor(0);
		} 
		if(missedR == true) {
			r3.setBackgroundColor(1);
			missedR = false;
		}
		if(!missedD) {
			r4.setBackgroundColor(0);
		} 
		if(missedD == true) {
			r4.setBackgroundColor(1);
			missedD = false;
		}
		
		// read through song file and create appropriate boxes
		// on each 16th note interval
		if(initCount < 128) {	
			if(song[numSixteenthNotes].charAt(0) == '1') {
				r1.addDrum();
			}
			if(song[numSixteenthNotes].charAt(1) == '1') {
				r2.addDrum();
			}
			if(song[numSixteenthNotes].charAt(2) == '1') {
				r3.addDrum();
			}
			if(song[numSixteenthNotes].charAt(3) == '1') {
				r4.addDrum();
			}
		}
		initCount++;
		numSixteenthNotes++;
		isUpPressed = false;
		isLeftPressed = false;
		isRightPressed = false;
		isDownPressed = false;
		
		// Repeat song after iterating through one loop
		// This will repeat 3 times, iterating through each
		// song 4 times
		if(numSixteenthNotes >= song.length)
			numSixteenthNotes = 0;
		repaint();
	return;
	}
	
	if(initCount == 136) 
		System.exit(0);
	}
}
