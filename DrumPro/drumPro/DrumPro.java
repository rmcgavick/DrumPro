package drumPro;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrumPro extends JFrame {

	Board board;
	
	public DrumPro(String[] s, int b) {
		board = new Board(s, b);
		add(board);
		
		//setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		setSize(1000, 650);
		setVisible(true);
		setLayout(null);
		setBackground(Color.black);
	}
}
