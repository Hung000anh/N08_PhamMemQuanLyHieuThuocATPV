	package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.SwingConstants;

import dao.ThongKe_Dao;
import entity.SanPham;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class GD_ThongKe extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnUser;
	private JTextField txtNgayBatDau;
	private JTextField txtNgayKetThuc;
	private JButton btnThongKe;
	private JButton btnTKSP;
	private JButton btnTKDT;
	private final Dialog_ThongKeDoanhThu TKDT = new Dialog_ThongKeDoanhThu();
	private final Dialog_ThongKeSanPham TKSP = new Dialog_ThongKeSanPham();
	private ThongKe_Dao tk_dao = new ThongKe_Dao();
	private JPanel panelBottom;
	private JComboBox loaiTG;
	private JLabel ngayBatDau;
	private JLabel ngayKetThuc;
	private JPanel panel2;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public GD_ThongKe() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140, 865);

		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(null);
		pnNorth.setBackground(new Color(187, 231, 252));
		pnNorth.setBounds(0, 0, 1200, 60);

		add(pnNorth);

		JLabel lblTitle = new JLabel("Thống kê");
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setBounds(350, 10, 500, 40);
		pnNorth.add(lblTitle);

		JButton btnUser = new JButton();
		btnUser.setBorderPainted(false);
		btnUser.setBackground(new Color(181, 230, 251));
		btnUser.setBounds(1085, 7, 45, 45);
		ImageIcon iconProfile = new ImageIcon("D://BaiTapLonPTUD_NHOM4//icon//icon_profile.png");
		iconProfile = new ImageIcon(iconProfile.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH));
		btnUser.setIcon(iconProfile);
		pnNorth.add(btnUser);

		btnTKSP = new JButton("Thống kê sản phẩm");
		btnTKSP.setFont(new Font("Arial", Font.BOLD, 16));
		btnTKSP.setBorderPainted(false);
		btnTKSP.setBackground(new Color(74, 131, 215));
		btnTKSP.setBounds(10, 70, 200, 40);
		add(btnTKSP);

		btnTKDT = new JButton("Thống kê doanh thu");
		btnTKDT.setFont(new Font("Arial", Font.BOLD, 16));
		btnTKDT.setBorderPainted(false);
		btnTKDT.setBackground(new Color(74, 131, 215));
		btnTKDT.setBounds(220, 70, 200, 40);
		add(btnTKDT);

		panel = new JPanel();
		panel.setBounds(0, 120, 1140, 125);
		add(panel);
		panel.setLayout(null);

		ngayBatDau = new JLabel("Ngày bắt đầu:");
		ngayBatDau.setFont(new Font("Arial", Font.BOLD, 16));
		ngayBatDau.setBounds(30, 85, 150, 20);
		panel.add(ngayBatDau);

		txtNgayBatDau = new JTextField();
		txtNgayBatDau.setBounds(190, 80, 220, 30);
		panel.add(txtNgayBatDau);
		txtNgayBatDau.setColumns(10);

		ngayKetThuc = new JLabel("Ngày kết thúc:");
		ngayKetThuc.setFont(new Font("Arial", Font.BOLD, 16));
		ngayKetThuc.setBounds(470, 85, 150, 20);
		panel.add(ngayKetThuc);

		txtNgayKetThuc = new JTextField();
		txtNgayKetThuc.setColumns(10);
		txtNgayKetThuc.setBounds(630, 80, 220, 30);
		txtNgayKetThuc.setEnabled(false);
		panel.add(txtNgayKetThuc);

		btnThongKe = new JButton("Thống kê");
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 16));
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBackground(new Color(74, 131, 215));
		btnThongKe.setBounds(910, 75, 200, 40);
		panel.add(btnThongKe);

		loaiTG = new JComboBox();
		loaiTG.setFont(new Font("Arial", Font.BOLD, 14));
		loaiTG.setModel(new DefaultComboBoxModel(new String[] {"Theo ngày", "Theo tháng", "Theo năm", "Khoảng thời gian"}));
		loaiTG.setBounds(190, 17, 220, 30);
		panel.add(loaiTG);
		loaiTG.addActionListener(this);

		JLabel lblThoiGianTK = new JLabel("Loại thời gian:");
		lblThoiGianTK.setFont(new Font("Arial", Font.BOLD, 16));
		lblThoiGianTK.setBounds(30, 20, 150, 20);
		panel.add(lblThoiGianTK);
		
		panel2 = new JPanel();
		

		panelBottom = new JPanel();
		panelBottom.setBounds(0, 255, 1140, 600);
		panelBottom.setLayout(null);
		panelBottom.add(TKDT).setVisible(true);
		this.add(panelBottom);

		btnTKDT.addActionListener(this);
		btnTKDT.setBackground(Color.decode("#bad7eb"));
		btnTKSP.addActionListener(this);
		btnThongKe.addActionListener(this);
	}

	public void resetBtnBackground() {
		btnTKDT.setBackground(new Color(74, 131, 215));
		btnTKSP.setBackground(new Color(74, 131, 215));
	}

	public void setVisibleFalse() {
		TKDT.setVisible(false);
		TKSP.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(loaiTG.getSelectedItem().equals("Theo ngày")) {
			txtNgayKetThuc.setEnabled(false);
			ngayBatDau.setText("Ngày bắt đầu:");
			ngayKetThuc.setText("Ngày kết thúc:");
			ngayKetThuc.setVisible(true);
			txtNgayKetThuc.setVisible(true);
		}
		if(loaiTG.getSelectedItem().equals("Theo tháng")) {
			txtNgayKetThuc.setEnabled(true);
			ngayBatDau.setText("Tháng:");
			ngayKetThuc.setText("Năm:");
			ngayKetThuc.setVisible(true);
			txtNgayKetThuc.setVisible(true);
		}
		if(loaiTG.getSelectedItem().equals("Theo năm")) {
			txtNgayKetThuc.setEnabled(true);
			ngayBatDau.setText("Năm:");
			ngayKetThuc.setVisible(false);
			txtNgayKetThuc.setVisible(false);
		}
		if(loaiTG.getSelectedItem().equals("Khoảng thời gian")) {
			txtNgayKetThuc.setEnabled(true);
			ngayBatDau.setText("Ngày bắt đầu:");
			ngayKetThuc.setText("Ngày kết thúc:");
			ngayKetThuc.setVisible(true);
			txtNgayKetThuc.setVisible(true);
		}
		if (o == btnTKDT) {
			setVisibleFalse();
			resetBtnBackground();
			btnTKDT.setBackground(Color.decode("#bad7eb"));
			btnThongKe.setVisible(true);
			panelBottom.add(TKDT).setVisible(true);
		}
		else if (o == btnTKSP) {
			setVisibleFalse();
			resetBtnBackground();
			btnThongKe.setVisible(false);
			btnTKSP.setBackground(Color.decode("#bad7eb"));
			panelBottom.add(TKSP).setVisible(true);
		}
		else if (o == btnThongKe && loaiTG.getSelectedItem().equals("Khoảng thời gian")) {
			TKDT.setDoanhThu(new ThongKe_Dao().tinhTongDoanhThu().toString());
			TKDT.setDoanhThuThuoc(tk_dao.tinhTongDTLoaiSPTheoKhoangTG("Thuốc", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayKetThuc.getText())).toString());
			TKDT.setDoanhThuThuoc(tk_dao.tinhTongDTLoaiSPTheoKhoangTG("Thực phẩm chức năng", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayKetThuc.getText())).toString());
			TKDT.setDoanhThuThuoc(tk_dao.tinhTongDTLoaiSPTheoKhoangTG("Dụng cụ y tế", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayKetThuc.getText())).toString());
		}
		else if (o == btnThongKe && loaiTG.getSelectedItem().equals("Theo tháng")) {
			TKDT.setDoanhThu(new ThongKe_Dao().tinhTongDoanhThu().toString());
			TKDT.setDoanhThuThuoc(new ThongKe_Dao().tinhTongDTLoaiSPTheoThang("Thuốc", Integer.valueOf(txtNgayBatDau.getText()), Integer.valueOf(txtNgayKetThuc.getText())).toString());
			TKDT.setDoanhThuThuoc(new ThongKe_Dao().tinhTongDTLoaiSPTheoThang("Thực phẩm chức năng", Integer.valueOf(txtNgayBatDau.getText()), Integer.valueOf(txtNgayKetThuc.getText())).toString());
			TKDT.setDoanhThuThuoc(new ThongKe_Dao().tinhTongDTLoaiSPTheoThang("Dụng cụ y tế", Integer.valueOf(txtNgayBatDau.getText()), Integer.valueOf(txtNgayKetThuc.getText())).toString());
		}
		else if (o == btnThongKe && loaiTG.getSelectedItem().equals("Theo nam")) {
			TKDT.setDoanhThu(new ThongKe_Dao().tinhTongDoanhThu().toString());
			TKDT.setDoanhThuThuoc(new ThongKe_Dao().tinhTongDTLoaiSPTheoNam("Thuốc", Integer.valueOf(txtNgayBatDau.getText())).toString());
			TKDT.setDoanhThuThuoc(new ThongKe_Dao().tinhTongDTLoaiSPTheoNam("Thực phẩm chức năng", Integer.valueOf(txtNgayBatDau.getText())).toString());
			TKDT.setDoanhThuThuoc(new ThongKe_Dao().tinhTongDTLoaiSPTheoNam("Dụng cụ y tế", Integer.valueOf(txtNgayBatDau.getText())).toString());
		}
		else if (o == btnThongKe && loaiTG.getSelectedItem().equals("Theo ngày")) {
			txtNgayKetThuc.setText(txtNgayBatDau.getText());
			TKDT.setDoanhThu(new ThongKe_Dao().tinhTongDoanhThu().toString());
			TKDT.setDoanhThuThuoc(new ThongKe_Dao().tinhTongDTLoaiSPTheoKhoangTG("Thuốc", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayBatDau.getText())).toString());
			TKDT.setDoanhThuThuoc(new ThongKe_Dao().tinhTongDTLoaiSPTheoKhoangTG("Thực phẩm chức năng", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayBatDau.getText())).toString());
			TKDT.setDoanhThuThuoc(new ThongKe_Dao().tinhTongDTLoaiSPTheoKhoangTG("Dụng cụ y tế", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayBatDau.getText())).toString());
		}
	}
}
