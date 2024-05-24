package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.DangNhap_Dao;



public class GD_QuenMatKhau extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblSDT,lblOTP,lblMatKhauMoi,lblNhapLaiMatKhauMoi;
	private JTextField txtSDT, txtPassword,txtPassword_New,txtOTP;
	private JLabel lblTitle;
	private JButton btnHuy,btnXacNhan,btnOTP;
	private DangNhap_Dao dangNhap_dao = new DangNhap_Dao();
	private JFrame frane;

	public  GD_QuenMatKhau() {
		setTitle("Quên Mật Khẩu");
		setSize(600, 350);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("image\\\\hinh_trangdangnhap.jpg");
	    this.setIconImage(icon.getImage());
		

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		lblTitle = new JLabel("QUÊN MẬT KHẨU");
		lblTitle.setEnabled(false);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitle.setBounds(155, 10, 300, 45);
		lblTitle.setForeground(Color.white);
		panel.add(lblTitle);
		
		//SDT
		    lblSDT = new JLabel("Số Điện Thoại");
		    lblSDT.setEnabled(false);
		    lblSDT.setFont(new Font("Arial", Font.BOLD, 15));
	        lblSDT.setBounds(5, 80, 110, 25);
	        lblSDT.setForeground(Color.white);
	        panel.add(lblSDT); 
	        
	        txtSDT = new JTextField(20);
	        txtSDT.setBounds(130, 80, 300, 25);
	        panel.add(txtSDT);
	        
		//OTP
		    lblOTP = new JLabel("Mã OTP");
		    lblOTP.setEnabled(false);
		    lblOTP.setFont(new Font("Arial", Font.BOLD, 12));
		    lblOTP.setBounds(5, 120, 110, 25);
		    lblOTP.setForeground(Color.white);
	        panel.add(lblOTP); 
	        
	        txtOTP = new JTextField(20);
	        txtOTP.setEditable(false);
	        txtOTP.setBounds(130, 120, 300, 25);
	        panel.add(txtOTP);
	        
	        btnOTP = new JButton("Mã OTP");
	        btnOTP.setBounds(435, 120, 100, 25);
	        btnOTP.setFont(new Font("Arial", Font.BOLD, 14));
	        btnOTP.setForeground(Color.black);
	        btnOTP.setBackground(new Color(64,224,208));
	     
			panel.add(btnOTP);
			
		//MK mới
		    lblMatKhauMoi = new JLabel("Nhập MK Mới");
		    lblMatKhauMoi.setEnabled(false);
		    lblMatKhauMoi.setFont(new Font("Arial", Font.BOLD, 12));
		    lblMatKhauMoi.setBounds(5, 160, 110, 25);
		    lblMatKhauMoi.setForeground(Color.white);
	        panel.add(lblMatKhauMoi); 
	        
	        txtPassword = new JPasswordField(20);
	        txtPassword.setBounds(130, 160, 300, 25);
	        panel.add(txtPassword);
			
		    lblNhapLaiMatKhauMoi = new JLabel("Nhập Lại MK");
		    lblNhapLaiMatKhauMoi.setEnabled(false);
		    lblNhapLaiMatKhauMoi.setFont(new Font("Arial", Font.BOLD, 12));
		    lblNhapLaiMatKhauMoi.setBounds(5, 200, 120, 25);
		    lblNhapLaiMatKhauMoi.setForeground(Color.white);
	        panel.add(lblNhapLaiMatKhauMoi); 
	        
	        txtPassword_New= new JPasswordField(20);
	        txtPassword_New.setBounds(130, 200, 300, 25);
	        panel.add(txtPassword_New);
	        
	       
	         btnXacNhan = new JButton("Xác Nhận");
	        btnXacNhan.setBounds(130, 240, 140, 35);
	        btnXacNhan.setFont(new Font("Arial", Font.BOLD, 18));
	        btnXacNhan.setForeground(Color.black);
	        btnXacNhan.setBackground(new Color(064,224,208));
	 
			panel.add(btnXacNhan);
			
	         btnHuy = new JButton("Hủy");
	        btnHuy.setBounds(290, 240, 140, 35);
	        btnHuy.setFont(new Font("Arial", Font.BOLD, 18));
	        btnHuy.setForeground(Color.black);
	        btnHuy.setBackground(Color.white);
	       
			panel.add(btnHuy);
	        
	        
			//hình nền
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("image\\quenmk.jpg"));
			label.setBounds(70, 0, 584, 311);
			ImageIcon hinhgt= new ImageIcon("image\\quenmk.jpg");
			Image image = hinhgt.getImage();
			Image newImage = image.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH);
			hinhgt = new ImageIcon(newImage);
			label.setIcon(hinhgt);
			panel.add(label);
			
	        
	        btnOTP.addActionListener(this);
	        btnHuy.addActionListener(this);
	        btnXacNhan.addActionListener(this);
	        getContentPane().add(panel);
	        
	        JLabel lblNewLabel = new JLabel("");
	        lblNewLabel.setBounds(70, 42, 45, 13);
	        panel.add(lblNewLabel);
	}

    public static void main(String[] args) {
    new GD_QuenMatKhau().setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(btnXacNhan)) {
			String sdt = txtSDT.getText();
			char[] mk1 = ((JPasswordField) txtPassword).getPassword();
			char[] mk2 = ((JPasswordField) txtPassword_New).getPassword();
			String mk_cu=new String(mk1);
			String mk_moi=new String(mk2);
			

				if(dangNhap_dao.TimkiemSDT(sdt)==true) {
					if(mk_cu.equalsIgnoreCase(mk_moi)) {
						JOptionPane.showMessageDialog(null, "Mật khẩu mới của bạn đã được cập nhật !");
						dangNhap_dao.doiMatKhau(sdt, mk_moi);
						GD_DangNhap window = new GD_DangNhap();
						window.frame.setVisible(true);	
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Mật khẩu mới và nhập lại mật khẩu mới không trùng nhau !");
					}
					
				}else JOptionPane.showMessageDialog(null, "Số điện thoại không tồn tại!");
			
		}
		else if(o.equals(btnHuy)) {
			// thêm joption thông báo rồi nhảy về trang đăng nhập//
			GD_DangNhap window = new GD_DangNhap();
			window.frame.setVisible(true);
			
			dispose();
		}
		else if (o.equals(btnOTP)) {
			  // Tạo mã OTP ngẫu nhiên gồm 6 chữ số
		    int otp = (int)(Math.random() * ((999999 - 100000) + 1)) + 100000;
		    
		    // Hiển thị mã OTP trong ô txtOTP
		    txtOTP.setText(String.valueOf(otp));
		}
//		
	}
}
