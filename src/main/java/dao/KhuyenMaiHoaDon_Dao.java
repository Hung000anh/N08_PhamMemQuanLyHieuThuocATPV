package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Database;
import entity.KhuyenMaiHoaDon;


public class KhuyenMaiHoaDon_Dao {
    private static ArrayList<KhuyenMaiHoaDon> DanhSachKhuyenMaiHoaDon = new ArrayList<KhuyenMaiHoaDon>();
    
    public static ArrayList<KhuyenMaiHoaDon> docTubang() {
    	DanhSachKhuyenMaiHoaDon.clear();
        try {
            Connection con = Database.getInstance().getConnection();
            
            
            
            // Cập nhật trạng thái của các bản ghi có ngày kết thúc < ngày hiện tại
            java.util.Date ngayHienTai = new java.util.Date(); 
            String updateActiveSql = "UPDATE KhuyenMaiHoaDon SET trangThai = 1 WHERE ngayBatDau <= ? AND ngayKetThuc >= ? "; 
            PreparedStatement updateActiveStatement = con.prepareStatement(updateActiveSql);
            updateActiveStatement.setDate(1, new java.sql.Date(ngayHienTai.getTime()));
            updateActiveStatement.setDate(2, new java.sql.Date(ngayHienTai.getTime()));
            updateActiveStatement.executeUpdate();
            updateActiveStatement.close();
            
            // Cập nhật trạng thái của các bản ghi có ngày bắt đầu <= ngày hiện tại hoặc ngày kết thúc >= ngày hiện tại
            String updateUnActiveSql = "UPDATE KhuyenMaiHoaDon SET trangThai = 0 WHERE ngayBatDau >= ? OR ngayKetThuc <= ?"; 
            PreparedStatement updateUnActiveStatement = con.prepareStatement(updateUnActiveSql);
            updateUnActiveStatement.setDate(1, new java.sql.Date(ngayHienTai.getTime()));
            updateUnActiveStatement.setDate(2, new java.sql.Date(ngayHienTai.getTime()));
            updateUnActiveStatement.executeUpdate();
            updateUnActiveStatement.close();
            
            String sql = "SELECT * FROM KhuyenMaiHoaDon"; // Corrected table name
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            	String maKM = rs.getString(1);  
            	String tenKM = rs.getString(2);
            	Date ngayBatDau = rs.getDate(3);
            	Date ngayKetThuc = rs.getDate(4);;
            	Boolean loaiChuongTrinh = rs.getBoolean(5);
            	Boolean trangThai = rs.getBoolean(6);
            	Double giaTriHoaDon= rs.getDouble(7);
            	Double GiamGiaHoaDon = rs.getDouble(8);
                
            	KhuyenMaiHoaDon khuyenMaiHoaDon = new KhuyenMaiHoaDon(maKM, tenKM, ngayBatDau, ngayKetThuc, loaiChuongTrinh, trangThai, giaTriHoaDon, GiamGiaHoaDon);
            	DanhSachKhuyenMaiHoaDon.add(khuyenMaiHoaDon);
            	
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DanhSachKhuyenMaiHoaDon;
    }
    public static boolean themKhuyenMaiHoaDon(KhuyenMaiHoaDon k) {
        try (Connection con = Database.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("INSERT INTO KhuyenMaiHoaDon VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            
            // Thiết lập các giá trị cho câu lệnh truy vấn
            stmt.setString(1, k.getMaKM());
            stmt.setString(2, k.getTenKM());
            stmt.setDate(3, new java.sql.Date(k.getNgayBatDau().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setDate(4, new java.sql.Date(k.getNgayKetThuc().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setBoolean(5, k.getLoaiChuongTrinh());
            stmt.setBoolean(6, k.getTrangThai());
            stmt.setDouble(7, k.getGiaTriHoaDon());
            stmt.setDouble(8, k.getGiamGiaHoaDon());

            int n = stmt.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static KhuyenMaiHoaDon timKhuyenMai(String maKM)
    {
    	for(KhuyenMaiHoaDon km : DanhSachKhuyenMaiHoaDon)
    	{
    		if(km.getMaKM().equals(maKM))
    		{
    			return km;
    		}
    	}
    	return new KhuyenMaiHoaDon(maKM);
    }

    public void xoaKhuyenMai(String ma) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Database.getInstance().getConnection();
            String sql = "DELETE FROM KhuyenMaiHoaDon WHERE maKhuyenMai = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ma);
            stmt.executeUpdate();
           
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa khuyến mãi: " + e.getMessage());
        }
    }
    public boolean suaKhuyenMai(KhuyenMaiHoaDon kmhd) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Database.getInstance().getConnection();
            String sql = "UPDATE KhuyenMaiHoaDon SET tenKhuyenMai = ?, ngayBatDau = ?, ngayKetThuc = ?, loaiChuongTrinh = ?, trangThai = ?, giaTriHoaDon = ?, giamGiaHoaDon = ? WHERE maKhuyenMai = ?";
            stmt = con.prepareStatement(sql);
            
            // Set values using getters of KhuyenMaiHoaDon object
            stmt.setString(1, kmhd.getTenKM());
            stmt.setDate(2, new java.sql.Date(kmhd.getNgayBatDau().getTime()));
            stmt.setDate(3, new java.sql.Date(kmhd.getNgayKetThuc().getTime()));
            stmt.setBoolean(4, kmhd.getLoaiChuongTrinh());
            stmt.setBoolean(5, kmhd.getTrangThai());
            stmt.setDouble(6, kmhd.getGiaTriHoaDon());
            stmt.setDouble(7,kmhd.getGiamGiaHoaDon() / 100 );
            stmt.setString(8, kmhd.getMaKM());
            int n = stmt.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        } 
    }
}