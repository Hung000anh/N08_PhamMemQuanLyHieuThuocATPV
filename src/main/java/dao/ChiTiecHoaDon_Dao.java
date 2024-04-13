package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.chiTiecHoaDon;

public class ChiTiecHoaDon_Dao {
	public boolean addChiTiecHoaDon(chiTiecHoaDon cthd) {
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
			psmt = con.prepareStatement("insert into ChiTiecHoaDon values(?,?,?,?)");
			psmt.setString(1, cthd.getHoaDon().getMaHD());
			psmt.setString(2, cthd.getSanPham().getMaSP());
			psmt.setInt(3, cthd.getSoLuong());
			psmt.setDouble(4, cthd.getThanhTien());
			
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
}
