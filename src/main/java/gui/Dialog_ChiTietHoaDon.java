package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.SanPham_Dao;
import entity.ChiTietHoaDon;
import entity.HoaDon;

public class Dialog_ChiTietHoaDon extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtThanhTien;
	private JTextField txtNgayMua;
	private JTextField txtSDT;
	private JTextField txtGioiTinh;
	private JTextField txtHoTen;
	private JTextField txtMaKH;
	private JTextField txtMaKM;
	private JTextField txtMaNV;
	private JTextField txtHoaDon;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_ChiTietHoaDon dialog = new Dialog_ChiTietHoaDon(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_ChiTietHoaDon(HoaDon currentHoaDon) {
		setBounds(100, 100, 576, 715);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 541, 628);
		panel_1.setBorder(BorderFactory.createTitledBorder("Hóa đơn đã bán hàng"));
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(null);
		
		String cols[] = { "MaSP", "TenSP", "SL", "Gia" };
		model = new DefaultTableModel(cols, 0);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 24, 521, 176);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(0, 0, 521, 176);
		panel_2.add(scrollpane);
		panel_2.setBackground(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 210, 521, 408);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 10, 488, 40);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(null);
		
		myJLabel lblNewLabel_1 = new myJLabel("Mã hóa đơn:");
		lblNewLabel_1.setBounds(5, 10, 146, 19);
		panel_5.add(lblNewLabel_1);
		
		txtHoaDon = new JTextField();
		txtHoaDon.setBackground(Color.WHITE);
		txtHoaDon.setBounds(170, 10, 288, 20);
		panel_5.add(txtHoaDon);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(null);
		panel_5_1.setLayout(null);
		panel_5_1.setBounds(10, 48, 488, 40);
		panel_3.add(panel_5_1);
		
		myJLabel lblNewLabel_1_1 = new myJLabel("Mã nhân viên:");
		lblNewLabel_1_1.setBounds(5, 10, 146, 19);
		panel_5_1.add(lblNewLabel_1_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setBackground(Color.WHITE);
		txtMaNV.setBounds(170, 10, 288, 20);
		panel_5_1.add(txtMaNV);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBackground(null);
		panel_5_2.setLayout(null);
		panel_5_2.setBounds(10, 88, 488, 40);
		panel_3.add(panel_5_2);
		
		myJLabel lblNewLabel_1_2 = new myJLabel("Mã KM:");
		lblNewLabel_1_2.setBounds(5, 10, 146, 19);
		panel_5_2.add(lblNewLabel_1_2);
		
		txtMaKM = new JTextField();
		txtMaKM.setBackground(Color.WHITE);
		txtMaKM.setBounds(170, 10, 288, 20);
		panel_5_2.add(txtMaKM);
		
		JPanel panel_5_3 = new JPanel();
		panel_5_3.setBackground(null);
		panel_5_3.setLayout(null);
		panel_5_3.setBounds(10, 128, 488, 40);
		panel_3.add(panel_5_3);
		
		myJLabel lblNewLabel_1_3 = new myJLabel("Mã KH:");
		lblNewLabel_1_3.setBounds(5, 10, 146, 19);
		panel_5_3.add(lblNewLabel_1_3);
		
		txtMaKH = new JTextField();
		txtMaKH.setBackground(Color.WHITE);
		txtMaKH.setBounds(170, 10, 288, 20);
		panel_5_3.add(txtMaKH);
		
		JPanel panel_5_4 = new JPanel();
		panel_5_4.setBackground(null);
		panel_5_4.setLayout(null);
		panel_5_4.setBounds(10, 167, 488, 40);
		panel_3.add(panel_5_4);
		
		myJLabel lblNewLabel_1_4 = new myJLabel("Họ và tên:");
		lblNewLabel_1_4.setBounds(5, 10, 146, 19);
		panel_5_4.add(lblNewLabel_1_4);
		
		txtHoTen = new JTextField();
		txtHoTen.setBackground(Color.WHITE);
		txtHoTen.setBounds(170, 10, 288, 20);
		panel_5_4.add(txtHoTen);
		
		JPanel panel_5_5 = new JPanel();
		panel_5_5.setBackground(null);
		panel_5_5.setLayout(null);
		panel_5_5.setBounds(10, 207, 488, 40);
		panel_3.add(panel_5_5);
		
		myJLabel lblNewLabel_1_5 = new myJLabel("Giới tính:");
		lblNewLabel_1_5.setBounds(5, 10, 146, 19);
		panel_5_5.add(lblNewLabel_1_5);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setBackground(Color.WHITE);
		txtGioiTinh.setBounds(170, 10, 288, 20);
		panel_5_5.add(txtGioiTinh);
		
		JPanel panel_5_6 = new JPanel();
		panel_5_6.setBackground(null);
		panel_5_6.setLayout(null);
		panel_5_6.setBounds(10, 247, 488, 40);
		panel_3.add(panel_5_6);
		
		myJLabel lblNewLabel_1_6 = new myJLabel("Số điện thoại:");
		lblNewLabel_1_6.setBounds(5, 10, 146, 19);
		panel_5_6.add(lblNewLabel_1_6);
		
		txtSDT = new JTextField();
		txtSDT.setBackground(Color.WHITE);
		txtSDT.setBounds(170, 10, 288, 20);
		panel_5_6.add(txtSDT);
		
		JPanel panel_5_7 = new JPanel();
		panel_5_7.setBackground(null);
		panel_5_7.setLayout(null);
		panel_5_7.setBounds(10, 285, 488, 40);
		panel_3.add(panel_5_7);
		
		myJLabel lblNewLabel_1_7 = new myJLabel("Ngày mua:");
		lblNewLabel_1_7.setBounds(5, 10, 146, 19);
		panel_5_7.add(lblNewLabel_1_7);
		
		txtNgayMua = new JTextField();
		txtNgayMua.setBackground(Color.WHITE);
		txtNgayMua.setBounds(170, 10, 288, 20);
		panel_5_7.add(txtNgayMua);
		
		JPanel panel_5_8 = new JPanel();
		panel_5_8.setBackground(null);
		panel_5_8.setLayout(null);
		panel_5_8.setBounds(10, 325, 488, 40);
		panel_3.add(panel_5_8);
		
		myJLabel lblNewLabel_1_8 = new myJLabel("Thành tiền:");
		lblNewLabel_1_8.setBounds(5, 10, 146, 19);
		panel_5_8.add(lblNewLabel_1_8);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setBackground(Color.WHITE);
		txtThanhTien.setBounds(170, 10, 288, 20);
		panel_5_8.add(txtThanhTien);
		
		if (currentHoaDon == null) return; 
		{
			HoaDon_DAO.docTubang();
			SanPham_Dao.docTubang();
			ChiTietHoaDon_DAO.docTubang();
			model.getDataVector().removeAllElements();
			
			HoaDon hd = HoaDon_DAO.layHoaDonTheoMa(currentHoaDon.getMaHD());
			ArrayList<ChiTietHoaDon> lst = ChiTietHoaDon_DAO.layChiTietHoaDonTheoMaHD(currentHoaDon.getMaHD());

			if (hd == null) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn");
				return;
			}
			
			currentHoaDon = hd;

			for (int i = 0; i < lst.size(); i++) {
				ChiTietHoaDon cthd = lst.get(i);
				model.addRow(
						new Object[] {
								//i+1,
								cthd.getSanPham().getMaSP(),
								cthd.getSanPham().getTenSP(),
								cthd.getSoLuong(),
								cthd.getThanhTien()
						}
					);
			}

			double tien = 0;
			ArrayList<ChiTietHoaDon> cthd_list = ChiTietHoaDon_DAO.layChiTietHoaDonTheoMaHD(hd.getMaHD());
			for (ChiTietHoaDon _e : cthd_list) {
				tien += _e.getThanhTien();
			}

			txtHoaDon.setText(hd.getMaHD());
			txtMaNV.setText(hd.getNhanVien().getMaNV());
			txtMaKM.setText(hd.getKhuyenMai().getMaKM());
			txtMaKH.setText(hd.getKhachHang().getMaKhachHang());
			txtHoTen.setText(hd.getKhachHang().getTenKhachHang());
			txtGioiTinh.setText(hd.getKhachHang().isGioiTinh()? "Nam" : "Nữ");
			txtSDT.setText(hd.getKhachHang().getSoDienThoai());
			txtNgayMua.setText(hd.getNgayXuat().toString());
			txtThanhTien.setText(String.valueOf(tien));
		}
	}

}
