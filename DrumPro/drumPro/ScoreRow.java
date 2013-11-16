package drumPro;

import java.awt.*;
import javax.swing.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScoreRow extends JPanel {
	
	public ScoreRow(int yCoord) {
		
		  setBackground(Color.BLACK);
		  setBounds(0, yCoord, 1000, 150);
		  setVisible(true);
		
	}
	
	
}
