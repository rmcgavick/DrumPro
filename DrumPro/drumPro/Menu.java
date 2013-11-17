package drumPro;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener {
	
	public static String[] aryLines;
	public static int bpm = 110;
	public static String file_name;
	public static boolean toggleMenu;

	public Menu() {
		
		Dimension minSize = new Dimension(50, 20);
		GridLayout menuButtons = new GridLayout();
		setLayout(menuButtons);
		
		/* Add Menu Buttons */
		Button b1 = new Button("Song 1");
		b1.addActionListener(this);
		b1.setActionCommand("Song1");
		b1.setSize(minSize);
		
		Button b2 = new Button("Song 2");
		b2.addActionListener(this);
		b2.setActionCommand("Song2");
		b2.setSize(minSize);
		
		Button b3 = new Button("Song 3");
		b3.addActionListener(this);
		b3.setActionCommand("Song3");
		b3.setSize(minSize);
		
		Button b4 = new Button("Song 4");
		b4.addActionListener(this);
		b4.setActionCommand("Song4");
		b4.setSize(minSize);
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		
		//setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setTitle("Drum Pro");
		setResizable(false);
		setBackground(Color.black);
		setSize(1000, 650);
		setVisible(true);		
	}
	
	public void actionPerformed(ActionEvent ef) {
		if("Song1".equals(ef.getActionCommand())) {
			file_name = "/Users/rmcgavick/Documents/workspace/DrumPro/DrumPro/drumPro/songs/Song1.txt";
			System.out.println(file_name); // Temp test code
			playSong(file_name);
		}
		else if("Song2".equals(ef.getActionCommand())) {
			file_name = "/Users/rmcgavick/Documents/workspace/DrumPro/DrumPro/drumPro/songs/Song2.txt";
			System.out.println(file_name); // test code
			playSong(file_name);
		}
		else if("Song3".equals(ef.getActionCommand())) {
			file_name = "/Users/rmcgavick/Documents/workspace/DrumPro/DrumPro/drumPro/songs/Song3.txt";
			System.out.println(file_name); // test code
			playSong(file_name);
		}
		else if("Song4".equals(ef.getActionCommand())) {
			file_name = "/Users/rmcgavick/Documents/workspace/DrumPro/DrumPro/drumPro/songs/Song4.txt";
			System.out.println(file_name); // test code
			playSong(file_name);
		}
	}
	
	public void playSong(String f) {
		try {
			ReadFile file = new ReadFile(f);
			aryLines = file.OpenFile();
			(new DrumProThread(aryLines, bpm)).start();;
		
		} catch (IOException e) {
		System.out.println(e.getMessage());
		}	
	}
	
	public static void main(String[] args) {
			new Menu();
	}
}
