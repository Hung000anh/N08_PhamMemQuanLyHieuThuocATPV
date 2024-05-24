package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Database;
import entity.ChiTietHoaDon;
import entity.KhuyenMaiHoaDon;
import entity.KhuyenMaiSanPham;
import entity.SanPham;


public class KhuyenMaiSanPham_Dao {
    private static ArrayList<KhuyenMaiSanPham> DanhSachKhuyenMaiSanPham = new ArrayList<KhuyenMaiSanPham>();

    public KhuyenMaiSanPham_Dao() {
    	docTubang();
    }

    public static ArrayList<KhuyenMaiSanPham> docTubang() {
    	DanhSachKhuyenMaiSanPham.clear();

        try {
            Connection con = Database.getInstance().getConnection();
            
            java.util.Date ngayHienTai = new java.util.Date();
             
            // Cập nhật trạng thái của các bản ghi có ngày bắt đầu <= ngày hiện tại và ngày kết thúc >= ngày hiện tại
            String updateActiveSql = "UPDATE KhuyenMaiSanPham SET trangThai = 1 WHERE ngayBatDau <= ? AND ngayKetThuc >= ? AND trangThai = 0"; 
            PreparedStatement updateActiveStatement = con.prepareStatement(updateActiveSql);
            updateActiveStatement.setDate(1, new java.sql.Date(ngayHienTai.getTime()));
            updateActiveStatement.setDate(2, new java.sql.Date(ngayHienTai.getTime()));
            updateActiveStatement.executeUpdate();
            updateActiveStatement.close();
            
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
    public static boolean themKhuyenMaiSanPham(KhuyenMaiSanPham k) {
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

    // gọi docTuBang() trước
    public static KhuyenMaiSanPham layKhuyenMaiSanPhamTheoMa(String id) {
    	for (KhuyenMaiSanPham e : DanhSachKhuyenMaiSanPham) {
    		if (id.equals(e.getMaKM()))
    			return e;
    	}
    	return new KhuyenMaiSanPham(id);
    }

    public void xoaKhuyenMai(String ma) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Database.getInstance().getConnection();
            // Cập nhật mã khuyến mãi của các sản phẩm về null
            String updateSql = "UPDATE SanPham SET maKhuyenMai = NULL WHERE maKhuyenMai = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateSql);
            updateStmt.setString(1, ma);
            updateStmt.executeUpdate();
            updateStmt.close();
            
            // Xóa khuyến mãi từ bảng khuyến mãi sản phẩm
            String deleteSql = "DELETE FROM KhuyenMaiSanPham WHERE maKhuyenMai = ?";
            stmt = con.prepareStatement(deleteSql);
            stmt.setString(1, ma);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa khuyến mãi: " + e.getMessage());
        }
    }
    public boolean suaKhuyenMai(KhuyenMaiSanPham kmsp) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Database.getInstance().getConnection();
            String sql = "UPDATE KhuyenMaiSanPham SET tenKhuyenMai = ?, ngayBatDau = ?, ngayKetThuc = ?, loaiChuongTrinh = ?, trangThai = ?, giamGiaSP = ? WHERE maKhuyenMai = ?";
            stmt = con.prepareStatement(sql);
            // Set values using getters of KhuyenMaiHoaDon object
            stmt.setString(1, kmsp.getTenKM());
            stmt.setDate(2, new java.sql.Date(kmsp.getNgayBatDau().getTime()));
            stmt.setDate(3, new java.sql.Date(kmsp.getNgayKetThuc().getTime()));
            stmt.setBoolean(4, kmsp.getLoaiChuongTrinh());
            stmt.setBoolean(5, kmsp.getTrangThai());
            stmt.setDouble(6, kmsp.getGiamGiaSanPham());
            stmt.setString(7, kmsp.getMaKM());
            int n = stmt.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        } 
    }
    
}