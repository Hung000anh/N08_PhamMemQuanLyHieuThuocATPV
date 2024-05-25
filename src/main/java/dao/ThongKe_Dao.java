package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connectDB.Database;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMaiHoaDon;
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
			String sql = "SELECT TOP 5\r\n" + "    SP.maSanPham,\r\n" + "    SP.tenSanPham,\r\n"
					+ "    SP.loaiSanPham,\r\n" + "    SP.ngayHetHan,\r\n" + "    SP.ngaySanXuat,\r\n"
					+ "    SP.donGiaNhap,\r\n" + "    SP.soLuongTon,\r\n" + "    SP.donGiaBan,\r\n"
					+ "    SP.hinhAnhSanPham,\r\n" + "    SP.donViTinh,\r\n" + "    SP.maKhuyenMai,\r\n"
					+ "    SUM(CTHD.soLuong) AS tongSoLuongBanDuoc\r\n" + "FROM \r\n" + "    ChiTietHoaDon CTHD\r\n"
					+ "INNER JOIN \r\n" + "    SanPham SP ON CTHD.maSanPham = SP.maSanPham\r\n" + "GROUP BY \r\n"
					+ "    SP.maSanPham,\r\n" + "    SP.tenSanPham,\r\n" + "    SP.loaiSanPham,\r\n"
					+ "    SP.ngayHetHan,\r\n" + "    SP.ngaySanXuat,\r\n" + "    SP.donGiaNhap,\r\n"
					+ "    SP.soLuongTon,\r\n" + "    SP.donGiaBan,\r\n" + "    SP.hinhAnhSanPham,\r\n"
					+ "    SP.donViTinh,\r\n" + "    SP.maKhuyenMai\r\n" + "ORDER BY \r\n" + "    SUM(CTHD.soLuong)"
					+ sapXep + ";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				dssp.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDouble(6), rs.getInt(8), rs.getDouble(7), rs.getString(9), rs.getString(10),
						new KhuyenMaiSanPham(rs.getString(11))));
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
			String sql = "SELECT TOP 1\r\n" + "    SP.maSanPham,\r\n" + "    SP.tenSanPham,\r\n"
					+ "    SP.loaiSanPham,\r\n" + "    SP.ngayHetHan,\r\n" + "    SP.ngaySanXuat,\r\n"
					+ "    SP.donGiaNhap,\r\n" + "    SP.soLuongTon,\r\n" + "    SP.donGiaBan,\r\n"
					+ "    SP.hinhAnhSanPham,\r\n" + "    SP.donViTinh,\r\n" + "    SP.maKhuyenMai,\r\n"
					+ "    SUM(CTHD.soLuong) AS tongSoLuongBanDuoc\r\n" + "FROM \r\n" + "    ChiTietHoaDon CTHD\r\n"
					+ "INNER JOIN \r\n" + "    SanPham SP ON CTHD.maSanPham = SP.maSanPham\r\n" + "GROUP BY \r\n"
					+ "    SP.maSanPham,\r\n" + "    SP.tenSanPham,\r\n" + "    SP.loaiSanPham,\r\n"
					+ "    SP.ngayHetHan,\r\n" + "    SP.ngaySanXuat,\r\n" + "    SP.donGiaNhap,\r\n"
					+ "    SP.soLuongTon,\r\n" + "    SP.donGiaBan,\r\n" + "    SP.hinhAnhSanPham,\r\n"
					+ "    SP.donViTinh,\r\n" + "    SP.maKhuyenMai\r\n" + "ORDER BY \r\n" + "    SUM(CTHD.soLuong)"
					+ sapXep + ";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDouble(6), rs.getInt(8), rs.getDouble(7), rs.getString(9), rs.getString(10),
						new KhuyenMaiSanPham(rs.getString(11)));
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
			String sql = "SELECT TOP 5 " + "SUM(CTHD.soLuong) AS tongSoLuongBanDuoc " + "FROM " + "ChiTietHoaDon CTHD "
					+ "INNER JOIN " + "    SanPham SP ON CTHD.maSanPham = SP.maSanPham" + " GROUP BY " + "SP.maSanPham "
					+ "ORDER BY " + "SUM(CTHD.soLuong)" + sapXep + ";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				sl[i] = rs.getInt(1);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sl;
	}

	// ----- Thống kê doanh thu ----- //

	public Double tinhTongDoanhThuTheoKhoangTG(Date ngayBatDau, Date ngayKetThuc) {
		Double doanhThu = 0.0;
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "DECLARE @NgayBatDau DATE = '" + ngayBatDau + "';" + "DECLARE @NgayKetThuc DATE = '" + ngayKetThuc
					+ "';" + "SELECT " + "SUM( " + "CASE "
					+ "WHEN HD.loaiHD like '%bán' THEN CTHD.thanhTien "
					+ "WHEN HD.loaiHD like '%trả' THEN -CTHD.thanhTien " + "ELSE 0 " + "END " + ") AS DoanhThu "
					+ "FROM " + "HoaDon HD " + "INNER JOIN " + "ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon "
					+ "WHERE " + "HD.ngayXuat BETWEEN @NgayBatDau AND @NgayKetThuc;";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				doanhThu = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doanhThu;
	}
	
	public Double tinhTongDoanhThuTheoThang(int thang, int nam) {
		Double doanhThu = 0.0;
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "DECLARE @Thang INT = '" + thang + "';" + "DECLARE @Nam INT = '" + nam
					+ "';" + "SELECT " + "SUM( " + "CASE "
					+ "WHEN HD.loaiHD like '%bán' THEN CTHD.thanhTien "
					+ "WHEN HD.loaiHD like '%trả' THEN -CTHD.thanhTien " + "ELSE 0 " + "END " + ") AS DoanhThu "
					+ "FROM " + "HoaDon HD " + "INNER JOIN " + "ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon "
					+ "WHERE " + "MONTH(HD.ngayXuat) = @Thang AND " + "YEAR(HD.ngayXuat) = @Nam;";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				doanhThu = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doanhThu;
	}
	
	public Double tinhTongDoanhThuTheoNam(int nam) {
		Double doanhThu = 0.0;
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "DECLARE @Nam INT = '" + nam + "';"
					+ "SELECT " + "SUM( " + "CASE "
					+ "WHEN HD.loaiHD like '%bán' THEN CTHD.thanhTien "
					+ "WHEN HD.loaiHD like '%trả' THEN -CTHD.thanhTien " + "ELSE 0 " + "END " + ") AS DoanhThu "
					+ "FROM " + "HoaDon HD " + "INNER JOIN " + "ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon "
					+ "WHERE " + "YEAR(HD.ngayXuat) = @Nam;";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				doanhThu = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doanhThu;
	}
	
	public Double tinhTongDTLoaiSPTheoKhoangTG(String loaiSP, Date ngayBatDau, Date ngayKetThuc) {
		Double doanhThu = 0.0;
		String sql = "DECLARE @NgayBatDau DATE = '" + ngayBatDau + "';" + "DECLARE @NgayKetThuc DATE = '" + ngayKetThuc
				+ "';" + "SELECT " + "SP.loaiSanPham AS LoaiSanPham, " + "SUM( " + "CASE "
				+ "WHEN HD.loaiHD like '%bán' THEN CTHD.thanhTien "
				+ "WHEN HD.loaiHD like '%trả' THEN -CTHD.thanhTien " + "ELSE 0 " + "END " + ") AS DoanhThu "
				+ "FROM " + "HoaDon HD " + "INNER JOIN " + "ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon "
				+ "INNER JOIN " + "SanPham SP ON CTHD.maSanPham = SP.maSanPham " + "WHERE " + "SP.loaiSanPham LIKE '"
				+ loaiSP + "%' AND HD.ngayXuat BETWEEN @NgayBatDau AND @NgayKetThuc " + "GROUP BY " + "SP.loaiSanPham;";
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

	public Double tinhTongDTLoaiSPTheoThang(String loaiSP, int thang, int nam) {
		Double doanhThu = 0.0;
		String sql = "DECLARE @Thang INT = '" + thang + "';" + "DECLARE @Nam INT = '" + nam + "';" + "\r\n" + "SELECT "
				+ "SP.loaiSanPham AS LoaiSanPham, " + "SUM( " + "CASE "
				+ "WHEN HD.loaiHD like '%bán' THEN CTHD.thanhTien "
				+ "WHEN HD.loaiHD like '%trả' THEN -CTHD.thanhTien " + "ELSE 0 " + "END " + ") AS DoanhThu "
				+ "FROM " + "HoaDon HD " + "INNER JOIN " + "ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon "
				+ "INNER JOIN " + "SanPham SP ON CTHD.maSanPham = SP.maSanPham " + "WHERE " + "SP.loaiSanPham LIKE '"
				+ loaiSP + "%' AND " + "MONTH(HD.ngayXuat) = @Thang AND " + "YEAR(HD.ngayXuat) = @Nam " + "GROUP BY "
				+ "SP.loaiSanPham;";
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

	public Double tinhTongDTLoaiSPTheoNam(String loaiSP, int nam) {
		Double doanhThu = 0.0;
		String sql = "DECLARE @Nam INT = " + nam + ";" + "SELECT " + "SP.loaiSanPham AS LoaiSanPham, " + "SUM( "
				+ "CASE " + "WHEN HD.loaiHD like '%bán' THEN CTHD.thanhTien "
				+ "WHEN HD.loaiHD like '%trả' THEN -CTHD.thanhTien " + "ELSE 0 " + "END " + ") AS DoanhThu "
				+ "FROM " + "HoaDon HD " + "INNER JOIN " + "ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon "
				+ "INNER JOIN " + "SanPham SP ON CTHD.maSanPham = SP.maSanPham " + "WHERE " + "SP.loaiSanPham LIKE '"
				+ loaiSP + "%' AND " + "YEAR(HD.ngayXuat) = @Nam " + "GROUP BY " + "SP.loaiSanPham;";
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

	public int laySL_HD_TheoKhoangTG(String loai, Date ngayBatDau, Date ngayKetThuc) {
		int sl = 0;
		String sql = "DECLARE @NgayBatDau DATE = '"+ ngayBatDau +"';"
				+ "DECLARE @NgayKetThuc DATE = '"+ ngayKetThuc +"';"
				+ "\r\n"
				+ "SELECT " + "COUNT(*) AS TongSoHoaDonBan " + "FROM " + "HoaDon "
				+ "WHERE " + "loaiHD like '%"+ loai +"' AND " + "ngayXuat BETWEEN @NgayBatDau AND @NgayKetThuc;";
		try {
			Connection con = Database.getInstance().getConnection();

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sl;
	}
	
	public int laySL_HD_TheoThang(String loai, int thang, int nam) {
		int sl = 0;
		String sql = "DECLARE @Thang INT = '"+ thang +"';"
				+ "DECLARE @Nam INT = '"+ nam +"';"
				+ "\r\n"
				+ "SELECT " + "COUNT(*) AS TongSoHoaDonBan " + "FROM " + "HoaDon "
				+ "WHERE " + "loaiHD like '%" + loai + "' AND " + "MONTH(ngayXuat) = @Thang AND " + "YEAR(ngayXuat) = @Nam ;";
		try {
			Connection con = Database.getInstance().getConnection();

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sl;
	}
	
	public int laySL_HD_TheoNam(String loai, int nam) {
		int sl = 0;
		String sql = "DECLARE @Nam INT = '"+ nam +"'; "
				+ "SELECT " + "COUNT(*) AS TongSoHoaDonBan " + "FROM " + "HoaDon "
				+ "WHERE " + "loaiHD like '%" + loai + "' AND " + "YEAR(ngayXuat) = @Nam;";
		try {
			Connection con = Database.getInstance().getConnection();

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sl;
	}
	
	public List<HoaDon> getDsHD_theoKhoangTG(Date ngayBatDau, Date ngayKetThuc) {
		List<HoaDon> list = new ArrayList<HoaDon>();
		String sql= "DECLARE @NgayBatDau DATE = '" + ngayBatDau + "';" + "DECLARE @NgayKetThuc DATE = '" + ngayKetThuc
				+ "';" + "SELECT "
				+ "maHoaDon, "
				+ "maKhachHang, "
				+ "maNV, "
				+ "ngayXuat, "
				+ "loaiHD, "
				+ "ghiChu, "
				+ "maKhuyenMai "
				+ "FROM "
				+ "HoaDon "
				+ "WHERE "
				+ "ngayXuat = BETWEEN @NgayBatDau AND @NgayKetThuc;";
		try {
			Connection con = Database.getInstance().getConnection();

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				list.add(new HoaDon(rs.getString(1), new KhachHang(rs.getString(2)), new NhanVien(rs.getString(3)), rs.getDate(4), rs.getString(5), rs.getString(6), new KhuyenMaiHoaDon(rs.getString(7))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<HoaDon> getDsHD_theoNam(int nam) {
		List<HoaDon> list = new ArrayList<HoaDon>();
		String sql= "DECLARE @Nam INT = '" + nam + "';" 
				+ "SELECT "
				+ "maHoaDon, "
				+ "maKhachHang, "
				+ "maNV, "
				+ "ngayXuat, "
				+ "loaiHD, "
				+ "ghiChu, "
				+ "maKhuyenMai "
				+ "FROM "
				+ "HoaDon "
				+ "WHERE "
				+ "YEAR(ngayXuat) = @Nam;";
		try {
			Connection con = Database.getInstance().getConnection();

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				list.add(new HoaDon(rs.getString(1), new KhachHang(rs.getString(2)), new NhanVien(rs.getString(3)), rs.getDate(4), rs.getString(5), rs.getString(6), new KhuyenMaiHoaDon(rs.getString(7))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<HoaDon> getDsHD_theoThang(int thang, int nam) {
		List<HoaDon> list = new ArrayList<HoaDon>();
		String sql= "DECLARE @Thang INT = '" + thang + "';" + "DECLARE @Nam INT = '" + nam
				+ "';" + "SELECT "
				+ "maHoaDon, "
				+ "maKhachHang, "
				+ "maNV, "
				+ "ngayXuat, "
				+ "loaiHD, "
				+ "ghiChu, "
				+ "maKhuyenMai "
				+ "FROM "
				+ "HoaDon "
				+ "WHERE "
				+ "MONTH(ngayXuat) = @Thang AND YEAR(ngayXuat) = @Nam;";
		try {
			Connection con = Database.getInstance().getConnection();

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				list.add(new HoaDon(rs.getString(1), new KhachHang(rs.getString(2)), new NhanVien(rs.getString(3)), rs.getDate(4), rs.getString(5), rs.getString(6), new KhuyenMaiHoaDon(rs.getString(7))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
