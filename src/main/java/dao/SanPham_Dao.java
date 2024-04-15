package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import connectDB.Database;
import entity.HoaDon;
import entity.KhuyenMaiSanPham;
import entity.SanPham;

public class SanPham_Dao {
    private static ArrayList<SanPham> DanhSachSanPham = new ArrayList<SanPham>();
    
    public SanPham_Dao() {
    	docTubang();
    }
    
    public static ArrayList<SanPham> docTubang() {
    	DanhSachSanPham.clear();

    	KhuyenMaiSanPham_Dao.docTubang();
    	
        try {
            Connection con = Database.getInstance().getConnection();
            String sql = "SELECT * FROM SanPham"; // Corrected table name
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString(1);
                String tenSP = rs.getString(2);
                String loai = rs.getString(3);
                java.util.Date ngayHetHan = rs.getDate(4); // Corrected method for Date type
                java.util.Date ngaySanXuat = rs.getDate(5); // Corrected method for Date type
                Double donGiaNhap = rs.getDouble(6); // Corrected method for Double type
                int soluongTon = rs.getInt(7); // Corrected method for Integer type
                Double donGiaBan = rs.getDouble(8); // Corrected method for Double type
                String hinhAnhSanPham = rs.getString(9);
                String DonViTinh = rs.getString(10);
                String idKhuyenMai = rs.getString(11);
                KhuyenMaiSanPham khuyenMai = (idKhuyenMai != null)? KhuyenMaiSanPham_Dao.layKhuyenMaiSanPhamTheoMa(idKhuyenMai) : null;
                
                SanPham s = new SanPham(maSP, tenSP, loai, ngayHetHan, ngaySanXuat, donGiaNhap, soluongTon, donGiaBan, DonViTinh, hinhAnhSanPham, khuyenMai);
                DanhSachSanPham.add(s);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DanhSachSanPham;
    }

    // gọi docTuBang() trước
    public static SanPham laySanPhamTheoMa(String maSP) {
    	for (SanPham sp : DanhSachSanPham) {
    		if (maSP.equals(sp.getMaSP()))
    			return sp;
    	}
    	return new SanPham(maSP);
    }

    public void ghiDeMaKhuyenMaiChoSanPham(String maSanPham, String maKhuyenMai) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Database.getInstance().getConnection();
            if (con == null || con.isClosed()) {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
                return;
            }
            
            String sql = "UPDATE SanPham SET maKhuyenMai = ? WHERE maSanPham = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maKhuyenMai);
            stmt.setString(2, maSanPham);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean themSanPham(SanPham sp) {        
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Database.getInstance().getConnection();
            String sql = "INSERT INTO SanPham VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sp.getMaSP());
            stmt.setString(2, sp.getTenSP());
            stmt.setString(3, sp.getLoai());
            stmt.setDate(4, new java.sql.Date(sp.getNgaySanXuat().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setDate(5, new java.sql.Date(sp.getNgayHetHan().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setDouble(6, sp.getDonGiaNhap());
            stmt.setDouble(8, sp.getDonGiaBan());
            stmt.setInt(7, sp.getSoluongTon());
            stmt.setString(9, sp.getDonViTinh());
            stmt.setString(10, sp.getHinhAnhSanPham());
            stmt.setNull(11, Types.VARCHAR); // Đặt giá trị NULL cho trường maKM
            int affectedRows = stmt.executeUpdate(); // Lấy số bản ghi bị ảnh hưởng bởi câu lệnh DELETE
            stmt.close();
            return affectedRows > 0; // Trả về true nếu có bản ghi nào bị xóa, ngược lại trả về false
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa sản phẩm: " + e.getMessage());
            return false; // Trả về false nếu có lỗi xảy ra trong quá trình xóa
        }
        
        
    }
    public boolean suaSanPham(SanPham sp) {        
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Database.getInstance().getConnection();
            String sql = "UPDATE SanPham SET tenSanPham = ?, loaiSanPham = ?, ngaySanXuat = ?, ngayHetHan = ?, donGiaNhap = ?, donGiaBan = ?, soluongTon = ?, donViTinh = ?, hinhAnhSanPham = ? WHERE maSanPham = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sp.getTenSP());
            stmt.setString(2, sp.getLoai());
            stmt.setDate(3, new java.sql.Date(sp.getNgaySanXuat().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setDate(4, new java.sql.Date(sp.getNgayHetHan().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setDouble(5, sp.getDonGiaNhap());
            stmt.setDouble(6, sp.getDonGiaBan());
            stmt.setInt(7, sp.getSoluongTon());
            stmt.setString(8, sp.getDonViTinh());
            stmt.setString(9, sp.getHinhAnhSanPham());
            stmt.setString(10, sp.getMaSP());
            int affectedRows = stmt.executeUpdate(); // Lấy số bản ghi bị ảnh hưởng bởi câu lệnh DELETE
            stmt.close();
            return affectedRows > 0; // Trả về true nếu có bản ghi nào bị xóa, ngược lại trả về false
        } catch (SQLException e) {
            System.err.println("Lỗi khi sửa sản phẩm: " + e.getMessage());
            return false; // Trả về false nếu có lỗi xảy ra trong quá trình xóa
        }
    }
    
    
    
    public boolean xoaSanPham(String ma) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Database.getInstance().getConnection();
            String sql = "DELETE FROM SanPham WHERE maSanPham = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ma);
            int affectedRows = stmt.executeUpdate(); // Lấy số bản ghi bị ảnh hưởng bởi câu lệnh DELETE
            return affectedRows > 0; // Trả về true nếu có bản ghi nào bị xóa, ngược lại trả về false
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa sản phẩm: " + e.getMessage());
            return false; // Trả về false nếu có lỗi xảy ra trong quá trình xóa
        }
    }

    public static boolean updateSoLuongTonTheoMa(String ma,int soLuongTon) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement psmt = null;
		int n = 0;
		try {
			psmt = con.prepareStatement(
					"UPDATE SanPham\r\n"
					+ "SET soLuongTon=?\r\n"
					+ "WHERE maSanPham=?;\r\n"
					+ "");
				psmt.setInt(1, soLuongTon);
		        psmt.setString(2, ma);
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return n > 0;
	}
}