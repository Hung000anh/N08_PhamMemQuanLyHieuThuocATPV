package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GD_KhuyenMai extends JPanel implements ActionListener, MouseListener {

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

    public GD_KhuyenMai() {
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
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1120, 410);
        panel_1.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	
        	},
        	new String[] {
        		"STT", "M\u00E3 Khuy\u1EBFn m\u00E3i", "T\u00EAn khuy\u1EBFn m\u00E3i", "Lo\u1EA1i ch\u01B0\u01A1ng tr\u00ECnh", "Ng\u00E0y b\u1EAFt \u0111\u1EA7u", "Ng\u00E0y k\u1EBFt th\u00FAc", "tr\u1EA1ng th\u00E1i"
        	}
        ));
        addSampleData();
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
        }

        if (o.equals(btnXemChiTiet)) {
        	int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Check if any row is selected
                // Get data from the selected row
                String maKM = table.getValueAt(selectedRow, 1).toString(); // Assume Mã khuyến mãi is at column index 1
                String loaiKM = table.getValueAt(selectedRow, 3).toString(); // Assume Loại chương trình is at column index 3

                // Open the edit interface and pass the data
                GD_XemChiTietKhuyenMai xemchitietKhuyenMai = new GD_XemChiTietKhuyenMai(maKM, loaiKM); // Assuming GD_SuaKhuyenMai is the name of your edit interface class
                xemchitietKhuyenMai.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần sửa!");
            }

        }
        if (o.equals(btnXoa)) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Check if any row is selected
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa hàng này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần xóa!");
            }
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
        model.setRowCount(0); // Xóa hết các dòng trong bảng
        addSampleData(); // Thêm dữ liệu mẫu ban đầu vào bảng
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
            String tenKM1 = (String) model.getValueAt(i, 2);
            String maKM1 = (String) model.getValueAt(i, 1);
            String loaiChuongTrinh = (String) model.getValueAt(i, 3);
            String ngayBatDau = (String) model.getValueAt(i, 4);
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


    
    private void addSampleData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Khuyến mãi theo hóa đơn
        model.addRow(new Object[] {1, "KM001", "Tết Nguyên Đán", "Khuyến mãi theo hóa đơn", "2024-01-20", "2024-02-05", "Kích hoạt"});
        model.addRow(new Object[] {2, "KM002", "Tết Trung Thu", "Khuyến mãi theo hóa đơn", "2024-09-10", "2024-09-25", "Không hoạt động"});
        model.addRow(new Object[] {3, "KM003", "Lễ Quốc Khánh", "Khuyến mãi theo hóa đơn", "2024-09-02", "2024-09-17", "Kích hoạt"});
        model.addRow(new Object[] {4, "KM004", "Lễ Phục Sinh", "Khuyến mãi theo hóa đơn", "2024-04-15", "2024-04-30", "Kích hoạt"});
        model.addRow(new Object[] {5, "KM005", "Ngày Nhà Giáo Việt Nam", "Khuyến mãi theo hóa đơn", "2024-11-20", "2024-12-05", "Không hoạt động"});
        model.addRow(new Object[] {6, "KM006", "Ngày Phụ Nữ Việt Nam", "Khuyến mãi theo hóa đơn", "2024-10-20", "2024-11-05", "Kích hoạt"});
        model.addRow(new Object[] {7, "KM007", "Ngày Thanh Niên Việt Nam", "Khuyến mãi theo hóa đơn", "2024-03-26", "2024-04-10", "Kích hoạt"});
        model.addRow(new Object[] {8, "KM008", "Ngày Thống Nhất", "Khuyến mãi theo hóa đơn", "2024-04-30", "2024-05-15", "Không hoạt động"});
        model.addRow(new Object[] {9, "KM009", "Ngày Quốc Tế Lao Động", "Khuyến mãi theo hóa đơn", "2024-05-01", "2024-05-16", "Kích hoạt"});
        model.addRow(new Object[] {10, "KM010", "Ngày Quốc Tế Phụ Nữ", "Khuyến mãi theo hóa đơn", "2024-03-08", "2024-03-23", "Không hoạt động"});
        model.addRow(new Object[] {11, "KM011", "Ngày Quốc Tế Thiếu Nhi", "Khuyến mãi theo hóa đơn", "2024-06-01", "2024-06-16", "Kích hoạt"});
        model.addRow(new Object[] {12, "KM012", "Ngày Quốc Tế Tình Bạn", "Khuyến mãi theo hóa đơn", "2024-07-30", "2024-08-14", "Kích hoạt"});
        model.addRow(new Object[] {13, "KM013", "Ngày Quốc Tế Hạnh Phúc", "Khuyến mãi theo hóa đơn", "2024-03-20", "2024-04-04", "Không hoạt động"});
        model.addRow(new Object[] {14, "KM014", "Ngày Quốc Tế Y Tế", "Khuyến mãi theo hóa đơn", "2024-04-07", "2024-04-22", "Kích hoạt"});
        model.addRow(new Object[] {15, "KM015", "Ngày Quốc Tế Trẻ Em Mất Cha Mẹ", "Khuyến mãi theo hóa đơn", "2024-06-01", "2024-06-16", "Kích hoạt"});

        // Khuyến mãi theo sản phẩm
        model.addRow(new Object[] {16, "KM016", "Lễ Tình Nhân", "Khuyến mãi theo sản phẩm", "2024-02-14", "2024-03-01", "Kích hoạt"});
        model.addRow(new Object[] {17, "KM017", "Giỗ Tổ Hùng Vương", "Khuyến mãi theo sản phẩm", "2024-04-10", "2024-04-25", "Không hoạt động"});
        model.addRow(new Object[] {18, "KM018", "Lễ Hội Đua Ngựa", "Khuyến mãi theo sản phẩm", "2024-03-25", "2024-04-09", "Kích hoạt"});
        model.addRow(new Object[] {19, "KM019", "Lễ Hội Đèn Đỏ", "Khuyến mãi theo sản phẩm", "2024-12-15", "2025-01-01", "Không hoạt động"});
        model.addRow(new Object[] {20, "KM020", "Lễ Hội Cà Phê", "Khuyến mãi theo sản phẩm", "2024-11-10", "2024-11-25", "Kích hoạt"});
        model.addRow(new Object[] {21, "KM021", "Lễ Hội Văn Hóa Dân Gian", "Khuyến mãi theo sản phẩm", "2024-04-20", "2024-05-05", "Không hoạt động"});
        model.addRow(new Object[] {22, "KM022", "Lễ Hội Lửa Và Nước", "Khuyến mãi theo sản phẩm", "2024-08-30", "2024-09-14", "Kích hoạt"});
        model.addRow(new Object[] {23, "KM023", "Lễ Hội Hoa Anh Đào", "Khuyến mãi theo sản phẩm", "2024-04-05", "2024-04-20", "Kích hoạt"});
        model.addRow(new Object[] {24, "KM024", "Lễ Hội Âm Nhạc", "Khuyến mãi theo sản phẩm", "2024-07-20", "2024-08-04", "Không hoạt động"});
        model.addRow(new Object[] {25, "KM025", "Lễ Hội Trăng Rằm", "Khuyến mãi theo sản phẩm", "2024-08-14", "2024-08-29", "Kích hoạt"});
        model.addRow(new Object[] {26, "KM026", "Lễ Hội Hoa Tulip", "Khuyến mãi theo sản phẩm", "2024-04-15", "2024-04-30", "Không hoạt động"});
        model.addRow(new Object[] {27, "KM027", "Lễ Hội Nghệ Thuật Đường Phố", "Khuyến mãi theo sản phẩm", "2024-11-05", "2024-11-20", "Kích hoạt"});
        model.addRow(new Object[] {28, "KM028", "Lễ Hội Biển", "Khuyến mãi theo sản phẩm", "2024-06-20", "2024-07-05", "Kích hoạt"});
        model.addRow(new Object[] {29, "KM029", "Lễ Hội Lồng Đèn", "Khuyến mãi theo sản phẩm", "2024-09-15", "2024-09-30", "Không hoạt động"});
        model.addRow(new Object[] {30, "KM030", "Lễ Hội Rượu Vang", "Khuyến mãi theo sản phẩm", "2024-12-20", "2025-01-05", "Kích hoạt"});
    }
}
