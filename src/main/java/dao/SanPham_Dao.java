package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import connectDB.ConnectDB;
import connectDB.Database;
import entity.HoaDon;
import entity.KhuyenMaiSanPham;
import entity.SanPham;

public class SanPham_Dao {
    private static ArrayList<SanPham> DanhSachSanPham = new ArrayList<SanPham>();
    
    public SanPham_Dao()   {
 
    }
    
    public static ArrayList<SanPham> docTubang()  {
    	DanhSachSanPham.clear();


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
                KhuyenMaiSanPham khuyenMai = (idKhuyenMai != null)? new KhuyenMaiSanPham(idKhuyenMai) : null;
                
                SanPham s = new SanPham(maSP, tenSP, loai, ngayHetHan, ngaySanXuat, donGiaNhap, donGiaBan, soluongTon, DonViTinh, hinhAnhSanPham, khuyenMai);
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



    public SanPham laySanPhamTheoMa1(String maSP)   {
    	
    	
    	SanPham sp = null;
    	
        try {
            Connection con = Database.getInstance().getConnection();
            String sql = "SELECT * FROM SanPham"; // Corrected table name
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String tenSP = rs.getString(2);
                String loai = rs.getString(3);
                Date ngayHetHan = rs.getDate(4); // Corrected method for Date type
                Date ngaySanXuat = rs.getDate(5); // Corrected method for Date type
                Double donGiaNhap = rs.getDouble(6); // Corrected method for Double type
                int soluongTon = rs.getInt(7); // Corrected method for Integer type
                Double donGiaBan = (double) rs.getFloat(8); // Corrected method for Double type
                String hinhAnhSanPham = rs.getString(9);
                String DonViTinh = rs.getString(10);
                
                KhuyenMaiSanPham khuyenMai = new KhuyenMaiSanPham(rs.getString(11));
           
                
                
                sp = new SanPham(maSP, tenSP, loai, ngayHetHan, ngaySanXuat, donGiaNhap, donGiaBan, soluongTon, DonViTinh, hinhAnhSanPham, khuyenMai);
                SanPham s = new SanPham(maSP, tenSP, loai, ngayHetHan, ngaySanXuat, donGiaNhap, donGiaBan, soluongTon,hinhAnhSanPham, DonViTinh,  khuyenMai);
                DanhSachSanPham.add(s);

            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }

    public ArrayList<SanPham> laySanPhamTheoMaHD(String MaHD) {
    	ArrayList<SanPham> list = new ArrayList<SanPham>();
    	// Lay SanPham tu ChiTietHoaDon

        try {
            Connection con = Database.getInstance().getConnection();
            String sql = "SELECT * FROM ChiTietHoaDon"; // Corrected table name
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString(2);
                SanPham s = laySanPhamTheoMa(maSP);
                list.add(s);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return list;
    }
    public SanPham getSanPhamTheoMa(String maSP) {
		SanPham sp = null;
		try {
			ConnectDB.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from SanPham where maSanPham = '" + maSP + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
			
				sp=new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDouble(6), rs.getDouble(8),rs.getInt(7), rs.getString(9), rs.getString(10), new KhuyenMaiSanPham(rs.getString(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sp;
	}

	public boolean updateSoLuongTonTheoMa(String ma,int soLuongTon) {
		try {
			ConnectDB.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
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

