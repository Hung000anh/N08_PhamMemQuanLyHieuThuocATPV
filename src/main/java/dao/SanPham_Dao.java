package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import connectDB.Database;
import entity.KhuyenMaiSanPham;
import entity.NhanVien;
import entity.SanPham;

public class SanPham_Dao {
    private ArrayList<SanPham> DanhSachSanPham;
    
    public SanPham_Dao() {
        DanhSachSanPham = new ArrayList<SanPham>();
    }
    
    public ArrayList<SanPham> docTubang() {
    	KhuyenMaiSanPham_Dao DanhSachKhuyenMaiSanPham = new KhuyenMaiSanPham_Dao();
    	ArrayList<KhuyenMaiSanPham> DanhSachKhuyenMaiSP = DanhSachKhuyenMaiSanPham.docTubang();
    	
        try {
            Connection con = Database.getInstance().getConnection();
            String sql = "SELECT * FROM SanPham"; // Corrected table name
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString(1);
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
           
                
                
                SanPham s = new SanPham(maSP, tenSP, loai, ngayHetHan, ngaySanXuat, donGiaNhap, soluongTon, donGiaBan,hinhAnhSanPham, DonViTinh,  khuyenMai);
                DanhSachSanPham.add(s);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DanhSachSanPham;
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
			
				sp=new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDouble(6), rs.getInt(7),rs.getDouble(8), rs.getString(9), rs.getString(10), new KhuyenMaiSanPham(rs.getString(11)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sp;
	}
}
