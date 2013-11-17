package drumPro;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;

public class Row extends JPanel {
	ArrayList<Integer> a = new ArrayList<Integer>(); 
	Image image;
	String ImageName;
	File sound;
    AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    Clip clip;
	
	public Row(String drum, String jpgName, int yCoord) {
		  setBackground(Color.BLACK);
		  setBounds(0, yCoord, 1000, 150);
		  setVisible(true);
		  ImageName = jpgName;		  
		  sound = new File("/Users/rmcgavick/Documents/workspace/DrumPro/DrumPro/drumPro/sounds/" + drum);
	}
	
	final Runnable play = new Runnable() {
		public void run() {
			
		try {

		    stream = AudioSystem.getAudioInputStream(sound);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();	
			
			} catch (Exception ex) {
				ex.printStackTrace(); 
			}
		}
	};
	
  
  public void addDrum() {
	  a.add(new Integer(850));
  }
  
  public void removeAll() {
	  a.removeAll(a);
  }
  
  public void playDrumSound() {
	  new Thread(play).start();
  }
	  
	  
  
  // only called to change background color during song
  public void setBackgroundColor(int cc) {
	  if(cc == 1) {
		  setBackground(Color.red);
	  }
	  if(cc == 0) {
		  setBackground(Color.black);
	  }
  }
  
  // draw Box
  public void paint(Graphics g) {
		super.paint(g);
		int purge = -1;
		
		Graphics2D g2d = (Graphics2D)g;
		ImageIcon i1 = new ImageIcon(this.getClass().getResource(ImageName +".png"));
		image = i1.getImage();
		int size = a.size();
		
		for(int i=0; i<size; i++) {
			g2d.drawImage(image, a.get(i), 0, this);
			a.set(i, a.get(i)-150);
			
			// purge will remove all boxes that reach edge of screen
			if(a.get(i) < 0) {
				purge = i;
			}
			
			Toolkit.getDefaultToolkit().sync();
		}
		if (purge > -1) {
			a.remove(purge);
			purge = -1;
		}
	}
}
