package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;

import connectDB.ConnectDB;
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
            Connection con = ConnectDB.getConnection();
            Statement statement = con.createStatement();
            java.util.Date ngayHienTai = new java.util.Date();
            // Cập nhật trạng thái của các bản ghi có ngày kết thúc < ngày hiện tại
            String updateSql = "UPDATE KhuyenMaiHoaDon SET TrangThai = 0 WHERE NgayKetThuc < ? OR NgayBatDau > ?";
            PreparedStatement updateStatement = con.prepareStatement(updateSql);
            updateStatement.setDate(1, new java.sql.Date(ngayHienTai.getTime())); // Ngày kết thúc < ngày hiện tại
            updateStatement.setDate(2, new java.sql.Date(ngayHienTai.getTime())); // Ngày bắt đầu > ngày hiện tại
            updateStatement.executeUpdate();
            updateStatement.close();
            
            // Cập nhật trạng thái của các bản ghi có ngày bắt đầu <= ngày hiện tại và ngày kết thúc >= ngày hiện tại
            String updateActiveSql = "UPDATE KhuyenMaiSanPham SET trangThai = 1 WHERE ngayBatDau <= ? AND ngayKetThuc >= ? AND trangThai = 0"; 
            PreparedStatement updateActiveStatement = con.prepareStatement(updateActiveSql);
            updateActiveStatement.setDate(1, new java.sql.Date(ngayHienTai.getTime()));
            updateActiveStatement.setDate(2, new java.sql.Date(ngayHienTai.getTime()));
            updateActiveStatement.executeUpdate();
            updateActiveStatement.close();
            
            // Tăng giá bán của sản phẩm lền 20%
            String selectSPSql = "SELECT * FROM SanPham";
            ResultSet rs = statement.executeQuery(selectSPSql);
            
            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                double donGiaNhap = rs.getDouble("donGiaNhap");

                double donGiaBanMoi = donGiaNhap * 1.2;
                String updateSqlPrice = "UPDATE SanPham SET donGiaBan = ? WHERE maSanPham = ?";
                PreparedStatement updatePriceStatement = con.prepareStatement(updateSqlPrice);
                updatePriceStatement.setDouble(1, donGiaBanMoi);
                updatePriceStatement.setString(2, maSanPham);
                updatePriceStatement.executeUpdate();
                updatePriceStatement.close();
            }
            //Giảm giá 10% với sản phẩm gần hết hạn (khoảng 20 ngày)
            rs = statement.executeQuery(selectSPSql);
            while (rs.next()) {
               
                String maSanPham = rs.getString("maSanPham");
                double donGiaNhap = rs.getDouble("donGiaNhap");
                double donGiaBanHienTai = rs.getDouble("donGiaBan");
                Date ngayKetThuc = rs.getDate("ngayHetHan");
                Calendar cal = Calendar.getInstance();
                cal.setTime(ngayKetThuc);
                cal.add(Calendar.DATE, -20);
                java.util.Date ngayGanKetThuc = cal.getTime();
                if (ngayHienTai.after(ngayGanKetThuc)) {
                    // Giảm giá 10%
                    double giamGia = 0.1;
                    double donGiaBanMoi = donGiaBanHienTai * (1 - giamGia);            
                    String updateSqlPrice = "UPDATE SanPham SET donGiaBan = ? WHERE maSanPham = ?";
                    try (PreparedStatement updatePriceStatement = con.prepareStatement(updateSqlPrice)) {
                        updatePriceStatement.setDouble(1, donGiaBanMoi);
                        updatePriceStatement.setString(2, maSanPham);
                        updatePriceStatement.executeUpdate();
                    }
                }
            }
            
            //Giảm giá với sản phẩm có khuyến mãi (nhưng trạng thái khuyến mãi phải được kích hoạt)
            rs = statement.executeQuery(selectSPSql);
            
            // Thực hiện truy vấn một lần để lấy dữ liệu KhuyenMai
            String selectKMSQL = "SELECT * FROM KhuyenMaiSanPham WHERE trangThai = ?";
            PreparedStatement kmStatement = con.prepareStatement(selectKMSQL);
            kmStatement.setBoolean(1, true);
            ResultSet kmResultSet = kmStatement.executeQuery();

            // Duyệt qua các sản phẩm và áp dụng giảm giá nếu có khuyến mãi hoạt động
            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String maKhuyenMai = rs.getString("maKhuyenMai");

                // Duyệt qua dữ liệu KhuyenMai đã lấy được
                while (kmResultSet.next()) {
                    // Kiểm tra mã khuyến mãi và trạng thái
                    if (maKhuyenMai.equals(kmResultSet.getString("maKhuyenMai")) && kmResultSet.getBoolean("trangThai")) {
                        double donGiaNhap = rs.getDouble("donGiaNhap");
                        double giamGiaSanPham = kmResultSet.getDouble("giamGiaSP");
                        double donGiaBanMoi = donGiaNhap * (1 - giamGiaSanPham); // Giảm giá

                        // Cập nhật giá bán mới vào cơ sở dữ liệu
                        String updateSqlPrice = "UPDATE SanPham SET donGiaBan = ? WHERE maSanPham = ?";
                        try (PreparedStatement updatePriceStatement = con.prepareStatement(updateSqlPrice)) {
                            updatePriceStatement.setDouble(1, donGiaBanMoi);
                            updatePriceStatement.setString(2, maSanPham);
                            updatePriceStatement.executeUpdate();
                        }
                        break; // Sau khi áp dụng giảm giá, thoát khỏi vòng lặp KhuyenMai
                    }
                }
                // Đặt lại con trỏ của ResultSet KhuyenMai để lặp lại
                //kmResultSet.beforeFirst();
            }


            
            String sql = "SELECT * FROM SanPham"; // Corrected table name
            statement = con.createStatement();
            rs = statement.executeQuery(sql);
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
                
                SanPham s = new SanPham(maSP, tenSP, loai, ngayHetHan, ngaySanXuat, donGiaNhap, soluongTon, donGiaBan, hinhAnhSanPham, DonViTinh , khuyenMai);
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
            con = ConnectDB.getConnection();
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
            con = ConnectDB.getConnection();
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
            stmt.setString(9, sp.getDonViTinh());
            stmt.setString(8, sp.getHinhAnhSanPham());
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
            con = ConnectDB.getConnection();
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

    public void goMaKhuyenMaiChoSanPham(String maSanPham) {
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement("UPDATE SanPham SET maKhuyenMai = NULL WHERE maSanPham = ?")) {
            stmt.setString(1, maSanPham);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Lỗi khi sửa mã khuyến mãi cho sản phẩm: " + e.getMessage());
        }
    }
}