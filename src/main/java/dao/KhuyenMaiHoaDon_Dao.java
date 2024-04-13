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
    private ArrayList<KhuyenMaiHoaDon> DanhSachKhuyenMaiHoaDon;
    
    public KhuyenMaiHoaDon_Dao() {
    	DanhSachKhuyenMaiHoaDon = new ArrayList<KhuyenMaiHoaDon>();
    	DanhSachKhuyenMaiHoaDon = docTubang();
    }
    
    public ArrayList<KhuyenMaiHoaDon> docTubang() {
        ArrayList<KhuyenMaiHoaDon> DanhSachKhuyenMaiHoaDon = new ArrayList<>();
        try {
            Connection con = Database.getInstance().getConnection();
            Statement statement = con.createStatement();

            // Lấy ngày hiện tại
            java.util.Date ngayHienTai = new java.util.Date();

            // Cập nhật trạng thái của các bản ghi có ngày kết thúc < ngày hiện tại
            String updateSql = "UPDATE KhuyenMaiHoaDon SET TrangThai = 0 WHERE NgayKetThuc < ? AND TrangThai = 1"; // Trạng thái = 1 là true, 0 là false
            PreparedStatement updateStatement = con.prepareStatement(updateSql);
            updateStatement.setDate(1, new java.sql.Date(ngayHienTai.getTime()));
            updateStatement.executeUpdate();
            updateStatement.close();

            // Lấy dữ liệu từ bảng KhuyenMaiHoaDon
            String selectSql = "SELECT * FROM KhuyenMaiHoaDon";
            ResultSet rs = statement.executeQuery(selectSql);
            while (rs.next()) {
                String maKM = rs.getString(1); 
                String tenKM = rs.getString(2);
                Date ngayBatDau = rs.getDate(3);
                Date ngayKetThuc = rs.getDate(4);
                Boolean loaiChuongTrinh = rs.getBoolean(5);
                Boolean trangThai = rs.getBoolean(6);
                Double giaTriHoaDon = rs.getDouble(7); 
                Double giamGiaHoaDon = rs.getDouble(8);

                KhuyenMaiHoaDon khuyenMaiHoaDon = new KhuyenMaiHoaDon(maKM, tenKM, ngayBatDau, ngayKetThuc, loaiChuongTrinh, trangThai, giaTriHoaDon, giamGiaHoaDon);
                DanhSachKhuyenMaiHoaDon.add(khuyenMaiHoaDon);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DanhSachKhuyenMaiHoaDon;
    }

    public boolean themKhuyenMaiHoaDon(KhuyenMaiHoaDon k) {
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
    public KhuyenMaiHoaDon timKhuyenMai(String maKM)
    {
    	
    	for(KhuyenMaiHoaDon km : DanhSachKhuyenMaiHoaDon)
    	{
    		if(km.getMaKM().equals(maKM))
    		{
    			return km;
    		}
    	}
    	return null;
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
}
