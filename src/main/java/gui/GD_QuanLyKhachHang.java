package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class GD_QuanLyKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textTenKH;
	private JTextField textMaKH;
	private JTextField textGioiTinh;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String col[] = { "STT", "Mã khách hàng", "Tên khách hàng", "Giới tính", "Tuổi", "Số điện thoại"};
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;

	public GD_QuanLyKhachHang() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140, 865);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1140, 60);
		panel.setBackground(new Color(187, 231, 252));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(0, 0, 1140, 60);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel tt_KhachHang = new JPanel();
		tt_KhachHang.setBackground(SystemColor.window);
		tt_KhachHang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin khách hàng", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		tt_KhachHang.setBounds(10, 70, 1120, 201);
		add(tt_KhachHang);
		tt_KhachHang.setLayout(null);
		
		JLabel tenKH = new JLabel("Tên khách hàng:");
		tenKH.setFont(new Font("Arial", Font.BOLD, 16));
		tenKH.setBounds(30, 92, 145, 30);
		tt_KhachHang.add(tenKH);
		
		textTenKH = new JTextField();
		textTenKH.setColumns(10);
		textTenKH.setBounds(185, 92, 220, 35);
		tt_KhachHang.add(textTenKH);
		
		JLabel maKH = new JLabel("Mã khách hàng:");
		maKH.setFont(new Font("Arial", Font.BOLD, 16));
		maKH.setBounds(30, 44, 145, 30);
		tt_KhachHang.add(maKH);
		
		textMaKH = new JTextField();
		textMaKH.setColumns(10);
		textMaKH.setBounds(185, 44, 220, 35);
		tt_KhachHang.add(textMaKH);
		
		JLabel gioiTinh = new JLabel("Giới tính:");
		gioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
		gioiTinh.setBounds(30, 138, 145, 30);
		tt_KhachHang.add(gioiTinh);
		
		textGioiTinh = new JTextField();
		textGioiTinh.setColumns(10);
		textGioiTinh.setBounds(185, 138, 220, 35);
		tt_KhachHang.add(textGioiTinh);
		
		JLabel txtAnh = new JLabel("Thêm ảnh");
		txtAnh.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnh.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		txtAnh.setBackground(Color.LIGHT_GRAY);
		txtAnh.setBounds(965, 35, 120, 140);
		tt_KhachHang.add(txtAnh);
		
		JLabel tuoi = new JLabel("Tuổi:");
		tuoi.setFont(new Font("Arial", Font.BOLD, 16));
		tuoi.setBounds(503, 47, 145, 30);
		tt_KhachHang.add(tuoi);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(640, 47, 220, 35);
		tt_KhachHang.add(textField_1);
		
		JLabel soDienThoai = new JLabel("Số điện thoại:");
		soDienThoai.setFont(new Font("Arial", Font.BOLD, 16));
		soDienThoai.setBounds(503, 95, 145, 30);
		tt_KhachHang.add(soDienThoai);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(640, 95, 220, 35);
		tt_KhachHang.add(textField_2);
		
		JPanel chucNang = new JPanel();
		chucNang.setLayout(null);
		chucNang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Chức năng", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		chucNang.setBackground(SystemColor.window);
		chucNang.setBounds(10, 281, 1120, 100);
		add(chucNang);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setToolTipText("thêm thông tin\r\n khách hàng");
		btnThem.setFont(new Font("Arial", Font.BOLD, 16));
		btnThem.setBounds(30, 38, 120, 40);
		btnThem.setBackground(Color.decode("#4db05e"));
		btnThem.setBorderPainted(false);
		chucNang.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setToolTipText("");
		btnXoa.setFont(new Font("Arial", Font.BOLD, 16));
		btnXoa.setBorderPainted(false);
		btnXoa.setBackground(Color.decode("#ee1919"));
		btnXoa.setBounds(180, 38, 120, 40);
		chucNang.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setToolTipText("thêm thông tin\r\n khách hàng");
		btnSua.setFont(new Font("Arial", Font.BOLD, 16));
		btnSua.setBorderPainted(false);
		btnSua.setBackground(Color.decode("#26bfbf"));
		btnSua.setBounds(330, 38, 120, 40);
		chucNang.add(btnSua);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setToolTipText("");
		btnTim.setFont(new Font("Arial", Font.BOLD, 16));
		btnTim.setBorderPainted(false);
		btnTim.setBackground(Color.decode("#4a83d7"));
		btnTim.setBounds(480, 38, 120, 40);
		chucNang.add(btnTim);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(631, 40, 220, 35);
		chucNang.add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo tên", "Tìm theo số điện thoại"}));
		comboBox.setBounds(880, 40, 210, 35);
		chucNang.add(comboBox);
		
		JLabel danhSach = new JLabel("Danh sách khách hàng");
		danhSach.setHorizontalAlignment(SwingConstants.CENTER);
		danhSach.setFont(new Font("Arial", Font.BOLD, 20));
		danhSach.setBounds(10, 391, 1120, 60);
		add(danhSach);
		
		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setSelectionBackground(SystemColor.controlHighlight);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(0).setMaxWidth(60);
		scroll = new JScrollPane(table);
		scroll.setFont(new Font("Arial", Font.BOLD, 25));
		scroll.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scroll.setBounds(10, 461, 1120, 384);
		add(scroll);
	}
	
		
}
