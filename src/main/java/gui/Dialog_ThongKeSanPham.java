package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.ThongKe_Dao;
import entity.SanPham;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Dialog_ThongKeSanPham extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private String col[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá nhập", "Đơn giá bán", "Số lượng tồn", "Ngày sản xuất", "Ngày hết hạn", "SL bán ra"};
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private ThongKe_Dao tk_dao = new ThongKe_Dao();
	private JComboBox comboBoxLoaiTk;
	/**
	 * Create the panel.
	 */
	public Dialog_ThongKeSanPham() {
		setLayout(null);
		setSize(1140, 600);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 350, 600);
		add(panel);
		panel.setLayout(null);
		
		JLabel loaiTK = new JLabel("Loại thống kê:");
		loaiTK.setFont(new Font("Arial", Font.BOLD, 16));
		loaiTK.setBounds(10, 10, 130, 30);
		panel.add(loaiTK);
		
		comboBoxLoaiTk = new JComboBox();
		comboBoxLoaiTk.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxLoaiTk.setModel(new DefaultComboBoxModel(new String[] {"Top 5 sản phẩm bán chạy nhất", "Top 5 sản phẩm bán ít nhất", "Sản phẩm bán chạy nhất", "Sản phẩm bán ít nhất"}));
		comboBoxLoaiTk.setBounds(150, 11, 190, 30);
		panel.add(comboBoxLoaiTk);
		
		JButton btnKQ = new JButton("Xem kết quả");
		btnKQ.setBackground(SystemColor.textHighlight);
		btnKQ.setFont(new Font("Arial", Font.BOLD, 16));
		btnKQ.setBounds(10, 125, 330, 50);
		panel.add(btnKQ);
		
		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setSelectionBackground(SystemColor.controlHighlight);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(0).setMaxWidth(60);
		scroll = new JScrollPane(table);
		scroll.setFont(new Font("Arial", Font.BOLD, 25));
		scroll.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scroll.setBounds(360, 10, 770, 580);
		add(scroll);
		btnKQ.addActionListener(this);
	}

	private void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	
	public void get_5_SP() {
		int i = 0;
		for (SanPham sp : tk_dao.top_5_SpBanChay()) {
			i++;
			Object[] row = { i, sp.getMaSP(), sp.getTenSP(), sp.getDonGiaNhap(), sp.getDonGiaBan(), sp.getSoluongTon(), sp.getNgaySanXuat(), sp.getNgayHetHan(), sp.getDonViTinh()};
			model.addRow(row);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == "btnKQ" && comboBoxLoaiTk.getSelectedItem().equals("Top 5 sản phẩm bán chạy nhất")) {
			clearTable();
			get_5_SP();
		}
	}
}
