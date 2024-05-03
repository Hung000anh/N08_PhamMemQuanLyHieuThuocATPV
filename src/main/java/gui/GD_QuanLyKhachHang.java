package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.KhachHang_Dao;
import entity.KhachHang;

public class GD_QuanLyKhachHang extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField textTenKH;
	private JTextField textMaKH;
	private JTextField textTuKhoaTim;
	private JTextField textTuoi;
	private JTextField textSdt;
	private String col[] = { "STT", "Mã khách hàng", "Tên khách hàng", "Giới tính", "Tuổi", "Số điện thoại",
			"Hình ảnh" };
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JLabel txtAnh;
	private KhachHang_Dao kh_dao = new KhachHang_Dao();
	private JButton btnTim;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnThem;
	private JComboBox<String> comboBoxLoaiTim;
	private Date date;

	public GD_QuanLyKhachHang() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140, 865);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1140, 60);
		panel.setBackground(new Color(187, 231, 252));
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(0, 0, 1140, 60);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JPanel tt_KhachHang = new JPanel();
		tt_KhachHang.setBackground(SystemColor.window);
		tt_KhachHang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin khách hàng", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20),
				Color.DARK_GRAY));
		tt_KhachHang.setBounds(10, 70, 1120, 201);
		add(tt_KhachHang);
		tt_KhachHang.setLayout(null);

		JLabel tenKH = new JLabel("Tên khách hàng:");
		tenKH.setFont(new Font("Arial", Font.BOLD, 16));
		tenKH.setBounds(30, 92, 145, 30);
		tt_KhachHang.add(tenKH);

		textTenKH = new JTextField();
		textTenKH.setColumns(10);
		textTenKH.setBounds(185, 92, 220, 35);
		tt_KhachHang.add(textTenKH);

		JLabel maKH = new JLabel("Mã khách hàng:");
		maKH.setFont(new Font("Arial", Font.BOLD, 16));
		maKH.setBounds(30, 44, 145, 30);
		tt_KhachHang.add(maKH);

		textMaKH = new JTextField();
		textMaKH.setColumns(10);
		textMaKH.setEnabled(false);
		textMaKH.setBounds(185, 44, 220, 35);
		tt_KhachHang.add(textMaKH);

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

		txtAnh = new JLabel();
		txtAnh.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnh.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		txtAnh.setBackground(Color.LIGHT_GRAY);
		txtAnh.setBounds(965, 35, 120, 140);
		tt_KhachHang.add(txtAnh);

		JLabel tuoi = new JLabel("Tuổi:");
		tuoi.setFont(new Font("Arial", Font.BOLD, 16));
		tuoi.setBounds(503, 47, 145, 30);
		tt_KhachHang.add(tuoi);

		textTuoi = new JTextField();
		textTuoi.setColumns(10);
		textTuoi.setBounds(640, 47, 220, 35);
		tt_KhachHang.add(textTuoi);

		JLabel soDienThoai = new JLabel("Số điện thoại:");
		soDienThoai.setFont(new Font("Arial", Font.BOLD, 16));
		soDienThoai.setBounds(503, 95, 145, 30);
		tt_KhachHang.add(soDienThoai);

		textSdt = new JTextField();
		textSdt.setColumns(10);
		textSdt.setBounds(640, 95, 220, 35);
		tt_KhachHang.add(textSdt);

		JPanel chucNang = new JPanel();
		chucNang.setLayout(null);
		chucNang.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Chức năng",
						TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		chucNang.setBackground(SystemColor.window);
		chucNang.setBounds(10, 281, 1120, 100);
		add(chucNang);

		btnThem = new JButton("Thêm");
		btnThem.setToolTipText("");
		btnThem.setFont(new Font("Arial", Font.BOLD, 16));
		btnThem.setBounds(30, 38, 100, 40);
		btnThem.setBackground(Color.decode("#4db05e"));
//		btnThem.setBorderPainted(false);
		chucNang.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setToolTipText("");
		btnXoa.setFont(new Font("Arial", Font.BOLD, 16));
		btnXoa.setBorderPainted(false);
		btnXoa.setBackground(Color.decode("#ee1919"));
		btnXoa.setBounds(150, 38, 100, 40);
		chucNang.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setToolTipText("thêm thông tin\r\n khách hàng");
		btnSua.setFont(new Font("Arial", Font.BOLD, 16));
		btnSua.setBorderPainted(false);
		btnSua.setBackground(Color.decode("#26bfbf"));
		btnSua.setBounds(270, 38, 100, 40);
		chucNang.add(btnSua);

		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setToolTipText("");
		btnXoaRong.setFont(new Font("Arial", Font.BOLD, 15));
		btnXoaRong.setBorderPainted(false);
		btnXoaRong.setBackground(SystemColor.activeCaptionBorder);
		btnXoaRong.setBounds(390, 38, 100, 40);
		chucNang.add(btnXoaRong);

		textTuKhoaTim = new JTextField();
		textTuKhoaTim.setColumns(10);
		textTuKhoaTim.setBounds(635, 40, 220, 35);
		chucNang.add(textTuKhoaTim);

		comboBoxLoaiTim = new JComboBox<String>();
		comboBoxLoaiTim.setFont(new Font("Arial", Font.BOLD, 16));
		comboBoxLoaiTim
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Tìm theo mã", "Tìm theo số điện thoại" }));
		comboBoxLoaiTim.setBounds(880, 40, 210, 35);
		chucNang.add(comboBoxLoaiTim);

		btnTim = new JButton("Tìm");
		btnTim.setToolTipText("");
		btnTim.setFont(new Font("Arial", Font.BOLD, 16));
		btnTim.setBorderPainted(false);
		btnTim.setBackground(new Color(74, 131, 215));
		btnTim.setBounds(510, 38, 100, 40);
		chucNang.add(btnTim);

		JLabel danhSach = new JLabel("Danh sách khách hàng");
		danhSach.setHorizontalAlignment(SwingConstants.CENTER);
		danhSach.setFont(new Font("Arial", Font.BOLD, 20));
		danhSach.setBounds(10, 391, 1120, 60);
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
		scroll.setBounds(10, 461, 1120, 384);
		add(scroll);
		btnXoaRong.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		rdoNam.addActionListener(this);
		rdoNu.addActionListener(this);
		table.addMouseListener(this);
		loadMa();
		loadData();
	}

	private int ThuTuKhachHangTrongNgay() {
		int sl = 1;
		String maKH = "";
		for (KhachHang kh : kh_dao.getAllKhachHang()) {
			maKH = kh.getMaKhachHang(); // Chạy hết vòng for sẽ lấy được mã KH cuối danh sách
		}
		int ngayTrenMaKHCuoiDS = Integer.parseInt(maKH.substring(2, 8));
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd"); // Format yyMMdd sẽ so sánh ngày được
		java.util.Date ngayHienTai = new java.util.Date();
		int ngayHT = Integer.parseInt(dateFormat.format(ngayHienTai));
		if (ngayHT > ngayTrenMaKHCuoiDS) {
			sl = 1;
		} else if (ngayHT == ngayTrenMaKHCuoiDS) {
			sl = Integer.parseInt(maKH.substring(8, 11)) + 1;
		}
		return sl;
	}

	private String generateRandomCode() {
		String prefix = "KH";
		DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		java.util.Date date = new java.util.Date();
		String suffix = String.format("%03d", ThuTuKhachHangTrongNgay());
		return prefix + dateFormat.format(date) + suffix;
	}

	private void loadMa() {
		String code;
		code = generateRandomCode();
		textMaKH.setText(code);
	}

	private void loadData() {
		int i = 0;
		String gioiTinh = "";
		for (KhachHang kh : kh_dao.getAllKhachHang()) {
			i++;
			if (kh.isGioiTinh() == true)
				gioiTinh = "Nam";
			else
				gioiTinh = "Nữ";
			Object[] row = { i, kh.getMaKhachHang(), kh.getTenKhachHang(), gioiTinh, kh.getTuoi(), kh.getSoDienThoai(),
					kh.getHinhAnhKhachHang() };
			model.addRow(row);
		}
	}

	private void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	private void xoaTrang() {
		loadMa();
		textTenKH.setText("");
		textSdt.setText("");
		rdoNam.setSelected(false);
		rdoNu.setSelected(false);
		textTuoi.setText("");
	}

	public void them() {
		String anh = "";
		if (rdoNam.isSelected()) {
			txtAnh.setIcon(new ImageIcon("image\\nhanvien_nam.png"));
			anh = "image\\nhanvien_nam.png";
		} else {
			txtAnh.setIcon(new ImageIcon("image\\nhanvien_nu.png"));
			anh = "image\\nhanvien_nu.png";
		}

		String ma = textMaKH.getText();
		String hoTen = textTenKH.getText();
		String sdt = textSdt.getText();

		boolean gt;
		if (rdoNam.isSelected())
			gt = true;
		else
			gt = false;

		int tuoi = Integer.parseInt(textTuoi.getText());
		if (!((sdt.length() > 0) && sdt.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(this, "Không được rỗng và số điện thoại phải có đủ 10 số");
		}
		KhachHang kh = new KhachHang(ma, hoTen, sdt, gt, tuoi, anh);
		if (kh_dao.addKhachHang(kh)) {
			JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công !");
			clearTable();
			xoaTrang();
			loadData();
			loadMa();
		}
	}

	public void xoa() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng muốn xóa !");
		} else if (table.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 khách hàng để xóa !");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này không?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int row = table.getSelectedRow();
				kh_dao.deleteKhachHang(model.getValueAt(row, 1).toString());
				model.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa thành công!!");
			}
		}
	}

	private void sua() {
		String anh = "";
		if (rdoNam.isSelected()) {
			txtAnh.setIcon(new ImageIcon("image\\nhanvien_nam.png"));
			anh = "image\\nhanvien_nam.png";
		} else {
			txtAnh.setIcon(new ImageIcon("image\\nhanvien_nu.png"));
			anh = "image\\nhanvien_nu.png";
		}

		String ma = textMaKH.getText();
		String hoTen = textTenKH.getText().trim();
		String sDT = textSdt.getText();

		boolean gt;
		if (rdoNam.isSelected())
			gt = true;
		else
			gt = false;
		int tuoi = Integer.valueOf(textTuoi.getText());

		KhachHang kh = new KhachHang(ma, hoTen, sDT, gt, tuoi, anh);
		if (kh_dao.updateKhachHang(kh)) {
			clearTable();
			loadData();
			JOptionPane.showMessageDialog(null, "Sữa thành công");
		} else
			JOptionPane.showMessageDialog(this, "Sửa không thành công");
	}

	public void tim() {
		if (comboBoxLoaiTim.getSelectedItem().equals("Tìm theo mã")) {
			KhachHang kh = null;
			kh = kh_dao.getKhachHangTheoMa(textTuKhoaTim.getText());
			if (kh != null) {
				textTenKH.setText(kh.getTenKhachHang());
				textSdt.setText(kh.getSoDienThoai());

				if (kh.isGioiTinh() == true)
					rdoNam.setSelected(true);
				else
					rdoNu.setSelected(true);

				String tuoi = String.valueOf(kh.getTuoi());
				textTuoi.setText(tuoi);
				txtAnh.setIcon(new ImageIcon(kh.getHinhAnhKhachHang()));
				textMaKH.setText(kh.getMaKhachHang());
			} else {
				JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng !");
			}
		} else if (comboBoxLoaiTim.getSelectedItem().equals("Tìm theo tên")) {
			ArrayList<KhachHang> dsKhachHang = kh_dao.getKhachHangTheoTen(textTuKhoaTim.getText());
			if (dsKhachHang != null) {
				for (KhachHang nv : dsKhachHang) {
					int firstSelectedRow = -1;
					for (int row = 0; row < table.getRowCount(); row++) {
						if (table.getValueAt(row, 2).equals(nv.getTenKhachHang())) {
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
		} else if (comboBoxLoaiTim.getSelectedItem().equals("Tìm theo số điện thoại")) {
			KhachHang kh = null;
			kh = kh_dao.getKhachHangTheoSDT(textTuKhoaTim.getText());
			if (kh != null) {
				textTenKH.setText(kh.getTenKhachHang());
				textSdt.setText(kh.getSoDienThoai());

				if (kh.isGioiTinh() == true)
					rdoNam.setSelected(true);
				else
					rdoNu.setSelected(true);

				String tuoi = String.valueOf(kh.getTuoi());
				textTuoi.setText(tuoi);
				txtAnh.setIcon(new ImageIcon(kh.getHinhAnhKhachHang()));
				textMaKH.setText(kh.getMaKhachHang());
			} else {
				JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(rdoNam)) {
			textMaKH.setText(null);
			loadMa();
			txtAnh.setIcon(new ImageIcon("image\\nhanvien_nam.png"));
		} else if (obj.equals(rdoNu)) {
			textMaKH.setText(null);
			loadMa();
			txtAnh.setIcon(new ImageIcon("image\\nhanvien_nu.png"));
		} else if (obj.equals(btnThem)) {
			them();
		} else if (obj.equals(btnXoaRong)) {
			xoaTrang();
		} else if (obj.equals(btnXoa)) {
			xoa();
		} else if (obj.equals(btnSua)) {
			sua();
		} else if (obj.equals(btnTim)) {
			table.clearSelection();
			tim();
		}
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
		int row = table.getSelectedRow();
		if (row != -1) {
			textTenKH.setText(model.getValueAt(row, 2).toString());
			textSdt.setText(model.getValueAt(row, 5).toString());
			if (model.getValueAt(row, 3).toString().equals("Nam"))
				rdoNam.setSelected(true);
			else
				rdoNu.setSelected(true);

			textTuoi.setText(model.getValueAt(row, 4).toString());
			txtAnh.setIcon(new ImageIcon(model.getValueAt(row, 6).toString()));
			textMaKH.setText(model.getValueAt(row, 1).toString());
		} else {
			// Xử lý trường hợp không có hàng nào được chọn
		}

	}
}
