package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import dao.DangNhap_Dao;



public class GD_DangNhap extends JFrame implements ActionListener{

	

	JFrame frame;
	private PlaceholderTextField textMK;
	private PlaceholderTextField textTenDangNhap;
	private JButton btnDangNhap ;
	private DangNhap_Dao dangNhap_dao;
	private String username;
	private GD_TrangChu gD_TrangChu;
	private JButton btnQuenMK ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DangNhap window = new GD_DangNhap();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GD_DangNhap() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(81,155,204));
		frame.setBounds(100, 100, 1092, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Hiệu thuốc ATPV");
		lblNewLabel.setBounds(449, 225, 313, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel);
		
		textMK = new PlaceholderTextField();
		textMK.setPlaceholder("Mật khẩu");
		textMK.setBounds(265, 420, 591, 32);
		frame.getContentPane().add(textMK);
		textMK.setColumns(10);
		
		btnDangNhap= new JButton("Đăng nhập");
		btnDangNhap.setBounds(265, 488, 591, 47);
		btnDangNhap.setBackground(Color.BLACK);
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(btnDangNhap);
		
		textTenDangNhap = new PlaceholderTextField();
		textTenDangNhap.setPlaceholder("Tên đăng nhập");
		textTenDangNhap.setBounds(265, 351, 591, 32);
		frame.getContentPane().add(textTenDangNhap);
		textTenDangNhap.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(364, 214, 66, 63);
		frame.getContentPane().add(lblNewLabel_2);
		Image logo = new ImageIcon(this.getClass().getResource("")).getImage();
		logo = logo.getScaledInstance(64, 63, Image.SCALE_DEFAULT);
		lblNewLabel_2.setIcon(new ImageIcon(logo));
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(223, 351, 32, 32);
		frame.getContentPane().add(lblNewLabel_3);
		Image user_icon = new ImageIcon(this.getClass().getResource("")).getImage();
		user_icon = user_icon.getScaledInstance(32, 32, Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(user_icon));
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBounds(223, 420, 32, 32);
		frame.getContentPane().add(lblNewLabel_4);
		Image pass_icon = new ImageIcon(this.getClass().getResource("")).getImage();
		pass_icon = pass_icon.getScaledInstance(32, 32, Image.SCALE_DEFAULT);
		lblNewLabel_4.setIcon(new ImageIcon(pass_icon));
		
	
		
		JSeparator separator = new JSeparator();
		separator.setBounds(129, 615, 324, 2);
		separator.setBackground(Color.WHITE);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(690, 615, 290, 2);
		separator_1.setBackground(Color.WHITE);
		frame.getContentPane().add(separator_1);
		
		btnQuenMK= new JButton("Quên mật khẩu");
		btnQuenMK.setBounds(493, 604, 161, 25);
		frame.getContentPane().add(btnQuenMK);
		btnDangNhap.addActionListener(this);
		btnQuenMK.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  DataManager.setUserName(textTenDangNhap.getText());
	      Object o = e.getSource();
	      if (o.equals(btnDangNhap)) {
	 		 gD_TrangChu=new GD_TrangChu();
	           username = textTenDangNhap.getText();
	           DataManager.setUserName(username);
	          String mkstr = textMK.getText();
	          dangNhap_dao = new DangNhap_Dao();
	          if (dangNhap_dao.Timkiem(username, mkstr) == true) {
	        	 
	        	  String roleName = dangNhap_dao.getRole(username, mkstr);
	        	    if (roleName.equals("Quản lý")) {
						DataManager.setRole("QL");
						DataManager.setRolePassword("QLpassword");
					} else if (roleName.equals("Nhân viên")) {
						DataManager.setRole("NV");
						DataManager.setRolePassword("NVpassword");
					   
					   
					    gD_TrangChu.btnNhanVien.setEnabled(false);
					   
					}
	            gD_TrangChu.setVisible(true);
	           
	                frame.dispose();
	             
	          } else {
	              JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!");
	          }
	      } else if(o.equals(btnQuenMK)) {
	    	  	GD_QuenMatKhau qmk=new GD_QuenMatKhau();
	    	  	qmk.setVisible(true);
	    	  	frame.dispose();
	      }
	}
}