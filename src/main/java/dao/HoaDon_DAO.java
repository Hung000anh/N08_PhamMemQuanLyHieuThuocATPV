package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            	NhanVien nhanVien = (new NhanVien_Dao()).getNhanVienTheoMa(maNV);
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
    	return null;
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
}