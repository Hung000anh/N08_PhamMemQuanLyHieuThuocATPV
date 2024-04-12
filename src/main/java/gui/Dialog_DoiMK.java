package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import dao.DangNhap_Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog_DoiMK extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textMKcu;
	private JTextField textMKMoi;
	private JTextField textNhapLia;
	private String manv="";
	private DangNhap_Dao dangNhap_Dao=new DangNhap_Dao();
	public Dialog_DoiMK(String ma) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		manv=ma;
		{
			JLabel lblNewLabel = new JLabel("Đổi Mật Khẩu");
			lblNewLabel.setBounds(160, 10, 116, 21);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nhập mật khẩu cũ:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_1.setBounds(25, 43, 143, 21);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nhập mật khẩu mới:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_1.setBounds(25, 98, 143, 21);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nhập lại mật khẩu mới:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_1.setBounds(25, 153, 174, 21);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textMKcu = new JTextField();
			textMKcu.setBounds(226, 45, 200, 19);
			contentPanel.add(textMKcu);
			textMKcu.setColumns(10);
		}
		{
			textMKMoi = new JTextField();
			textMKMoi.setColumns(10);
			textMKMoi.setBounds(226, 100, 200, 19);
			contentPanel.add(textMKMoi);
		}
		{
			textNhapLia = new JTextField();
			textNhapLia.setColumns(10);
			textNhapLia.setBounds(226, 155, 200, 19);
			contentPanel.add(textNhapLia);
		}
		{
			JButton btnXacNhan = new JButton("Xác Nhận");
			btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 16));
			btnXacNhan.setBounds(54, 205, 121, 35);
			contentPanel.add(btnXacNhan);
			btnXacNhan.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
	
					    String mk_cu=textMKcu.getText();
					    String mk_moi=textMKMoi.getText();
					    String mk_nhaplaimoi=textNhapLia.getText();
					    if(dangNhap_Dao.LayMatKhauTheoMaNhanVien(manv).getMatKhau()!=null&&dangNhap_Dao.LayMatKhauTheoMaNhanVien(manv).getMatKhau().equals(mk_cu)) {
					        if(!mk_cu.equals(mk_moi)) {
					            if(mk_moi.isEmpty() || mk_nhaplaimoi.isEmpty()) {
					                JOptionPane.showMessageDialog(null, "Mật khẩu mới không được để trống !");
					            } else if(mk_moi.equals(mk_nhaplaimoi)) {
					                JOptionPane.showMessageDialog(null, "Mật khẩu mới của bạn đã được cập nhật !");
					                dangNhap_Dao.doiMatKhauTheoMaNV(manv, mk_moi);
					                setVisible(false);	
					            } else {
					                JOptionPane.showMessageDialog(null, "Mật khẩu mới và nhập lại mật khẩu mới không trùng nhau !");
					            }
					        } else {
					            JOptionPane.showMessageDialog(null, "Mật khẩu mới không được trùng với mật khẩu cũ !");
					        }
					    } else {
					        JOptionPane.showMessageDialog(null, "MK cũ không chính xác hoặc không tồn tại!");
					    }
				}
			});
		}
		{
			JButton btnHuy = new JButton("Hủy");
			btnHuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
			btnHuy.setBounds(268, 205, 121, 35);
			contentPanel.add(btnHuy);
		}
	}

}
