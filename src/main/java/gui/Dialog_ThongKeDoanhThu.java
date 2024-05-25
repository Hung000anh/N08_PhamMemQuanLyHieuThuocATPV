package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JTextField;

import dao.ThongKe_Dao;
import entity.HoaDon;
import entity.SanPham;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Dialog_ThongKeDoanhThu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ThongKe_Dao tk_dao = new ThongKe_Dao();
	private JTextField txtNgayBatDau;
	private JTextField txtNgayKetThuc;
	private JButton btnKQ;
	private String col[] = { "STT", "Mã hóa đơn", "Mã khách hàng", "Loại hóa đơn", "Ngày xuất HD", "Khuyến mãi", "Ghi chú" };
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private JComboBox LoaiTG;
	private JLabel txtDTThuoc;
	private JLabel txtDTTPCN;
	private JLabel txtDTDCYT;
	private JLabel txtSL_HD_B;
	private JLabel txtSL_HD_T;
	private JLabel txtTongDT;
	private JLabel ngayKetThuc;
	private JLabel ngayBatDau;

	/**
	 * Create the panel.
	 */
	public Dialog_ThongKeDoanhThu() {
		setLayout(null);
		setBounds(0, 0, 1140, 725);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1140, 120);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel loaiTG = new JLabel("Loại thời gian:");
		loaiTG.setFont(new Font("Arial", Font.BOLD, 16));
		loaiTG.setBounds(10, 10, 130, 30);
		panel_1.add(loaiTG);

		LoaiTG = new JComboBox();
		LoaiTG.setModel(new DefaultComboBoxModel(new String[] {"Theo khoảng thời gian", "Theo ngày", "Theo tháng", "Theo năm" }));
		LoaiTG.setFont(new Font("Arial", Font.BOLD, 12));
		LoaiTG.setBounds(150, 10, 190, 30);
		LoaiTG.addActionListener(this);
		panel_1.add(LoaiTG);

		ngayBatDau = new JLabel("Ngày bắt đầu:");
		ngayBatDau.setFont(new Font("Arial", Font.BOLD, 16));
		ngayBatDau.setBounds(10, 80, 130, 30);
		panel_1.add(ngayBatDau);

		txtNgayBatDau = new JTextField();
		txtNgayBatDau.setBounds(150, 80, 190, 30);
		panel_1.add(txtNgayBatDau);
		txtNgayBatDau.setColumns(10);

		ngayKetThuc = new JLabel("Ngày kết thúc:");
		ngayKetThuc.setFont(new Font("Arial", Font.BOLD, 16));
		ngayKetThuc.setBounds(403, 80, 130, 30);
		panel_1.add(ngayKetThuc);

		txtNgayKetThuc = new JTextField();
		txtNgayKetThuc.setColumns(10);
		txtNgayKetThuc.setBounds(543, 80, 190, 30);
		panel_1.add(txtNgayKetThuc);

		btnKQ = new JButton("Xem kết quả");
		btnKQ.setBounds(800, 80, 330, 30);
		panel_1.add(btnKQ);
		btnKQ.setBackground(SystemColor.textHighlight);
		btnKQ.setFont(new Font("Arial", Font.BOLD, 16));
		btnKQ.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#74a2d6"));
		panel.setBounds(50, 150, 300, 110);
		add(panel);
		panel.setLayout(null);

		JLabel thuoc = new JLabel("Doanh thu thuốc");
		thuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		thuoc.setForeground(Color.DARK_GRAY);
		thuoc.setFont(new Font("Arial", Font.BOLD, 16));
		thuoc.setBounds(10, 69, 280, 30);
		panel.add(thuoc);

		txtDTThuoc = new JLabel("Null");
		txtDTThuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDTThuoc.setBounds(10, 10, 280, 50);
		panel.add(txtDTThuoc);
		txtDTThuoc.setForeground(Color.BLACK);
		txtDTThuoc.setFont(new Font("Arial", Font.BOLD, 26));

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.decode("#74a2d6"));
		panel_2.setBounds(420, 150, 300, 110);
		add(panel_2);

		JLabel tpcn = new JLabel("Doanh thu thực phẩm chức năng");
		tpcn.setHorizontalAlignment(SwingConstants.RIGHT);
		tpcn.setForeground(Color.DARK_GRAY);
		tpcn.setFont(new Font("Arial", Font.BOLD, 16));
		tpcn.setBounds(10, 69, 280, 30);
		panel_2.add(tpcn);

		txtDTTPCN = new JLabel("Null");
		txtDTTPCN.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDTTPCN.setForeground(Color.BLACK);
		txtDTTPCN.setFont(new Font("Arial", Font.BOLD, 26));
		txtDTTPCN.setBounds(10, 10, 280, 50);
		panel_2.add(txtDTTPCN);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.decode("#74a2d6"));
		panel_3.setBounds(790, 150, 300, 110);
		add(panel_3);

		JLabel dcyt = new JLabel("Doanh thu dụng cụ y tế");
		dcyt.setHorizontalAlignment(SwingConstants.RIGHT);
		dcyt.setForeground(Color.DARK_GRAY);
		dcyt.setFont(new Font("Arial", Font.BOLD, 16));
		dcyt.setBounds(10, 69, 280, 30);
		panel_3.add(dcyt);

		txtDTDCYT = new JLabel("Null");
		txtDTDCYT.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDTDCYT.setForeground(Color.BLACK);
		txtDTDCYT.setFont(new Font("Arial", Font.BOLD, 26));
		txtDTDCYT.setBounds(10, 10, 280, 50);
		panel_3.add(txtDTDCYT);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.decode("#44cad5"));
		panel_4.setBounds(50, 280, 300, 110);
		add(panel_4);

		JLabel lblSLngHa = new JLabel("Số lượng hóa đơn bán hàng");
		lblSLngHa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSLngHa.setForeground(Color.DARK_GRAY);
		lblSLngHa.setFont(new Font("Arial", Font.BOLD, 16));
		lblSLngHa.setBounds(10, 69, 280, 30);
		panel_4.add(lblSLngHa);

		txtSL_HD_B = new JLabel("Null");
		txtSL_HD_B.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSL_HD_B.setForeground(Color.BLACK);
		txtSL_HD_B.setFont(new Font("Arial", Font.BOLD, 26));
		txtSL_HD_B.setBounds(10, 10, 280, 50);
		panel_4.add(txtSL_HD_B);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.decode("#e59399"));
		panel_5.setBounds(420, 280, 300, 110);
		add(panel_5);

		JLabel lblSLHDT = new JLabel("Số lượng hóa đơn trả hàng");
		lblSLHDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSLHDT.setForeground(Color.DARK_GRAY);
		lblSLHDT.setFont(new Font("Arial", Font.BOLD, 16));
		lblSLHDT.setBounds(10, 69, 280, 30);
		panel_5.add(lblSLHDT);

		txtSL_HD_T = new JLabel("Null");
		txtSL_HD_T.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSL_HD_T.setForeground(Color.BLACK);
		txtSL_HD_T.setFont(new Font("Arial", Font.BOLD, 26));
		txtSL_HD_T.setBounds(10, 10, 280, 50);
		panel_5.add(txtSL_HD_T);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.decode("#90c28b"));
		panel_6.setBounds(790, 280, 300, 110);
		add(panel_6);

		JLabel lblTngDoanhThu = new JLabel("Tổng doanh thu");
		lblTngDoanhThu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTngDoanhThu.setForeground(Color.DARK_GRAY);
		lblTngDoanhThu.setFont(new Font("Arial", Font.BOLD, 16));
		lblTngDoanhThu.setBounds(10, 69, 280, 30);
		panel_6.add(lblTngDoanhThu);

		txtTongDT = new JLabel("Null");
		txtTongDT.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTongDT.setForeground(Color.BLACK);
		txtTongDT.setFont(new Font("Arial", Font.BOLD, 26));
		txtTongDT.setBounds(10, 10, 280, 50);
		panel_6.add(txtTongDT);

		// ----- Table ----- //
		JLabel danhSach = new JLabel("Danh sách hóa đơn");
		danhSach.setHorizontalAlignment(SwingConstants.CENTER);
		danhSach.setFont(new Font("Arial", Font.BOLD, 20));
		danhSach.setBounds(10, 400, 1120, 60);
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
		scroll.setBounds(10, 470, 1120, 255);
		add(scroll);
	}
	
	private void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	
	public void get_dshd_KhoangTG() {
		int i = 0;
		for (HoaDon hd : tk_dao.getDsHD_theoKhoangTG(Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayKetThuc.getText()))) {
			Object[] row = { i+1, hd.getMaHD(), hd.getKhachHang().getMaKhachHang(), hd.getLoaiHD(), hd.getNgayXuat(), hd.getKhuyenMai().getMaKM(), hd.getGhiChu()};
			model.addRow(row);
			i++;
		}
	}
	
	public void get_dshd_Thang() {
		int i = 0;
		for (HoaDon hd : tk_dao.getDsHD_theoThang(Integer.valueOf(txtNgayBatDau.getText()), Integer.valueOf(txtNgayKetThuc.getText()))) {
			Object[] row = { i+1, hd.getMaHD(), hd.getKhachHang().getMaKhachHang(), hd.getLoaiHD(), hd.getNgayXuat(), hd.getKhuyenMai().getMaKM(), hd.getGhiChu()};
			model.addRow(row);
			i++;
		}
	}
	
	public void get_dshd_Nam() {
		int i = 0;
		for (HoaDon hd : tk_dao.getDsHD_theoNam(Integer.valueOf(txtNgayBatDau.getText()))) {
			Object[] row = { i+1, hd.getMaHD(), hd.getKhachHang().getMaKhachHang(), hd.getLoaiHD(), hd.getNgayXuat(), hd.getKhuyenMai().getMaKM(), hd.getGhiChu()};
			model.addRow(row);
			i++;
		}
	}
	
	public boolean ktNgay(String ngay) {
		if(ngay.matches("\\d{4}-\\d{2}-\\d{2}")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ngày không được rỗng, nhập ngày/tháng/năm (yyyy-mm-dd)");
			return false;
		}
	}
	
	public boolean ktThang(String thang) {
		if(thang.matches("^(0[1-9]|1[0-2])$")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Tháng không được rỗng, nhập tháng (01-12)");
			return false;
		}
	}
	
	public boolean ktNam(String nam) {
		if(nam.matches("^\\d{4}$")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Năm không được rỗng, nhập năm (yyyy)");
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(LoaiTG.getSelectedItem().equals("Theo ngày")) {
			txtNgayKetThuc.setEnabled(false);
			ngayBatDau.setText("Ngày bắt đầu:");
			ngayKetThuc.setText("Ngày kết thúc:");
			ngayKetThuc.setVisible(true);
			ngayKetThuc.setVisible(false);
			txtNgayKetThuc.setVisible(false);
		}
		if(LoaiTG.getSelectedItem().equals("Theo tháng")) {
			txtNgayKetThuc.setEnabled(true);
			ngayBatDau.setText("Tháng:");
			ngayKetThuc.setText("Năm:");
			ngayKetThuc.setVisible(true);
			txtNgayKetThuc.setVisible(true);
		}
		if(LoaiTG.getSelectedItem().equals("Theo năm")) {
			txtNgayKetThuc.setEnabled(true);
			ngayBatDau.setText("Năm:");
			ngayKetThuc.setVisible(false);
			txtNgayKetThuc.setVisible(false);
		}
		if(LoaiTG.getSelectedItem().equals("Theo khoảng thời gian")) {
			txtNgayKetThuc.setEnabled(true);
			ngayBatDau.setText("Ngày bắt đầu:");
			ngayKetThuc.setText("Ngày kết thúc:");
			ngayKetThuc.setVisible(true);
			txtNgayKetThuc.setVisible(true);
		}
		if (o == btnKQ && LoaiTG.getSelectedItem().equals("Theo khoảng thời gian") && ktNgay(txtNgayBatDau.getText())  && ktNgay(txtNgayKetThuc.getText()) && txtNgayBatDau.getText().length() > 0 && txtNgayKetThuc.getText().length() > 0) {
			clearTable();
			get_dshd_KhoangTG();
			txtTongDT.setText(tk_dao.tinhTongDoanhThuTheoKhoangTG(Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayKetThuc.getText())).toString());
			txtDTThuoc.setText(tk_dao.tinhTongDTLoaiSPTheoKhoangTG("Thu", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayKetThuc.getText())).toString());
			txtDTTPCN.setText(tk_dao.tinhTongDTLoaiSPTheoKhoangTG("%ph", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayKetThuc.getText())).toString());
			txtDTDCYT.setText(tk_dao.tinhTongDTLoaiSPTheoKhoangTG("D", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayKetThuc.getText())).toString());
			txtSL_HD_B.setText(String.valueOf(tk_dao.laySL_HD_TheoKhoangTG("bán" ,Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayKetThuc.getText()))));
			txtSL_HD_T.setText(String.valueOf(tk_dao.laySL_HD_TheoKhoangTG("trả" ,Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayKetThuc.getText()))));
		} else if (o == btnKQ && LoaiTG.getSelectedItem().equals("Theo tháng") && ktThang(txtNgayBatDau.getText())  && ktNam(txtNgayKetThuc.getText()) && txtNgayBatDau.getText().length() > 0 && txtNgayKetThuc.getText().length() > 0) {
			clearTable();
			get_dshd_Thang();
			txtTongDT.setText(tk_dao.tinhTongDoanhThuTheoThang(Integer.valueOf(txtNgayBatDau.getText()), Integer.valueOf(txtNgayKetThuc.getText())).toString());
			txtDTThuoc.setText(tk_dao.tinhTongDTLoaiSPTheoThang("Thu", Integer.valueOf(txtNgayBatDau.getText()), Integer.valueOf(txtNgayKetThuc.getText())).toString());
			txtDTTPCN.setText(tk_dao.tinhTongDTLoaiSPTheoThang("%ph", Integer.valueOf(txtNgayBatDau.getText()), Integer.valueOf(txtNgayKetThuc.getText())).toString());
			txtDTDCYT.setText(tk_dao.tinhTongDTLoaiSPTheoThang("D", Integer.valueOf(txtNgayBatDau.getText()), Integer.valueOf(txtNgayKetThuc.getText())).toString());
			txtSL_HD_B.setText(String.valueOf(tk_dao.laySL_HD_TheoThang("bán" ,Integer.valueOf(txtNgayBatDau.getText()), Integer.valueOf(txtNgayKetThuc.getText()))));
			txtSL_HD_T.setText(String.valueOf(tk_dao.laySL_HD_TheoThang("trả" ,Integer.valueOf(txtNgayBatDau.getText()), Integer.valueOf(txtNgayKetThuc.getText()))));
		} else if (o == btnKQ && LoaiTG.getSelectedItem().equals("Theo năm") && ktNam(txtNgayBatDau.getText()) && txtNgayBatDau.getText().length() > 0) {
			clearTable();
			get_dshd_Nam();
			txtTongDT.setText(tk_dao.tinhTongDoanhThuTheoNam(Integer.valueOf(txtNgayBatDau.getText())).toString());
			txtDTThuoc.setText(tk_dao.tinhTongDTLoaiSPTheoNam("Thu", Integer.valueOf(txtNgayBatDau.getText())).toString());
			txtDTTPCN.setText(tk_dao.tinhTongDTLoaiSPTheoNam("%ph", Integer.valueOf(txtNgayBatDau.getText())).toString());
			txtDTDCYT.setText(tk_dao.tinhTongDTLoaiSPTheoNam("D", Integer.valueOf(txtNgayBatDau.getText())).toString());
			txtSL_HD_B.setText(String.valueOf(tk_dao.laySL_HD_TheoNam("bán", Integer.valueOf(txtNgayBatDau.getText()))));
			txtSL_HD_T.setText(String.valueOf(tk_dao.laySL_HD_TheoNam("trả", Integer.valueOf(txtNgayBatDau.getText()))));
		} else if (o == btnKQ && LoaiTG.getSelectedItem().equals("Theo ngày") && ktNgay(txtNgayBatDau.getText()) && txtNgayBatDau.getText().length() > 0) {
			txtNgayKetThuc.setText(txtNgayBatDau.getText());
			clearTable();
			get_dshd_KhoangTG();
			txtTongDT.setText(tk_dao.tinhTongDoanhThuTheoKhoangTG(Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayBatDau.getText())).toString());
			txtDTThuoc.setText(tk_dao.tinhTongDTLoaiSPTheoKhoangTG("Thu", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayBatDau.getText())).toString());
			txtDTTPCN.setText(tk_dao.tinhTongDTLoaiSPTheoKhoangTG("%ph", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayBatDau.getText())).toString());
			txtDTDCYT.setText(tk_dao.tinhTongDTLoaiSPTheoKhoangTG("D", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayBatDau.getText())).toString());
			txtSL_HD_B.setText(String.valueOf(tk_dao.laySL_HD_TheoKhoangTG("bán", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayBatDau.getText()))));
			txtSL_HD_T.setText(String.valueOf(tk_dao.laySL_HD_TheoKhoangTG("trả", Date.valueOf(txtNgayBatDau.getText()), Date.valueOf(txtNgayBatDau.getText()))));
		}
	}
}
