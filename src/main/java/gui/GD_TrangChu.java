package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GD_TrangChu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton btnBanThuoc;
	private JButton btnTraThuoc;
	private JButton btnKhuyenMai;
	public JButton btnNhanVien;
	private JButton btnKhachHang;
	private JButton btnSanPham;
	private JButton btnHoaDon;
	private JButton btnThongKe;
	private JButton btnTroGiup;
	private JPanel panel;
	private JButton btnTrangChu;
	private final GD_BanSanPham banSP = new GD_BanSanPham();
	private final GD_TraSanPham traSP = new GD_TraSanPham();
	private final GD_TroGiup troGiup = new GD_TroGiup();
	private final GD_QuanLyKhachHang khachHang = new GD_QuanLyKhachHang();
	private final GD_QuanLyNhanVien nhanVien = new GD_QuanLyNhanVien();
	private final GD_QuanLySanPham sanPham = new GD_QuanLySanPham();
	private final GD_QuanLyHoaDon hoaDon = new GD_QuanLyHoaDon();
	private final GD_ThongKe thongKe = new GD_ThongKe();
	private final GD_QuanLyKhuyenMai khuyenMai = new GD_QuanLyKhuyenMai();
	private JLabel backgound;
	private JButton btnThoat;

	private void initialize() {
		this.setSize(1540, 866);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel menu = new JPanel();
		menu.setBorder(null);
		menu.setBackground(Color.decode("#bad7eb"));
		menu.setBounds(0, 0, 400, 865);
		getContentPane().add(menu);
		menu.setLayout(null);

		btnTrangChu = new JButton("HIỆU THUỐC ATPV");
		btnTrangChu.setBackground(new Color(153, 180, 209));
		btnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChu.setBorderPainted(false);
		btnTrangChu.setFocusPainted(false);
		btnTrangChu.setFont(new Font("Arial", Font.BOLD, 28));
		btnTrangChu.setForeground(Color.BLACK);
		btnTrangChu.setBackground(Color.decode("#bad7eb"));
		btnTrangChu.setIcon(new ImageIcon("image//logo.png"));
		btnTrangChu.setBounds(-15, 0, 415, 120);
		menu.add(btnTrangChu);

		// ----- Bán Thuốc ----- //
		btnBanThuoc = new JButton("BÁN SẢN PHẨM                ");
		btnBanThuoc.setBounds(0, 135, 400, 60);
		menu.add(btnBanThuoc);
		btnBanThuoc.setBorderPainted(false);
		btnBanThuoc.setFocusPainted(false);
		btnBanThuoc.setFont(new Font("Arial", Font.BOLD, 20));
		btnBanThuoc.setForeground(Color.BLACK);
		btnBanThuoc.setBackground(Color.decode("#bad7eb"));
		btnBanThuoc.setIconTextGap(40); // Tạo Khoảng cách giữa icon và Nội dung(text)
		btnBanThuoc.setIcon(new ImageIcon("image//banThuoc.png"));

		// ----- Trả Thuốc ----- //
		btnTraThuoc = new JButton("TRẢ SẢN PHẨM                ");
		btnTraThuoc.setBounds(0, 210, 400, 60);
		menu.add(btnTraThuoc);
		btnTraThuoc.setBorderPainted(false);
		btnTraThuoc.setFocusPainted(false);
		btnTraThuoc.setFont(new Font("Arial", Font.BOLD, 20));
		btnTraThuoc.setForeground(Color.BLACK);
		btnTraThuoc.setBackground(Color.decode("#bad7eb"));
		btnTraThuoc.setIconTextGap(40); // Tạo Khoảng cách giữa icon và Nội dung(text)
		btnTraThuoc.setIcon(new ImageIcon("image//traThuoc.png"));
		btnTraThuoc.setBorderPainted(false);

		// ----- Khuyến Mãi ----- //
		btnKhuyenMai = new JButton("QUẢN LÝ KHUYẾN MÃI    ");
		btnKhuyenMai.setBounds(0, 285, 400, 60);
		menu.add(btnKhuyenMai);
		btnKhuyenMai.setBorderPainted(false);
		btnKhuyenMai.setFocusPainted(false);
		btnKhuyenMai.setFont(new Font("Arial", Font.BOLD, 20));
		btnKhuyenMai.setForeground(Color.BLACK);
		btnKhuyenMai.setBackground(Color.decode("#bad7eb"));
		btnKhuyenMai.setIconTextGap(43); // Tạo Khoảng cách giữa icon và Nội dung(text)
		btnKhuyenMai.setIcon(new ImageIcon("image//khuyenMai.png"));

		// ----- Nhân Viên ----- //
		btnNhanVien = new JButton("QUẢN LÝ NHÂN VIÊN      ");
		btnNhanVien.setBounds(0, 360, 400, 60);
		menu.add(btnNhanVien);
		btnNhanVien.setBorderPainted(false);
		btnNhanVien.setFocusPainted(false);
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 20));
		btnNhanVien.setForeground(Color.BLACK);
		btnNhanVien.setBackground(Color.decode("#bad7eb"));
		btnNhanVien.setIconTextGap(36); // Tạo Khoảng cách giữa icon và Nội dung(text)
		btnNhanVien.setIcon(new ImageIcon("image//nhanVien.png"));

		// ----- Khách Hàng ----- //
		btnKhachHang = new JButton("QUẢN LÝ KHÁCH HÀNG  ");
		btnKhachHang.setBounds(0, 435, 400, 60);
		menu.add(btnKhachHang);
		btnKhachHang.setBorderPainted(false);
		btnKhachHang.setFocusPainted(false);
		btnKhachHang.setFont(new Font("Arial", Font.BOLD, 20));
		btnKhachHang.setForeground(Color.BLACK);
		btnKhachHang.setBackground(Color.decode("#bad7eb"));
		btnKhachHang.setIconTextGap(42); // Tạo Khoảng cách giữa icon và Nội dung(text)
		btnKhachHang.setIcon(new ImageIcon("image//khachHang.png"));

		// ----- Sản Phẩm ----- //
		btnSanPham = new JButton("QUẢN LÝ SẢN PHẨM       ");
		btnSanPham.setBounds(0, 510, 400, 60);
		menu.add(btnSanPham);
		btnSanPham.setBorderPainted(false);
		btnSanPham.setFocusPainted(false);
		btnSanPham.setFont(new Font("Arial", Font.BOLD, 20));
		btnSanPham.setForeground(Color.BLACK);
		btnSanPham.setBackground(Color.decode("#bad7eb"));
		btnSanPham.setIconTextGap(40); // Tạo Khoảng cách giữa icon và Nội dung(text)
		btnSanPham.setIcon(new ImageIcon("image//sanPham.png"));

		// ----- Hóa Đơn ----- //
		btnHoaDon = new JButton("QUẢN LÝ HÓA ĐƠN         ");
		btnHoaDon.setBounds(0, 585, 400, 60);
		menu.add(btnHoaDon);
		btnHoaDon.setBorderPainted(false);
		btnHoaDon.setFocusPainted(false);
		btnHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btnHoaDon.setForeground(Color.BLACK);
		btnHoaDon.setBackground(Color.decode("#bad7eb"));
		btnHoaDon.setIconTextGap(48); // Tạo Khoảng cách giữa icon và Nội dung(text)
		btnHoaDon.setIcon(new ImageIcon("image//hoaDon.png"));

		// ----- Thống Kê ----- //
		btnThongKe = new JButton("THỐNG KÊ                        ");
		btnThongKe.setBounds(0, 660, 400, 60);
		menu.add(btnThongKe);
		btnThongKe.setBorderPainted(false);
		btnThongKe.setFocusPainted(false);
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 20));
		btnThongKe.setForeground(Color.BLACK);
		btnThongKe.setBackground(Color.decode("#bad7eb"));
		btnThongKe.setIconTextGap(40); // Tạo Khoảng cách giữa icon và Nội dung(text)
		btnThongKe.setIcon(new ImageIcon("image//thongKe.png"));

		// ----- Trợ Giúp ----- //
		btnTroGiup = new JButton("TRỢ GIÚP                        ");
		btnTroGiup.setBounds(0, 735, 400, 60);
		menu.add(btnTroGiup);
		btnTroGiup.setBorderPainted(false);
		btnTroGiup.setFocusPainted(false);
		btnTroGiup.setFont(new Font("Arial", Font.BOLD, 20));
		btnTroGiup.setForeground(Color.BLACK);
		btnTroGiup.setBackground(Color.decode("#bad7eb"));
		btnTroGiup.setIconTextGap(45); // Tạo Khoảng cách giữa icon và Nội dung(text)
		btnTroGiup.setIcon(new ImageIcon("image//troGiup.png"));

		btnThoat = new JButton("THOÁT CHƯƠNG TRÌNH");
		btnThoat.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		btnThoat.setIconTextGap(45);
		btnThoat.setForeground(Color.BLACK);
		btnThoat.setFont(new Font("Arial", Font.BOLD, 20));
		btnThoat.setFocusPainted(false);
		btnThoat.setBackground(new Color(220, 20, 60));
		btnThoat.setBounds(0, 810, 400, 55);
		menu.add(btnThoat);

		panel = new JPanel();
		panel.setBounds(400, 0, 1140, 865);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnTrangChu.addActionListener(this);
		btnBanThuoc.addActionListener(this);
		btnTroGiup.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnSanPham.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnKhuyenMai.addActionListener(this);
		btnTraThuoc.addActionListener(this);
		btnThoat.addActionListener(this);

		backgound = new JLabel("");
		backgound.setIcon(new ImageIcon("image//background1.jpeg"));
		backgound.setBounds(0, 0, 1140, 865);
		panel.add(backgound);

	}

	public GD_TrangChu() {
		initialize();
	}

	public static void main(String[] args) {
		new GD_TrangChu().setVisible(true);
	}

	public void resetBtnBackground() {
		btnBanThuoc.setBackground(Color.decode("#bad7eb"));
		btnThongKe.setBackground(Color.decode("#bad7eb"));
		btnTroGiup.setBackground(Color.decode("#bad7eb"));
		btnKhachHang.setBackground(Color.decode("#bad7eb"));
		btnNhanVien.setBackground(Color.decode("#bad7eb"));
		btnSanPham.setBackground(Color.decode("#bad7eb"));
		btnHoaDon.setBackground(Color.decode("#bad7eb"));
		btnKhuyenMai.setBackground(Color.decode("#bad7eb"));
		btnTraThuoc.setBackground(Color.decode("#bad7eb"));
	}

	public void setVisibleFalse() {
		backgound.setVisible(false);
		banSP.setVisible(false);
		traSP.setVisible(false);
		troGiup.setVisible(false);
		khachHang.setVisible(false);
		nhanVien.setVisible(false);
		sanPham.setVisible(false);
		hoaDon.setVisible(false);
		thongKe.setVisible(false);
		khuyenMai.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnTrangChu) {
			setVisibleFalse();
			resetBtnBackground();
			panel.add(backgound).setVisible(true);
		} else if (o == btnBanThuoc) {
			setVisibleFalse();
			resetBtnBackground();
			panel.add(banSP).setVisible(true);
			btnBanThuoc.setBackground(Color.LIGHT_GRAY);
		} else if (o == btnKhachHang) {
			setVisibleFalse();
			resetBtnBackground();
			panel.add(khachHang).setVisible(true);
			btnKhachHang.setBackground(Color.LIGHT_GRAY);
		} else if (o == btnNhanVien) {
			setVisibleFalse();
			resetBtnBackground();
			panel.add(nhanVien).setVisible(true);
			btnNhanVien.setBackground(Color.LIGHT_GRAY);
		} else if (o == btnThongKe) {
			setVisibleFalse();
			resetBtnBackground();
			panel.add(thongKe).setVisible(true);
			btnThongKe.setBackground(Color.LIGHT_GRAY);
		} else if (o == btnSanPham) {
			setVisibleFalse();
			resetBtnBackground();
			panel.add(sanPham).setVisible(true);
			btnSanPham.setBackground(Color.LIGHT_GRAY);
		} else if (o == btnHoaDon) {
			setVisibleFalse();
			resetBtnBackground();
			panel.add(hoaDon).setVisible(true);
			btnHoaDon.setBackground(Color.LIGHT_GRAY);
		} else if (o == btnKhuyenMai) {
			setVisibleFalse();
			resetBtnBackground();
			panel.add(khuyenMai).setVisible(true);
			btnKhuyenMai.setBackground(Color.LIGHT_GRAY);
		} else if (o == btnTraThuoc) {
			setVisibleFalse();
			resetBtnBackground();
			panel.add(traSP).setVisible(true);
			btnTraThuoc.setBackground(Color.LIGHT_GRAY);
		} else if (o == btnTroGiup) {
			setVisibleFalse();
			resetBtnBackground();
			panel.add(troGiup).setVisible(true);
			btnTroGiup.setBackground(Color.LIGHT_GRAY);
		} else if (o == btnThoat) {
			btnThoat.setBackground(Color.LIGHT_GRAY);
			int confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận thoát chương tình !", "Thoát chương trình",
					JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION) {
				// Kết thúc giao diện Thêm sản phẩm
				System.exit(0);
			}
			else {
				btnThoat.setBackground(new Color(220, 20, 60));
			}
		}
	}
}
