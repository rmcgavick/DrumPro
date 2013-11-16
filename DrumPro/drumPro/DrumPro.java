package drumPro;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrumPro extends JFrame {

	public DrumPro(String[] s, int b) {
		add(new Board(s, b));
		
		//setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		setSize(1000, 650);
		setFocusable(true);
		setVisible(true);
		setLayout(null);
		setBackground(Color.black);
	}
}
