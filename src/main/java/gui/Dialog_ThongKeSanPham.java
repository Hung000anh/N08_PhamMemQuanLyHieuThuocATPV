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
import java.sql.Date;

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

public class Dialog_ThongKeSanPham extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ThongKe_Dao tk_dao = new ThongKe_Dao();
	private JButton btnKQ;
	private JTextField txtMaSP1;
	private JTextField txtSl1;
	private JTextField txtTenSp1;
	private JTextField txtMaSP2;
	private JTextField txtSl2;
	private JTextField txtTenSp2;
	private JTextField txtMaSP3;
	private JTextField txtSl3;
	private JTextField txtTenSp3;
	private JTextField txtMaSP4;
	private JTextField txtSl4;
	private JTextField txtTenSp4;
	private JTextField txtMaSP5;
	private JTextField txtSl5;
	private JTextField txtTenSp5;
	private JLabel hinh1;
	private JComboBox comboBoxLoaiTk;
	private JLabel hinh2;
	private JLabel hinh3;
	private JLabel hinh4;
	private JLabel hinh5;
	private JPanel sp1;
	private JPanel sp2;
	private JPanel sp3;
	private JPanel sp4;
	private JPanel sp5;
	/**
	 * Create the panel.
	 */
	public Dialog_ThongKeSanPham() {
		setLayout(null);
		setSize(1140, 725);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1140, 100);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel loaiTK = new JLabel("Loại thống kê:");
		loaiTK.setFont(new Font("Arial", Font.BOLD, 16));
		loaiTK.setBounds(10, 10, 130, 30);
		panel_1.add(loaiTK);
		
		comboBoxLoaiTk = new JComboBox<String>();
		comboBoxLoaiTk.setModel(new DefaultComboBoxModel(new String[] {"Top 5 sản phẩm bán chạy nhất", "Top 5 sản phẩm bán ít nhất", "Sản phẩm bán chạy nhất", "Sản phẩm bán ít nhất"}));
		comboBoxLoaiTk.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxLoaiTk.setBounds(150, 12, 190, 30);
		comboBoxLoaiTk.addActionListener(this);
		panel_1.add(comboBoxLoaiTk);
		
		btnKQ = new JButton("Xem kết quả");
		btnKQ.setBounds(10, 60, 330, 30);
		panel_1.add(btnKQ);
		btnKQ.setBackground(SystemColor.textHighlight);
		btnKQ.setFont(new Font("Arial", Font.BOLD, 16));
		btnKQ.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH SẢN PHẨM");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 105, 1140, 48);
		add(lblNewLabel);
		
		sp1 = new JPanel();
		sp1.setBounds(10, 160, 1120, 100);
		sp1.setBackground(Color.decode("#90c28b"));
		add(sp1);
		sp1.setLayout(null);
		
		hinh1 = new JLabel();
		hinh1.setForeground(Color.BLACK);
		hinh1.setBackground(Color.WHITE);
		hinh1.setBounds(10, 10, 150, 80);
		sp1.add(hinh1);
		
		JLabel maSP1 = new JLabel("Mã sản phẩm:");
		maSP1.setFont(new Font("Arial", Font.BOLD, 16));
		maSP1.setBounds(200, 35, 120, 30);
		sp1.add(maSP1);
		
		txtMaSP1 = new JTextField();
		txtMaSP1.setEditable(false);
		txtMaSP1.setBounds(330, 35, 120, 30);
		sp1.add(txtMaSP1);
		txtMaSP1.setColumns(10);
		
		JLabel sl1 = new JLabel("Số lượng bán ra:");
		sl1.setFont(new Font("Arial", Font.BOLD, 16));
		sl1.setBounds(819, 35, 150, 30);
		sp1.add(sl1);
		
		txtSl1 = new JTextField();
		txtSl1.setEditable(false);
		txtSl1.setColumns(10);
		txtSl1.setBounds(979, 35, 120, 30);
		sp1.add(txtSl1);
		
		JLabel tenSP1 = new JLabel("Tên sản phẩm:");
		tenSP1.setFont(new Font("Arial", Font.BOLD, 16));
		tenSP1.setBounds(520, 35, 120, 30);
		sp1.add(tenSP1);
		
		txtTenSp1 = new JTextField();
		txtTenSp1.setEditable(false);
		txtTenSp1.setColumns(10);
		txtTenSp1.setBounds(650, 35, 120, 30);
		sp1.add(txtTenSp1);
		
		sp2 = new JPanel();
		sp2.setLayout(null);
		sp2.setBackground(Color.decode("#90c28b"));
		sp2.setBounds(10, 275, 1120, 100);
		add(sp2);
		
		hinh2 = new JLabel();
		hinh2.setBounds(10, 10, 150, 80);
		sp2.add(hinh2);
		
		JLabel maSP2 = new JLabel("Mã sản phẩm:");
		maSP2.setFont(new Font("Arial", Font.BOLD, 16));
		maSP2.setBounds(200, 35, 120, 30);
		sp2.add(maSP2);
		
		txtMaSP2 = new JTextField();
		txtMaSP2.setEditable(false);
		txtMaSP2.setColumns(10);
		txtMaSP2.setBounds(330, 35, 120, 30);
		sp2.add(txtMaSP2);
		
		JLabel sl2 = new JLabel("Số lượng bán ra:");
		sl2.setFont(new Font("Arial", Font.BOLD, 16));
		sl2.setBounds(819, 35, 150, 30);
		sp2.add(sl2);
		
		txtSl2 = new JTextField();
		txtSl2.setEditable(false);
		txtSl2.setColumns(10);
		txtSl2.setBounds(979, 35, 120, 30);
		sp2.add(txtSl2);
		
		JLabel tenSP2 = new JLabel("Tên sản phẩm:");
		tenSP2.setFont(new Font("Arial", Font.BOLD, 16));
		tenSP2.setBounds(520, 35, 120, 30);
		sp2.add(tenSP2);
		
		txtTenSp2 = new JTextField();
		txtTenSp2.setEditable(false);
		txtTenSp2.setColumns(10);
		txtTenSp2.setBounds(650, 35, 120, 30);
		sp2.add(txtTenSp2);
		
		sp3 = new JPanel();
		sp3.setLayout(null);
		sp3.setBackground(Color.decode("#90c28b"));
		sp3.setBounds(10, 390, 1120, 100);
		add(sp3);
		
		hinh3 = new JLabel();
		hinh3.setBounds(10, 10, 150, 80);
		sp3.add(hinh3);
		
		JLabel maSP3 = new JLabel("Mã sản phẩm:");
		maSP3.setFont(new Font("Arial", Font.BOLD, 16));
		maSP3.setBounds(200, 35, 120, 30);
		sp3.add(maSP3);
		
		txtMaSP3 = new JTextField();
		txtMaSP3.setEditable(false);
		txtMaSP3.setColumns(10);
		txtMaSP3.setBounds(330, 35, 120, 30);
		sp3.add(txtMaSP3);
		
		JLabel sl3 = new JLabel("Số lượng bán ra:");
		sl3.setFont(new Font("Arial", Font.BOLD, 16));
		sl3.setBounds(819, 35, 150, 30);
		sp3.add(sl3);
		
		txtSl3 = new JTextField();
		txtSl3.setEditable(false);
		txtSl3.setColumns(10);
		txtSl3.setBounds(979, 35, 120, 30);
		sp3.add(txtSl3);
		
		JLabel tenSP3 = new JLabel("Tên sản phẩm:");
		tenSP3.setFont(new Font("Arial", Font.BOLD, 16));
		tenSP3.setBounds(520, 35, 120, 30);
		sp3.add(tenSP3);
		
		txtTenSp3 = new JTextField();
		txtTenSp3.setEditable(false);
		txtTenSp3.setColumns(10);
		txtTenSp3.setBounds(650, 35, 120, 30);
		sp3.add(txtTenSp3);
		
		sp4 = new JPanel();
		sp4.setLayout(null);
		sp4.setBackground(Color.decode("#90c28b"));
		sp4.setBounds(10, 505, 1120, 100);
		add(sp4);
		
		hinh4 = new JLabel();
		hinh4.setBounds(10, 10, 150, 80);
		sp4.add(hinh4);
		
		JLabel maSP4 = new JLabel("Mã sản phẩm:");
		maSP4.setFont(new Font("Arial", Font.BOLD, 16));
		maSP4.setBounds(200, 35, 120, 30);
		sp4.add(maSP4);
		
		txtMaSP4 = new JTextField();
		txtMaSP4.setEditable(false);
		txtMaSP4.setColumns(10);
		txtMaSP4.setBounds(330, 35, 120, 30);
		sp4.add(txtMaSP4);
		
		JLabel sl4 = new JLabel("Số lượng bán ra:");
		sl4.setFont(new Font("Arial", Font.BOLD, 16));
		sl4.setBounds(819, 35, 150, 30);
		sp4.add(sl4);
		
		txtSl4 = new JTextField();
		txtSl4.setEditable(false);
		txtSl4.setColumns(10);
		txtSl4.setBounds(979, 35, 120, 30);
		sp4.add(txtSl4);
		
		JLabel tenSP4 = new JLabel("Tên sản phẩm:");
		tenSP4.setFont(new Font("Arial", Font.BOLD, 16));
		tenSP4.setBounds(520, 35, 120, 30);
		sp4.add(tenSP4);
		
		txtTenSp4 = new JTextField();
		txtTenSp4.setEditable(false);
		txtTenSp4.setColumns(10);
		txtTenSp4.setBounds(650, 35, 120, 30);
		sp4.add(txtTenSp4);
		
		sp5 = new JPanel();
		sp5.setLayout(null);
		sp5.setBackground(Color.decode("#90c28b"));
		sp5.setBounds(10, 620, 1120, 100);
		add(sp5);
		
		hinh5 = new JLabel();
		hinh5.setBounds(10, 10, 150, 80);
		sp5.add(hinh5);
		
		JLabel maSP5 = new JLabel("Mã sản phẩm:");
		maSP5.setFont(new Font("Arial", Font.BOLD, 16));
		maSP5.setBounds(200, 35, 120, 30);
		sp5.add(maSP5);
		
		txtMaSP5 = new JTextField();
		txtMaSP5.setEditable(false);
		txtMaSP5.setColumns(10);
		txtMaSP5.setBounds(330, 35, 120, 30);
		sp5.add(txtMaSP5);
		
		JLabel sl5 = new JLabel("Số lượng bán ra:");
		sl5.setFont(new Font("Arial", Font.BOLD, 16));
		sl5.setBounds(819, 35, 150, 30);
		sp5.add(sl5);
		
		txtSl5 = new JTextField();
		txtSl5.setEditable(false);
		txtSl5.setColumns(10);
		txtSl5.setBounds(979, 35, 120, 30);
		sp5.add(txtSl5);
		
		JLabel tenSP5 = new JLabel("Tên sản phẩm:");
		tenSP5.setFont(new Font("Arial", Font.BOLD, 16));
		tenSP5.setBounds(520, 35, 120, 30);
		sp5.add(tenSP5);
		
		txtTenSp5 = new JTextField();
		txtTenSp5.setEditable(false);
		txtTenSp5.setColumns(10);
		txtTenSp5.setBounds(650, 35, 120, 30);
		sp5.add(txtTenSp5);
		
		sp1.setVisible(true);
		sp2.setVisible(false);
		sp3.setVisible(false);
		sp4.setVisible(false);
		sp5.setVisible(false);
		
	}
	
	public void get_5_SP_BanChayNhat() {
		int i = 0;
		int[] sl = tk_dao.laySlBanRa("DESC");
		for (SanPham sp : tk_dao.top_5_SP("DESC")) {
			if(i == 0) {
				hinh1.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
				txtMaSP1.setText(sp.getMaSP());
				txtTenSp1.setText(sp.getTenSP());
				txtSl1.setText(String.valueOf(sl[i]));
			}
			if(i == 1) {
				hinh2.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
				txtMaSP2.setText(sp.getMaSP());
				txtTenSp2.setText(sp.getTenSP());
				txtSl2.setText(String.valueOf(sl[i]));
			}
			if(i == 2) {
				hinh3.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
				txtMaSP3.setText(sp.getMaSP());
				txtTenSp3.setText(sp.getTenSP());
				txtSl3.setText(String.valueOf(sl[i]));
			}
			if(i == 3) {
				hinh4.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
				txtMaSP4.setText(sp.getMaSP());
				txtTenSp4.setText(sp.getTenSP());
				txtSl4.setText(String.valueOf(sl[i]));
			}
			if(i == 4) {
				hinh5.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
				txtMaSP5.setText(sp.getMaSP());
				txtTenSp5.setText(sp.getTenSP());
				txtSl5.setText(String.valueOf(sl[i]));
			}
			
			sp1.setVisible(true);
			sp2.setVisible(true);
			sp3.setVisible(true);
			sp4.setVisible(true);
			sp5.setVisible(true);
			
			i++;
		}
	}
	
	public void get_5_SP_BanChamNhat() {
		int i = 0;
		int[] sl = tk_dao.laySlBanRa("");
		for (SanPham sp : tk_dao.top_5_SP("")) {
			if(i == 0) {
				hinh1.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
				txtMaSP1.setText(sp.getMaSP());
				txtTenSp1.setText(sp.getTenSP());
				txtSl1.setText(String.valueOf(sl[i]));
			}
			if(i == 1) {
				hinh2.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
				txtMaSP2.setText(sp.getMaSP());
				txtTenSp2.setText(sp.getTenSP());
				txtSl2.setText(String.valueOf(sl[i]));
			}
			if(i == 2) {
				hinh3.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
				txtMaSP3.setText(sp.getMaSP());
				txtTenSp3.setText(sp.getTenSP());
				txtSl3.setText(String.valueOf(sl[i]));
			}
			if(i == 3) {
				hinh4.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
				txtMaSP4.setText(sp.getMaSP());
				txtTenSp4.setText(sp.getTenSP());
				txtSl4.setText(String.valueOf(sl[i]));
			}
			if(i == 4) {
				hinh5.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
				txtMaSP5.setText(sp.getMaSP());
				txtTenSp5.setText(sp.getTenSP());
				txtSl5.setText(String.valueOf(sl[i]));
			}
			
			sp1.setVisible(true);
			sp2.setVisible(true);
			sp3.setVisible(true);
			sp4.setVisible(true);
			sp5.setVisible(true);
			
			i++;
		}
	}
	
	public void get_SpBanChayNhat() {
		SanPham sp = tk_dao.getSanPham("DESC");
		int[] sl = tk_dao.laySlBanRa("DESC");
		hinh1.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
		txtMaSP1.setText(sp.getMaSP());
		txtTenSp1.setText(sp.getTenSP());
		txtSl1.setText(String.valueOf(sl[0]));
		sp1.setVisible(true);
		sp2.setVisible(false);
		sp3.setVisible(false);
		sp4.setVisible(false);
		sp5.setVisible(false);
	}
	
	public void get_SpBanChamNhat() {
		SanPham sp = tk_dao.getSanPham("");
		int[] sl = tk_dao.laySlBanRa("");
		hinh1.setIcon(new ImageIcon(new ImageIcon(sp.getHinhAnhSanPham()).getImage().getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH)));
		txtMaSP1.setText(sp.getMaSP());
		txtTenSp1.setText(sp.getTenSP());
		txtSl1.setText(String.valueOf(sl[0]));
		sp1.setVisible(true);
		sp2.setVisible(false);
		sp3.setVisible(false);
		sp4.setVisible(false);
		sp5.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnKQ && comboBoxLoaiTk.getSelectedItem().equals("Top 5 sản phẩm bán chạy nhất")) {
			get_5_SP_BanChayNhat();
		}
		else if (obj == btnKQ && comboBoxLoaiTk.getSelectedItem().equals("Top 5 sản phẩm bán ít nhất")) {
			get_5_SP_BanChamNhat();
		}
		else if (obj == btnKQ && comboBoxLoaiTk.getSelectedItem().equals("Sản phẩm bán ít nhất")) {
			get_SpBanChamNhat();
		}
		else if (obj == btnKQ && comboBoxLoaiTk.getSelectedItem().equals("Sản phẩm bán chạy nhất")) {
			get_SpBanChayNhat();
		}
	}
}
