package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import connectDB.Database;
import entity.*;


public class HoaDon_DAO {
    private ArrayList<HoaDon> DanhSachHoaDon;
    
    
    public HoaDon_DAO() {
    	DanhSachHoaDon = new ArrayList<HoaDon>();
    }
    
    public ArrayList<HoaDon> docTubang() {
        try {
            Connection con = Database.getInstance().getConnection();
            String sql = "SELECT * FROM HoaDon"; // Corrected table name
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            	String maHD = rs.getString(1); 
            	String maKhachHang = rs.getString(2);
            	KhachHang khachHang = new KhachHang(maKhachHang);
            	String maNV = rs.getString(3);
            	NhanVien nhanVien = (new NhanVien_Dao()).getNhanVienTheoMa(maNV);
            	Date ngayXuat = rs.getDate(4);;
            	String loaiHD = rs.getString(5);
            	String ghiChu = rs.getString(6);
            	String maKhuyenMai = rs.getString(7);
            	
            	KhuyenMaiHoaDon_Dao ds = new KhuyenMaiHoaDon_Dao();
            	ds.docTubang();
            
            	HoaDon HoaDon = new HoaDon(maHD, khachHang, nhanVien, ngayXuat, loaiHD, ghiChu, ds.timKhuyenMai(maKhuyenMai));
            	DanhSachHoaDon.add(HoaDon);
            	
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DanhSachHoaDon;
    }
    public boolean addHoaDon(HoaDon hd) {
		try {
			ConnectDB.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement psmt = null;
		int n = 0;
		try {
			psmt = con.prepareStatement("insert into HoaDon values(?,?,?,?,?,?,?)");
			psmt.setString(1, hd.getMaHD());
			psmt.setString(2, hd.getKhachHang().getMaKhachHang());
			psmt.setString(3, hd.getNhanVien().getMaNV());
			psmt.setDate(4, (Date) hd.getNgayXuat());
			psmt.setString(5, hd.getLoaiHD());
			psmt.setString(6, hd.getGhiChu());
			psmt.setString(7, hd.getKhuyenMai().getMaKM());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean updateHoaDon(HoaDon hd) {
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
					"UPDATE HoaDon \r\n"
					+ "SET maKhachHang=?, maNV=?, ngayXuat=?, loaiHD=?, ghiChu=?, maKhuyenMai=? \r\n"
					+ "WHERE maHoaDon=?\r\n"
					+ "");
				psmt.setString(1, hd.getKhachHang().getMaKhachHang());
		        psmt.setString(2, hd.getNhanVien().getMaNV());
		        psmt.setDate(3,  (Date) hd.getNgayXuat());
		        psmt.setString(4, hd.getLoaiHD());
		        psmt.setString(5, hd.getGhiChu());
		        psmt.setString(6, hd.getKhuyenMai().getMaKM());
		        psmt.setString(7, hd.getMaHD());
		      
			n = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return n > 0;
	}
	 public HoaDon getHDTheoMa(String maHD) {
			HoaDon hd = null;
			try {
				ConnectDB.getConnection();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			Connection con = ConnectDB.getConnection();
			try {
				String sql = "select * from HoaDon where maHoaDon = '" + maHD + "'";
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
				
					hd=new HoaDon(rs.getString(1), new KhachHang(rs.getString(2)), new NhanVien(rs.getString(3)), rs.getDate(4), rs.getString(5), rs.getString(6), new KhuyenMaiHoaDon(rs.getString(7)));
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return hd;
		}

}
