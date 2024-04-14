package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhuyenMaiSanPham;
import entity.NhanVien;
import entity.SanPham;
import entity.ChiTietHoaDon;

public class ThongKe_Dao {
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private SanPham_Dao sp_dao = new SanPham_Dao();
	
//	public List<SanPham> top_5_SpBanChay() {
//		List<SanPham> dssp = new ArrayList<SanPham>();
//		List<ChiTiecHoaDon> ds_ctHD = new ArrayList<ChiTiecHoaDon>();
//		try {
//			Connection con = ConnectDB.getConnection();
//			String sql = "select * from ChiTietHoaDon";
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while (rs.next()) {
//				ChiTiecHoaDon chiTiecHoaDon = new ChiTiecHoaDon(hd_dao.getHoaDonTheoMa(rs.getString(1)), sp_dao.getSanPhamTheoMa(rs.getString(2)), rs.getInt(3));
//				chiTiecHoaDon.setThanhTien();
//				ds_ctHD.add(chiTiecHoaDon);
//			}
//			
//			while
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dssp;
//	}
	
	public List<SanPham> top_5_SpBanChay() {
		List<SanPham> dssp = new ArrayList<SanPham>();
		List<ChiTietHoaDon> ds_ctHD = new ArrayList<ChiTietHoaDon>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT TOP 5\r\n"
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
					+ "    SUM(CTHD.soLuong) DESC;";
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
}
