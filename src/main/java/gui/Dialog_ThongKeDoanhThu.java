package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import dao.ThongKe_Dao;

public class Dialog_ThongKeDoanhThu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ThongKe_Dao tk_dao = new ThongKe_Dao();

	/**
	 * Create the panel.
	 */
	public Dialog_ThongKeDoanhThu() {
		setLayout(null);
		setBounds(0, 0, 1200, 602);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 0));
		panel.setBounds(78, 10, 266, 99);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doanh Thu");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(34, 17, 77, 20);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(34, 50, 144, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 142, 210));
		panel_1.setBounds(78, 493, 266, 99);
		add(panel_1);
		
		JLabel lblSLngHa = new JLabel("Số lượng hóa đơn");
		lblSLngHa.setForeground(Color.WHITE);
		lblSLngHa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSLngHa.setBounds(34, 17, 125, 20);
		panel_1.add(lblSLngHa);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(34, 50, 144, 26);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 204, 0));
		panel_2.setBounds(78, 130, 266, 99);
		add(panel_2);
		
		JLabel lblDoanhThuBn = new JLabel("Doanh thu thuốc");
		lblDoanhThuBn.setForeground(Color.WHITE);
		lblDoanhThuBn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDoanhThuBn.setBounds(34, 17, 136, 20);
		panel_2.add(lblDoanhThuBn);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(34, 50, 144, 26);
		panel_2.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 204, 0));
		panel_3.setBounds(78, 250, 266, 99);
		add(panel_3);
		
		JLabel lblDoanhThuBn_1 = new JLabel("Doanh thu thực phẩm chức năng");
		lblDoanhThuBn_1.setForeground(Color.WHITE);
		lblDoanhThuBn_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDoanhThuBn_1.setBounds(34, 17, 222, 20);
		panel_3.add(lblDoanhThuBn_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(34, 50, 144, 26);
		panel_3.add(textField_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(0, 204, 0));
		panel_4.setBounds(78, 370, 266, 99);
		add(panel_4);
		
		JLabel lblDoanhThuDng = new JLabel("Doanh Thu dụng cụ y tế");
		lblDoanhThuDng.setForeground(Color.WHITE);
		lblDoanhThuDng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDoanhThuDng.setBounds(34, 17, 156, 20);
		panel_4.add(lblDoanhThuDng);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(34, 50, 144, 26);
		panel_4.add(textField_4);
	}
	
	public void setDoanhThu(String dt) {
		textField.setText(dt);
	}
	
	public void setDoanhThuThuoc(String dt) {
		textField_2.setText(dt);
	}
	
	public void setDoanhThuDCYT(String dt) {
		textField_3.setText(dt);
	}
	
	public void setDoanhThuTPCN(String dt) {
		textField_4.setText(dt);
	}
}
