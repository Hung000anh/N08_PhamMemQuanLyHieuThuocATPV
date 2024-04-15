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
import entity.KhuyenMaiSanPham;
import entity.SanPham;


public class KhuyenMaiSanPham_Dao {
    private static ArrayList<KhuyenMaiSanPham> DanhSachKhuyenMaiSanPham = new ArrayList<KhuyenMaiSanPham>();
	private static Connection con= Database.getInstance().getConnection();

    public KhuyenMaiSanPham_Dao() {
    	docTubang();
    }

    public static ArrayList<KhuyenMaiSanPham> docTubang() {
    	DanhSachKhuyenMaiSanPham.clear();
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



            // Lấy ngày hiện tại
            java.util.Date ngayHienTai = new java.util.Date();

            // Cập nhật trạng thái của các bản ghi có ngày kết thúc < ngày hiện tại
            String updateSql = "UPDATE KhuyenMaiSanPham SET TrangThai = 0 WHERE NgayKetThuc < ? AND TrangThai = 1"; // Trạng thái = 1 là true, 0 là false
            try (PreparedStatement updateStatement = con.prepareStatement(updateSql)) {
                updateStatement.setDate(1, new java.sql.Date(ngayHienTai.getTime()));
                updateStatement.executeUpdate();
            } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

            // Lấy dữ liệu từ bảng KhuyenMaiSanPham
            String selectSql = "SELECT * FROM KhuyenMaiSanPham";
            try (PreparedStatement statement = con.prepareStatement(selectSql);
                 ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String maKM = rs.getString(1);
                    String tenKM = rs.getString(2);
                    Date ngayBatDau = rs.getDate(3);
                    Date ngayKetThuc = rs.getDate(4);
                    Boolean loaiChuongTrinh = rs.getBoolean(5);
                    Boolean trangThai = rs.getBoolean(6);
                    Double giamGiaSanPham = rs.getDouble(7);

                    KhuyenMaiSanPham khuyenMaiSanPham = new KhuyenMaiSanPham(maKM, tenKM, ngayBatDau, ngayKetThuc, loaiChuongTrinh, trangThai, giamGiaSanPham);
                    DanhSachKhuyenMaiSanPham.add(khuyenMaiSanPham);
                }

            rs.close();
            statement.close();
            } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} }  
        return DanhSachKhuyenMaiSanPham;

    }



    public boolean themKhuyenMaiSanPham(KhuyenMaiSanPham k) {
         
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Database.getInstance().getConnection();
            String sql = "INSERT INTO KhuyenMaiSanPham VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);

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
            String sql = "DELETE FROM KhuyenMaiSanPham WHERE maKhuyenMai = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ma);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa khuyến mãi: " + e.getMessage());
            e.printStackTrace();
        }
    }
}