package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import dao.NhanVien_Dao;
import entity.NhanVien;

public class Dialog_User extends JFrame implements ActionListener{

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialog_User frame = new Dialog_User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

		JFrame frame;
		private static final long serialVersionUID = 1L;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField txtangHotng;
		private NhanVien_Dao nv_dao=new NhanVien_Dao();
		private 	JLabel anhNV ;
		private String ma;
		private Dialog_DoiMK Dialog_Doi_mk;
		/**
		 * Create the panel.
		 */
		public Dialog_User() {
			setBackground(Color.decode("#94D4FF"));
			getContentPane().setLayout(null);
			JLabel lb = new JLabel("Tên nhân viên:");
			lb.setFont(new Font("Arial", Font.BOLD, 15));
			lb.setBounds(10, 187, 120, 20);
			getContentPane().add(lb);
			
			JLabel lblTnNhnVin = new JLabel("Chức vụ:");
			lblTnNhnVin.setFont(new Font("Arial", Font.BOLD, 15));
			lblTnNhnVin.setBounds(10, 234, 120, 20);
			getContentPane().add(lblTnNhnVin);
			
			JLabel lblSinThoi = new JLabel("Số điện thoại:");
			lblSinThoi.setFont(new Font("Arial", Font.BOLD, 15));
			lblSinThoi.setBounds(10, 283, 120, 20);
			getContentPane().add(lblSinThoi);
			
			JLabel imageLabel = new JLabel();
			imageLabel.setBounds(348, 43, 114, 115);
			getContentPane().add(imageLabel);
			
			textField = new JTextField();
			textField.setEnabled(false);
			textField.setColumns(10);
			textField.setBounds(169, 185, 196, 28);
			getContentPane().add(textField);
			
			textField_1 = new JTextField();
			textField_1.setEnabled(false);
			textField_1.setColumns(10);
			textField_1.setBounds(169, 232, 196, 28);
			getContentPane().add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setEnabled(false);
			textField_2.setColumns(10);
			textField_2.setBounds(169, 281, 196, 28);
			getContentPane().add(textField_2);
			
			JButton btnngXut = new JButton("Đăng xuất");
			btnngXut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window[] windows = Window.getWindows();
					for (Window window : windows) {
						window.dispose();
					}
					GD_DangNhap dn=new GD_DangNhap();
					dn.frame.setVisible(true);
				}
			});
			btnngXut.setOpaque(true);
			btnngXut.setForeground(new Color(0, 0, 0));
			btnngXut.setFont(new Font("Arial", Font.BOLD, 18));
			btnngXut.setBorderPainted(false);
			btnngXut.setBackground(new Color(255, 83, 83));
			btnngXut.setBounds(217, 319, 159, 34);
			btnngXut.setIconTextGap(20); // Tạo Khoảng cách giữa icon và Nội dung(text)
			btnngXut.setIcon(new ImageIcon("image//dangXuatUser.png"));		
			getContentPane().add(btnngXut);
			
			JButton btnDoiMK = new JButton("Đổi mật khẩu");
			btnDoiMK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Dialog_Doi_mk= new Dialog_DoiMK(ma);
					Dialog_Doi_mk.setModal(true);
					Dialog_Doi_mk.setVisible(true);
				}
			});
			btnDoiMK.setOpaque(true);
			btnDoiMK.setIconTextGap(20);
			btnDoiMK.setForeground(Color.BLACK);
			btnDoiMK.setFont(new Font("Arial", Font.BOLD, 18));
			btnDoiMK.setBorderPainted(false);
			btnDoiMK.setBackground(new Color(255, 83, 83));
			btnDoiMK.setBounds(20, 319, 159, 34);
			getContentPane().add(btnDoiMK);
			
			anhNV= new JLabel("");
			anhNV.setBounds(269, 68, 96, 107);
			getContentPane().add(anhNV);
			
			JLabel lblTrngThi = new JLabel("Trạng Thái:");
			lblTrngThi.setFont(new Font("Arial", Font.BOLD, 15));
			lblTrngThi.setBounds(10, 102, 120, 20);
			getContentPane().add(lblTrngThi);
			
			txtangHotng = new JTextField();
			txtangHotng.setForeground(new Color(240, 240, 240));
			txtangHotng.setFont(new Font("Times New Roman", Font.BOLD, 14));
			txtangHotng.setText("Đang hoạt động");
			txtangHotng.setEnabled(false);
			txtangHotng.setColumns(10);
			txtangHotng.setBounds(139, 99, 120, 28);
			getContentPane().add(txtangHotng);
			
			JLabel lblHeader = new JLabel("Thông tin nhân viên");
			lblHeader.setForeground(new Color(0, 128, 255));
			lblHeader.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblHeader.setBounds(115, 30, 196, 28);
			getContentPane().add(lblHeader);
			
			JButton btnNewButton = new JButton("X");
			btnNewButton.setForeground(new Color(255, 0, 0));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(348, 0, 38, 21);
			getContentPane().add(btnNewButton);
			setSize(400,400);
			this.addWindowListener(new WindowAdapter() {
			    public void windowOpened(WindowEvent e) {
					loadDuLieu();
					
			    }
			});		
	
			
	}

		public void loadDuLieu() {
			NhanVien nv = null;
			nv = nv_dao.getNhanVienTheoMa(DataManager.getUserName());
			textField.setText(nv.getTenNV());
			String chucVu="";
			ma=nv.getMaNV();
			if(nv.isChucVu()==true)
				chucVu="Quản lí";
			else
				chucVu="Nhân viên";
			textField_1.setText(chucVu);
			textField_2.setText(nv.getSdt());
			anhNV.setIcon(new ImageIcon(nv.getHinhAnhNhanVien()));
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
		}
}
