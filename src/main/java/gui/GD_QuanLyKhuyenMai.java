package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.KhuyenMaiHoaDon_Dao;
import dao.KhuyenMaiSanPham_Dao;
import entity.KhuyenMaiHoaDon;
import entity.KhuyenMaiSanPham;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GD_QuanLyKhuyenMai extends JPanel implements ActionListener, MouseListener {

    private static final long serialVersionUID = 1L;
    private JTextField textTenKM;
    private JTextField textTKMaKM;
    private String col[] = {"STT", "Mã khuyến mãi", "Tên khuyến mãi", "Loại chương trình", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"};
    private DefaultTableModel model;
    private JTextField txtTuNgay;
    private JTextField txtDenNgay;
    private JRadioButton rdbtnKichhoat;
    private JRadioButton rdbtnTatCa;
    private JRadioButton rdbtnKhongHoatDong;

    private JButton btnThem;
    private JButton btnXoa;
    private JButton btnSua;
    private JButton btnXemChiTiet;
    private JButton btnTim;
    private JTable table;
	private JComboBox txtLoai;

    public GD_QuanLyKhuyenMai() {
        setBackground(new Color(246, 245, 255));
        setSize(1140, 865);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1140, 60);
        panel.setBackground(new Color(187, 231, 252));
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("QUẢN LÝ KHUYẾN MÃI");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
        lblNewLabel.setBounds(0, 0, 1140, 60);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel);

        JPanel tt_TimKiem = new JPanel();
        tt_TimKiem.setBackground(SystemColor.window);
        tt_TimKiem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                "Thông tin tìm kiếm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
        tt_TimKiem.setBounds(10, 70, 1120, 201);
        add(tt_TimKiem);
        tt_TimKiem.setLayout(null);

        JLabel tenKM = new JLabel("Tìm kiếm theo tên:");
        tenKM.setBounds(30, 92, 253, 30);
        tenKM.setHorizontalAlignment(SwingConstants.RIGHT);
        tenKM.setFont(new Font("Arial", Font.BOLD, 16));
        tt_TimKiem.add(tenKM);

        textTenKM = new JTextField();
        textTenKM.setBounds(293, 92, 250, 35);
        textTenKM.setColumns(10);
        tt_TimKiem.add(textTenKM);

        JLabel tbTKmaKM = new JLabel("Tìm kiếm theo mã:");
        tbTKmaKM.setBounds(30, 44, 253, 30);
        tbTKmaKM.setHorizontalAlignment(SwingConstants.RIGHT);
        tbTKmaKM.setFont(new Font("Arial", Font.BOLD, 16));
        tt_TimKiem.add(tbTKmaKM);

        textTKMaKM = new JTextField();
        textTKMaKM.setBounds(293, 44, 250, 35);
        textTKMaKM.setColumns(10);
        tt_TimKiem.add(textTKMaKM);

        JLabel lbTKLoai = new JLabel("Tìm kiếm theo loại chương trình:");
        lbTKLoai.setBounds(30, 138, 253, 30);
        lbTKLoai.setFont(new Font("Arial", Font.BOLD, 16));
        tt_TimKiem.add(lbTKLoai);

        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setFont(new Font("Arial", Font.BOLD, 16));
        lblTrangThai.setBounds(590, 44, 100, 30);
        tt_TimKiem.add(lblTrangThai);

        rdbtnKichhoat = new JRadioButton("Kích hoạt");
        rdbtnKichhoat.setFont(new Font("Arial", Font.BOLD, 16));
        rdbtnKichhoat.setBounds(788, 44, 120, 33);
        tt_TimKiem.add(rdbtnKichhoat);

        rdbtnKhongHoatDong = new JRadioButton("Không hoạt động");
        rdbtnKhongHoatDong.setFont(new Font("Arial", Font.BOLD, 16));
        rdbtnKhongHoatDong.setBounds(904, 44, 170, 33);
        tt_TimKiem.add(rdbtnKhongHoatDong);

        rdbtnTatCa = new JRadioButton("Tất cả");
        rdbtnTatCa.setFont(new Font("Arial", Font.BOLD, 16));
        rdbtnTatCa.setBounds(684, 44, 103, 33);
        tt_TimKiem.add(rdbtnTatCa);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtnKichhoat);
        bg.add(rdbtnKhongHoatDong);
        bg.add(rdbtnTatCa);
        rdbtnTatCa.setSelected(true);

        txtLoai = new JComboBox();
        txtLoai.setFont(new Font("Arial", Font.BOLD, 16));
        txtLoai.addItem("Tất cả");
        txtLoai.addItem("Khuyến mãi theo hóa đơn");
        txtLoai.addItem("Khuyến mãi theo sản phẩm");
        txtLoai.setBounds(293, 140, 250, 32);
        tt_TimKiem.add(txtLoai);

        JLabel lblTuNgay = new JLabel("Từ ngày:");
        lblTuNgay.setHorizontalAlignment(SwingConstants.LEFT);
        lblTuNgay.setFont(new Font("Arial", Font.BOLD, 16));
        lblTuNgay.setBounds(590, 92, 100, 30);
        tt_TimKiem.add(lblTuNgay);

        txtTuNgay = new JTextField();
        txtTuNgay.setBounds(684, 92, 150, 30);
        tt_TimKiem.add(txtTuNgay);
        txtTuNgay.setColumns(10);

        JLabel lblDenNgay = new JLabel("Đến ngày:");
        lblDenNgay.setHorizontalAlignment(SwingConstants.LEFT);
        lblDenNgay.setFont(new Font("Arial", Font.BOLD, 16));
        lblDenNgay.setBounds(590, 138, 100, 30);
        tt_TimKiem.add(lblDenNgay);

        txtDenNgay = new JTextField();
        txtDenNgay.setColumns(10);
        txtDenNgay.setBounds(684, 138, 150, 30);
        tt_TimKiem.add(txtDenNgay);

        JPanel chucNang = new JPanel();
        chucNang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Chức năng", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
        chucNang.setBackground(SystemColor.window);
        chucNang.setBounds(10, 281, 1120, 100);
        add(chucNang);
        chucNang.setLayout(null);

        btnThem = new JButton("Thêm khuyến mãi");
        btnThem.setBounds(40, 38, 200, 40);
        btnThem.setToolTipText("thêm thông tin\r\n khách hàng");
        btnThem.setFont(new Font("Arial", Font.BOLD, 16));
        btnThem.setBackground(Color.decode("#4db05e"));
        btnThem.setBorderPainted(false);
        chucNang.add(btnThem);

        btnXoa = new JButton("Xóa khuyến mãi");
        btnXoa.setBounds(250, 38, 200, 40);
        btnXoa.setToolTipText("");
        btnXoa.setFont(new Font("Arial", Font.BOLD, 16));
        btnXoa.setBorderPainted(false);
        btnXoa.setBackground(Color.decode("#ee1919"));
        chucNang.add(btnXoa);

        btnSua = new JButton("Sửa khuyến mãi");
        btnSua.setBounds(460, 38, 200, 40);
        btnSua.setToolTipText("thêm thông tin\r\n khách hàng");
        btnSua.setFont(new Font("Arial", Font.BOLD, 16));
        btnSua.setBorderPainted(false);
        btnSua.setBackground(Color.decode("#26bfbf"));
        chucNang.add(btnSua);

        btnTim = new JButton("Tìm kiếm");
        btnTim.setBounds(670, 38, 200, 40);
        btnTim.setToolTipText("");
        btnTim.setFont(new Font("Arial", Font.BOLD, 16));
        btnTim.setBorderPainted(false);
        btnTim.setBackground(Color.decode("#4a83d7"));
        chucNang.add(btnTim);

        btnXemChiTiet = new JButton("Xem chi tiết");
        btnXemChiTiet.setBounds(880, 38, 200, 40);
        btnXemChiTiet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnXemChiTiet.setToolTipText("");
        btnXemChiTiet.setFont(new Font("Arial", Font.BOLD, 16));
        btnXemChiTiet.setBorderPainted(false);
        btnXemChiTiet.setBackground(new Color(0, 255, 255));
        chucNang.add(btnXemChiTiet);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 391, 1120, 410);
        add(panel_1);
        panel_1.setLayout(null);
        
        
        JLabel danhSach = new JLabel("Danh sách khuyến mãi");
		danhSach.setHorizontalAlignment(SwingConstants.CENTER);
		danhSach.setFont(new Font("Arial", Font.BOLD, 20));
		danhSach.setBounds(0, 10 , 1120, 30);
		
		panel_1.add(danhSach);
        
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 50, 1120, 410);
        panel_1.add(scrollPane);
        
       
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	
        	},
        	new String[] {
        		"STT", "M\u00E3 Khuy\u1EBFn m\u00E3i", "T\u00EAn khuy\u1EBFn m\u00E3i", "Lo\u1EA1i ch\u01B0\u01A1ng tr\u00ECnh", "Ng\u00E0y b\u1EAFt \u0111\u1EA7u", "Ng\u00E0y k\u1EBFt th\u00FAc" ,"tr\u1EA1ng th\u00E1i", "Giảm giá"
        	}
        ));
        addData();
        scrollPane.setViewportView(table);
        model = new DefaultTableModel(col, 0);
        
        btnThem.addActionListener(this);
        btnXoa.addActionListener(this);
        btnSua.addActionListener(this);
        btnTim.addActionListener(this);
        btnXemChiTiet.addActionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnThem)) {
            // Open the new interface here
            GD_ThemKhuyenMai themKhuyenMai = new GD_ThemKhuyenMai(); // Assuming GD_ThemKhuyenMai is the name of your new interface class
            themKhuyenMai.setVisible(true);
            
            reloadDuLieuMau();
        }
        if (o.equals(btnSua)) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Check if any row is selected
                // Get data from the selected row
                String maKM = table.getValueAt(selectedRow, 1).toString(); // Assume Mã khuyến mãi is at column index 1
                String loaiKM = table.getValueAt(selectedRow, 3).toString(); // Assume Loại chương trình is at column index 3

                // Open the edit interface and pass the data
                GD_SuaKhuyenMai suaKhuyenMai = new GD_SuaKhuyenMai(maKM, loaiKM); // Assuming GD_SuaKhuyenMai is the name of your edit interface class
                suaKhuyenMai.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần sửa!");
            }
            
            reloadDuLieuMau();
        }

        if (o.equals(btnXemChiTiet)) {
        	int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Check if any row is selected
                // Get data from the selected row
                String maKM = table.getValueAt(selectedRow, 1).toString(); // Assume Mã khuyến mãi is at column index 1
                String loaiKM = table.getValueAt(selectedRow, 3).toString(); // Assume Loại chương trình is at column index 3

                // Open the edit interface and pass the data
             
                GD_XemChiTietKhuyenMai xemchitietKhuyenMai = new GD_XemChiTietKhuyenMai(maKM, loaiKM);
                xemchitietKhuyenMai.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần xem chi tiết!");
            }
            reloadDuLieuMau();
        }
        if (o.equals(btnXoa)) {
        	KhuyenMaiSanPham_Dao ds1 = new KhuyenMaiSanPham_Dao();
            KhuyenMaiHoaDon_Dao ds2 = new KhuyenMaiHoaDon_Dao();
        	
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Check if any row is selected
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa hàng này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                	if(table.getValueAt(selectedRow, 3).toString().equals("Khuyến mãi theo hóa đơn"))
                	{
                		ds2.xoaKhuyenMai(table.getValueAt(selectedRow, 1).toString());             
                	}
                	else if (table.getValueAt(selectedRow, 3).toString().equals("Khuyến mãi theo sản phẩm"))
                	{
                		ds1.xoaKhuyenMai(table.getValueAt(selectedRow, 1).toString());
                	}
                	JOptionPane.showMessageDialog(this, "Xóa khuyến mãi thành công!");
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);    
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần xóa!");
            }
            //reloadDuLieuMau();
        }
        if (o.equals(btnTim)) {
        	//lấy lại dữ liệu cữ
        	reloadDuLieuMau();
            // Lấy giá trị từ các ô nhập liệu
        	timKiemKhuyenMai();
        }

    }
    private void reloadDuLieuMau() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        while(model.getRowCount() > 0)
        	model.setRowCount(0); // Xóa hết các dòng trong bảng
        addData(); // Thêm dữ liệu mẫu ban đầu vào bảng
    }
    private void timKiemKhuyenMai() {
        // Lấy giá trị từ các ô nhập liệu
        String tenKM = textTenKM.getText();
        String maKM = textTKMaKM.getText();
        String tuNgay = txtTuNgay.getText();
        String denNgay = txtDenNgay.getText();

        // Xác định giá trị của trạng thái từ các radio button
        String trangThai = "";
        if (rdbtnKichhoat.isSelected()) {
            trangThai = "Kích hoạt";
        } else if (rdbtnKhongHoatDong.isSelected()) {
            trangThai = "Không hoạt động";
        }

        // Lọc dữ liệu từ bảng dựa trên các điều kiện đã xác định
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            
            String maKM1 = (String) model.getValueAt(i, 1);
            String tenKM1 = (String) model.getValueAt(i, 2);
            String loaiChuongTrinh = (String) model.getValueAt(i, 3);
//            java.sql.Date date = (java.sql.Date) model.getValueAt(i, 4);
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày theo ý muốn
            String ngayBatDau = (String) model.getValueAt(i, 3); 
            
//            java.sql.Date date2 = (java.sql.Date) model.getValueAt(i, 5);
           
            String ngayKetThuc = (String) model.getValueAt(i, 5); 
            String trangThai1 = (String) model.getValueAt(i, 6);

            // Áp dụng các điều kiện lọc
            boolean tenKMMatch = tenKM.isEmpty() || tenKM1.contains(tenKM);
            boolean maKMMatch = maKM.isEmpty() || maKM1.contains(maKM);
            boolean loaiChuongTrinhMatch = txtLoai.getSelectedItem().equals("Tất cả") || loaiChuongTrinh.equals(txtLoai.getSelectedItem());
            boolean ngayBatDauMatch = tuNgay.isEmpty() || ngayBatDau.equals(tuNgay);
            boolean ngayKetThucMatch = denNgay.isEmpty() || ngayKetThuc.equals(denNgay);
            boolean trangThaiMatch = (rdbtnTatCa.isSelected() || (rdbtnKichhoat.isSelected() && trangThai1.equals("Kích hoạt")) || (rdbtnKhongHoatDong.isSelected() && trangThai1.equals("Không hoạt động")));

            // Kiểm tra xem hàng có đáp ứng điều kiện lọc không, nếu không thì loại bỏ hàng đó khỏi bảng
            if (!(tenKMMatch && maKMMatch && loaiChuongTrinhMatch && ngayBatDauMatch && ngayKetThucMatch && trangThaiMatch)) {
                model.removeRow(i);
            }
        }
    }


    
    private void addData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
       
        
        KhuyenMaiSanPham_Dao ds1 = new KhuyenMaiSanPham_Dao();
        ArrayList<KhuyenMaiSanPham> data1 = ds1.docTubang();
        
        KhuyenMaiHoaDon_Dao ds2 = new KhuyenMaiHoaDon_Dao();
        ArrayList<KhuyenMaiHoaDon> data2 = ds2.docTubang();
        
        String TrangThai;
        String LoaiChuongTrinh;
        String giamGia;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int i = 0;
        for(KhuyenMaiSanPham km : data1)
        {
        	if(km.getTrangThai())
        		TrangThai = "Kích hoạt";
        	else
        		TrangThai = "Không hoạt động";
        	
        	
        	LoaiChuongTrinh = "Khuyến mãi theo sản phẩm";
        	giamGia = km.getGiamGiaSanPham()*100 + "%";
    
    		Object[] rowData = { i, km.getMaKM(), km.getTenKM(),LoaiChuongTrinh, dateFormat.format(km.getNgayBatDau()), dateFormat.format(km.getNgayKetThuc()), TrangThai, giamGia};
    		model.addRow(rowData);
        	i++;
        }
        for(KhuyenMaiHoaDon km : data2)
        {
        	if(km.getTrangThai())
        		TrangThai = "Kích hoạt";
        	else
        		TrangThai = "Không hoạt động";
        	
        	
        	LoaiChuongTrinh = "Khuyến mãi theo hóa đơn";
        	giamGia = km.getGiamGiaHoaDon()*100 + "%";
        	
			// Hiển thị ngày bắt đầu và kết thúc từ đối tượng KhuyenMaiHoaDon lên giao diện
    		Object[] rowData = { i, km.getMaKM(), km.getTenKM(),LoaiChuongTrinh, dateFormat.format(km.getNgayBatDau()), dateFormat.format(km.getNgayKetThuc()), TrangThai, giamGia};
    		model.addRow(rowData);
        	i++;
        }

    }
}