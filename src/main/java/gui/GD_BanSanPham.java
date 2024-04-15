package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.ChiTiecHoaDon_Dao;
import dao.HoaDon_DAO;

import dao.KhuyenMaiSanPham_Dao;

import dao.KhachHang_Dao;
import dao.KhuyenMaiHoaDon_Dao;

import dao.NhanVien_Dao;
import dao.SanPham_Dao;
import entity.ChiTietHoaDon;
import entity.HoaDon;

import entity.KhuyenMaiSanPham;

import entity.KhachHang;
import entity.KhuyenMaiHoaDon;

import entity.NhanVien;
import entity.SanPham;

public class GD_BanSanPham extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	Font font = new Font("Arial", Font.BOLD, 16); // khung tittle
	Font font2 = new Font("Arial", Font.BOLD, 18); // thuộc tính
	Font font3 = new Font("Arial", Font.PLAIN, 18); // jtexfield

	private String col[] = { "STT", "Mã sản phẩm ", "Tên sản phẩm", "Đơn vị tính", "số lượng", "Đơn giá"};
	private JLabel lblTitle;
	private JPanel pnNorth;

	private Properties p;

	private JComboBox<String> cbChucVu;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JComboBox<String> cbLoaiTim;
	private JTextField txtTuKhoaTim;
	private JButton btnTimKiem;
	private JButton btnXuatExcel;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;

	private JTextField txtMa;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JButton openButton;
	private JLabel imageLabel;
	private String absolutePath;
	private File selectedFile;


	private JButton btnUser;
	private JComboBox<String> comBoBoxMaSP;
	private JTextField txtMaSp;
	private JTextField txtTen;
	private JTextField txtLoai;
	private JTextField txtNgayHH;
	private JTextField txtSLTon;
	private JTextField txtDonViTinh;
	private JTextField txtKhuyenMai;
	private JTextField txtGia;
	private JTextField txtSoLuong;
	private JButton btnThemSPVaoHD;
	private JTextField textField;
	private JLabel lblNgyLp;
	private JTextField textField_1;
	private JLabel lblMKhchHngc;
	private JLabel lblMNhnVin;
	private JTextField textField_3;
	private JLabel lblLoiHan;
	private JTextField textField_4;
	private JLabel lblKhuynMic;
	private JTextField textField_5;
	private JTable table_1;
	private JLabel lblNewLabel_1;
	private JTextField textField_6;
	private JLabel lblNewLabel_2;
	private JTextField textField_7;
	private JLabel lblNewLabel_3;
	private JTextField textField_8;
	private JLabel lblNewLabel_4;
	private JTextField textField_9;
	private int q=0;
	private JButton btnXoaSP;
	private ChiTiecHoaDon_Dao chiTiecHoaDon_dao=new ChiTiecHoaDon_Dao();
	private HoaDon_DAO hd_dao=new HoaDon_DAO();
	private JComboBox<String> comBoBoxMaSP_1 ;
	private KhachHang_Dao kh_dao=new KhachHang_Dao();
	private String maKh="";
	private JButton btnInHoaDon ;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public GD_BanSanPham()   {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140,865);
		pnNorth = new JPanel();
		pnNorth.setLayout(null);
		pnNorth.setBounds(0, 0, 1200, 60);
		pnNorth.setBackground(new Color(187, 231, 252));
		add(pnNorth);
		lblTitle = new JLabel("Bán Hàng");
		pnNorth.add(lblTitle);
		// ---nút user
		btnUser = new JButton();
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialog_User user=new Dialog_User();
				user.setVisible(true);
			}
		});
		btnUser.setBackground(Color.decode("#B5E6FB"));
		btnUser.setBorderPainted(false);
		btnUser.setIcon(new ImageIcon("D://BaiTapLonPTUD_NHOM4//icon//icon_profile.png"));
		btnUser.setBounds(1092, 5, 45, 45);
		ImageIcon iconProfile = new ImageIcon("D://BaiTapLonPTUD_NHOM4//icon//icon_profile.png");
		iconProfile = new ImageIcon(iconProfile.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH));
		btnUser.setIcon(iconProfile);
		pnNorth.add(btnUser);

		// căn giữa title
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);

		// Đặt kích thước và tọa độ cho lblTitle
		int labelWidth = 500; // Thay đổi kích thước theo ý muốn
		int labelHeight = 40; // Thay đổi kích thước theo ý muốn
		int labelX = (pnNorth.getWidth() - labelWidth) / 2; // Căn giữa theo chiều ngang
		int labelY = (pnNorth.getHeight() - labelHeight) / 2; // Căn giữa theo chiều dọc
		lblTitle.setBounds(labelX, labelY, labelWidth, labelHeight);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));

		// khung thông tin nhân viên
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(new Color(255, 255, 255));
		pnSouth.setBounds(15, 80, 400, 755);
		pnSouth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin sản phẩm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),
				Color.blue));
		TitledBorder titlethongtin = (TitledBorder) pnSouth.getBorder();
		titlethongtin.setTitleColor(Color.blue);
		titlethongtin.setTitleFont(font);
		pnSouth.setLayout(null);
		add(pnSouth);

		// Nội dung thông tin nhân viên

		JLabel lblMa = new JLabel("Chọn mã sản phẩm:");
		pnSouth.add(lblMa);
		lblMa.setBounds(23, 0, 180, 100);
		lblMa.setFont(font2);

		

		int x = 230, y = 55, w = 180, h = 28;
		comBoBoxMaSP = new JComboBox<String>();
		comBoBoxMaSP.setBounds(232, 36, w-30, h);
		pnSouth.add(comBoBoxMaSP);
		comBoBoxMaSP.setFont(font3);
		
		JPanel pnTTSP = new JPanel();
		pnTTSP.setBackground(new Color(255, 255, 250));
		pnTTSP.setBounds(12, 74, 370, 486);
		pnTTSP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin chi tiết sản phẩm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),
				Color.blue));
		TitledBorder titlethongtin1 = (TitledBorder) pnTTSP.getBorder();
		titlethongtin1.setTitleColor(Color.blue);
		titlethongtin1.setTitleFont(font);
		pnTTSP.setLayout(null);
		pnSouth.add(pnTTSP);
		
		JLabel lblAnh = new JLabel("Ảnh");
		pnTTSP.add(lblAnh);
		lblAnh.setFont(font2);
		lblAnh.setBounds(58, 91, w + 20, h);

	

		JLabel lblMaSP = new JLabel("Mã sản phẩm:");
		lblMaSP.setBounds(7, 135, 150, 100);
		lblMaSP.setFont(font2);
		pnTTSP.add(lblMaSP);

		txtMaSp = new JTextField();
		txtMaSp.setEnabled(false);
		pnTTSP.add(txtMaSp);
		txtMaSp.setBounds(150, 171, 200, h);
		txtMaSp.setFont(font3);
		
		JLabel lblTen = new JLabel("Tên sản phẩm:");
		lblTen.setBounds(7, 173, 150, 100);
		lblTen.setFont(font2);
		pnTTSP.add(lblTen);

		txtTen = new JTextField();
		pnTTSP.add(txtTen);
		txtTen.setEditable(false);
		txtTen.setBounds(150, 209, 200, h);
		txtTen.setFont(font3);
		
		JLabel lblLoai = new JLabel("Loại sản phẩm:");
		lblLoai.setBounds(7, 211, 150, 100);
		lblLoai.setFont(font2);
		pnTTSP.add(lblLoai);

		txtLoai = new JTextField();
		pnTTSP.add(txtLoai);
		txtLoai.setEditable(false);
		txtLoai.setBounds(150, 247, 200, h);
		txtLoai.setFont(font3);
		
		JLabel lblNgayHH = new JLabel("Ngày hết hạn:");
		lblNgayHH.setBounds(7, 249, 150, 100);
		lblNgayHH.setFont(font2);
		pnTTSP.add(lblNgayHH);

		txtNgayHH = new JTextField();
		pnTTSP.add(txtNgayHH);
		txtNgayHH.setEditable(false);
		txtNgayHH.setBounds(150, 285, 200, h);
		txtNgayHH.setFont(font3);
		
		JLabel lblSLTon = new JLabel("Số lượng tồn:");
		lblSLTon.setBounds(7, 290, 150, 100);
		lblSLTon.setFont(font2);
		pnTTSP.add(lblSLTon);

		txtSLTon = new JTextField();
		pnTTSP.add(txtSLTon);
		txtSLTon.setEditable(false);
		txtSLTon.setBounds(150, 326, 200, h);
		txtSLTon.setFont(font3);
		
		JLabel lblDonViTinh = new JLabel("Đơn vị tính:");
		lblDonViTinh.setBounds(7, 328, 150, 100);
		lblDonViTinh.setFont(font2);
		pnTTSP.add(lblDonViTinh);

		txtDonViTinh = new JTextField();
		pnTTSP.add(txtDonViTinh);
		txtDonViTinh.setEditable(false);
		txtDonViTinh.setBounds(150, 364, 200, h);
		txtDonViTinh.setFont(font3);
		
		JLabel lblKhuyenMai = new JLabel("Khuyến mãi:");
		lblKhuyenMai.setBounds(7, 366, 150, 100);
		lblKhuyenMai.setFont(font2);
		pnTTSP.add(lblKhuyenMai);

		txtKhuyenMai = new JTextField();
		pnTTSP.add(txtKhuyenMai);
		txtKhuyenMai.setEditable(false);
		txtKhuyenMai.setBounds(150, 402, 200, h);
		txtKhuyenMai.setFont(font3);
		
		JLabel lblgia = new JLabel("Giá bán:");
		lblgia.setBounds(7, 404, 150, 100);
		lblgia.setFont(font2);
		pnTTSP.add(lblgia);

		txtGia = new JTextField();
		pnTTSP.add(txtGia);
		txtGia.setEditable(false);
		txtGia.setBounds(150, 440, 200, h);
		txtGia.setFont(font3);
		
		JLabel lblSoLuong = new JLabel("Nhập số lượng:");
		lblSoLuong.setBounds(7, 530, 150, 100);
		lblSoLuong.setFont(font2);
		pnSouth.add(lblSoLuong);

		txtSoLuong = new JTextField();
		pnSouth.add(txtSoLuong);

		txtSoLuong.setBounds(150, 565, 100, h);
		txtSoLuong.setFont(font3);
		
		
		btnThemSPVaoHD = new JButton("Thêm vào hóa đơn");
		btnThemSPVaoHD.addActionListener(this);
			
		btnThemSPVaoHD.setFont(font);
		btnThemSPVaoHD.setBounds(100, 600, 200, 35);
		btnThemSPVaoHD.setBackground(new Color(238, 233, 233));
		pnSouth.add(btnThemSPVaoHD);
		
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(new Color(255, 255, 255));
		pnNorth.setBounds(425, 75, 700, 760);
		pnNorth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin hóa đơn", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),
				Color.blue));
		TitledBorder thongtin = (TitledBorder) pnNorth.getBorder();
		thongtin.setTitleColor(Color.blue);
		thongtin.setTitleFont(font);
		pnNorth.setLayout(null);
		add(pnNorth);
		
		JLabel lblNewLabel = new JLabel("Mã hóa đơn:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(43, 37, 120, 20);
		pnNorth.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(160, 32, 241, 28);
		pnNorth.add(textField);
		textField.setColumns(10);
		
		lblNgyLp = new JLabel("Ngày lập:");
		lblNgyLp.setFont(new Font("Arial", Font.BOLD, 18));
		lblNgyLp.setBounds(430, 37, 90, 20);
		pnNorth.add(lblNgyLp);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(528, 32, 159, 28);
		pnNorth.add(textField_1);
		
		lblMKhchHngc = new JLabel("Mã Khách hàng:");
		lblMKhchHngc.setFont(new Font("Arial", Font.BOLD, 18));
		lblMKhchHngc.setBounds(43, 94, 150, 20);
		pnNorth.add(lblMKhchHngc);
		
		lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setFont(new Font("Arial", Font.BOLD, 18));
		lblMNhnVin.setBounds(43, 150, 131, 20);
		pnNorth.add(lblMNhnVin);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(172, 146, 229, 28);
		pnNorth.add(textField_3);
		
		lblLoiHan = new JLabel("Loại hóa đơn:");
		lblLoiHan.setFont(new Font("Arial", Font.BOLD, 18));
		lblLoiHan.setBounds(421, 150, 131, 20);
		pnNorth.add(lblLoiHan);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(553, 147, 134, 28);
		pnNorth.add(textField_4);
		
		lblKhuynMic = new JLabel("Khuyến mãi được áp dụng:");
		lblKhuynMic.setFont(new Font("Arial", Font.BOLD, 18));
		lblKhuynMic.setBounds(43, 203, 252, 20);
		pnNorth.add(lblKhuynMic);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(313, 200, 374, 28);
		pnNorth.add(textField_5);
		
		JPanel pnNorth1 = new JPanel();
		pnNorth1.setBackground(new Color(255, 255, 255));
		pnNorth1.setBounds(20, 250, 667, 328);
		pnNorth1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Danh sách sản phẩm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),
				Color.blue));
		TitledBorder thongtin1 = (TitledBorder) pnNorth1.getBorder();
		thongtin1.setTitleColor(Color.blue);
		thongtin1.setTitleFont(font);
		pnNorth1.setLayout(null);
		pnNorth.add(pnNorth1);
		
		JPanel pnlTable = new JPanel();
		pnlTable.setLayout(null);
		pnlTable.setBackground(new Color(242, 240, 255));
		pnlTable.setBounds(0, 310, 1078, 500);
	
		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		table.setSelectionBackground(Color.pink);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(0).setMaxWidth(60);
		scroll = new JScrollPane(table);
		scroll.setBounds(13, 28, 644, 277);
		pnNorth1.add(scroll);
		
		lblNewLabel_1 = new JLabel("Tiền hàng:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(43, 630, 120, 20);
		pnNorth.add(lblNewLabel_1);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(170, 627, 188, 28);
		pnNorth.add(textField_6);
		
		lblNewLabel_2 = new JLabel("Tổng cộng:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(381, 630, 120, 20);
		pnNorth.add(lblNewLabel_2);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(511, 627, 176, 28);
		pnNorth.add(textField_7);
		
		lblNewLabel_3 = new JLabel("Giảm giá:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(43, 700, 120, 20);
		pnNorth.add(lblNewLabel_3);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(156, 695, 40, 28);
		pnNorth.add(textField_8);
		
		lblNewLabel_4 = new JLabel("%");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(203, 703, 25, 20);
		pnNorth.add(lblNewLabel_4);
		
		textField_9 = new JTextField();
		textField_9.setEnabled(false);
		textField_9.setColumns(10);
		textField_9.setBounds(249, 695, 106, 28);
		pnNorth.add(textField_9);
		
		
		comBoBoxMaSP.addActionListener(this);
		btnInHoaDon= new JButton("In hóa đơn");
		btnInHoaDon.setForeground(new Color(255, 255, 255));
		btnInHoaDon.setFont(new Font("Arial", Font.BOLD, 18));
		btnInHoaDon.setBackground(new Color(66, 160, 255));
		btnInHoaDon.setOpaque(true);
		btnInHoaDon.setBorderPainted(false);
		btnInHoaDon.setBounds(511, 690, 176, 34);
		pnNorth.add(btnInHoaDon);
		btnInHoaDon.addActionListener(this);
		
		btnXoaSP = new JButton("Xóa");
		btnXoaSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					xoa();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnXoaSP.setBackground(new Color(255, 0, 0));
		btnXoaSP.setBounds(602, 588, 85, 21);
		pnNorth.add(btnXoaSP);
		
		comBoBoxMaSP_1= new JComboBox<String>();
		comBoBoxMaSP_1.setFont(new Font("Arial", Font.PLAIN, 18));
		comBoBoxMaSP_1.setBounds(225, 86, 340, 28);
		pnNorth.add(comBoBoxMaSP_1);
		comBoBoxMaSP_1.addActionListener(this);
		try {
			updateComBoBoxMaSP();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		updateComBoBoxMaKH();
		updateHoaDon();
		
	}
	public void updateComBoBoxMaSP() throws SQLException {
		KhuyenMaiSanPham_Dao.docTubang();
		ArrayList<SanPham> list = SanPham_Dao.docTubang();
		for (int i = 0; i < list.size(); i++) {
			comBoBoxMaSP.addItem(list.get(i).getMaSP());
		}
	}
	public void updateComBoBoxMaKH() {
		KhachHang_Dao dskh = new KhachHang_Dao();
	
		List<KhachHang> list = dskh.getAllKhachHang();
		
		for (KhachHang ds : list) {
			comBoBoxMaSP_1.addItem(ds.getMaKhachHang());
			
		}
	}
	public void updateDuLieuSP() throws SQLException {
		KhuyenMaiSanPham_Dao.docTubang();
		SanPham_Dao.docTubang();
		
		Object obj = comBoBoxMaSP.getSelectedItem();
		
		if (obj == null) return;
		
		String masp = obj.toString();
		
		SanPham sp = SanPham_Dao.laySanPhamTheoMa(masp);
		
		txtMaSp.setText(masp);
		
		txtTen.setText(sp.getTenSP());
		txtLoai.setText(sp.getLoai());
		txtNgayHH.setText(sp.getNgayHetHan().toString());
		txtSLTon.setText(String.valueOf(sp.getSoluongTon()));
	
		txtDonViTinh.setText(sp.getDonViTinh());
		KhuyenMaiSanPham km = sp.getKhuyenMai();
		txtKhuyenMai.setText(km == null? "" : km.getMaKM());
		txtGia.setText(sp.getDonGiaBan().toString());
	}

	private String taoMaHoaDon() {
		// HDddmmyyxxxxxxx
        Date date = new Date(); 
        DateFormat dateFormat = new SimpleDateFormat("ddMMyy");  
        String strDate = dateFormat.format(date);
        
        int number = HoaDon_DAO.laySLHoaDonTheoNgay(strDate) + 1;
        int desiredWidth = 7; // Total width including leading zeros

        // Convert the integer to a formatted string
        String formattedString = String.format("%0" + desiredWidth + "d", number);
        
		return "HD" + strDate + formattedString;
	}
	private String thuTuHoaDonTrongNgay() {
		int sl = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
	    String currentDate = sdf.format(new Date());

		HoaDon_DAO hd_Dao=new HoaDon_DAO();
		for (HoaDon hd : hd_Dao.docTubang()) {
			if (hd.getMaHD().substring(2, 8).equals(currentDate))
				sl++;
		}
		String slString = String.format("%07d", sl + 1);
		return slString;
	}
	private String generateRandomCode() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
	    String currentDate = sdf.format(new Date());
		String ma="HD";
		
		ma+=currentDate;
		
		return ma + thuTuHoaDonTrongNgay();
	}
	private void loadMa() {
		String code;
		code = generateRandomCode();
		textField.setText(code);
	}
	
	public void updateHoaDon() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String currentDate = sdf.format(new Date());


	loadMa();
	String code;
	code = generateRandomCode();


	textField_1.setText(currentDate);
	NhanVien_Dao.getAllNhanVien();
	NhanVien nv = NhanVien_Dao.getNhanVienTheoMa(DataManager.getUserName());
	
	
	textField_3.setText(nv.getMaNV());
	textField_4.setText("Hóa Đơn Bán");
	
	
	KhuyenMaiHoaDon_Dao dsKMHD = new KhuyenMaiHoaDon_Dao();
	String text = textField_6.getText();
	Double tienHang = 0.0;
	if(!text.isEmpty()) {
	    tienHang = Double.parseDouble(text);
	}
	List<KhuyenMaiHoaDon> list = dsKMHD.docTubang();

	// Khởi tạo giá trị khuyến mãi lớn nhất và khuyến mãi tương ứng
	double maxDiscount = 0;
	KhuyenMaiHoaDon maxDiscountPromotion = null;

	for (KhuyenMaiHoaDon ds : list) {
	    if(ds.getTrangThai().equals(true)) {
	        if(tienHang >= ds.getGiaTriHoaDon() && ds.getGiamGiaHoaDon() > maxDiscount) {
	            maxDiscount = ds.getGiamGiaHoaDon();
	            maxDiscountPromotion = ds;
	        }
	    } 
	}

	
	if(maxDiscountPromotion != null) {
	    // maxDiscountPromotion là đối tượng KhuyenMaiHoaDon có giá trị giảm giá lớn nhất
	    // Bạn có thể sử dụng nó ở đây
		
		textField_5.setText(maxDiscountPromotion.getMaKM());
		textField_8.setText(String.valueOf(maxDiscountPromotion.getGiamGiaHoaDon()));
	}
	else {
		
		textField_5.setText("");
		textField_8.setText(String.valueOf(0.0));
	}
	
	Date ngay=java.sql.Date.valueOf(currentDate);
	KhachHang kh=kh_dao.getKhachHangTheoMa(maKh);
}
	public void updateTienHang() {
	    double tongTienHang = 0.0;
	    for (int i = 0; i < table.getRowCount(); i++) {
	        String donGiaStr = table.getValueAt(i, 5).toString();
	        if (donGiaStr.matches("-?\\d+(\\.\\d+)?")) {  // kiểm tra xem chuỗi có phải là số không
	            double donGia = Double.parseDouble(donGiaStr);
	            tongTienHang += donGia;
	        }
	    }
	    textField_6.setText(String.valueOf(tongTienHang));

	    String tienGiamStr = textField_8.getText();
	    if (tienGiamStr.matches("-?\\d+(\\.\\d+)?")) {  // kiểm tra xem chuỗi có phải là số không
	    	Double tienGiam = tongTienHang * Double.parseDouble(tienGiamStr);
	    	String tienGiamFormatted = String.format("%.2f", tienGiam);
	    	textField_9.setText(tienGiamFormatted);

	        Double tongTien = tongTienHang - tienGiam;
	        textField_7.setText(String.valueOf(tongTien));
	    } else {
	        JOptionPane.showMessageDialog(this, "Giá trị trong textField_8 không phải là số hợp lệ");
	    }

	}

	public void xoa() throws SQLException {
	    SanPham_Dao sp_dao=new SanPham_Dao();    
	    if (table.getSelectedRow() == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa!!");
	    } else if (table.getSelectedRowCount() > 1) {
	        JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 nhân viên để xóa!!");
	    } else {
	        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Thông báo",
	                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	            int row = table.getSelectedRow();
	            int s=Integer.parseInt(txtSLTon.getText())+ Integer.parseInt(model.getValueAt(row, 4).toString()); 
	            sp_dao.updateSoLuongTonTheoMa(model.getValueAt(row, 1).toString(), s);
	            updateDuLieuSP();
	            chiTiecHoaDon_dao.deleteChiTiecHoaDon(model.getValueAt(row, 1).toString()) ;
	            model.removeRow(row);
	            JOptionPane.showMessageDialog(this, "Xóa thành công!!");
	            KhuyenMaiHoaDon_Dao dsKMHD = new KhuyenMaiHoaDon_Dao();
	        	String text = textField_6.getText();
	        	double tienHang = 0.0;
				for (int i = 0; i < table.getRowCount(); i++) {
				    double donGia = Double.parseDouble(table.getValueAt(i, 5).toString());
				    tienHang += donGia;
				}
	        	List<KhuyenMaiHoaDon> list = dsKMHD.docTubang();

	        	// Khởi tạo giá trị khuyến mãi lớn nhất và khuyến mãi tương ứng
	        	double maxDiscount = 0;
	        	KhuyenMaiHoaDon maxDiscountPromotion = null;

	        	for (KhuyenMaiHoaDon ds : list) {
	        	    if(ds.getTrangThai().equals(true)) {
	        	        if(tienHang >= ds.getGiaTriHoaDon() && ds.getGiamGiaHoaDon() > maxDiscount) {
	        	            maxDiscount = ds.getGiamGiaHoaDon();
	        	            maxDiscountPromotion = ds;
	        	        }
	        	    } 
	        	}

	        	
	        	if(maxDiscountPromotion != null) {
	        	    // maxDiscountPromotion là đối tượng KhuyenMaiHoaDon có giá trị giảm giá lớn nhất
	        	    // Bạn có thể sử dụng nó ở đây
	        		
	        		textField_5.setText(maxDiscountPromotion.getMaKM());
	        		textField_8.setText(String.valueOf(maxDiscountPromotion.getGiamGiaHoaDon()));
	        	}
	        	else {
	        	
	        		textField_5.setText("");
	        		textField_8.setText(String.valueOf(0.0));
	        	}
	        	
	            updateTienHang();
	            q--;
	            // Giảm giá trị của phần tử ở vị trí thứ 0 trong bảng
	            if (model.getRowCount() > 0) {
	                int firstElementValue = Integer.parseInt(model.getValueAt(0, 0).toString());
	                model.setValueAt(firstElementValue - 1, 0, 0);
	              
	            } else {
	                model.setValueAt(0, 0, 0);
	                q = 0;
	            }
	        }
	    }
	}

	private void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(comBoBoxMaSP)) {
			try {
				updateDuLieuSP();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(o.equals(btnThemSPVaoHD)) {
				
				q++;
				String ma =comBoBoxMaSP.getSelectedItem().toString();
				String ten=txtTen.getText();
				String dvt=txtDonViTinh.getText();
				int soLuong=Integer.parseInt(txtSoLuong.getText());	
				SanPham sp = SanPham_Dao.laySanPhamTheoMa(ma);
				int soLuong11=Integer.parseInt(txtSoLuong.getText());
				SanPham_Dao sp_dao=new SanPham_Dao();		
				SanPham sp1=sp_dao.getSanPhamTheoMa(ma);
				ChiTietHoaDon cthd1=new ChiTietHoaDon(new HoaDon(textField.getText()), sp1, soLuong11);
				
				if( Integer.parseInt(txtSLTon.getText())>=soLuong){
				Object[] row = { q, ma,ten,dvt,soLuong11,cthd1.getThanhTien()};
				model.addRow(row);
				
				KhuyenMaiHoaDon_Dao dsKMHD = new KhuyenMaiHoaDon_Dao();
				String text = textField_6.getText();
				double tongTienHang = 0.0;
				for (int i = 0; i < table.getRowCount(); i++) {
				    double donGia = Double.parseDouble(table.getValueAt(i, 5).toString());
				    tongTienHang += donGia;
				}
				List<KhuyenMaiHoaDon> list = dsKMHD.docTubang();

				// Khởi tạo giá trị khuyến mãi lớn nhất và khuyến mãi tương ứng
				double maxDiscount = 0.0;
				KhuyenMaiHoaDon maxDiscountPromotion = null;
			
				for (KhuyenMaiHoaDon ds : list) {
				    if(ds.getTrangThai().equals(true)) {
				        if(tongTienHang >= ds.getGiaTriHoaDon() && ds.getGiamGiaHoaDon() > maxDiscount) {
				            maxDiscount = ds.getGiamGiaHoaDon();
				            maxDiscountPromotion = ds;
				        }
				    } 
				}

				if(maxDiscountPromotion != null) {
				    // maxDiscountPromotion là đối tượng KhuyenMaiHoaDon có giá trị giảm giá lớn nhất
				    // Bạn có thể sử dụng nó ở đây
				
					textField_5.setText(maxDiscountPromotion.getMaKM());
					textField_8.setText(String.valueOf(maxDiscountPromotion.getGiamGiaHoaDon()));
				}

				else {
					textField_5.setText("");
					textField_8.setText(String.valueOf(0.0));
				}
				
				updateTienHang();
				JOptionPane.showMessageDialog(this, textField_9.getText());
				int s=Integer.parseInt(txtSLTon.getText())- Integer.parseInt(txtSoLuong.getText()); 
				txtSoLuong.setText("");
				sp_dao.updateSoLuongTonTheoMa(ma, s);
				

				try {
					updateDuLieuSP();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}else {
					JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không đủ");
				}
				
			
		}else if(o.equals(comBoBoxMaSP_1)){
			maKh=comBoBoxMaSP_1.getSelectedItem().toString();
		}else if(o.equals(btnInHoaDon)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    String currentDate = sdf.format(new Date());
			
			String code;
			code = textField.getText();

			
			NhanVien_Dao nv_dao=new NhanVien_Dao();
			NhanVien nv = null;
			nv = nv_dao.getNhanVienTheoMa(DataManager.getUserName());
		
			KhuyenMaiHoaDon_Dao dsKMHD = new KhuyenMaiHoaDon_Dao();
			String text = textField_6.getText();
			Double tienHang = 0.0;
			if(!text.isEmpty()) {
			    tienHang = Double.parseDouble(text);
			}
			List<KhuyenMaiHoaDon> list = dsKMHD.docTubang();
			
			Date ngay=java.sql.Date.valueOf(currentDate);
			KhachHang kh=kh_dao.getKhachHangTheoMa(maKh);
			// Khởi tạo giá trị khuyến mãi lớn nhất và khuyến mãi tương ứng
			double maxDiscount = 0;
			KhuyenMaiHoaDon maxDiscountPromotion = null;

			for (KhuyenMaiHoaDon ds : list) {
			    if(ds.getTrangThai().equals(true)) {
			        if(tienHang >= ds.getGiaTriHoaDon() && ds.getGiamGiaHoaDon() > maxDiscount) {
			            maxDiscount = ds.getGiamGiaHoaDon();
			            maxDiscountPromotion = ds;
			        }
			    } 
			}

			HoaDon hd;
			if(maxDiscountPromotion != null) {
			    // maxDiscountPromotion là đối tượng KhuyenMaiHoaDon có giá trị giảm giá lớn nhất
			    // Bạn có thể sử dụng nó ở đây\
				hd=new HoaDon(code,kh, nv, ngay, "Hóa Đơn Bán", "không có gì", null);
			}else {
				hd=new HoaDon(code,kh, nv, ngay, "Hóa Đơn Bán", "không có gì", maxDiscountPromotion);
			}
		
		
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn in hóa đơn không", "Thông báo",
	                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if(hd_dao.addHoaDon(hd)) {
				JOptionPane.showMessageDialog(this, "In hóa đơn thành công");
				SanPham_Dao sp_dao=new SanPham_Dao();		
				HoaDon hD= hd_dao.getHDTheoMa(code);
				// Giả sử 'table' là đối tượng JTable của bạn và 'model' là model của table
				for (int i = 0; i < table.getRowCount(); i++) {
				    // Lấy dữ liệu từ mỗi cột của dòng hiện tại
				    SanPham sp =sp_dao.getSanPhamTheoMa(model.getValueAt(i, 1).toString()) ; // Thay đổi chỉ số cột nếu cần
				    int soLuong = Integer.parseInt(model.getValueAt(i, 4).toString()); // Thay đổi chỉ số cột nếu cần

				    // Tạo đối tượng chiTiecHoaDon mới và thêm vào cơ sở dữ liệu
				    ChiTietHoaDon cthd = new ChiTietHoaDon(hD, sp, soLuong);
				    chiTiecHoaDon_dao.addChiTiecHoaDon(cthd);
				}

				loadMa();
				updateHoaDon();
				try {
					updateDuLieuSP();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				clearTable();
				q=0;
			}
			else {
				JOptionPane.showMessageDialog(this,"In hóa đơn không thành công");
			}}
		}
	}
}
