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

import dao.DangNhap_Dao;
import dao.NhanVien_Dao;
import entity.NhanVien;
import entity.TaiKhoan;

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
	private NhanVien_Dao nv_dao=new NhanVien_Dao();
	private NhanVien nv=new NhanVien();
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
	private DangNhap_Dao dangNhap_dao=new DangNhap_Dao();
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
		loadData();
		loadMa();
	}
	private String thuTuNhanVienTrongNam() {
		int sl = 0;
		for (NhanVien nv : nv_dao.getAllNhanVien()) {
			if (nv.getMaNV().substring(2, 4).equals("24"))
				sl++;
		}
		String slString = String.format("%03d", sl + 1);
		return slString;
	}
	private String generateRandomCode() {
		Year year = Year.now();
		String ma;
		int lastTwoDigitsOfYear = year.getValue() % 100;
		String lastTwoDigitsString = String.valueOf(lastTwoDigitsOfYear);

		
		if (comboBoxChucVu.getSelectedIndex() == 0)
			ma = "QL";
		else
			ma = "NV";
		ma += lastTwoDigitsString;
		
		if (rdoNam.isSelected())
			ma += "1";
		else
			ma += "0";
		
		return ma + thuTuNhanVienTrongNam();
	}

	private void loadData() {
		int i = 0;
		String gioiTinh="";
		Double luong;
		String trangThaiLV="";
		String chucVu="";
		DecimalFormat formatter = new DecimalFormat("#,###");
		for (NhanVien nv : nv_dao.getAllNhanVien()) {
			i++;
			if(nv.isGioiTinh()==true)
				gioiTinh="Nam";
			else
				gioiTinh="Nữ";
			if(nv.isTrangThaiLV()==true)
				trangThaiLV="Có";
			else
				trangThaiLV="Không";
			if(nv.isChucVu()==true)
				chucVu="Quản lí";
			else
				chucVu="Nhân viên";
			Object[] row = { i, nv.getMaNV(), nv.getTenNV(), nv.getSdt(), gioiTinh,formatter.format(nv.getLuong()),nv.getCaTruc(), nv.getNgaySinh(),
					trangThaiLV,chucVu, nv.getHinhAnhNhanVien()};
			model.addRow(row);
		}
	}
	private void loadMa() {
		String code;
		code = generateRandomCode();
		textMaNV.setText(code);
	}
	private void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	public static int calculateAge(Date birthDate) {
        LocalDate birth = birthDate.toLocalDate();
        LocalDate today = LocalDate.now();

        Period period = Period.between(birth, today);

        return period.getYears();
    }
	private void xoaTrang() {
		loadMa();
		textTenKH.setText("");
		textSDT.setText("");
		rdoNam.setSelected(false);
		rdoNu.setSelected(false);
		textNgaySinh.setText("yyyy-MM-dd");
		textLuong.setText("");
		comboBoxCaTruc.setSelectedItem(1);
		comboBoxChucVu.setSelectedItem(1);
		comboBoxTrangThai.setSelectedItem(1);
	}
	  
	public void them() {
		String anh="";
		if(rdoNam.isSelected()) {
			anhNhanVien.setIcon(new ImageIcon("D:\\btLon\\pharmacyManagement\\image\\nhanvien_nam.png"));
			anh="D:\\btLon\\pharmacyManagement\\image\\nhanvien_nam.png";}
		else {
			anhNhanVien.setIcon(new ImageIcon("D:\\btLon\\pharmacyManagement\\image\\nhanvien_nu.png"));
			anh="D:\\btLon\\pharmacyManagement\\image\\nhanvien_nu.png";
		}
		
		String ma = textMaNV.getText();
		String hoTen = textTenKH.getText();
		String sDT = textSDT.getText();
		
		boolean gt;
		if (rdoNam.isSelected())
			gt = true;
		else
			gt = false;
		Date ngaySinh= Date.valueOf(textNgaySinh.getText()) ;
		Double luong=Double.parseDouble(textLuong.getText());
		String caTruc= comboBoxCaTruc.getSelectedItem().toString();
		Boolean chucVu;
		

		
		
		int tuoi = calculateAge(ngaySinh);
		if (!((sDT.length() > 0) && sDT.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(this,
				"Không được rỗng và số điện thoại phải có đủ 10 số");
		
		}
		else {
		if(tuoi<18)
			JOptionPane.showMessageDialog(this, "Nhân viên này chưa đủ 18 tuổi");
			
		else {
			if(luong<15000000)
				JOptionPane.showMessageDialog(this, "Lương phải lớn hơn hoặc bằng 15000000");
			else {
				String role,mk;
				boolean trangthai;
			if(comboBoxChucVu.getSelectedItem().toString().equals("Quản lí")) {
				chucVu=true;
				role="Quản lý";
				trangthai=true;
				mk=ma;
			}
			else {
				chucVu=false;
				role="Nhân viên";
				trangthai=true;
				mk=ma;
			}
			
			
			NhanVien nv=new NhanVien(ma, hoTen, sDT, gt, luong, caTruc, ngaySinh, trangthai, chucVu, anh);
			if (nv_dao.addNhanVien(nv)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công | Tài Khoản và Mật Khẩu của bạn là: "+ma+"\nVui lòng tiến hành đổi mật khẩu để tăng bảo mật !");
				TaiKhoan tk= new TaiKhoan(ma, mk, trangthai, nv= new NhanVien(ma, hoTen, sDT, gt, luong, caTruc, ngaySinh, chucVu, trangthai, anh), role);
				dangNhap_dao.Them_taiKhoan_matKhau(tk);
				clearTable();
				xoaTrang();
				loadData();
				loadMa();
				}
			}}}
	}
	public void xoa() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa!!");
		} else if (table.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 nhân viên để xóa!!");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int row = table.getSelectedRow();
				nv_dao.deleteNhanVien(model.getValueAt(row, 1).toString());
				model.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa thành công!!");
				xoaTrang();
			}
		}
	}
	private void sua() {
		
		
			String anh="";
			if(rdoNam.isSelected()) {
				anhNhanVien.setIcon(new ImageIcon("D:\\btLon\\pharmacyManagement\\image\\nhanvien_nam.png"));
				anh="D:\\btLon\\pharmacyManagement\\image\\nhanvien_nam.png";}
			else {
				anhNhanVien.setIcon(new ImageIcon("D:\\btLon\\pharmacyManagement\\image\\nhanvien_nu.png"));
				anh="D:\\btLon\\pharmacyManagement\\image\\nhanvien_nu.png";
			}
		
			String ma = textMaNV.getText();
			String hoTen = textTenKH.getText().trim();
			String sDT = textSDT.getText();
			
			boolean gt;
			if (rdoNam.isSelected())
				gt = true;
			else
				gt = false;
			Date ngaySinh= Date.valueOf(textNgaySinh.getText()) ;
			
			Double luong=Double.parseDouble(textLuong.getText());
	
		
			String caTruc= comboBoxCaTruc.getSelectedItem().toString();
			boolean chucVu;
			boolean trangthai;

			
			
			int tuoi = calculateAge(ngaySinh);
			if(tuoi<18)
				JOptionPane.showMessageDialog(this, "Nhân viên này chưa đủ 18 tuổi");
				
			else {
				if(luong<15000000)
					JOptionPane.showMessageDialog(this, "Lương phải lớn hơn hoặc bằng 15000000");
				else {
					
					
				if(comboBoxChucVu.getSelectedItem().toString().equals("Quản lí")) {
					chucVu=true;
					
				}
				else {
					chucVu=false;
					
				}
				if(comboBoxTrangThai.getSelectedItem().toString().equals("Có"))
					trangthai=true;
				else
					trangthai=false;
				
				NhanVien nv=new NhanVien(ma, hoTen, sDT, gt, luong, caTruc, ngaySinh, trangthai, chucVu, anh);
				if (nv_dao.updateNhanVien(nv)) {
					
					if(nv.isTrangThaiLV()==false)
					{
						dangNhap_dao.doiTrangThaiTheoMa(ma, nv.isTrangThaiLV());}
					clearTable();
					loadData();
					JOptionPane.showMessageDialog(null, "Sữa thành công");
					xoaTrang();
					}
				else
					JOptionPane.showMessageDialog(this,"Sửa không thành công");
				}}
		
	}
	public void tim() {
		int i = 1;
		if (btnTim.getText().equals("Tìm")) {
			if (comboBoxLoaiTim.getSelectedItem().equals("Tìm theo mã")) {
				NhanVien nv = null;
				nv = nv_dao.getNhanVienTheoMa(textTuKhoaTim.getText());
				if (nv != null) {
					 textTenKH.setText(nv.getTenNV());
					    textSDT.setText(nv.getSdt());
					    if (nv.isGioiTinh()==true)
					        rdoNam.setSelected(true);
					    else
					        rdoNu.setSelected(true);

					    textLuong.setText( nv.getLuong().toString().replace(".", ""));
					    comboBoxCaTruc.setSelectedItem(nv.getCaTruc());
					    textNgaySinh.setText( nv.getNgaySinh().toString());
					    String trangThai;
					    if (nv.isTrangThaiLV()==true)
					       trangThai="Có";
					    else
					    	 trangThai="Không";
					    String chucVu;
					    if (nv.isChucVu()==true)
					       chucVu="Quản lí";
					    else
					    	 chucVu="Nhân viên";

					    
					    comboBoxTrangThai.setSelectedItem(trangThai);
					    comboBoxChucVu.setSelectedItem(chucVu);
					    anhNhanVien.setIcon(new ImageIcon(nv.getHinhAnhNhanVien()));
					    textMaNV.setText(nv.getMaNV());
					
				} else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
				}
				} else if (comboBoxLoaiTim.getSelectedItem().equals("Tìm theo tên")) {
				ArrayList<NhanVien> dsNhanVien = nv_dao.getNhanVienTheoTen(textTuKhoaTim.getText());
				if (dsNhanVien != null) {
					
					for (NhanVien nv : dsNhanVien) {
				        int firstSelectedRow = -1;
				        for (int row = 0; row < table.getRowCount(); row++) {
				            if (table.getValueAt(row, 2).equals(nv.getTenNV())) {
				                // Nếu tìm thấy, chọn dòng tương ứng
				                table.addRowSelectionInterval(row, row);
				                if (firstSelectedRow == -1) {
				                    firstSelectedRow = row;
				                }
				            }
				        }

				        // Cuộn đến dòng đầu tiên được chọn
				        if (firstSelectedRow != -1) {
				            table.scrollRectToVisible(table.getCellRect(firstSelectedRow, 0, true));
				        }


					}
				} else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
				}
			}
				else if (comboBoxLoaiTim.getSelectedItem().equals("Tìm theo số điện thoại")) {
					NhanVien nv = null;
					nv = nv_dao.getNhanVienTheoSDT(textTuKhoaTim.getText());
					if (nv != null) {
						 textTenKH.setText(nv.getTenNV());
						    textSDT.setText(nv.getSdt());
						    if (nv.isGioiTinh()==true)
						        rdoNam.setSelected(true);
						    else
						        rdoNu.setSelected(true);

						    textLuong.setText( nv.getLuong().toString().replace(".", ""));
						    comboBoxCaTruc.setSelectedItem(nv.getCaTruc());
						    textNgaySinh.setText( nv.getNgaySinh().toString());
						    String trangThai;
						    if (nv.isTrangThaiLV()==true)
						       trangThai="Có";
						    else
						    	 trangThai="Không";
						    String chucVu;
						    if (nv.isChucVu()==true)
						       chucVu="Quản lí";
						    else
						    	 chucVu="Nhân viên";

						    
						    comboBoxTrangThai.setSelectedItem(trangThai);
						    comboBoxChucVu.setSelectedItem(chucVu);
						    anhNhanVien.setIcon(new ImageIcon(nv.getHinhAnhNhanVien()));
						    textMaNV.setText(nv.getMaNV());
					} else {
						JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
					}
				}
		} }
	
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
		int row = table.getSelectedRow();
		  
		if (row != -1) {
			
		  
		    textTenKH.setText(model.getValueAt(row, 2).toString());
		    textSDT.setText(model.getValueAt(row, 3).toString());
		    if (model.getValueAt(row, 4).toString().equals("Nam"))
		        rdoNam.setSelected(true);
		    else
		        rdoNu.setSelected(true);

		    textLuong.setText( model.getValueAt(row, 5).toString().replace(".", ""));
		    comboBoxCaTruc.setSelectedItem(model.getValueAt(row, 6));
		    textNgaySinh.setText( model.getValueAt(row, 7).toString());
		    comboBoxTrangThai.setSelectedItem(model.getValueAt(row, 8));
		    comboBoxChucVu.setSelectedItem(model.getValueAt(row, 9));
		    anhNhanVien.setIcon(new ImageIcon(model.getValueAt(row, 10).toString()));
		    textMaNV.setText(model.getValueAt(row, 1).toString());
		} else {
		    // Xử lý trường hợp không có hàng nào được chọn
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		 if (obj.equals(rdoNam)) {
		
			textMaNV.setText(null);
			loadMa();
			anhNhanVien.setIcon(new ImageIcon("D:\\btLon\\pharmacyManagement\\image\\nhanvien_nam.png"));
		} else if (obj.equals(rdoNu)) {
			
			textMaNV.setText(null);
			loadMa();
			anhNhanVien.setIcon(new ImageIcon("D:\\btLon\\pharmacyManagement\\image\\nhanvien_nu.png"));
		} else if (obj.equals(btnThem)) {
			them();
		}else if (obj.equals(btnXoaTrang)) {
			xoaTrang();
		}
		else if (obj.equals(comboBoxChucVu)) {
			textMaNV.setText(null);
			loadMa();
		}else if (obj.equals(btnXoa)) {
			xoa();
		}else if (obj.equals(btnSua)) {
			sua();
		}else if (obj.equals(btnTim)) {
			table.clearSelection();
			tim();
		}
	}
	
	
	
}
