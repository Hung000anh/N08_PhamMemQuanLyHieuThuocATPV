package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog_User extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Dialog_User() {
		setBackground(Color.decode("#94D4FF"));
		setLayout(null);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setFont(new Font("Arial", Font.BOLD, 15));
		lblMNhnVin.setBounds(10, 49, 120, 20);
		add(lblMNhnVin);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên:");
		lblTnNhnVin.setFont(new Font("Arial", Font.BOLD, 15));
		lblTnNhnVin.setBounds(10, 95, 120, 20);
		add(lblTnNhnVin);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Arial", Font.BOLD, 15));
		lblSinThoi.setBounds(10, 138, 120, 20);
		add(lblSinThoi);
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(348, 43, 114, 115);
		add(imageLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(122, 47, 196, 28);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(122, 93, 196, 28);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(122, 136, 196, 28);
		add(textField_2);
		
		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnngXut.setOpaque(true);
		btnngXut.setForeground(new Color(0, 0, 0));
		btnngXut.setFont(new Font("Arial", Font.BOLD, 18));
		btnngXut.setBorderPainted(false);
		btnngXut.setBackground(new Color(255, 83, 83));
		btnngXut.setBounds(149, 191, 188, 34);
		btnngXut.setIconTextGap(20); // Tạo Khoảng cách giữa icon và Nội dung(text)
		btnngXut.setIcon(new ImageIcon("image//dangXuatUser.png"));		
		add(btnngXut);

	}
public static void main(String[] args) {
	new Dialog_User().setVisible(true);
}
}
