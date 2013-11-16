package keytest;
import java.awt.event.*;
import javax.swing.*;

public class Tester extends JFrame implements KeyListener {

	JTextField KeyCodeT = new JTextField("Key Code:");
	public Tester() {
		KeyCodeT.addKeyListener(this);
		KeyCodeT.setEditable(false);
		add(KeyCodeT);
		setSize(400, 300);
		setVisible(true);
	}
	
	// called when key pressed down
	public void keyPressed(KeyEvent e) {
		System.out.println("Key Pressed");
		KeyCodeT.setText("Key Code:" + e.getKeyCode());
	}
	
	//called when key is released
	public void keyReleased(KeyEvent e) {
		System.out.println("Key released");
	}
	
	//called when key is typed
	public void keyTyped(KeyEvent e) {
		
	}
	
	public static void main(String[] args) {
		Tester key = new Tester();
	}
	
}
