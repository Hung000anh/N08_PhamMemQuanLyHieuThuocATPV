package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.SanPham_Dao;
import entity.ChiTietHoaDon;
import entity.HoaDon;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GD_TraSanPham extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;


	private JTextField txtNhpMCn;
	private JTable table;
	private JTable table_1;
	private JTextField txtNhpLDo;
	private JTextField txtNhpMSn;
	private JTextField txtNhpSLng;

	private HoaDon currentHoaDon = null;


	private myJButton btnNewButton;


	private DefaultTableModel model;

	public GD_TraSanPham() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140, 865);


		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(null);
		pnNorth.setBounds(0, 0, 1200, 60);
		pnNorth.setBackground(new Color(187, 231, 252));
		add(pnNorth);
		myJLabel lblTitle = new myJLabel("TRẢ SẢN PHẨM");
		pnNorth.add(lblTitle);

		// căn giữa title
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);

		
		JPanel panel = new JPanel();
		panel.setBounds(10, 60, 1106, 85);
		panel.setBorder(BorderFactory.createTitledBorder("Thông tin tìm kiếm"));
		panel.setBackground(null);
		add(panel);
		panel.setLayout(null);

		// Đặt kích thước và tọa độ cho lblTitle
		int labelWidth = 500; // Thay đổi kích thước theo ý muốn
		int labelHeight = 40; // Thay đổi kích thước theo ý muốn
		int labelX = (pnNorth.getWidth() - labelWidth) / 2; // Căn giữa theo chiều ngang
		int labelY = (pnNorth.getHeight() - labelHeight) / 2; // Căn giữa theo chiều dọc
		lblTitle.setBounds(labelX, labelY, labelWidth, labelHeight);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		
		myJLabel lblNewLabel = new myJLabel("Mã hóa đơn: ");
		lblNewLabel.setBounds(22, 32, 118, 25);
		panel.add(lblNewLabel);
		
		txtNhpMCn = new JTextField();
		txtNhpMCn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNhpMCn.setBounds(150, 28, 253, 34);
		panel.add(txtNhpMCn);
		txtNhpMCn.setColumns(10);
		
		btnNewButton = new myJButton("Tìm hóa đơn");
		btnNewButton.setBounds(413, 27, 161, 34);
		panel.add(btnNewButton);

		btnNewButton.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 155, 541, 628);
		panel_1.setBorder(BorderFactory.createTitledBorder("Hóa đơn đã bán hàng"));
		add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(null);
		
		String cols[] = { "STT", "MaSP", "TenSP", "SL", "Gia" };
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
		lblNewLabel_1.setBounds(5, 10, 86, 19);
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(130, 10, 348, 20);
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setHgap(10);
		panel_5.add(panel_6);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(null);
		panel_5_1.setLayout(null);
		panel_5_1.setBounds(10, 48, 488, 40);
		panel_3.add(panel_5_1);
		
		myJLabel lblNewLabel_1_1 = new myJLabel("Mã nhân viên:");
		lblNewLabel_1_1.setBounds(5, 10, 97, 19);
		panel_5_1.add(lblNewLabel_1_1);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(130, 10, 348, 20);
		panel_5_1.add(panel_6_1);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBackground(null);
		panel_5_2.setLayout(null);
		panel_5_2.setBounds(10, 88, 488, 40);
		panel_3.add(panel_5_2);
		
		myJLabel lblNewLabel_1_2 = new myJLabel("Mã KM:");
		lblNewLabel_1_2.setBounds(5, 10, 86, 19);
		panel_5_2.add(lblNewLabel_1_2);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBackground(Color.WHITE);
		panel_6_2.setBounds(130, 10, 348, 20);
		panel_5_2.add(panel_6_2);
		
		JPanel panel_5_3 = new JPanel();
		panel_5_3.setBackground(null);
		panel_5_3.setLayout(null);
		panel_5_3.setBounds(10, 128, 488, 40);
		panel_3.add(panel_5_3);
		
		myJLabel lblNewLabel_1_3 = new myJLabel("Mã KH:");
		lblNewLabel_1_3.setBounds(5, 10, 86, 19);
		panel_5_3.add(lblNewLabel_1_3);
		
		JPanel panel_6_3 = new JPanel();
		panel_6_3.setBackground(Color.WHITE);
		panel_6_3.setBounds(130, 10, 348, 20);
		panel_5_3.add(panel_6_3);
		
		JPanel panel_5_4 = new JPanel();
		panel_5_4.setBackground(null);
		panel_5_4.setLayout(null);
		panel_5_4.setBounds(10, 167, 488, 40);
		panel_3.add(panel_5_4);
		
		myJLabel lblNewLabel_1_4 = new myJLabel("Họ và tên:");
		lblNewLabel_1_4.setBounds(5, 10, 86, 19);
		panel_5_4.add(lblNewLabel_1_4);
		
		JPanel panel_6_4 = new JPanel();
		panel_6_4.setBackground(Color.WHITE);
		panel_6_4.setBounds(130, 10, 348, 20);
		panel_5_4.add(panel_6_4);
		
		JPanel panel_5_5 = new JPanel();
		panel_5_5.setBackground(null);
		panel_5_5.setLayout(null);
		panel_5_5.setBounds(10, 207, 488, 40);
		panel_3.add(panel_5_5);
		
		myJLabel lblNewLabel_1_5 = new myJLabel("Giới tính:");
		lblNewLabel_1_5.setBounds(5, 10, 86, 19);
		panel_5_5.add(lblNewLabel_1_5);
		
		JPanel panel_6_5 = new JPanel();
		panel_6_5.setBackground(Color.WHITE);
		panel_6_5.setBounds(130, 10, 348, 20);
		panel_5_5.add(panel_6_5);
		
		JPanel panel_5_6 = new JPanel();
		panel_5_6.setBackground(null);
		panel_5_6.setLayout(null);
		panel_5_6.setBounds(10, 247, 488, 40);
		panel_3.add(panel_5_6);
		
		myJLabel lblNewLabel_1_6 = new myJLabel("Số điện thoại:");
		lblNewLabel_1_6.setBounds(5, 10, 115, 19);
		panel_5_6.add(lblNewLabel_1_6);
		
		JPanel panel_6_6 = new JPanel();
		panel_6_6.setBackground(Color.WHITE);
		panel_6_6.setBounds(130, 10, 348, 20);
		panel_5_6.add(panel_6_6);
		
		JPanel panel_5_7 = new JPanel();
		panel_5_7.setBackground(null);
		panel_5_7.setLayout(null);
		panel_5_7.setBounds(10, 285, 488, 40);
		panel_3.add(panel_5_7);
		
		myJLabel lblNewLabel_1_7 = new myJLabel("Ngày mua:");
		lblNewLabel_1_7.setBounds(5, 10, 86, 19);
		panel_5_7.add(lblNewLabel_1_7);
		
		JPanel panel_6_7 = new JPanel();
		panel_6_7.setBackground(Color.WHITE);
		panel_6_7.setBounds(130, 10, 348, 20);
		panel_5_7.add(panel_6_7);
		
		JPanel panel_5_8 = new JPanel();
		panel_5_8.setBackground(null);
		panel_5_8.setLayout(null);
		panel_5_8.setBounds(10, 325, 488, 40);
		panel_3.add(panel_5_8);
		
		myJLabel lblNewLabel_1_8 = new myJLabel("Thành tiền:");
		lblNewLabel_1_8.setBounds(5, 10, 86, 19);
		panel_5_8.add(lblNewLabel_1_8);
		
		JPanel panel_6_8 = new JPanel();
		panel_6_8.setBackground(Color.WHITE);
		panel_6_8.setBounds(130, 10, 348, 20);
		panel_5_8.add(panel_6_8);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(null);
		panel_1_1.setBorder(BorderFactory.createTitledBorder("Hóa đơn đã bán hàng"));
		panel_1_1.setBounds(575, 155, 541, 628);
		add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(10, 74, 521, 126);
		panel_1_1.add(panel_2_1);
		
		DefaultTableModel model_1 = new DefaultTableModel(cols, 0);
		table_1 = new JTable(model_1);
		JScrollPane scrollpane_1 = new JScrollPane(table_1);
		scrollpane_1.setBounds(0, 0, 521, 176);
		panel_2_1.add(scrollpane_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(null);
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1.setBounds(10, 210, 521, 346);
		panel_1_1.add(panel_3_1);
		
		JPanel panel_5_9 = new JPanel();
		panel_5_9.setBackground(null);
		panel_5_9.setLayout(null);
		panel_5_9.setBounds(10, 10, 488, 40);
		panel_3_1.add(panel_5_9);
		
		myJLabel lblNewLabel_1_9 = new myJLabel("Mã hóa đơn:");
		lblNewLabel_1_9.setBounds(5, 10, 86, 19);
		panel_5_9.add(lblNewLabel_1_9);
		
		JPanel panel_6_9 = new JPanel();
		panel_6_9.setBackground(Color.WHITE);
		panel_6_9.setBounds(130, 10, 348, 20);
		panel_5_9.add(panel_6_9);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBackground(null);
		panel_5_1_1.setLayout(null);
		panel_5_1_1.setBounds(10, 48, 488, 40);
		panel_3_1.add(panel_5_1_1);
		
		myJLabel lblNewLabel_1_1_1 = new myJLabel("Mã nhân viên:");
		lblNewLabel_1_1_1.setBounds(5, 10, 102, 19);
		panel_5_1_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_6_1_1 = new JPanel();
		panel_6_1_1.setBackground(Color.WHITE);
		panel_6_1_1.setBounds(130, 10, 348, 20);
		panel_5_1_1.add(panel_6_1_1);
		
		JPanel panel_5_2_1 = new JPanel();
		panel_5_2_1.setBackground(null);
		panel_5_2_1.setLayout(null);
		panel_5_2_1.setBounds(10, 88, 488, 40);
		panel_3_1.add(panel_5_2_1);
		
		myJLabel lblNewLabel_1_2_1 = new myJLabel("Mã KH:");
		lblNewLabel_1_2_1.setBounds(5, 10, 86, 19);
		panel_5_2_1.add(lblNewLabel_1_2_1);
		
		JPanel panel_6_2_1 = new JPanel();
		panel_6_2_1.setBackground(Color.WHITE);
		panel_6_2_1.setBounds(130, 10, 348, 20);
		panel_5_2_1.add(panel_6_2_1);
		
		JPanel panel_5_3_1 = new JPanel();
		panel_5_3_1.setBackground(null);
		panel_5_3_1.setLayout(null);
		panel_5_3_1.setBounds(10, 128, 488, 40);
		panel_3_1.add(panel_5_3_1);
		
		myJLabel lblNewLabel_1_3_1 = new myJLabel("Họ và tên:");
		lblNewLabel_1_3_1.setBounds(5, 10, 86, 19);
		panel_5_3_1.add(lblNewLabel_1_3_1);
		
		JPanel panel_6_3_1 = new JPanel();
		panel_6_3_1.setBackground(Color.WHITE);
		panel_6_3_1.setBounds(130, 10, 348, 20);
		panel_5_3_1.add(panel_6_3_1);
		
		JPanel panel_5_4_1 = new JPanel();
		panel_5_4_1.setBackground(null);
		panel_5_4_1.setLayout(null);
		panel_5_4_1.setBounds(10, 167, 488, 40);
		panel_3_1.add(panel_5_4_1);
		
		myJLabel lblNewLabel_1_4_1 = new myJLabel("Giới tính:");
		lblNewLabel_1_4_1.setBounds(5, 10, 86, 19);
		panel_5_4_1.add(lblNewLabel_1_4_1);
		
		JPanel panel_6_4_1 = new JPanel();
		panel_6_4_1.setBackground(Color.WHITE);
		panel_6_4_1.setBounds(130, 10, 348, 20);
		panel_5_4_1.add(panel_6_4_1);
		
		JPanel panel_5_5_1 = new JPanel();
		panel_5_5_1.setBackground(null);
		panel_5_5_1.setLayout(null);
		panel_5_5_1.setBounds(10, 207, 488, 40);
		panel_3_1.add(panel_5_5_1);
		
		myJLabel lblNewLabel_1_5_1 = new myJLabel("Số điện thoại:");
		lblNewLabel_1_5_1.setBounds(5, 10, 103, 19);
		panel_5_5_1.add(lblNewLabel_1_5_1);
		
		JPanel panel_6_5_1 = new JPanel();
		panel_6_5_1.setBackground(Color.WHITE);
		panel_6_5_1.setBounds(130, 10, 348, 20);
		panel_5_5_1.add(panel_6_5_1);
		
		JPanel panel_5_6_1 = new JPanel();
		panel_5_6_1.setBackground(null);
		panel_5_6_1.setLayout(null);
		panel_5_6_1.setBounds(10, 247, 488, 40);
		panel_3_1.add(panel_5_6_1);
		
		myJLabel lblNewLabel_1_6_1 = new myJLabel("Ngày trả:");
		lblNewLabel_1_6_1.setBounds(5, 10, 86, 19);
		panel_5_6_1.add(lblNewLabel_1_6_1);
		
		JPanel panel_6_6_1 = new JPanel();
		panel_6_6_1.setBackground(Color.WHITE);
		panel_6_6_1.setBounds(130, 10, 348, 20);
		panel_5_6_1.add(panel_6_6_1);
		
		JPanel panel_5_7_1 = new JPanel();
		panel_5_7_1.setBackground(null);
		panel_5_7_1.setLayout(null);
		panel_5_7_1.setBounds(10, 285, 488, 40);
		panel_3_1.add(panel_5_7_1);
		
		myJLabel lblNewLabel_1_7_1 = new myJLabel("Số tiền trả:");
		lblNewLabel_1_7_1.setBounds(5, 10, 86, 19);
		panel_5_7_1.add(lblNewLabel_1_7_1);
		
		JPanel panel_6_7_1 = new JPanel();
		panel_6_7_1.setBackground(Color.WHITE);
		panel_6_7_1.setBounds(130, 10, 348, 20);
		panel_5_7_1.add(panel_6_7_1);
		
		txtNhpLDo = new JTextField();
		txtNhpLDo.setText("Nhập lý do trả hàng");
		txtNhpLDo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNhpLDo.setBounds(10, 566, 367, 31);
		panel_1_1.add(txtNhpLDo);
		txtNhpLDo.setColumns(10);
		
		myJButton btnNewButton_1 = new myJButton("Xác nhận");
		btnNewButton_1.setBlue();
		btnNewButton_1.setBounds(387, 566, 144, 31);
		panel_1_1.add(btnNewButton_1);
		
		txtNhpMSn = new JTextField();
		txtNhpMSn.setText("Nhập mã sản phẩm");
		txtNhpMSn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNhpMSn.setColumns(10);
		txtNhpMSn.setBounds(10, 21, 254, 31);
		panel_1_1.add(txtNhpMSn);
		
		txtNhpSLng = new JTextField();
		txtNhpSLng.setText("Nhập số lượng");
		txtNhpSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNhpSLng.setColumns(10);
		txtNhpSLng.setBounds(274, 21, 144, 31);
		panel_1_1.add(txtNhpSLng);
		
		myJButton btnThm = new myJButton("Thêm");
		btnThm.setBounds(428, 18, 103, 34);
		panel_1_1.add(btnThm);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnNewButton) {
			String ma = txtNhpMCn.getText();
			HoaDon_DAO.docTubang();
			SanPham_Dao.docTubang();
			ChiTietHoaDon_DAO.docTubang();
			
			HoaDon hd = HoaDon_DAO.layHoaDonTheoMa(ma);
			ArrayList<ChiTietHoaDon> lst = ChiTietHoaDon_DAO.layChiTietHoaDonTheoMaHD(ma);

			model.getDataVector().removeAllElements();
			for (ChiTietHoaDon x : lst) {
				
			}
			
		}
		
	}
}
