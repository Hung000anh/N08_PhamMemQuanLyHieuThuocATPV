package gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.KhuyenMaiHoaDon_Dao;
import dao.KhuyenMaiSanPham_Dao;
import dao.SanPham_Dao;
import entity.KhuyenMaiHoaDon;
import entity.KhuyenMaiSanPham;
import entity.SanPham;

public class GD_XemChiTietKhuyenMai extends JFrame implements ItemListener, MouseListener{
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
	private JTextField txtGiaTriHD;
	private JTextField txtGiamGiaHD;


    public GD_XemChiTietKhuyenMai(String maKM, String loaiKM) {
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
        txtTenKhuyenMai.setEditable(false);
        
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
        txtMaKhuyenMai.setEditable(false);

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
        txtLoai.setEnabled(false);

        // Vô hiệu hóa sửa đổi trên các trường txtMaKhuyenMai và txtLoai
        
        JLabel lblTuNgay = new JLabel("Từ ngày:");
        lblTuNgay.setHorizontalAlignment(SwingConstants.LEFT);
        lblTuNgay.setFont(new Font("Arial", Font.BOLD, 16));
        lblTuNgay.setBounds(490, 44, 100, 30);
        tt_TimKiem.add(lblTuNgay);

        txtTuNgay = new JTextField();
        txtTuNgay.setColumns(10);
        txtTuNgay.setBounds(570, 44, 150, 30);
        tt_TimKiem.add(txtTuNgay);
        txtTuNgay.setEditable(false);

        JLabel lblDenNgay = new JLabel("Đến ngày:");
        lblDenNgay.setHorizontalAlignment(SwingConstants.LEFT);
        lblDenNgay.setFont(new Font("Arial", Font.BOLD, 16));
        lblDenNgay.setBounds(740, 44, 100, 30);
        tt_TimKiem.add(lblDenNgay);

        txtDenNgay = new JTextField();
        txtDenNgay.setColumns(10);
        txtDenNgay.setBounds(830, 44, 150, 30);
        tt_TimKiem.add(txtDenNgay);
        txtDenNgay.setEditable(false);
        
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
        
        
        JButton btnDong = new JButton("Đóng");
        btnDong.setForeground(new Color(255, 0, 0));
        btnDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDong.setBounds(851, 690, 156, 31);
        contentPane.add(btnDong);
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    dispose();
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
            txtGiaTriHD.setEditable(false);
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
            txtGiamGiaHD.setEditable(false);
            txtGiamGiaHD.setBounds(302, 80, 166, 30);
            panel.add(txtGiamGiaHD); 

            JLabel lblPhanTram = new JLabel("%");
            lblPhanTram.setFont(new Font("Arial", Font.BOLD, 16));
            lblPhanTram.setBounds(488, 77, 50, 30);
            panel.add(lblPhanTram);

            TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                    "Khuyến mãi theo hóa đơn", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20),
                    Color.DARK_GRAY);
            panel.setBorder(border);
            dayDulieuTimKiemKMHD(name);
            return panel;
            
            
    }
    private JPanel createPanel2(String name, Color color) {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1006, 538);
        panel.setBackground(color);
        
        // Tạo và thiết lập TitledBorder cho panel
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                "Khuyến mãi theo sản phẩm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20),
                Color.DARK_GRAY);
        panel.setBorder(border);
        panel.setLayout(null);
        
        JLabel lbGiamGia = new JLabel("Giảm giá cho sản phẩm:");
        lbGiamGia.setFont(new Font("Arial", Font.BOLD, 16));
        lbGiamGia.setBounds(10, 30, 196, 30);
        panel.add(lbGiamGia); 
        
        txtGiamGia = new JTextField();
        txtGiamGia.setColumns(10);
        txtGiamGia.setBounds(200, 30, 86, 30);
        txtGiamGia.setEditable(false);
        panel.add(txtGiamGia);

        
        JLabel lblNewLabel_1_1 = new JLabel("%");
        lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel_1_1.setBounds(300, 30, 20, 25);
        panel.add(lblNewLabel_1_1);

        
        // Create a table with appropriate columns
        String[] columns = {"Mã SP", "Tên SP", "Loại SP", "Ngày hết hạn", "Ngày sản xuất", "Số lượng tồn", "Đơn Giá bán"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model); // Khởi tạo biến table ở mức lớp
        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 60, 986, 426);
        panel.add(scrollPane);

        // Additional components can be added here if needed
        dayDulieuTimKiemKMSP();
        
        // Additional components can be added here if needed 
        dayDulieuTimKiemKMSP();
        return panel;
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
	public void dayDulieuTimKiemKMSP() {
        // Xóa dữ liệu cũ khỏi bảng table
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        KhuyenMaiSanPham_Dao kmspdao = new KhuyenMaiSanPham_Dao();
        ArrayList<KhuyenMaiSanPham> ds = kmspdao.docTubang();
        for (KhuyenMaiSanPham sp : ds) {
            if (sp.getMaKM().equals(txtMaKhuyenMai.getText())) {
                // Hiển thị thông tin chi tiết của khuyến mãi trong giao diện
                txtTenKhuyenMai.setText(sp.getTenKM());
                txtTuNgay.setText(sp.getNgayBatDau().toString());
                txtDenNgay.setText(sp.getNgayBatDau().toString());
                txtGiamGia.setText(sp.getGiamGiaSanPham().toString());
                SanPham_Dao spd = new SanPham_Dao();
                ArrayList<SanPham> dssp = spd.docTubang();
                //DefaultTableModel model1 = (DefaultTableModel) table.getModel();
                for (SanPham sp1 : dssp) {
                	if(sp1.getKhuyenMai() != null && sp1.getKhuyenMai().getMaKM().equals(txtMaKhuyenMai.getText()))
                	{
                	//System.out.println(sp1.getMaSP() + "MKM: " + sp1.getKhuyenMai().getMaKM());
                		Object row[] = {sp1.getMaSP(), sp1.getTenSP(), sp1.getLoai(), sp1.getNgayHetHan(), sp1.getNgaySanXuat(), sp1.getSoluongTon(), sp1.getDonGiaBan()};
                        model.addRow(row);
                	}       	
                }
                // Sau khi tìm thấy và hiển thị thông tin, bạn có thể thoát vòng lặp
                return;
            }
        }
        // Nếu không tìm thấy khuyến mãi, bạn có thể thông báo cho người dùng hoặc thực hiện các xử lý khác tùy ý
        //JOptionPane.showMessageDialog(null, "Không tìm thấy khuyến mãi có mã: " + txtMaKhuyenMai.getText());
    }

    
    public void dayDulieuTimKiemKMHD(String str)
    {
    	KhuyenMaiHoaDon_Dao kmhddao = new KhuyenMaiHoaDon_Dao();
    	ArrayList<KhuyenMaiHoaDon> ds = kmhddao.docTubang();
    	for(KhuyenMaiHoaDon kmhd :  ds)
    	{
    		if (kmhd.getMaKM().equals(txtMaKhuyenMai.getText())) {
    			txtTenKhuyenMai.setText(kmhd.getTenKM());
                txtTuNgay.setText(kmhd.getNgayBatDau().toString());
                txtDenNgay.setText(kmhd.getNgayBatDau().toString());
                txtGiaTriHD.setText(kmhd.getGiaTriHoaDon().toString());
                txtGiamGiaHD.setText(kmhd.getGiamGiaHoaDon().toString());
    		}
    	}
    }
}
