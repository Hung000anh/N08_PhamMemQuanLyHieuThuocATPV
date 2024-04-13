package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class myJButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public myJButton(String txt) {
		super(txt);
		setFont(new Font("Arial", Font.BOLD, 16));
		setBackground(new Color(238, 233, 233));
	}
	
	public void setBlue() {
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Arial", Font.BOLD, 18));
		setBackground(new Color(66, 160, 255));
		setOpaque(true);
		setBorderPainted(false);
	}
}