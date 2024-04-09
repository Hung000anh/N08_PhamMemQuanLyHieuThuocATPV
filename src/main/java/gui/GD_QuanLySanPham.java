package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GD_QuanLySanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	private String col[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Đơn giá nhập", "Đơn giá bán", "Số lượng tồn", "Ngày sản xuất", "Ngày hết hạn", "Đơn vị tính"};
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private JTextField textField;
	private JTextField textNgaySX;
	private JTextField textLoaiSP;
	private JTextField txtMaSP;
	private JTextField textTenSP;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public GD_QuanLySanPham() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140, 865);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1140, 60);
		panel.setBackground(new Color(187, 231, 252));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(0, 0, 1140, 60);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel tt_KhachHang = new JPanel();
		tt_KhachHang.setBackground(SystemColor.window);
		tt_KhachHang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin sản phẩm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		tt_KhachHang.setBounds(10, 70, 1120, 250);
		add(tt_KhachHang);
		tt_KhachHang.setLayout(null);
		
		JLabel tenSP = new JLabel("Tên sản phẩm:");
		tenSP.setFont(new Font("Arial", Font.BOLD, 16));
		tenSP.setBounds(30, 92, 145, 30);
		tt_KhachHang.add(tenSP);
		
		textTenSP = new JTextField();
		textTenSP.setColumns(10);
		textTenSP.setBounds(185, 92, 220, 35);
		tt_KhachHang.add(textTenSP);
		
		JLabel maSP = new JLabel("Mã sản phẩm:");
		maSP.setFont(new Font("Arial", Font.BOLD, 16));
		maSP.setBounds(30, 44, 145, 30);
		tt_KhachHang.add(maSP);
		
		txtMaSP = new JTextField();
		txtMaSP.setEnabled(false);
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(185, 44, 220, 35);
		tt_KhachHang.add(txtMaSP);
		
		JLabel loai = new JLabel("Loại sản phẩm:");
		loai.setFont(new Font("Arial", Font.BOLD, 16));
		loai.setBounds(30, 138, 145, 30);
		tt_KhachHang.add(loai);
		
		textLoaiSP = new JTextField();
		textLoaiSP.setColumns(10);
		textLoaiSP.setBounds(185, 138, 220, 35);
		tt_KhachHang.add(textLoaiSP);
		
		JLabel txtAnh = new JLabel("Thêm ảnh");
		txtAnh.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnh.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		txtAnh.setBackground(Color.LIGHT_GRAY);
		txtAnh.setBounds(865, 39, 220, 134);
		tt_KhachHang.add(txtAnh);
		
		JLabel ngaySX = new JLabel("Ngày sản xuất:");
		ngaySX.setFont(new Font("Arial", Font.BOLD, 16));
		ngaySX.setBounds(30, 183, 145, 30);
		tt_KhachHang.add(ngaySX);
		
		textNgaySX = new JTextField();
		textNgaySX.setColumns(10);
		textNgaySX.setBounds(185, 183, 220, 35);
		tt_KhachHang.add(textNgaySX);
		
		JLabel donViTinh = new JLabel("Đơn vị tính:");
		donViTinh.setFont(new Font("Arial", Font.BOLD, 16));
		donViTinh.setBounds(865, 183, 145, 30);
		tt_KhachHang.add(donViTinh);
		
		JLabel soLuongTon = new JLabel("Số lượng tồn:");
		soLuongTon.setFont(new Font("Arial", Font.BOLD, 16));
		soLuongTon.setBounds(452, 44, 145, 30);
		tt_KhachHang.add(soLuongTon);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(589, 41, 220, 35);
		tt_KhachHang.add(textField_1);
		
		JLabel donGiaNhap = new JLabel("Đơn gá nhập:");
		donGiaNhap.setFont(new Font("Arial", Font.BOLD, 16));
		donGiaNhap.setBounds(452, 89, 145, 30);
		tt_KhachHang.add(donGiaNhap);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(589, 89, 220, 35);
		tt_KhachHang.add(textField_2);
		
		JLabel donGiaban = new JLabel("Đơn giá bán:");
		donGiaban.setFont(new Font("Arial", Font.BOLD, 16));
		donGiaban.setBounds(452, 135, 145, 30);
		tt_KhachHang.add(donGiaban);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(589, 135, 220, 35);
		tt_KhachHang.add(textField_3);
		
		JLabel ngayHH = new JLabel("Ngày hết hạn:");
		ngayHH.setFont(new Font("Arial", Font.BOLD, 16));
		ngayHH.setBounds(452, 180, 145, 30);
		tt_KhachHang.add(ngayHH);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(589, 183, 220, 35);
		tt_KhachHang.add(textField_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Hộp", "Viên", "Vĩ", "Cái", "Chai"}));
		comboBox_1.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox_1.setBounds(964, 183, 121, 35);
		tt_KhachHang.add(comboBox_1);
		
		JPanel chucNang = new JPanel();
		chucNang.setLayout(null);
		chucNang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Chức năng", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		chucNang.setBackground(SystemColor.window);
		chucNang.setBounds(10, 330, 1120, 100);
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
		
		JLabel danhSach = new JLabel("Danh sách sản phẩm");
		danhSach.setHorizontalAlignment(SwingConstants.CENTER);
		danhSach.setFont(new Font("Arial", Font.BOLD, 20));
		danhSach.setBounds(10, 440, 1120, 60);
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
		scroll.setBounds(10, 510, 1120, 335);
		add(scroll);
	}

}
