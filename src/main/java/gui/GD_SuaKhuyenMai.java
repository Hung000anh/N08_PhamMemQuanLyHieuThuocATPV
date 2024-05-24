package gui;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import dao.KhuyenMaiHoaDon_Dao;
import dao.KhuyenMaiSanPham_Dao;
import dao.SanPham_Dao;
import entity.KhuyenMaiHoaDon;
import entity.KhuyenMaiSanPham;
import entity.SanPham;

public class GD_SuaKhuyenMai extends JFrame implements ItemListener, MouseListener{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtTenKhuyenMai;
    private JTextField txtMaKhuyenMai;
    private JTextField txtTuNgay;
    private JTextField txtDenNgay;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JComboBox<String> txtLoai;
    private JTextField txtGiaBan;
    private JTable table;
    private JTable table_1;
    private JTextField txtGiamGia;
    private JTextField txtGiaKhuyenMai;
    private String maKM;
	private String loaiKM;
	private boolean xacNhan;
	private JTextField txtGiamGiaHD;
	private JTextField txtGiaTriHD;
	private double giamGiaBanDau;


    public GD_SuaKhuyenMai(String maKM, String loaiKM) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setSize(1140 - 100, 865 - 100);
        
        JPanel tt_TimKiem = new JPanel();
        tt_TimKiem.setLayout(null);
        tt_TimKiem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                "Thông tin khuyến mãi", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20),
                Color.DARK_GRAY));
        tt_TimKiem.setBackground(SystemColor.window);
        tt_TimKiem.setBounds(10, 10, 1010, 160);
        contentPane.add(tt_TimKiem);

        JLabel lblTnKhuynMi = new JLabel("Tên khuyến mãi:");
        lblTnKhuynMi.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTnKhuynMi.setFont(new Font("Arial", Font.BOLD, 16));
        lblTnKhuynMi.setBounds(30, 92, 150, 30);
        tt_TimKiem.add(lblTnKhuynMi);

        txtTenKhuyenMai = new JTextField();
        txtTenKhuyenMai.setColumns(10);
        
        txtTenKhuyenMai.setBounds(190, 92, 250, 35);
        tt_TimKiem.add(txtTenKhuyenMai);

        JLabel lblMKhuynMi = new JLabel("Mã khuyến mãi:");
        lblMKhuynMi.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMKhuynMi.setFont(new Font("Arial", Font.BOLD, 16));
        lblMKhuynMi.setBounds(30, 44, 150, 30);
        tt_TimKiem.add(lblMKhuynMi);

        txtMaKhuyenMai = new JTextField();
        txtMaKhuyenMai.setEditable(false);
        txtMaKhuyenMai.setColumns(10);
        txtMaKhuyenMai.setBounds(190, 44, 250, 35);
        setMaKhuyenMai(maKM);
        tt_TimKiem.add(txtMaKhuyenMai);

        JLabel lblLoiChngTrnh = new JLabel("Loại chương trình:");
        lblLoiChngTrnh.setHorizontalAlignment(SwingConstants.LEFT);
        lblLoiChngTrnh.setFont(new Font("Arial", Font.BOLD, 16));
        lblLoiChngTrnh.setBounds(490, 92, 150, 30);
        tt_TimKiem.add(lblLoiChngTrnh);
        
        txtLoai = new JComboBox<>();
 
        txtLoai.setModel(new DefaultComboBoxModel<>(new String[] { "Khuyến mãi theo hóa đơn", "Khuyến mãi theo sản phẩm" }));
        txtLoai.setBounds(650, 92, 250, 32);
        setLoaiKhuyenMai(loaiKM);
        tt_TimKiem.add(txtLoai);
        

        // Vô hiệu hóa sửa đổi trên các trường txtMaKhuyenMai và txtLoai
        txtMaKhuyenMai.setEditable(false);

        JLabel lblTuNgay = new JLabel("Từ ngày:");
        lblTuNgay.setHorizontalAlignment(SwingConstants.LEFT);
        lblTuNgay.setFont(new Font("Arial", Font.BOLD, 16));
        lblTuNgay.setBounds(490, 44, 100, 30);
        tt_TimKiem.add(lblTuNgay);

        txtTuNgay = new JTextField();
        txtTuNgay.setColumns(10);
        txtTuNgay.setBounds(570, 44, 150, 30);
        tt_TimKiem.add(txtTuNgay);

        JLabel lblDenNgay = new JLabel("Đến ngày:");
        lblDenNgay.setHorizontalAlignment(SwingConstants.LEFT);
        lblDenNgay.setFont(new Font("Arial", Font.BOLD, 16));
        lblDenNgay.setBounds(740, 44, 100, 30);
        tt_TimKiem.add(lblDenNgay);

        txtDenNgay = new JTextField();
        txtDenNgay.setColumns(10);
        txtDenNgay.setBounds(830, 44, 150, 30);
        tt_TimKiem.add(txtDenNgay);
        
        
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        cardPanel.setLocation(10, 180);
        cardPanel.setSize(1006, 500);
        contentPane.add(cardPanel);

        JPanel panel1 = createPanel1("Khuyến mãi theo hóa đơn", Color.white);
        JPanel panel2 = createPanel2("Khuyến mãi theo sản phẩm", Color.white);

        if(loaiKM.equals("Khuyến mãi theo hóa đơn"))
        {
        	cardPanel.add(panel1, "Khuyến mãi theo hóa đơn");
            cardPanel.add(panel2, "Khuyến mãi theo sản phẩm");
        }
        else
        {
        	cardPanel.add(panel2, "Khuyến mãi theo sản phẩm");
        	cardPanel.add(panel1, "Khuyến mãi theo hóa đơn");

        }
        
        JButton btnLuu = new JButton("Lưu và áp dụng");
        btnLuu.setForeground(new Color(0, 0, 255));
        btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnLuu.setBounds(685, 690, 156, 31);
        contentPane.add(btnLuu);
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(txtTenKhuyenMai.getText().isEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "Tên khuyến mãi không được rỗng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
            	}
            	
            	
                String ngayBatDau = txtTuNgay.getText();
                String ngayKetThuc = txtDenNgay.getText();
                
                // Kiểm tra ngày bắt đầu
                if (!kiemTraNgayHopLe(ngayBatDau)) {
                    JOptionPane.showMessageDialog(null, "Ngày bắt đầu không đúng định dạng (dd/MM/yyyy)", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Kiểm tra ngày kết thúc
                if (!kiemTraNgayHopLe(ngayKetThuc)) {
                    JOptionPane.showMessageDialog(null, "Ngày kết thúc không đúng định dạng (dd/MM/yyyy)", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Chuyển đổi chuỗi ngày thành đối tượng LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate tuNgay = LocalDate.parse(ngayBatDau, formatter);
                LocalDate denNgay = LocalDate.parse(ngayKetThuc, formatter);

                // Kiểm tra ngày kết thúc phải lớn hơn ngày bắt đầu
                if (denNgay.isEqual(tuNgay) || denNgay.isBefore(tuNgay)) {
                    JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Kiểm tra ngày kết thúc phải lớn hơn ngày hiện tại
                if (denNgay.isBefore(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null, "Ngày kết thúc phải lớn hơn ngày hiện tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return; 
                }
                if (txtLoai.getSelectedItem().equals("Khuyến mãi theo hóa đơn")) 
                {
                	String giaTriHoaDonStr = txtGiaTriHD.getText();
                    if (!kiemTraSoThucDuong(giaTriHoaDonStr)) {
                        JOptionPane.showMessageDialog(null, "Giá trị hóa đơn phải là một số thực dương", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double giaTriHoaDon = Double.parseDouble(giaTriHoaDonStr);
                    // Kiểm tra giảm giá hóa đơn
                    String giamGiaHoaDonStr = txtGiamGiaHD.getText();
                    if (!kiemTraSoThucDuong(giamGiaHoaDonStr)) {
                        JOptionPane.showMessageDialog(null, "Giảm giá hóa đơn phải là một số thực dương", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double giamGiaHoaDon =  Double.parseDouble(giamGiaHoaDonStr);

                    if (giamGiaHoaDon > 100) {
                        JOptionPane.showMessageDialog(null, "Giảm giá hóa đơn không được lớn hơn 100", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    String maKM = txtMaKhuyenMai.getText();
                    String tenKM = txtTenKhuyenMai.getText();
                    Date ngayBatDau1 = null;
                    Date ngayKetThuc1 = null;
                    try {
                        ngayBatDau1 = new SimpleDateFormat("dd/MM/yyyy").parse(txtTuNgay.getText());
                        ngayKetThuc1 = new SimpleDateFormat("dd/MM/yyyy").parse(txtDenNgay.getText());
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    KhuyenMaiHoaDon khuyenMaiHoaDon = new KhuyenMaiHoaDon(maKM, tenKM, ngayBatDau1, ngayKetThuc1,  true, true, giaTriHoaDon, giamGiaHoaDon/100);            
                    // Gọi phương thức thêm khuyến mãi hóa đơn từ DAO
                    KhuyenMaiHoaDon_Dao khuyenMaiHoaDonDao = new KhuyenMaiHoaDon_Dao();
                    boolean result;
                    if(loaiKM.equals(txtLoai.getSelectedItem().toString()))
                    {
                    	result = khuyenMaiHoaDonDao.suaKhuyenMai(khuyenMaiHoaDon);
                    }
                    // Tạo đối tượng KhuyenMaiHoaDon
                    else
                    {
                    	KhuyenMaiSanPham_Dao kmsp_D = new KhuyenMaiSanPham_Dao();
                    	kmsp_D.xoaKhuyenMai(maKM);
                    	result = khuyenMaiHoaDonDao.themKhuyenMaiHoaDon(khuyenMaiHoaDon);
                    }
                    
                    
                    if(result) {
                        JOptionPane.showMessageDialog(null, "Sửa khuyến mãi hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa khuyến mãi hóa đơn thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }

                }
                else if(txtLoai.getSelectedItem().equals("Khuyến mãi theo sản phẩm")) {
                    if(!xacNhan) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn xác nhận trước khi lưu", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    } 
                    
                    // Lấy thông tin từ các trường nhập liệu hoặc các thành phần giao diện người dùng
                    String maKM = txtMaKhuyenMai.getText();
                    String tenKM = txtTenKhuyenMai.getText();
                    
                    // Chuyển đổi ngày từ String thành Date
                    Date ngayBatDau1 = null;
                    Date ngayKetThuc1 = null;
                    try {
                        ngayBatDau1 = new SimpleDateFormat("dd/MM/yyyy").parse(txtTuNgay.getText());
                        ngayKetThuc1 = new SimpleDateFormat("dd/MM/yyyy").parse(txtDenNgay.getText());
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    Double giamGiaSanPham = Double.parseDouble(txtGiamGia.getText());
                    
                    // Tạo đối tượng KhuyenMaiSanPham
                    KhuyenMaiSanPham khuyenMaiSanPham = new KhuyenMaiSanPham(maKM, tenKM, ngayBatDau1, ngayKetThuc1, true, true, giamGiaSanPham/100);
                    
                    // Gọi phương thức thêm khuyến mãi sản phẩm
                    KhuyenMaiSanPham_Dao khuyenMaiSanPhamDao = new KhuyenMaiSanPham_Dao();
                    boolean result;
                    if(loaiKM.equals(txtLoai.getSelectedItem().toString()))
                    {
                    	result = khuyenMaiSanPhamDao.suaKhuyenMai(khuyenMaiSanPham);
                    }
                    else
                    {
                    	KhuyenMaiHoaDon_Dao kmhd_D = new KhuyenMaiHoaDon_Dao();
                    	kmhd_D.xoaKhuyenMai(maKM);
                    	result = khuyenMaiSanPhamDao.themKhuyenMaiSanPham(khuyenMaiSanPham);
                    }
                  
                    
                    if(result) {
                       JOptionPane.showMessageDialog(null, "Sửa khuyến mãi sản phẩm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa khuyến mãi sản phẩm thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    
                    SanPham_Dao sanPhamDao = new SanPham_Dao();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
	                 int rowCount = model.getRowCount();
	                 for (int i = 0; i < rowCount; i++) {
	                     String maSanPham = model.getValueAt(i, 1).toString(); // Lấy mã sản phẩm từ cột thứ 2
	                     sanPhamDao.goMaKhuyenMaiChoSanPham(maSanPham, maKM); // Thêm sản phẩm vào cơ sở dữ liệu
	                 }
                    
                    
	                 // Ghi đè mã khuyến mãi cho các sản phẩm trong bảng table_1
	                 DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
	                 int rowCount1 = model1.getRowCount();
	                 for (int i = 0; i < rowCount1; i++) {
	                     String maSanPham = model1.getValueAt(i, 1).toString(); // Lấy mã sản phẩm từ cột thứ 2
	                     sanPhamDao.ghiDeMaKhuyenMaiChoSanPham(maSanPham, maKM); // Thêm sản phẩm vào cơ sở dữ liệu
	                 }
	
                     dispose();
                } 
            }
        });
        JButton btnDong = new JButton("Đóng");
        btnDong.setForeground(new Color(255, 0, 0));
        btnDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDong.setBounds(851, 690, 156, 31);
        contentPane.add(btnDong);
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị hộp thoại xác nhận
                int confirmed = JOptionPane.showConfirmDialog(null, 
                    "Bạn chắc chắn không? Nội dung bạn đã nhập sẽ bị mất.", 
                    "Xác nhận đóng", JOptionPane.YES_NO_OPTION);
                
                // Nếu người dùng chọn "Đồng ý"
                if (confirmed == JOptionPane.YES_OPTION) {
                    // Kết thúc giao diện Thêm sản phẩm
                    dispose();
                }
            }
        });
        
        txtLoai.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedPanel = (String) txtLoai.getSelectedItem();
                    if (selectedPanel.equals("Khuyến mãi theo hóa đơn")) {
                        cardLayout.show(cardPanel, "Khuyến mãi theo hóa đơn");
                    } else {
                        cardLayout.show(cardPanel, "Khuyến mãi theo sản phẩm");
                    }
                }
            }
        });

    } 
    public void setMaKhuyenMai(String maKM) {
        this.maKM = maKM;
        txtMaKhuyenMai.setText(maKM);
    }

    public void setLoaiKhuyenMai(String loaiKM) {
        this.loaiKM = loaiKM;
        if(loaiKM.equals("Khuyến mãi theo hóa đơn"))
            txtLoai.setSelectedIndex(0);
        else
        	txtLoai.setSelectedIndex(1);
    }
    
    
    private JPanel createPanel1(String name, Color color) {
            JPanel panel = new JPanel(null);
            panel.setBounds(0, 0, 1006, 538);
            panel.setBackground(color);

            JLabel lblGiaTriHD = new JLabel("Giá trị hóa đơn lớn hơn hoặc bằng");
            lblGiaTriHD.setFont(new Font("Arial", Font.BOLD, 16));
            lblGiaTriHD.setBounds(19, 31, 263, 30);
            panel.add(lblGiaTriHD);

            txtGiaTriHD = new JTextField();
            txtGiaTriHD.setBounds(302, 34, 166, 30);
            panel.add(txtGiaTriHD);

            JLabel lblVND = new JLabel("VND");
            lblVND.setFont(new Font("Arial", Font.BOLD, 16));
            lblVND.setBounds(478, 31, 50, 30);
            panel.add(lblVND);

            JLabel lblGiamGiaHD = new JLabel("Giảm giá hóa đơn");
            lblGiamGiaHD.setHorizontalAlignment(SwingConstants.RIGHT);
            lblGiamGiaHD.setFont(new Font("Arial", Font.BOLD, 16));
            lblGiamGiaHD.setBounds(19, 77, 263, 30);
            panel.add(lblGiamGiaHD);

            txtGiamGiaHD = new JTextField();
            txtGiamGiaHD.setBounds(302, 80, 166, 30);
            panel.add(txtGiamGiaHD); 

            JLabel lblPhanTram = new JLabel("%");
            lblPhanTram.setFont(new Font("Arial", Font.BOLD, 16));
            lblPhanTram.setBounds(488, 77, 50, 30);
            panel.add(lblPhanTram);

            TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                    "Giảm giá theo hóa đơn", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20),
                    Color.DARK_GRAY);
            panel.setBorder(border);
            dayDulieuTimKiemKMHD(name);
            return panel;
    }
    private JPanel createPanel2(String name, Color color) {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1006, 538);
        panel.setBackground(color);
        
        xacNhan = false;
        
        // Tạo và thiết lập TitledBorder cho panel
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                "Giảm giá theo sản phẩm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20),
                Color.DARK_GRAY);
        panel.setBorder(border);
        panel.setLayout(null);
        
        JLabel lbGiamGia = new JLabel("Giảm giá cho sản phẩm:");
        lbGiamGia.setFont(new Font("Arial", Font.BOLD, 16));
        lbGiamGia.setBounds(10, 39, 196, 30);
        panel.add(lbGiamGia); 
        
        txtGiamGia = new JTextField();
        txtGiamGia.setColumns(10);
        txtGiamGia.setBounds(201, 39, 86, 30);
        panel.add(txtGiamGia);

        
        JLabel lblNewLabel_1_1 = new JLabel("%");
        lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel_1_1.setBounds(292, 42, 20, 25);
        panel.add(lblNewLabel_1_1);

        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 82, 474, 408);
        panel.add(scrollPane);
        
        JButton btnXacNhan = new JButton("Xác nhận");
        btnXacNhan.setFont(new Font("Arial", Font.PLAIN, 16));
        btnXacNhan.setBounds(322, 44, 107, 21);
        panel.add(btnXacNhan);
        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtGiamGia.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập giảm giá", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return; // Tránh tiếp tục thực hiện khi không có giảm giá được nhập
                }
                
                // Kiểm tra xem giảm giá nhập vào có phải là số thực dương không
                if(!kiemTraSoThucDuong(txtGiamGia.getText())) {
                    JOptionPane.showMessageDialog(null, "Giảm giá sản phẩm phải là một số thực dương", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return; // Tránh tiếp tục thực hiện khi giảm giá không hợp lệ
                }
                
                double giamGiaCuoiCung = Double.parseDouble(txtGiamGia.getText());
                if(giamGiaBanDau != giamGiaCuoiCung) {
                    int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc không? Nếu đồng ý, giá bán mới sẽ thay đổi", "Xác nhận",  JOptionPane.YES_NO_OPTION);
                    if(option == JOptionPane.YES_OPTION) {
                        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                        for(int i = 0; i < model.getRowCount(); i++) {
                            String maSanPham = (String) model.getValueAt(i, 1); // Lấy mã sản phẩm từ hàng i
                            // Tìm sản phẩm trong danh sách sản phẩm với mã tương ứng
                            for(SanPham sp : SanPham_Dao.docTubang()) {
                                if(sp.getMaSP().equals(maSanPham)) {
                                    // Tính toán giá bán mới dựa trên giảm giá và giá nhập
                                    double donGiaNhap = sp.getDonGiaNhap();
                                    double donGiaBanMoi = donGiaNhap - (donGiaNhap * giamGiaCuoiCung/100);
                                    // Cập nhật giá bán mới trong bảng table_1
                                    model.setValueAt(donGiaBanMoi, i, 3);
                                    break; // Dừng vòng lặp khi đã tìm thấy sản phẩm tương ứng
                                }
                            }
                        }
                    }
                }
                
                txtGiamGia.setEditable(false);
                xacNhan = true; // xác nhận thay đổi
            }
        });
        

        
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		
        	},
        	new String[] {
        		"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn S\u1EA3n ph\u1EA9m", "Gi\u00E1 b\u00E1n"
        	}
        ));
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(556, 82, 440, 408);
        panel.add(scrollPane_1);
        
        table_1 = new JTable();
        scrollPane_1.setViewportView(table_1);
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {

        	},
        	new String[] {
        			"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn S\u1EA3n ph\u1EA9m", "Giá bán mới"
        	}
        ));
        
        JButton bttnChuyen = new JButton(">");
        bttnChuyen.setFont(new Font("Arial", Font.BOLD, 16));
        bttnChuyen.setBounds(494, 183, 45, 30);
        panel.add(bttnChuyen);
        
        JButton bttnThuHoi = new JButton("<");
        bttnThuHoi.setFont(new Font("Arial", Font.BOLD, 16));
        bttnThuHoi.setBounds(494, 236, 45, 30);
        panel.add(bttnThuHoi);
        
        
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        dayDulieuTimKiemKMSP(name);
        
        bttnChuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
            	
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần chuyển.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!xacNhan)
                {
                	JOptionPane.showMessageDialog(null, "Vui lòng xác nhận giảm giá", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(txtGiamGia.toString().isEmpty())
                {
                	JOptionPane.showMessageDialog(null, "Vui lòng nhập giảm giá", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                
                
                double giamGia = Double.parseDouble(txtGiamGia.getText());
                //System.out.println(giamGia);
                double giaHienTai = Double.parseDouble( table.getValueAt(row, 3).toString());
                Double giaKhuyenMai =  giaHienTai - giaHienTai* (giamGia/100);
                // Chuyển hàng từ table sang table_1
                DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                
                
                
                
                if (row != -1) {
                    // Lấy dữ liệu từ hàng được chọn của table
                    Object[] rowData = new Object[model.getColumnCount()];
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        rowData[i] = model.getValueAt(row, i);
                    }
                    // Chèn dữ liệu vào table_1
                    model1.addRow(rowData);
                    // Xóa hàng đã chọn khỏi table
                    model.removeRow(row);
                    // Cập nhật giá bán và giảm giá trong table_1
                    int newRow = model1.getRowCount() - 1;
                    // Lấy giá bán từ cột "Giá khuyến mãi" của hàng vừa thêm vào table_1
                    model1.setValueAt(decimalFormat.format(giaKhuyenMai), newRow, 3);
       
                }
            }
        });

        bttnThuHoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ số hàng được chọn từ table_1
            	if(xacNhan)
            	{
            		int row = table_1.getSelectedRow();
                    if (row == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần thu hồi.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    DefaultTableModel model_1 = (DefaultTableModel) table_1.getModel();
                    double giamGia = Double.parseDouble(txtGiamGia.getText());
                    double giaKhuyenMai =  Double.parseDouble( table_1.getValueAt(row, 3).toString());
                    double giaHienTai = giaKhuyenMai + giaKhuyenMai* giamGia/100;

                    // Thêm hàng đã chọn vào table
                    model.addRow(new Object[] { table_1.getValueAt(row, 0), table_1.getValueAt(row, 1), table_1.getValueAt(row, 2), decimalFormat.format(giaHienTai) });
                    
                    // Xóa hàng đã chọn từ table_1
                    
                    model_1.removeRow(row);
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "Vui lòng xác nhận giảm giá", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
            	}
                
                //txtGiamGia.setText("");
            }
        });
        return panel;
    }
    
    
    public void dayDulieuTimKiemKMSP(String str) {
        // Xóa dữ liệu cũ khỏi bảng table
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
        model.setRowCount(0);
        model1.setRowCount(0);
        
        KhuyenMaiSanPham_Dao kmspdao = new KhuyenMaiSanPham_Dao();
        ArrayList<KhuyenMaiSanPham> ds = kmspdao.docTubang();
        for (KhuyenMaiSanPham kmsp : ds) {
            if (kmsp.getMaKM().equals(txtMaKhuyenMai.getText())) {
                // Hiển thị thông tin chi tiết của khuyến mãi trong giao diện
                txtTenKhuyenMai.setText(kmsp.getTenKM());
                txtTuNgay.setText(kmsp.getNgayBatDau().toString());
                txtTenKhuyenMai.setText(kmsp.getTenKM());
    			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    			// Hiển thị ngày bắt đầu và kết thúc từ đối tượng KhuyenMaiHoaDon lên giao diện
    			txtTuNgay.setText(dateFormat.format(kmsp.getNgayBatDau()));
    			txtDenNgay.setText(dateFormat.format(kmsp.getNgayKetThuc()));
    			txtGiamGia.setText(String.valueOf(kmsp.getGiamGiaSanPham()*100));
    			giamGiaBanDau = Double.parseDouble(txtGiamGia.getText());
                SanPham_Dao spd = new SanPham_Dao();
                ArrayList<SanPham> dssp = spd.docTubang();
                //DefaultTableModel model1 = (DefaultTableModel) table.getModel();
                int stt1 = 0;
                int stt2 = 0;
                for (SanPham sp1 : dssp) {
                	
                	if(sp1.getKhuyenMai() != null)
                	{
                		if(sp1.getKhuyenMai().getMaKM().equals(txtMaKhuyenMai.getText()))
                    	{
                    	//System.out.println(sp1.getMaSP() + "MKM: " + sp1.getKhuyenMai().getMaKM());
                    		Object row[] = {stt1, sp1.getMaSP(), sp1.getTenSP(), sp1.getDonGiaBan()};
                            model1.addRow(row);
                            stt1++;
                    	}
                		else
                		{
                			Object row[] = {stt1, sp1.getMaSP(), sp1.getTenSP(), sp1.getDonGiaBan()};
                            model.addRow(row);
                            stt2++;
                		}
                	}
                	else
                	{
                		Object row[] = {stt2, sp1.getMaSP(), sp1.getTenSP(), sp1.getDonGiaBan()};
                		model.addRow(row);
                		stt2++;
                	}
                }
                // Sau khi tìm thấy và hiển thị thông tin, bạn có thể thoát vòng lặp
                return;
            }
        }
    }

    
    public void dayDulieuTimKiemKMHD(String str)
    {
    	KhuyenMaiHoaDon_Dao kmhddao = new KhuyenMaiHoaDon_Dao();
    	ArrayList<KhuyenMaiHoaDon> ds = kmhddao.docTubang();
    	for(KhuyenMaiHoaDon kmhd :  ds)
    	{
    		if (kmhd.getMaKM().equals(txtMaKhuyenMai.getText())) {
    			txtTenKhuyenMai.setText(kmhd.getTenKM());
    			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    			// Hiển thị ngày bắt đầu và kết thúc từ đối tượng KhuyenMaiHoaDon lên giao diện
    			txtTuNgay.setText(dateFormat.format(kmhd.getNgayBatDau()));
    			txtDenNgay.setText(dateFormat.format(kmhd.getNgayKetThuc()));
                txtGiaTriHD.setText(kmhd.getGiaTriHoaDon().toString());
                txtGiamGiaHD.setText(String.valueOf(kmhd.getGiamGiaHoaDon()*100));
    		}
    	}
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	private boolean kiemTraNgayHopLe(String ngay) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(ngay, formatter);
            return true;
        } catch (DateTimeParseException e) {
        	
            return false;
        }
    }
    //Kiểm tra số nguyên dương
    private boolean kiemTraSoThucDuong(String str) {
        if (str == null || str.isEmpty()) {
            return false; // Hoặc true tùy thuộc vào yêu cầu của ứng dụng
        }
        try {
            double number = Double.parseDouble(str);
            return number >= 0; // Số không âm là số dương hoặc số không
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
}
