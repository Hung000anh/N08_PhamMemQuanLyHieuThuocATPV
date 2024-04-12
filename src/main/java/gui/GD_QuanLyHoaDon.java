package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
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

import dao.HoaDon_DAO;
import entity.HoaDon;

import javax.swing.JTextArea;

public class GD_QuanLyHoaDon extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textMaNV;
	private JTextField textMaHD;
	private JTextField textMaKH;
	private JTextField textLoai;
	private JTextField textNgayXuatHD;
	private DefaultTableModel model;
	private JTable table;
	private String col[] = { "STT", "Mã hóa đơn", "Mã sản phẩm", "Mã khách hàng", "Loại hóa đơn", "Ngày xuất HD", "Khuyến mãi", "Tổng tiền", "Ghi chú"};
	private JScrollPane scroll;
	private JTextField textKhuyenMai;
	private JTextField textTongTien;
	private JTextField textTuKhoa;

	private HoaDon_DAO hd_dao = new HoaDon_DAO();

	private ArrayList<HoaDon> list;
	private JButton btnTim;

	/**
	 * Create the panel.
	 */
	public GD_QuanLyHoaDon() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140, 865);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1140, 60);
		panel.setBackground(new Color(187, 231, 252));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(0, 0, 1140, 60);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		// ----- Thông tin hóa đơn ----- //
		JPanel tt_Hoadon = new JPanel();
		tt_Hoadon.setBackground(SystemColor.window);
		tt_Hoadon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Thông tin nhân viên", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		tt_Hoadon.setBounds(10, 70, 850, 290);
		add(tt_Hoadon);
		tt_Hoadon.setLayout(null);
		
		JLabel maNV = new JLabel("Mã nhân viên:");
		maNV.setFont(new Font("Arial", Font.BOLD, 16));
		maNV.setBounds(30, 92, 145, 30);
		tt_Hoadon.add(maNV);
		
		textMaNV = new JTextField();
		textMaNV.setEnabled(false);
		textMaNV.setColumns(10);
		textMaNV.setBounds(185, 92, 220, 35);
		tt_Hoadon.add(textMaNV);
		
		JLabel maHD = new JLabel("Mã hóa đơn:");
		maHD.setFont(new Font("Arial", Font.BOLD, 16));
		maHD.setBounds(30, 44, 145, 30);
		tt_Hoadon.add(maHD);
		
		textMaHD = new JTextField();
		textMaHD.setEnabled(false);
		textMaHD.setColumns(10);
		textMaHD.setBounds(185, 44, 220, 35);
		tt_Hoadon.add(textMaHD);
		
		JLabel maKH = new JLabel("Mã khách hàng:");
		maKH.setFont(new Font("Arial", Font.BOLD, 16));
		maKH.setBounds(30, 138, 145, 30);
		tt_Hoadon.add(maKH);
		
		textMaKH = new JTextField();
		textMaKH.setEnabled(false);
		textMaKH.setColumns(10);
		textMaKH.setBounds(185, 138, 220, 35);
		tt_Hoadon.add(textMaKH);
		
		JLabel loai = new JLabel("Loại hóa đơn:");
		loai.setFont(new Font("Arial", Font.BOLD, 16));
		loai.setBounds(28, 183, 145, 30);
		tt_Hoadon.add(loai);
		
		textLoai = new JTextField();
		textLoai.setEnabled(false);
		textLoai.setColumns(10);
		textLoai.setBounds(185, 183, 220, 35);
		tt_Hoadon.add(textLoai);
		
		JLabel ngayXuat = new JLabel("Ngày xuất HD:");
		ngayXuat.setFont(new Font("Arial", Font.BOLD, 16));
		ngayXuat.setBounds(28, 231, 145, 30);
		tt_Hoadon.add(ngayXuat);

		textNgayXuatHD = new JTextField();
		textNgayXuatHD.setEnabled(false);
		textNgayXuatHD.setColumns(10);
		textNgayXuatHD.setBounds(185, 231, 220, 35);
		tt_Hoadon.add(textNgayXuatHD);
		
		JLabel khuyenMai = new JLabel("Khuyến mãi:");
		khuyenMai.setFont(new Font("Arial", Font.BOLD, 16));
		khuyenMai.setBounds(468, 47, 145, 30);
		tt_Hoadon.add(khuyenMai);
		
		textKhuyenMai = new JTextField();
		textKhuyenMai.setEnabled(false);
		textKhuyenMai.setColumns(10);
		textKhuyenMai.setBounds(605, 44, 220, 35);
		tt_Hoadon.add(textKhuyenMai);
		
		JLabel tongTien = new JLabel("Tổng tiền:");
		tongTien.setFont(new Font("Arial", Font.BOLD, 16));
		tongTien.setBounds(468, 92, 145, 30);
		tt_Hoadon.add(tongTien);
		
		textTongTien = new JTextField();
		textTongTien.setEnabled(false);
		textTongTien.setColumns(10);
		textTongTien.setBounds(605, 92, 220, 35);
		tt_Hoadon.add(textTongTien);
		
		JLabel ghiChu = new JLabel("Ghi chú:");
		ghiChu.setFont(new Font("Arial", Font.BOLD, 16));
		ghiChu.setBounds(468, 138, 120, 30);
		tt_Hoadon.add(ghiChu);
		
		JTextArea textGhiChu = new JTextArea();
		textGhiChu.setEnabled(false);
		textGhiChu.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		textGhiChu.setBounds(605, 144, 220, 122);
		tt_Hoadon.add(textGhiChu);
		
		// ----- Chức năng ----- //
		JPanel traCuu = new JPanel();
		traCuu.setLayout(null);
		traCuu.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Tìm kiếm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		traCuu.setBackground(SystemColor.window);
		traCuu.setBounds(870, 70, 260, 290);
		add(traCuu);
		
		JComboBox comboBoxTim = new JComboBox();
		comboBoxTim.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã"}));
		comboBoxTim.setFont(new Font("Arial", Font.BOLD, 16));
		comboBoxTim.setBounds(30, 46, 200, 35);
		traCuu.add(comboBoxTim);
		
		JLabel tuKhoa = new JLabel("Nhập từ khóa");
		tuKhoa.setHorizontalAlignment(SwingConstants.CENTER);
		tuKhoa.setFont(new Font("Arial", Font.BOLD, 16));
		tuKhoa.setBounds(10, 91, 240, 30);
		traCuu.add(tuKhoa);
		
		textTuKhoa = new JTextField();
		textTuKhoa.setColumns(10);
		textTuKhoa.setBounds(30, 131, 200, 35);
		traCuu.add(textTuKhoa);
		
		btnTim = new JButton("Tìm");
		btnTim.setToolTipText("");
		btnTim.setFont(new Font("Arial", Font.BOLD, 16));
		btnTim.setBorderPainted(false);
		btnTim.setBackground(new Color(74, 131, 215));
		btnTim.setBounds(30, 176, 200, 40);
		traCuu.add(btnTim);
		btnTim.addActionListener(this);
		
		JButton btnXemChiTiet = new JButton("Chi Tiết Hóa Đơn");
		btnXemChiTiet.setFont(new Font("Arial", Font.BOLD, 16));
		btnXemChiTiet.setBorderPainted(false);
		btnXemChiTiet.setBackground(new Color(38, 191, 191));
		btnXemChiTiet.setBounds(30, 226, 200, 40);
		traCuu.add(btnXemChiTiet);
		
		// ----- Table ----- //
		JLabel danhSach = new JLabel("Danh sách hóa đơn");
		danhSach.setHorizontalAlignment(SwingConstants.CENTER);
		danhSach.setFont(new Font("Arial", Font.BOLD, 20));
		danhSach.setBounds(10, 370, 1120, 60);
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
		scroll.setBounds(10, 440, 1120, 405);
		add(scroll);
		
		list = hd_dao.docTubang();

		for (int i = 0; i < list.size(); i++) {
			HoaDon hd = list.get(i);
			// "STT", "Mã hóa đơn", "Mã sản phẩm", "Mã khách hàng", "Loại hóa đơn", "Ngày xuất HD", "Khuyến mãi", "Tổng tiền", "Ghi chú"

			model.addRow(new Object[] {
					i+1,
					hd.getMaHD(),
					"?", // chưa biết
					hd.getKhachHang().getMaKhachHang(),
					hd.getMaHD(),
					hd.getNgayXuat(),
					hd.getKhuyenMai().getMaKM(),
					"?", // chưa biết
					hd.getGhiChu()
			});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnTim) {
			String tukhoa = textTuKhoa.getText().trim();
			HoaDon hd = null;
			for (HoaDon s : list) {
				if (s.getMaHD().equals(tukhoa)) {
					hd = s;
					break;
				}
			}
			if (hd == null) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
				return;
			}
			
			textMaHD.setText(hd.getMaHD());
			textMaKH.setText(hd.getKhachHang().getMaKhachHang());
			textKhuyenMai.setText(hd.getKhuyenMai().getMaKM());
			textMaNV.setText(hd.getNhanVien().getMaNV());
			textLoai.setText(hd.getLoaiHD());
			textNgayXuatHD.setText(hd.getNgayXuat().toString());
		}
	}
}
