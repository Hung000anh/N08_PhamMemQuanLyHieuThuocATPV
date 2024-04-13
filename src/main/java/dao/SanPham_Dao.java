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
import entity.KhuyenMaiSanPham;
import entity.SanPham;

public class SanPham_Dao {
    private ArrayList<SanPham> DanhSachSanPham;
    
    public SanPham_Dao() {
        DanhSachSanPham = new ArrayList<SanPham>();
    }
    
    public ArrayList<SanPham> docTubang() {
        ArrayList<SanPham> DanhSachSanPham = new ArrayList<>();
        try {
            Connection con = Database.getInstance().getConnection();
            // Lấy ngày hiện tại
            java.util.Date ngayHienTai = new java.util.Date();
            // Cập nhật trạng thái của các bản ghi có ngày kết thúc < ngày hiện tại
            String updateSql = "UPDATE KhuyenMaiSanPham SET TrangThai = 0 WHERE NgayKetThuc < ? AND TrangThai = 1";
            try (PreparedStatement updateStatement = con.prepareStatement(updateSql)) {
                updateStatement.setDate(1, new java.sql.Date(ngayHienTai.getTime()));
                updateStatement.executeUpdate();
            }

            // Lấy dữ liệu từ bảng KhuyenMaiSanPham
            ArrayList<KhuyenMaiSanPham> DanhSachKhuyenMaiSanPham = new KhuyenMaiSanPham_Dao().docTubang();
            
            // Lấy dữ liệu từ bảng SanPham
            String selectSql = "SELECT * FROM SanPham";
            try (PreparedStatement statement = con.prepareStatement(selectSql);
                 ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String maSP = rs.getString(1);
                    String tenSP = rs.getString(2);
                    String loai = rs.getString(3);
                    Date ngayHetHan = rs.getDate(4);
                    Date ngaySanXuat = rs.getDate(5);
                    Double donGiaNhap = rs.getDouble(6);
                    int soluongTon = rs.getInt(7);
                    Double donGiaBan = rs.getDouble(8);
                    String hinhAnhSanPham = rs.getString(9);
                    String DonViTinh = rs.getString(10);
                    String idKhuyenMai = rs.getString(11);
                    
                    KhuyenMaiSanPham khuyenMai = null;
                    for (KhuyenMaiSanPham km : DanhSachKhuyenMaiSanPham) {
                        if (km.getMaKM().equals(idKhuyenMai)) {
                            khuyenMai = new KhuyenMaiSanPham(km.getMaKM(), km.getTenKM(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getLoaiChuongTrinh(), km.getTrangThai(), km.getGiamGiaSanPham());
                            break;
                        }
                    }

                    SanPham s = new SanPham(maSP, tenSP, loai, ngayHetHan, ngaySanXuat, donGiaNhap, donGiaBan, soluongTon, DonViTinh, hinhAnhSanPham, khuyenMai);
                    DanhSachSanPham.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DanhSachSanPham;
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


    public SanPham laySanPhamTheoMa(String maSP) {
    	KhuyenMaiSanPham_Dao DanhSachKhuyenMaiSanPham = new KhuyenMaiSanPham_Dao();
    	ArrayList<KhuyenMaiSanPham> DanhSachKhuyenMaiSP = DanhSachKhuyenMaiSanPham.docTubang();
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
                Double donGiaBan = rs.getDouble(8); // Corrected method for Double type
                String hinhAnhSanPham = rs.getString(9);
                String DonViTinh = rs.getString(10);
                String idKhuyenMai = rs.getString(11);
                KhuyenMaiSanPham khuyenMai = null;
                for(KhuyenMaiSanPham km : DanhSachKhuyenMaiSP)
                {
                	if(km.getMaKM().equals(idKhuyenMai))	
            		{
                		khuyenMai = new KhuyenMaiSanPham(km.getMaKM(), km.getTenKM(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getLoaiChuongTrinh(), km.getTrangThai(), km.getGiamGiaSanPham());
                		break;
            		}	
                }
                
                
                sp = new SanPham(maSP, tenSP, loai, ngayHetHan, ngaySanXuat, donGiaNhap, donGiaBan, soluongTon, DonViTinh, hinhAnhSanPham, khuyenMai);
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
}
