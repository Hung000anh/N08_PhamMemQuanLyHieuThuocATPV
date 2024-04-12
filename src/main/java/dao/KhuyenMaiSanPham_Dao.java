package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Database;
import entity.KhuyenMaiSanPham;
import entity.SanPham;


public class KhuyenMaiSanPham_Dao {
    private ArrayList<KhuyenMaiSanPham> DanhSachKhuyenMaiSanPham;
    
    public KhuyenMaiSanPham_Dao() {
    	DanhSachKhuyenMaiSanPham = new ArrayList<KhuyenMaiSanPham>();
    }
    
    public ArrayList<KhuyenMaiSanPham> docTubang() {
        try {
            Connection con = Database.getInstance().getConnection();
            String sql = "SELECT * FROM KhuyenMaiSanPham"; // Corrected table name
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            	String maKM = rs.getString(1); 
            	String tenKM = rs.getString(2);
            	Date ngayBatDau = rs.getDate(3);
            	Date ngayKetThuc = rs.getDate(4);;
            	Boolean loaiChuongTrinh = rs.getBoolean(5);
            	Boolean trangThai = rs.getBoolean(6);
            	Double giamGiaSanPham = rs.getDouble(7);
                
            	KhuyenMaiSanPham khuyenMaiSanPham = new KhuyenMaiSanPham(maKM, tenKM, ngayBatDau, ngayKetThuc, loaiChuongTrinh, trangThai, giamGiaSanPham);
            	DanhSachKhuyenMaiSanPham.add(khuyenMaiSanPham);
            	
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DanhSachKhuyenMaiSanPham;
    }
    public boolean themKhuyenMaiSanPham(KhuyenMaiSanPham k) {
        try (Connection con = Database.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("INSERT INTO KhuyenMaiSanPham VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            
            // Thiết lập các giá trị cho câu lệnh truy vấn
            stmt.setString(1, k.getMaKM());
            stmt.setString(2, k.getTenKM());
            stmt.setDate(3, new java.sql.Date(k.getNgayBatDau().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setDate(4, new java.sql.Date(k.getNgayKetThuc().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setBoolean(5, k.getLoaiChuongTrinh());
            stmt.setBoolean(6, k.getTrangThai());
            stmt.setDouble(7, k.getGiamGiaSanPham());

            int n = stmt.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
