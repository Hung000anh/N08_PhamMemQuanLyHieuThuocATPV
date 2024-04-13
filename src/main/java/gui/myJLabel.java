package gui;

import java.awt.Font;

import javax.swing.JLabel;

public class myJLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public myJLabel(String txt) {
		super(txt);
		setFont(new Font("Arial", Font.BOLD, 18));
	}
}
