package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_Dao {
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				dsKhachHang.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
						rs.getInt(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	public boolean addKhachHang(KhachHang kh) {
		int n = 0;
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement psmt = null;
			psmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?)");
			psmt.setString(1, kh.getMaKhachHang());
			psmt.setString(2, kh.getTenKhachHang());
			psmt.setString(3, kh.getSoDienThoai());
			psmt.setBoolean(4, kh.isGioiTinh());
			psmt.setDouble(5, kh.getTuoi());
			psmt.setString(6, kh.getHinhAnhKhachHang());
			n = psmt.executeUpdate();
			psmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean deleteKhachHang(String maKH) {
		int n = 0;
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement psmt = null;
			psmt = con.prepareStatement("delete KhachHang where maKhachHang=?");
			psmt.setString(1, maKH);
			n = psmt.executeUpdate();
			psmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return n > 0;
	}

	public boolean updateKhachHang(KhachHang kh) {
		int n = 0;
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement psmt = null;
			psmt = con.prepareStatement(
					"update KhachHang set tenKhachHang=?, soDienThoai=?, gioiTinh=?, tuoi=?, hinhAnhKhachHang=? where maKhachHang=?");
			psmt.setString(1, kh.getTenKhachHang());
			psmt.setString(2, kh.getSoDienThoai());
			psmt.setBoolean(3, kh.isGioiTinh());
			psmt.setInt(4, kh.getTuoi());
			psmt.setString(5, kh.getHinhAnhKhachHang());
			psmt.setString(6, kh.getMaKhachHang());
			n = psmt.executeUpdate();
			psmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return n > 0;
	}

	public KhachHang getKhachHangTheoMa(String maKH) {
		KhachHang kh = null;
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang where maKhachHang = '" + maKH + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	public ArrayList<KhachHang> getKhachHangTheoTen(String tenKH) {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM KhachHang WHERE tenKhachHang LIKE N'%" + tenKH + "%'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				dsKhachHang.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	public KhachHang getKhachHangTheoSDT(String sdt) {
		KhachHang kh = null;
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang where soDienThoai = '" + sdt + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
}
