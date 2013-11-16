/*package drumPro;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BoardTemp extends JPanel implements ActionListener, KeyListener {
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
	Row r2 = new Row("Snare.wav", "Left", 164);
	Row r3 = new Row("Tom.wav", "Right", 321);
	Row r4 = new Row("Bass.wav", "Down", 478);
	ScoreRow sr = new ScoreRow(635);
	
	// Board Constructor
	public BoardTemp(String[] ary, int bpm) {
		song = ary;
		msInterval = 60000/(bpm*2);
		setBackground(Color.white);
		setLayout(null);
		
		add(r1);
		add(r2);
		add(r3);
		add(r4);
		add(sr);
		addKeyListener(this);
		
		setDoubleBuffered(true);
		setFocusable(true);
		
		timer = new Timer(msInterval, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.white);
		g2d.setStroke(new BasicStroke(7));
		
		// Draw the target box lines
		g2d.drawLine(910, 0, 910, 628);
		g2d.drawLine(740, 0, 740, 628);
		
		g.dispose();
	}
	
	public void keyPressed(KeyEvent e) {
		keyCode = e.getKeyCode();
		
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
					System.out.println("Up");
					isUpPressed = true;
				} else {
					System.out.println("W Up");
					missedU = true;
				}
			}
		
			if(keyCode == 37) {
				if(song[current].charAt(1) == '1' && !isLeftPressed) {
					System.out.println("Left");
					isLeftPressed = true;
				} else {
					System.out.println("W Left");
					missedL = true;
				}
			}
		
			if(keyCode == 39) {
				if(song[current].charAt(2) == '1' && !isRightPressed) {
					System.out.println("Right");
					isRightPressed = true;
				} else {
					System.out.println("W Right");
					missedR = true;
				}
			}
		
			if(keyCode == 40) {
				if(song[current].charAt(3) == '1' && !isDownPressed) {
					System.out.println("Down");
					isDownPressed = true;
				} else {
					System.out.println("W Down");
					missedD = true;
				}
			}
			//System.out.println(initCount);
			return;
		}
	}
	
	public void keyTyped(KeyEvent e) {  }
	public void keyReleased(KeyEvent e) {  }
	
	public void actionPerformed(ActionEvent e) {
		
	//plays song 128 notes (4 times through the song)
	while(initCount < 128)	{
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
		
		initCount++;
		numSixteenthNotes++;
		isUpPressed = false;
		isLeftPressed = false;
		isRightPressed = false;
		isDownPressed = false;
		
		// repeat song when it ends
		if(numSixteenthNotes >= song.length)
			numSixteenthNotes = 0;
		repaint();
	return;
	}
	
	// display blank screen for a few notes before repeating song
	while(initCount >= 128 && initCount < 136) {
		repaint();
		initCount++;
		return;
	}
	if(initCount == 136) {
		initCount = 0;
		numSixteenthNotes = 0;
		isUpPressed = false;
		isLeftPressed = false;
		isRightPressed = false;
		isDownPressed = false;
	}
	}
}

*/