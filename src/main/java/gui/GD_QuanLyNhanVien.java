package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javax.swing.JRadioButton;




public class GD_QuanLyNhanVien extends JPanel implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;
	private String col[] = { "STT", "Mã nhân viên", "Tên nhân viên","SDT", "Giới tính","Lương","Ca Trực", "Ngày sinh", "Trạng thái","Chức vụ","link Ảnh"};
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private JTextField textTuKhoaTim;
	private JTextField textNgaySinh;
	private JTextField textLuong;
	private JTextField textMaNV;
	private JTextField textTenKH;
	private JTextField textSDT;
	private JButton openButton;
	private Container pnSouth;
	private JLabel imageLabel;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JComboBox comboBoxChucVu;
	private JComboBox comboBoxCaTruc;
	private JComboBox comboBoxTrangThai;
	private JLabel anhNhanVien;
	private JButton btnThem;
	private JButton btnXoaTrang ;
	private 	JButton btnXoa;
	private JButton btnSua ;
	private JComboBox comboBoxLoaiTim ;
	private JButton btnTim ;
	/**
	 * Create the panel.
	 */
	public GD_QuanLyNhanVien() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140, 865);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1140, 60);
		panel.setBackground(new Color(187, 231, 252));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(0, 0, 1140, 60);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel tt_KhachHang = new JPanel();
		tt_KhachHang.setBackground(SystemColor.window);
		tt_KhachHang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin nhân viên", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		tt_KhachHang.setBounds(10, 70, 1120, 290);
		add(tt_KhachHang);
		tt_KhachHang.setLayout(null);
		
		JLabel tenNV = new JLabel("Tên nhân viên:");
		tenNV.setFont(new Font("Arial", Font.BOLD, 16));
		tenNV.setBounds(30, 92, 145, 30);
		tt_KhachHang.add(tenNV);
		
		textTenKH = new JTextField();
		textTenKH.setColumns(10);
		textTenKH.setBounds(185, 92, 220, 35);
		tt_KhachHang.add(textTenKH);
		
		JLabel maNV = new JLabel("Mã nhân viên:");
		maNV.setFont(new Font("Arial", Font.BOLD, 16));
		maNV.setBounds(30, 44, 145, 30);
		tt_KhachHang.add(maNV);
		
		textMaNV = new JTextField();
		textMaNV.setEnabled(false);
		textMaNV.setColumns(10);
		textMaNV.setBounds(185, 44, 220, 35);
		tt_KhachHang.add(textMaNV);
		
		JLabel gioiTinh = new JLabel("Giới tính:");
		gioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
		gioiTinh.setBounds(30, 138, 145, 30);
		tt_KhachHang.add(gioiTinh);
		
		rdoNam = new JRadioButton();
		rdoNam.setSize(21, 16);
		rdoNam.setLocation(185, 145);
		tt_KhachHang.add(rdoNam);
		rdoNam.setBackground(new Color(255, 255, 255));
		JLabel lblNam = new JLabel("Nam");
		lblNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNam.setSize(72, 24);
		lblNam.setLocation(212, 141);
		tt_KhachHang.add(lblNam);
		rdoNu = new JRadioButton();
		rdoNu.setBackground(new Color(255, 255, 255));
		rdoNu.setBounds(273, 145, 21, 16);
		tt_KhachHang.add(rdoNu);
		JLabel lblNu = new JLabel("Nữ");
		lblNu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNu.setBounds(300, 141, 64, 24);
		tt_KhachHang.add(lblNu);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdoNam);
		bg.add(rdoNu);

		
		JLabel txtAnh = new JLabel("");
		txtAnh.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnh.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		txtAnh.setBackground(Color.LIGHT_GRAY);
		txtAnh.setBounds(960, 65, 101, 108);
		tt_KhachHang.add(txtAnh);
	
		
		JLabel ngaySinh = new JLabel("Ngày sinh:");
		ngaySinh.setFont(new Font("Arial", Font.BOLD, 16));
		ngaySinh.setBounds(503, 47, 145, 30);
		tt_KhachHang.add(ngaySinh);
		
		textNgaySinh = new JTextField();
		textNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textNgaySinh.setText("yyyy-MM-dd");
		textNgaySinh.setColumns(10);
		textNgaySinh.setBounds(640, 44, 220, 35);
		tt_KhachHang.add(textNgaySinh);
		
		JLabel luong = new JLabel("Lương:");
		luong.setFont(new Font("Arial", Font.BOLD, 16));
		luong.setBounds(503, 92, 145, 30);
		tt_KhachHang.add(luong);
		
		textLuong = new JTextField();
		textLuong.setColumns(10);
		textLuong.setBounds(640, 92, 220, 35);
		tt_KhachHang.add(textLuong);
		
		textSDT = new JTextField();
		textSDT.setColumns(10);
		textSDT.setBounds(185, 183, 220, 35);
		tt_KhachHang.add(textSDT);
		
		JLabel soDienThoai = new JLabel("Số điện thoại:");
		soDienThoai.setFont(new Font("Arial", Font.BOLD, 16));
		soDienThoai.setBounds(30, 183, 145, 30);
		tt_KhachHang.add(soDienThoai);
		
		JLabel caTruc = new JLabel("Ca trực:");
		caTruc.setFont(new Font("Arial", Font.BOLD, 16));
		caTruc.setBounds(503, 138, 145, 30);
		tt_KhachHang.add(caTruc);
		
		JLabel trangThai = new JLabel("Trạng thái:");
		trangThai.setFont(new Font("Arial", Font.BOLD, 16));
		trangThai.setBounds(503, 235, 145, 30);
		tt_KhachHang.add(trangThai);
		
		 comboBoxCaTruc= new JComboBox();
		comboBoxCaTruc.setModel(new DefaultComboBoxModel(new String[] {"Sáng", "Trưa", "Chiều"}));
		comboBoxCaTruc.setFont(new Font("Arial", Font.BOLD, 16));
		comboBoxCaTruc.setBounds(640, 138, 220, 35);
		tt_KhachHang.add(comboBoxCaTruc);
		
		 comboBoxTrangThai= new JComboBox();
		comboBoxTrangThai.setModel(new DefaultComboBoxModel(new String[] {"Có", "Không"}));
		comboBoxTrangThai.setFont(new Font("Arial", Font.BOLD, 16));
		comboBoxTrangThai.setBounds(640, 233, 220, 35);
		tt_KhachHang.add(comboBoxTrangThai);
		
		comboBoxChucVu= new JComboBox();
		comboBoxChucVu.setModel(new DefaultComboBoxModel(new String[] {"Quản lí","Nhân viên"}));
		comboBoxChucVu.setFont(new Font("Arial", Font.BOLD, 16));
		comboBoxChucVu.setBounds(640, 183, 220, 35);
		tt_KhachHang.add(comboBoxChucVu);
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setFont(new Font("Arial", Font.BOLD, 16));
		lblChcV.setBounds(503, 187, 145, 30);
		tt_KhachHang.add(lblChcV);
		
		 anhNhanVien= new JLabel("");
		anhNhanVien.setBounds(960, 44, 120, 140);
		tt_KhachHang.add(anhNhanVien);
		
		JPanel chucNang = new JPanel();
		chucNang.setLayout(null);
		chucNang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Chức năng", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		chucNang.setBackground(SystemColor.window);
		chucNang.setBounds(10, 370, 1120, 100);
		add(chucNang);
		
		 btnThem= new JButton("Thêm");
		btnThem.addActionListener(this);
		btnThem.setToolTipText("thêm thông tin\r\n khách hàng");
		btnThem.setFont(new Font("Arial", Font.BOLD, 16));
		btnThem.setBounds(30, 38, 120, 40);
		btnThem.setBackground(Color.decode("#4db05e"));
		btnThem.setBorderPainted(false);
		chucNang.add(btnThem);
		
		btnXoa= new JButton("Xóa");
		btnXoa.setToolTipText("");
		btnXoa.setFont(new Font("Arial", Font.BOLD, 16));
		btnXoa.setBorderPainted(false);
		btnXoa.setBackground(Color.decode("#ee1919"));
		btnXoa.setBounds(180, 38, 120, 40);
		btnXoa.addActionListener(this);
		chucNang.add(btnXoa);
		
		btnSua= new JButton("Sửa");
		btnSua.setToolTipText("thêm thông tin\r\n khách hàng");
		btnSua.setFont(new Font("Arial", Font.BOLD, 16));
		btnSua.setBorderPainted(false);
		btnSua.setBackground(Color.decode("#26bfbf"));
		btnSua.setBounds(330, 38, 120, 40);
		btnSua.addActionListener(this);
		chucNang.add(btnSua);
		
		btnTim= new JButton("Tìm");
		btnTim.setToolTipText("");
		btnTim.setFont(new Font("Arial", Font.BOLD, 16));
		btnTim.setBorderPainted(false);
		btnTim.setBackground(Color.decode("#4a83d7"));
		btnTim.setBounds(480, 38, 120, 40);
		btnTim.addActionListener(this);
		chucNang.add(btnTim);
		
		textTuKhoaTim = new JTextField();
		textTuKhoaTim.setColumns(10);
		textTuKhoaTim.setBounds(755, 40, 142, 35);
		chucNang.add(textTuKhoaTim);
		
		comboBoxLoaiTim= new JComboBox();
		comboBoxLoaiTim.setFont(new Font("Arial", Font.BOLD, 16));
		comboBoxLoaiTim.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo tên", "Tìm theo số điện thoại"}));
		comboBoxLoaiTim.setBounds(920, 40, 170, 35);
		chucNang.add(comboBoxLoaiTim);
		
		btnXoaTrang= new JButton("Xóa trắng");
		btnXoaTrang.setToolTipText("");
		btnXoaTrang.setFont(new Font("Arial", Font.BOLD, 16));
		btnXoaTrang.setBorderPainted(false);
		btnXoaTrang.setBackground(new Color(74, 131, 215));
		btnXoaTrang.setBounds(625, 38, 120, 40);
		btnXoaTrang.addActionListener(this);
		chucNang.add(btnXoaTrang);
		
		JLabel danhSach = new JLabel("Danh sách nhân viên");
		danhSach.setHorizontalAlignment(SwingConstants.CENTER);
		danhSach.setFont(new Font("Arial", Font.BOLD, 20));
		danhSach.setBounds(10, 480, 1120, 60);
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
		scroll.setBounds(10, 550, 1120, 295);
		add(scroll);
		rdoNam.addActionListener(this);
		rdoNu.addActionListener(this);
		table.addMouseListener(this);
		comboBoxChucVu.addActionListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
