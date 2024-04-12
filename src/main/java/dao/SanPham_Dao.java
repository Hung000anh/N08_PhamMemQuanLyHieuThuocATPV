package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
