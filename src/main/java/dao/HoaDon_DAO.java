package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connectDB.Database;
import entity.*;


public class HoaDon_DAO {
    private static ArrayList<HoaDon> DanhSachHoaDon  = new ArrayList<HoaDon>();

    public HoaDon_DAO() {
    	docTubang();
    }

    public static ArrayList<HoaDon> docTubang() {
    	DanhSachHoaDon.clear();
        try {
            Connection con = Database.getInstance().getConnection();
            String sql = "SELECT * FROM HoaDon"; // Corrected table name
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            	String maHD = rs.getString(1); 
            	String maKhachHang = rs.getString(2);
            	KhachHang khachHang = new KhachHang(maKhachHang);
            	String maNV = rs.getString(3);
            	NhanVien nhanVien = NhanVien_Dao.getNhanVienTheoMa(maNV);
            	Date ngayXuat = rs.getDate(4);;
            	String loaiHD = rs.getString(5);
            	String ghiChu = rs.getString(6);
            	String maKhuyenMai = rs.getString(7);
            	
            	KhuyenMaiHoaDon_Dao ds = new KhuyenMaiHoaDon_Dao();
            	ds.docTubang();
            
            	HoaDon HoaDon = new HoaDon(maHD, khachHang, nhanVien, ngayXuat, loaiHD, ghiChu, ds.timKhuyenMai(maKhuyenMai));
            	DanhSachHoaDon.add(HoaDon);
            	
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DanhSachHoaDon;
    }

    // gọi docTuBang() trước
    public static HoaDon layHoaDonTheoMa(String maHD) {
    	for (HoaDon hd : DanhSachHoaDon) {
    		if (maHD.equals(hd.getMaHD()))
    			return hd;
    	}
    	return new HoaDon(maHD);
    }

    // gọi docTuBang() trước
    public static int laySLHoaDonTheoNgay(String ngay) {
    	int num = 0;
    	for (HoaDon hd : DanhSachHoaDon) {
    		java.util.Date date = hd.getNgayXuat();
            DateFormat dateFormat = new SimpleDateFormat("ddmmyy");  
            String strDate = dateFormat.format(date);
    		if (ngay.equals(strDate))
    			num++;
    	}
    	return num;
    }

    public static boolean them(HoaDon k) {
        try (Connection con = Database.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("INSERT INTO HoaDon VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            // Thiết lập các giá trị cho câu lệnh truy vấn
            stmt.setString(1, k.getMaHD());
            stmt.setString(2, k.getKhachHang().getMaKhachHang());
            stmt.setString(3, k.getNhanVien().getMaNV()); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setDate(4, new java.sql.Date(k.getNgayXuat().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setString(5, k.getLoaiHD());
            stmt.setString(6, k.getGhiChu());
            if (k.getKhuyenMai() == null)
            		stmt.setNull(7,  Types.VARCHAR);
            else
            		stmt.setString(7, k.getKhuyenMai().getMaKM());

            int n = stmt.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}