package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import connectDB.Database;
import entity.HoaDon;
import entity.KhuyenMaiSanPham;
import entity.NhanVien;
import entity.SanPham;
import entity.ChiTietHoaDon;

public class ThongKe_Dao {
	
	// ----- Thống kê sản phẩm ----- //
	
	// Top 5 sp bán chạy, bán chậm
	public List<SanPham> top_5_SP(String sapXep) {
		List<SanPham> dssp = new ArrayList<SanPham>();
		try {
			Connection con = Database.getInstance().getConnection();
			String sql ="SELECT TOP 5\r\n"
					+ "    SP.maSanPham,\r\n"
					+ "    SP.tenSanPham,\r\n"
					+ "    SP.loaiSanPham,\r\n"
					+ "    SP.ngayHetHan,\r\n"
					+ "    SP.ngaySanXuat,\r\n"
					+ "    SP.donGiaNhap,\r\n"
					+ "    SP.soLuongTon,\r\n"
					+ "    SP.donGiaBan,\r\n"
					+ "    SP.hinhAnhSanPham,\r\n"
					+ "    SP.donViTinh,\r\n"
					+ "    SP.maKhuyenMai,\r\n"
					+ "    SUM(CTHD.soLuong) AS tongSoLuongBanDuoc\r\n"
					+ "FROM \r\n"
					+ "    ChiTietHoaDon CTHD\r\n"
					+ "INNER JOIN \r\n"
					+ "    SanPham SP ON CTHD.maSanPham = SP.maSanPham\r\n"
					+ "GROUP BY \r\n"
					+ "    SP.maSanPham,\r\n"
					+ "    SP.tenSanPham,\r\n"
					+ "    SP.loaiSanPham,\r\n"
					+ "    SP.ngayHetHan,\r\n"
					+ "    SP.ngaySanXuat,\r\n"
					+ "    SP.donGiaNhap,\r\n"
					+ "    SP.soLuongTon,\r\n"
					+ "    SP.donGiaBan,\r\n"
					+ "    SP.hinhAnhSanPham,\r\n"
					+ "    SP.donViTinh,\r\n"
					+ "    SP.maKhuyenMai\r\n"
					+ "ORDER BY \r\n"
					+ "    SUM(CTHD.soLuong)"
					+ sapXep + ";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				dssp.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDouble(6), rs.getInt(8), rs.getDouble(7), rs.getString(9), rs.getString(10), new KhuyenMaiSanPham(rs.getString(11))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssp;
	}
	
	// Sản phẩm bán chạy, bán chậm nhất
	public SanPham getSanPham(String sapXep) {
		SanPham sp = null;
		try {
			Connection con = Database.getInstance().getConnection();
			String sql ="SELECT TOP 1\r\n"
					+ "    SP.maSanPham,\r\n"
					+ "    SP.tenSanPham,\r\n"
					+ "    SP.loaiSanPham,\r\n"
					+ "    SP.ngayHetHan,\r\n"
					+ "    SP.ngaySanXuat,\r\n"
					+ "    SP.donGiaNhap,\r\n"
					+ "    SP.soLuongTon,\r\n"
					+ "    SP.donGiaBan,\r\n"
					+ "    SP.hinhAnhSanPham,\r\n"
					+ "    SP.donViTinh,\r\n"
					+ "    SP.maKhuyenMai,\r\n"
					+ "    SUM(CTHD.soLuong) AS tongSoLuongBanDuoc\r\n"
					+ "FROM \r\n"
					+ "    ChiTietHoaDon CTHD\r\n"
					+ "INNER JOIN \r\n"
					+ "    SanPham SP ON CTHD.maSanPham = SP.maSanPham\r\n"
					+ "GROUP BY \r\n"
					+ "    SP.maSanPham,\r\n"
					+ "    SP.tenSanPham,\r\n"
					+ "    SP.loaiSanPham,\r\n"
					+ "    SP.ngayHetHan,\r\n"
					+ "    SP.ngaySanXuat,\r\n"
					+ "    SP.donGiaNhap,\r\n"
					+ "    SP.soLuongTon,\r\n"
					+ "    SP.donGiaBan,\r\n"
					+ "    SP.hinhAnhSanPham,\r\n"
					+ "    SP.donViTinh,\r\n"
					+ "    SP.maKhuyenMai\r\n"
					+ "ORDER BY \r\n"
					+ "    SUM(CTHD.soLuong)"
					+ sapXep + ";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDouble(6), rs.getInt(8), rs.getDouble(7), rs.getString(9), rs.getString(10), new KhuyenMaiSanPham(rs.getString(11)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	
	// Lấy số lượng sản phẩm bán ra
	public int[] laySlBanRa(String sapXep) {
		int[] sl = new int[100000];
		try {
			Connection con = Database.getInstance().getConnection();
			String sql ="SELECT TOP 5\r\n"
					+ "    SP.maSanPham,\r\n"
					+ "    SP.tenSanPham,\r\n"
					+ "    SP.loaiSanPham,\r\n"
					+ "    SP.ngayHetHan,\r\n"
					+ "    SP.ngaySanXuat,\r\n"
					+ "    SP.donGiaNhap,\r\n"
					+ "    SP.soLuongTon,\r\n"
					+ "    SP.donGiaBan,\r\n"
					+ "    SP.hinhAnhSanPham,\r\n"
					+ "    SP.donViTinh,\r\n"
					+ "    SP.maKhuyenMai,\r\n"
					+ "    SUM(CTHD.soLuong) AS tongSoLuongBanDuoc\r\n"
					+ "FROM \r\n"
					+ "    ChiTietHoaDon CTHD\r\n"
					+ "INNER JOIN \r\n"
					+ "    SanPham SP ON CTHD.maSanPham = SP.maSanPham\r\n"
					+ "GROUP BY \r\n"
					+ "    SP.maSanPham,\r\n"
					+ "    SP.tenSanPham,\r\n"
					+ "    SP.loaiSanPham,\r\n"
					+ "    SP.ngayHetHan,\r\n"
					+ "    SP.ngaySanXuat,\r\n"
					+ "    SP.donGiaNhap,\r\n"
					+ "    SP.soLuongTon,\r\n"
					+ "    SP.donGiaBan,\r\n"
					+ "    SP.hinhAnhSanPham,\r\n"
					+ "    SP.donViTinh,\r\n"
					+ "    SP.maKhuyenMai\r\n"
					+ "ORDER BY \r\n"
					+ "    SUM(CTHD.soLuong)"
					+ sapXep + ";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				sl[i] = rs.getInt(12);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sl;
	}
	
	// ----- Thống kê doanh thu ----- //

	public Double tinhTongDoanhThu() {
		Double doanhThu = 0.0;
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "SELECT \r\n"
					+ "    SP.loaiSanPham,\r\n"
					+ "    SUM(CTHD.soLuong * SP.donGiaBan) AS tongDoanhThu\r\n"
					+ "FROM \r\n"
					+ "    ChiTietHoaDon CTHD\r\n"
					+ "INNER JOIN \r\n"
					+ "    SanPham SP ON CTHD.maSanPham = SP.maSanPham\r\n"
					+ "GROUP BY \r\n"
					+ "    SP.loaiSanPham;";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				doanhThu = rs.getDouble(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doanhThu;
	}
	
	public Double tinhTongDoanhThuTheoLoai(String loaiSP) {
		Double doanhThu = 0.0;
		String sql = "SELECT \r\n"
				+ "    SP.loaiSanPham,\r\n"
				+ "    SUM(CTHD.soLuong * SP.donGiaBan) AS tongDoanhThu\r\n"
				+ "FROM \r\n"
				+ "    ChiTietHoaDon CTHD\r\n"
				+ "INNER JOIN \r\n"
				+ "    SanPham SP ON CTHD.maSanPham = SP.maSanPham\r\n"
				+ "WHERE \r\n"
				+ "    SP.loaiSanPham = '" + loaiSP + "'\r\n"
				+ "GROUP BY \r\n"
				+ "    SP.loaiSanPham;";
		try {
			Connection con = Database.getInstance().getConnection();
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				doanhThu = rs.getDouble(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doanhThu;
	}
	
	public Double tinhTongDTLoaiSPTheoKhoangTG(String loaiSP, Date ngayBatDau, Date ngayKetThuc) {
		Double doanhThu = 0.0;
		String sql ="DECLARE @NgayBatDau DATE = '" + ngayBatDau + "';" +
	               "DECLARE @NgayKetThuc DATE = '" + ngayKetThuc + "';" +
	               "SELECT " +
	               "    SP.maSanPham AS MaSanPham, " +
	               "    SP.tenSanPham AS TenSanPham, " +
	               "    SUM(CTHD.soLuong * SP.donGiaBan) AS DoanhThu " +
	               "FROM " +
	               "    HoaDon HD " +
	               "INNER JOIN " +
	               "    ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon " +
	               "INNER JOIN " +
	               "    SanPham SP ON CTHD.maSanPham = SP.maSanPham " +
	               "WHERE " +
	               "    SP.loaiSanPham = '" + loaiSP + "' AND HD.ngayXuat BETWEEN @NgayBatDau AND @NgayKetThuc " +
	               "GROUP BY " +
	               "    SP.maSanPham, SP.tenSanPham;";;
		try {
			Connection con = Database.getInstance().getConnection();
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				doanhThu = rs.getDouble(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doanhThu;
	}
	
	public Double tinhTongDTLoaiSPTheoThang(String loaiSP, int thang, int nam) {
		Double doanhThu = 0.0;
		String sql = "DECLARE @Thang INT = '" + thang + "';"
				+ "DECLARE @Nam INT = '" + nam + "';"
				+ "\r\n"
				+ "SELECT \r\n"
				+ "    SP.maSanPham AS MaSanPham,\r\n"
				+ "    SP.tenSanPham AS TenSanPham,\r\n"
				+ "    SUM(CTHD.soLuong * SP.donGiaBan) AS DoanhThu\r\n"
				+ "FROM \r\n"
				+ "    HoaDon HD \r\n"
				+ "INNER JOIN \r\n"
				+ "    ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon \r\n"
				+ "INNER JOIN \r\n"
				+ "    SanPham SP ON CTHD.maSanPham = SP.maSanPham\r\n"
				+ "WHERE \r\n"
				+ "    SP.loaiSanPham = '" + loaiSP + "' AND \r\n"
				+ "    MONTH(HD.ngayXuat) = @Thang AND \r\n"
				+ "    YEAR(HD.ngayXuat) = @Nam\r\n"
				+ "GROUP BY \r\n"
				+ "    SP.maSanPham, SP.tenSanPham;";
		try {
			Connection con = Database.getInstance().getConnection();
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				doanhThu = rs.getDouble(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doanhThu;
	}
	
	public Double tinhTongDTLoaiSPTheoNam(String loaiSP, int nam) {
		Double doanhThu = 0.0;
		String sql = "DECLARE @Nam INT = '" + nam + "';"
				+ "\r\n"
				+ "SELECT \r\n"
				+ "    SP.maSanPham AS MaSanPham,\r\n"
				+ "    SP.tenSanPham AS TenSanPham,\r\n"
				+ "    SUM(CTHD.soLuong * SP.donGiaBan) AS DoanhThu\r\n"
				+ "FROM \r\n"
				+ "    HoaDon HD \r\n"
				+ "INNER JOIN \r\n"
				+ "    ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon \r\n"
				+ "INNER JOIN \r\n"
				+ "    SanPham SP ON CTHD.maSanPham = SP.maSanPham\r\n"
				+ "WHERE \r\n"
				+ "    SP.loaiSanPham = '" + loaiSP + "' AND \r\n"
				+ "    YEAR(HD.ngayXuat) = @Nam\r\n"
				+ "GROUP BY \r\n"
				+ "    SP.maSanPham, SP.tenSanPham;";
		try {
			Connection con = Database.getInstance().getConnection();
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				doanhThu = rs.getDouble(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doanhThu;
	}
}
