package gui;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class GD_BanSanPham extends JPanel {

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
	private JTextField textField_2;
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
	/**
	 * Create the panel.
	 */
	public GD_BanSanPham() {
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

		pnTTSP.add(openButton = new JButton("Chọn tệp"));
		openButton.setBounds(219, 95, 87, 20);
		pnTTSP.add(imageLabel = new JLabel());
		imageLabel.setBounds(189, 46, 150, 115);

		JLabel lblMaSP = new JLabel("Mã sản phẩm:");
		lblMaSP.setBounds(7, 135, 150, 100);
		lblMaSP.setFont(font2);
		pnTTSP.add(lblMaSP);

		txtMaSp = new JTextField();
		pnTTSP.add(txtMaSp);
		txtMaSp.setEnabled(false);
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
		
		lblMKhchHngc = new JLabel("Mã Khách hàng(có thể để trống):");
		lblMKhchHngc.setFont(new Font("Arial", Font.BOLD, 18));
		lblMKhchHngc.setBounds(43, 94, 292, 20);
		pnNorth.add(lblMKhchHngc);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(342, 90, 345, 28);
		pnNorth.add(textField_2);
		
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
		
		lblNewLabel_1 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(43, 615, 120, 20);
		pnNorth.add(lblNewLabel_1);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(170, 612, 188, 28);
		pnNorth.add(textField_6);
		
		lblNewLabel_2 = new JLabel("Mã hóa đơn:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(381, 615, 120, 20);
		pnNorth.add(lblNewLabel_2);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(511, 612, 176, 28);
		pnNorth.add(textField_7);
		
		lblNewLabel_3 = new JLabel("Giảm giá:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(43, 690, 120, 20);
		pnNorth.add(lblNewLabel_3);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(156, 685, 40, 28);
		pnNorth.add(textField_8);
		
		lblNewLabel_4 = new JLabel("%");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(203, 693, 25, 20);
		pnNorth.add(lblNewLabel_4);
		
		textField_9 = new JTextField();
		textField_9.setEnabled(false);
		textField_9.setColumns(10);
		textField_9.setBounds(249, 685, 106, 28);
		pnNorth.add(textField_9);
		
		JButton btnNewButton = new JButton("In hóa đơn");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(66, 160, 255));
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(511, 683, 176, 34);
		pnNorth.add(btnNewButton);
		
	}
}
