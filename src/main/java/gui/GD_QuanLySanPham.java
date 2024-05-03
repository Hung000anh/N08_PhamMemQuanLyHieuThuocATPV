package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.Database;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.SanPham_Dao;
import entity.SanPham;

public class GD_QuanLySanPham extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private String col[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Đơn giá nhập", "Đơn giá bán", "Số lượng tồn",  "Ngày hết hạn", "Ngày sản xuất", "Đơn vị tính", "Mã khuyến mãi", "Hình Ảnh"};
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private JTextField txtTimKiem;
	private JTextField textNgaySX;
	private JTextField textLoaiSP;
	private JTextField txtMaSP;
	private JTextField textTenSP;
	private JTextField txtDonGiaNhap;
	private JTextField txtSoLuongTon;
	private JTextField txtDonGiaBan;
	private JTextField txtNgayHetHan;
	private JComboBox loai1;
	private JLabel txtAnh;
	private JComboBox comboBox;
	private String filePath;
	private JButton btnUser;


	public GD_QuanLySanPham() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140, 865);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1140, 60);
		panel.setBackground(new Color(187, 231, 252));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(0, 0, 1140, 60);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		btnUser = new JButton();
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialog_User user=new Dialog_User();
				user.setVisible(true);
			}
		});
		btnUser.setBackground(Color.decode("#B5E6FB"));
		btnUser.setBorderPainted(false);
		btnUser.setIcon(new ImageIcon("D://BaiTapLonPTUD_NHOM4//icon//icon_profile.png"));
		btnUser.setBounds(1092, 5, 45, 45);
		ImageIcon iconProfile = new ImageIcon("D://BaiTapLonPTUD_NHOM4//icon//icon_profile.png");
		iconProfile = new ImageIcon(iconProfile.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH));
		btnUser.setIcon(iconProfile);
		panel.add(btnUser);
		JPanel tt_KhachHang = new JPanel();
		tt_KhachHang.setBackground(SystemColor.window);
		tt_KhachHang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin sản phẩm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		tt_KhachHang.setBounds(10, 70, 1120, 250);
		add(tt_KhachHang);
		tt_KhachHang.setLayout(null);
		
		JLabel tenSP = new JLabel("Tên sản phẩm:");
		tenSP.setFont(new Font("Arial", Font.BOLD, 16));
		tenSP.setBounds(30, 92, 145, 30);
		tt_KhachHang.add(tenSP);
		
		textTenSP = new JTextField();
		textTenSP.setColumns(10);
		textTenSP.setBounds(185, 92, 220, 35);
		tt_KhachHang.add(textTenSP);
		
		JLabel maSP = new JLabel("Mã sản phẩm:");
		maSP.setFont(new Font("Arial", Font.BOLD, 16));
		maSP.setBounds(30, 44, 145, 30);
		tt_KhachHang.add(maSP);
		
		
		txtMaSP = new JTextField();
		txtMaSP.setEnabled(false);
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(185, 44, 220, 35);
		tt_KhachHang.add(txtMaSP);
		txtMaSP.setText(taoMaSP());
		
		JLabel loai = new JLabel("Loại sản phẩm:");
		loai.setFont(new Font("Arial", Font.BOLD, 16));
		loai.setBounds(30, 138, 145, 30);
		tt_KhachHang.add(loai);
		
		textLoaiSP = new JTextField();
		textLoaiSP.setColumns(10);
		textLoaiSP.setBounds(185, 138, 220, 35);
		tt_KhachHang.add(textLoaiSP);
		
		txtAnh = new JLabel("Thêm ảnh");
		txtAnh.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnh.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		txtAnh.setBackground(Color.LIGHT_GRAY);
		txtAnh.setBounds(865, 39, 220, 134);
		tt_KhachHang.add(txtAnh);
		
		txtAnh.addMouseListener(new MouseAdapter() {
		    

			@Override
		    public void mouseClicked(MouseEvent e) {
		        // Tạo một đối tượng JFileChooser
		        JFileChooser fileChooser = new JFileChooser();
		        
		        // Đặt bộ lọc cho các tệp được chọn (chỉ cho phép các tệp ảnh)
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg");
		        fileChooser.setFileFilter(filter);
		        
		        // Hiển thị hộp thoại chọn tệp và lấy kết quả trả về
		        int result = fileChooser.showOpenDialog(null);
		        
		        // Nếu người dùng chọn tệp và nhấn nút "Open" trong hộp thoại
		        if (result == JFileChooser.APPROVE_OPTION) {
		            // Lấy đường dẫn đến tệp đã chọn
		            filePath = fileChooser.getSelectedFile().getAbsolutePath();
		            

		            // Thiết lập hình ảnh cho JLabel từ đường dẫn tệp đã chọn
		            txtAnh.setIcon(new ImageIcon(filePath));
		        }
		    }
		});
		//txtAnh.setIcon(new ImageIcon("image//thuocVitamin.jpg"));
		
		JLabel ngaySX = new JLabel("Ngày sản xuất:");
		ngaySX.setFont(new Font("Arial", Font.BOLD, 16));
		ngaySX.setBounds(30, 183, 145, 30);
		tt_KhachHang.add(ngaySX);
		
		textNgaySX = new JTextField();
		textNgaySX.setColumns(10);
		textNgaySX.setBounds(185, 183, 220, 35);
		tt_KhachHang.add(textNgaySX);
		
		JLabel donViTinh = new JLabel("Đơn vị tính:");
		donViTinh.setFont(new Font("Arial", Font.BOLD, 16));
		donViTinh.setBounds(865, 183, 145, 30);
		tt_KhachHang.add(donViTinh);
		
		JLabel soLuongTon = new JLabel("Số lượng tồn:");
		soLuongTon.setFont(new Font("Arial", Font.BOLD, 16));
		soLuongTon.setBounds(452, 44, 145, 30);
		tt_KhachHang.add(soLuongTon);
		
		txtSoLuongTon = new JTextField();
		txtSoLuongTon.setColumns(10);
		txtSoLuongTon.setBounds(589, 41, 220, 35);
		tt_KhachHang.add(txtSoLuongTon);
		
		JLabel donGiaNhap = new JLabel("Đơn giá nhập:");
		donGiaNhap.setFont(new Font("Arial", Font.BOLD, 16));
		donGiaNhap.setBounds(452, 89, 145, 30);
		tt_KhachHang.add(donGiaNhap);
		
		txtDonGiaNhap = new JTextField();
		txtDonGiaNhap.setColumns(10);
		txtDonGiaNhap.setBounds(589, 89, 220, 35);
		tt_KhachHang.add(txtDonGiaNhap);
		
		JLabel donGiaban = new JLabel("Đơn giá bán:");
		donGiaban.setFont(new Font("Arial", Font.BOLD, 16));
		donGiaban.setBounds(452, 135, 145, 30);
		tt_KhachHang.add(donGiaban);
		
		txtDonGiaBan = new JTextField();
		txtDonGiaBan.setColumns(10);
		txtDonGiaBan.setEnabled(false);
		txtDonGiaBan.setBounds(589, 135, 220, 35);
		tt_KhachHang.add(txtDonGiaBan);
		
		JLabel ngayHH = new JLabel("Ngày hết hạn:");
		ngayHH.setFont(new Font("Arial", Font.BOLD, 16));
		ngayHH.setBounds(452, 180, 145, 30);
		tt_KhachHang.add(ngayHH);
		
		txtNgayHetHan = new JTextField();
		txtNgayHetHan.setColumns(10);
		txtNgayHetHan.setBounds(589, 183, 220, 35);
		tt_KhachHang.add(txtNgayHetHan);
		
		loai1 = new JComboBox();
		loai1.setModel(new DefaultComboBoxModel(new String[] {"Hộp", "Viên", "Vĩ", "Cái", "Chai", "Tuýp", "Cuộn"}));
		loai1.setFont(new Font("Arial", Font.BOLD, 16));
		loai1.setBounds(964, 183, 121, 35);
		tt_KhachHang.add(loai1);
		
		JPanel chucNang = new JPanel();
		chucNang.setLayout(null);
		chucNang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Chức năng", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		chucNang.setBackground(SystemColor.window);
		chucNang.setBounds(10, 330, 1120, 100);
		add(chucNang);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setToolTipText("thêm thông tin\r\n khách hàng");
		btnThem.setFont(new Font("Arial", Font.BOLD, 16));
		btnThem.setBounds(30, 38, 100, 40);
		btnThem.setBackground(Color.decode("#4db05e"));
		btnThem.setBorderPainted(false);
		chucNang.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Kiểm tra dữ liệu không được để trống
		        if (textTenSP.getText().isEmpty() || textLoaiSP.getText().isEmpty() ||
		            textNgaySX.getText().isEmpty() || txtDonGiaNhap.getText().isEmpty() ||
		            txtSoLuongTon.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin sản phẩm!");
		            return;
		        }
		        
		        // Kiểm tra định dạng ngày tháng 
		        String ngaySX = textNgaySX.getText();
		        
		        if (!ngaySX.matches("\\d{2}/\\d{2}/\\d{4}")) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày tháng theo định dạng dd/MM/yyyy!");
		            return; // Dừng thực thi nếu dữ liệu không hợp lệ
		        }
		        
		        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		        sdf.setLenient(false); // Không cho phép ngày tháng năm không hợp lệ
		        java.util.Date date1;
		        try {
		        	date1 = sdf.parse(ngaySX);
		            // Nếu không có ngoại lệ ném ra, có nghĩa là ngày tháng năm hợp lệ
		        } catch (ParseException ex) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày tháng theo định dạng dd/MM/yyyy!");
		            return; // Dừng thực thi nếu dữ liệu không hợp lệ
		        }
		        
		        String ngayHH = txtNgayHetHan.getText();
		        if (!ngayHH.matches("\\d{2}/\\d{2}/\\d{4}")) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày tháng theo định dạng dd/MM/yyyy!");
		            return; // Dừng thực thi nếu dữ liệu không hợp lệ
		        }
		        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		        sdf1.setLenient(false); // Không cho phép ngày tháng năm không hợp lệ
		        java.util.Date date2;
		        try {
		        	date2 = sdf1.parse(ngaySX);
		            // Nếu không có ngoại lệ ném ra, có nghĩa là ngày tháng năm hợp lệ
		        } catch (ParseException ex) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày tháng theo định dạng dd/MM/yyyy!");
		            return; // Dừng thực thi nếu dữ liệu không hợp lệ
		        }
		        
		        // Kiểm tra số lượng tồn và giá nhập không được chứa ký tự chữ
		        String soLuongTon = txtSoLuongTon.getText();
		        String giaNhap = txtDonGiaNhap.getText();
		        String donviTinh = loai1.getSelectedItem().toString();
		        if (!soLuongTon.matches("\\d*\\.?\\d+") || !giaNhap.matches("\\d*\\.?\\d+")) {
		            JOptionPane.showMessageDialog(null, "Số lượng tồn và giá nhập phải là số nguyên dương hoặc số thực!");
		            return;
		        }
		        Double dbGiaNhap = Double.parseDouble(giaNhap);
		        int intSoLuongTon = Integer.parseInt(soLuongTon);
		        Double dbGiaBan = dbGiaNhap + dbGiaNhap * 0.2;
		        SanPham sanPham = new SanPham(txtMaSP.getText(), textTenSP.getText(), textLoaiSP.getText(), date1, date2, dbGiaNhap, intSoLuongTon, dbGiaBan, filePath, donviTinh, null);
		        
		        // Tiến hành thêm sản phẩm vào cơ sở dữ liệu
		        SanPham_Dao spd = new SanPham_Dao();
		        spd.themSanPham(sanPham);
		        
		        // Đoạn mã thêm sản phẩm vào cơ sở dữ liệu ở đây
		        
		        // Sau khi thêm thành công, làm sạch các trường nhập liệu và cập nhật lại bảng
		        JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công!");
		        txtMaSP.setText(taoMaSP());
		        textTenSP.setText("");
		        textLoaiSP.setText("");
		        textNgaySX.setText("");
		        txtNgayHetHan.setText("");
		        txtDonGiaNhap.setText("");
		        txtSoLuongTon.setText("");
		        txtDonGiaBan.setText("");
		        loai1.setSelectedIndex(0);
		        txtTimKiem.setText("");
		        txtAnh.setIcon(null);
		        
		        // Cập nhật lại bảng
		        loadDataToTable();
		    }
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setToolTipText("");
		btnXoa.setFont(new Font("Arial", Font.BOLD, 16));
		btnXoa.setBorderPainted(false);
		btnXoa.setBackground(Color.decode("#ee1919"));
		btnXoa.setBounds(140, 38, 100, 40);
		chucNang.add(btnXoa);
		// Thêm ActionListener cho nút "Xóa"
		btnXoa.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Thực hiện các hoạt động xóa ở đây
		        // Ví dụ: hiển thị hộp thoại xác nhận trước khi xóa
		        int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
		        
		        // Nếu người dùng chọn "Yes"
		        if (choice == JOptionPane.YES_OPTION) {
		            // Thực hiện xóa (gọi phương thức xóa dữ liệu)
		            // Ví dụ: xóa sản phẩm có mã sản phẩm là "maSP"
		        	SanPham_Dao spd = new SanPham_Dao();
		            boolean result = spd.xoaSanPham(txtMaSP.getText()); // Thay "maSP" bằng mã sản phẩm thực tế
		            if (result) {
		                // Xóa thành công, thực hiện các hành động cập nhật UI hoặc hiển thị thông báo
		                JOptionPane.showMessageDialog(null, "Xóa thành công!");
		            } else {
		                // Xóa không thành công, hiển thị thông báo lỗi
		                JOptionPane.showMessageDialog(null, "Xóa không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		        loadDataToTable();
		    }
		    
		});
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setToolTipText("thêm thông tin\r\n khách hàng");
		btnSua.setFont(new Font("Arial", Font.BOLD, 16));
		btnSua.setBorderPainted(false);
		btnSua.setBackground(Color.decode("#26bfbf"));
		btnSua.setBounds(250, 38, 100, 40);
		chucNang.add(btnSua);
		btnSua.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	int selectedRow = table.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa!");
		            return;
		        }
		        // Kiểm tra dữ liệu không được để trống
		        if (textTenSP.getText().isEmpty() || textLoaiSP.getText().isEmpty() ||
		            textNgaySX.getText().isEmpty() || txtDonGiaNhap.getText().isEmpty() ||
		            txtSoLuongTon.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin sản phẩm!");
		            return;
		        } 
		        // Kiểm tra định dạng ngày tháng 
		        String ngayHH = txtNgayHetHan.getText();
		        String ngaySX = textNgaySX.getText();
		        
		        if (!ngaySX.matches("\\d{2}/\\d{2}/\\d{4}")) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày tháng theo định dạng dd/MM/yyyy!");
		            return; // Dừng thực thi nếu dữ liệu không hợp lệ
		        }
		        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		        sdf.setLenient(false); // Không cho phép ngày tháng năm không hợp lệ
		        java.util.Date date1;
		        try {
		        	date1 = sdf.parse(ngayHH);
		            // Nếu không có ngoại lệ ném ra, có nghĩa là ngày tháng năm hợp lệ
		        } catch (ParseException ex) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày tháng theo định dạng dd/MM/yyyy!");
		            return; // Dừng thực thi nếu dữ liệu không hợp lệ
		        }
		        
		        
		        if (!ngayHH.matches("\\d{2}/\\d{2}/\\d{4}")) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày tháng theo định dạng dd/MM/yyyy!");
		            return; // Dừng thực thi nếu dữ liệu không hợp lệ
		        }
		        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		        sdf1.setLenient(false); // Không cho phép ngày tháng năm không hợp lệ
		        java.util.Date date2;
		        try {
		        	date2 = sdf1.parse(ngaySX);
		            // Nếu không có ngoại lệ ném ra, có nghĩa là ngày tháng năm hợp lệ
		        } catch (ParseException ex) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày tháng theo định dạng dd/MM/yyyy!");
		            return; // Dừng thực thi nếu dữ liệu không hợp lệ
		        }
		        
		        // Kiểm tra số lượng tồn và giá nhập không được chứa ký tự chữ
		        String soLuongTon = txtSoLuongTon.getText();
		        String giaNhap = txtDonGiaNhap.getText();
		        String donviTinh = loai1.getSelectedItem().toString();
		        if (!soLuongTon.matches("\\d+") || !giaNhap.matches("\\d*\\.?\\d+")) {
		            JOptionPane.showMessageDialog(null, "Số lượng tồn và giá nhập phải là số nguyên dương hoặc số thực!");
		            return;
		        }
		        Double dbGiaNhap = Double.parseDouble(giaNhap);
		        int intSoLuongTon = Integer.parseInt(soLuongTon);
		        Double dbGiaBan = dbGiaNhap + dbGiaNhap * 0.2;
		        SanPham sanPham = new SanPham(txtMaSP.getText(), textTenSP.getText(), textLoaiSP.getText(), date1, date2, dbGiaNhap, intSoLuongTon, dbGiaBan , donviTinh, filePath , null);
//		        System.out.println(sanPham.getHinhAnhSanPham());
//		        System.out.println(filePath);
		        // Tiến hành thêm sản phẩm vào cơ sở dữ liệu
		        SanPham_Dao spd = new SanPham_Dao();
		        spd.suaSanPham(sanPham);
//		        
		        // Đoạn mã thêm sản phẩm vào cơ sở dữ liệu ở đây
		        
		        // Sau khi thêm thành công, làm sạch các trường nhập liệu và cập nhật lại bảng
		        JOptionPane.showMessageDialog(null, "Sửa sản phẩm thành công!");
		        txtMaSP.setText(taoMaSP());
		        textTenSP.setText("");
		        textLoaiSP.setText("");
		        textNgaySX.setText("");
		        txtNgayHetHan.setText("");
		        txtDonGiaNhap.setText("");
		        txtSoLuongTon.setText("");
		        txtDonGiaBan.setText("");
		        loai1.setSelectedIndex(0);
		        txtTimKiem.setText("");
		        txtAnh.setIcon(null);
		        
		        // Cập nhật lại bảng
		        loadDataToTable();
		    }
		});

		JButton btnTim = new JButton("Tìm");
		btnTim.setToolTipText("");
		btnTim.setFont(new Font("Arial", Font.BOLD, 16));
		btnTim.setBorderPainted(false);
		btnTim.setBackground(Color.decode("#4a83d7"));
		btnTim.setBounds(360, 38, 100, 40);
		chucNang.add(btnTim); 
		btnTim.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String searchKeyword = txtTimKiem.getText(); // Get the search keyword from the text field
		        String searchBy = comboBox.getSelectedItem().toString(); // Get the selected search option
		        
		        if(txtTimKiem.getText().isEmpty())
		        {
		        	//JOptionPane.showMessageDialog(null, "Vui lòng nhập tìm kiếm sản phẩm");
		        	loadDataToTable();
		        }
		        else {
		            if (searchBy.equals("Tìm theo mã")) {
		                timKiemTheoMaSP(searchKeyword);
		            } else if (searchBy.equals("Tìm theo tên")) {
		                timKiemTheoTenSP(searchKeyword);
		            } else if (searchBy.equals("Tìm theo số lượng tồn")) {
		                    int soLuongTon = Integer.parseInt(searchKeyword);
		                    if (soLuongTon > 0) {
		                        timKiemTheoSoLuongTon(searchKeyword);
		                    } else {
		                    	JOptionPane.showMessageDialog(null, "Vui lòng số lượng tồn là một số nguyên dương");
		    		            return; // Dừng thực thi nếu dữ liệu không hợp lệ
		                    }
		            
		            }	
		        }
		   }
		});

		
		JButton btnXoaRong = new JButton("Xóa rống");
		btnXoaRong .setToolTipText("");
		btnXoaRong .setFont(new Font("Arial", Font.BOLD, 16));
		btnXoaRong .setBorderPainted(false);
		btnXoaRong .setBackground(Color.decode("#4a83d7"));
		btnXoaRong .setBounds(470, 38, 120, 40);
		chucNang.add(btnXoaRong ); 
		btnXoaRong.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Xóa nội dung của các JTextField và JComboBox
	        	txtMaSP.setText(taoMaSP());
	            textTenSP.setText("");
	            textLoaiSP.setText("");
	            textNgaySX.setText("");
	            txtNgayHetHan.setText("");
	            txtDonGiaNhap.setText("");
	            txtSoLuongTon.setText("");
	            txtDonGiaBan.setText("");
	            loai1.setSelectedIndex(0); // Chọn lại item đầu tiên trong JComboBox
	            txtTimKiem.setText("");
	            // Xóa hình ảnh
	            txtAnh.setIcon(null);
	        }
	    });
		
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(631, 40, 220, 35);
		chucNang.add(txtTimKiem);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo tên", "Tìm theo số lượng tồn"}));
		comboBox.setBounds(880, 40, 210, 35);
		chucNang.add(comboBox);
		
		JLabel danhSach = new JLabel("Danh sách sản phẩm");
		danhSach.setHorizontalAlignment(SwingConstants.CENTER);
		danhSach.setFont(new Font("Arial", Font.BOLD, 20));
		danhSach.setBounds(10, 440, 1120, 60);
		add(danhSach);
		
		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		//table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setSelectionBackground(SystemColor.controlHighlight);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(0).setMaxWidth(60);
		scroll = new JScrollPane(table);
		//scroll.setFont(new Font("Arial", Font.BOLD, 25));
		scroll.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scroll.setBounds(10, 510, 1120, 335);
		add(scroll);
		
		table.addMouseListener(this);
		
		loadDataToTable();
	}
	private void loadDataToTable() {
	    SanPham_Dao sanPhamDao = new SanPham_Dao();
	    ArrayList<SanPham> danhSachSanPham = sanPhamDao.docTubang();
	    
	    while (model.getRowCount() > 0)
	    {
	        model.removeRow(0);
	    }
	    
	    int stt = 1;
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    for (SanPham sanPham : danhSachSanPham) {
	        String maKhuyenMai;
	        if (sanPham.getKhuyenMai() != null) {
	            maKhuyenMai = sanPham.getKhuyenMai().getMaKM();
	        } else {
	            maKhuyenMai = "NULL";
	        }
	        model.addRow(new Object[]{
	                stt++,
	                sanPham.getMaSP(),
	                sanPham.getTenSP(),
	                sanPham.getLoai(),
	                sanPham.getDonGiaNhap(),
	                sanPham.getDonGiaBan(),
	                sanPham.getSoluongTon(),
	                sdf.format(sanPham.getNgaySanXuat()), // Định dạng ngày thành "dd/mm/yyyy"
	                sdf.format(sanPham.getNgayHetHan()), // Định dạng ngày thành "dd/mm/yyyy"
	                sanPham.getDonViTinh(),
	                maKhuyenMai,
	                sanPham.getHinhAnhSanPham()
	        });
	    }
	}
        @Override
        public void mouseClicked(MouseEvent e) {
        	int row = table.getSelectedRow();
            if (row >= 0) {
                // Lấy dữ liệu từ hàng được chọn
                String maSP = table.getValueAt(row, 1).toString();
                String tenSP = table.getValueAt(row, 2).toString();
                String loaiSP = table.getValueAt(row, 3).toString();
                String donGiaNhap = table.getValueAt(row, 4).toString();
                String donGiaBan = table.getValueAt(row, 5).toString();
                String soLuongTon = table.getValueAt(row, 6).toString();
                String ngaySX = table.getValueAt(row, 8).toString();
                String ngayHH = table.getValueAt(row, 7).toString();
                String donViTinh = table.getValueAt(row, 9).toString();
                String hinhAnh = table .getValueAt(row, 11).toString();
                
                // Hiển thị dữ liệu lên các JLabel tương ứng
                txtMaSP.setText(maSP);
                textTenSP.setText(tenSP);
                textLoaiSP.setText(loaiSP);
                txtDonGiaNhap.setText(donGiaNhap);
                txtSoLuongTon.setText(soLuongTon);
                txtDonGiaBan.setText(donGiaBan); 
                textNgaySX.setText(ngaySX);
                txtNgayHetHan.setText(ngayHH);
                loai1.setSelectedItem(donViTinh);
                filePath = table.getValueAt(row, 11).toString();
                txtAnh.setIcon(new ImageIcon(hinhAnh));
                // Bạn có thể làm tương tự cho các trường dữ liệu khác nếu cần
            }
        }
        
        
        public String taoMaSP() {
            SanPham_Dao spd = new SanPham_Dao();
            ArrayList<SanPham> ds = spd.docTubang();
            String[] arrStrDat = new String[ds.size()];

            int demMa = 0;
            for(SanPham sp : ds) {
                arrStrDat[demMa] = sp.getMaSP();
                demMa++;
            }

            int soThuTuLonNhat = 0;

            if(arrStrDat.length == 0) {
                soThuTuLonNhat = 1;
            } else {
                for (int i = 0; i < arrStrDat.length; i++) {
                    String strMaSTT = arrStrDat[i].substring(2); // Lấy phần số thứ tự từ mã sản phẩm hiện có
                    int soThuTu = Integer.parseInt(strMaSTT);
                    if (soThuTu > soThuTuLonNhat) {
                        soThuTuLonNhat = soThuTu;
                    }
                }
            }
            soThuTuLonNhat++;
            String soThuTuFormatted = String.format("%03d", soThuTuLonNhat); // Định dạng số thứ tự thành 3 chữ số
            String maSanPham = "SP" + soThuTuFormatted;

            return maSanPham;
        }
        
     // Phương thức tìm kiếm theo MaSP (Mã sản phẩm)
        private void timKiemTheoMaSP(String tuKhoa) {
        	DefaultTableModel model = (DefaultTableModel) table.getModel();
        	while(model.getRowCount() > 0)
        		model.removeRow(0);
        	
        	
        	SanPham_Dao spd = new SanPham_Dao();
        	ArrayList<SanPham> ds = spd.docTubang();
        	int stt = 0;
        	for(SanPham sanPham : ds)
        	{
        		if(sanPham.getMaSP().contains(tuKhoa))
        		{

        		String maKhuyenMai;
        		if (sanPham.getKhuyenMai() != null) {
    	            maKhuyenMai = sanPham.getKhuyenMai().getMaKM();
    	        } else {
    	            maKhuyenMai = "NULL";
    	        }
    	        
	    	        model.addRow(new Object[]{
	    	                stt++,
	    	                sanPham.getMaSP(),
	    	                sanPham.getTenSP(),
	    	                sanPham.getLoai(),
	    	                sanPham.getDonGiaNhap(),
	    	                sanPham.getDonGiaBan(),
	    	                sanPham.getSoluongTon(),
	    	                sanPham.getNgayHetHan(),
	    	                sanPham.getNgaySanXuat(),
	    	                sanPham.getDonViTinh(),
	    	                maKhuyenMai,
	    	                sanPham.getHinhAnhSanPham()
	    	        });
        		}
        	}
        	
        }

        // Phương thức tìm kiếm theo TenSP (Tên sản phẩm)
        private void timKiemTheoTenSP(String tuKhoa) {
        	DefaultTableModel model = (DefaultTableModel) table.getModel();
        	while(model.getRowCount() > 0)
        		model.removeRow(0);
        	
        	
        	SanPham_Dao spd = new SanPham_Dao();
        	ArrayList<SanPham> ds = spd.docTubang();
        	int stt = 0;
        	for(SanPham sanPham : ds)
        	{
        		if(sanPham.getTenSP().contains(tuKhoa))
        		{

        		String maKhuyenMai;
        		if (sanPham.getKhuyenMai() != null) {
    	            maKhuyenMai = sanPham.getKhuyenMai().getMaKM();
    	        } else {
    	            maKhuyenMai = "NULL";
    	        }
    	        
	    	        model.addRow(new Object[]{
	    	                stt++,
	    	                sanPham.getMaSP(),
	    	                sanPham.getTenSP(),
	    	                sanPham.getLoai(),
	    	                sanPham.getDonGiaNhap(),
	    	                sanPham.getDonGiaBan(),
	    	                sanPham.getSoluongTon(),
	    	                sanPham.getNgayHetHan(),
	    	                sanPham.getNgaySanXuat(),
	    	                sanPham.getDonViTinh(),
	    	                maKhuyenMai,
	    	                sanPham.getHinhAnhSanPham()
	    	        });
        		}
        	}
        }

        // Phương thức tìm kiếm theo SoLuongTon (Số lượng tồn)
        private void timKiemTheoSoLuongTon(String tuKhoa) {
        	DefaultTableModel model = (DefaultTableModel) table.getModel();
        	while(model.getRowCount() > 0)
        		model.removeRow(0);
        	SanPham_Dao spd = new SanPham_Dao();
        	ArrayList<SanPham> ds = spd.docTubang();
        	int stt = 0;
        	for(SanPham sanPham : ds)
        	{
        		if(sanPham.getSoluongTon() == Integer.parseInt(tuKhoa))
        		{
        		String maKhuyenMai;
        		if (sanPham.getKhuyenMai() != null) {
    	            maKhuyenMai = sanPham.getKhuyenMai().getMaKM();
    	        } else {
    	            maKhuyenMai = "NULL";
    	        }
    	        model.addRow(new Object[]{
    	                stt++,
    	                sanPham.getMaSP(),
    	                sanPham.getTenSP(),
    	                sanPham.getLoai(),
    	                sanPham.getDonGiaNhap(),
    	                sanPham.getDonGiaBan(),
    	                sanPham.getSoluongTon(),
    	                sanPham.getNgayHetHan(),
    	                sanPham.getNgaySanXuat(),
    	                sanPham.getDonViTinh(),
    	                maKhuyenMai,
    	                sanPham.getHinhAnhSanPham()
    	        });
        		}
        	}
        	
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
			// TODO Auto-generated method stub
			
		}


}