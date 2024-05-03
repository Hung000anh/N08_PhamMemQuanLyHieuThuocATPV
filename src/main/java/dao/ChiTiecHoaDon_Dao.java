package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import connectDB.Database;
import entity.*;


public class ChiTiecHoaDon_Dao {
    private static ArrayList<ChiTietHoaDon> list =  new ArrayList<ChiTietHoaDon>();

    public static ArrayList<ChiTietHoaDon> docTubang() {
    	list.clear();

        try {
            Connection con = Database.getInstance().getConnection();
            String sql = "SELECT * FROM ChiTietHoaDon"; // Corrected table name
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            	String maHD = rs.getString(1);
                String maSP = rs.getString(2);
                int SoLuong = rs.getInt(3);
                HoaDon hd = new HoaDon(maHD);
                SanPham s = SanPham_Dao.getSPTheoMa(maSP);
                list.add(new ChiTietHoaDon(
                		hd,
                		s,
                		SoLuong
                ));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return list;
    }

    // gọi docTuBang() trước
    public static ArrayList<ChiTietHoaDon> layChiTietHoaDonTheoMaHD(String maHD) {
    	ArrayList<ChiTietHoaDon> lst = new ArrayList<ChiTietHoaDon>();
    	for (ChiTietHoaDon hd : list) {
    		if (maHD.equals(hd.getHoaDon().getMaHD()))
    			lst.add(hd);
    	}
    	return lst;
    }

    public static boolean them(ChiTietHoaDon k) {
        try (Connection con = Database.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("INSERT INTO ChiTietHoaDon VALUES (?, ?, ?, ?)")) {

            // Thiết lập các giá trị cho câu lệnh truy vấn
            stmt.setString(1, k.getHoaDon().getMaHD());
            stmt.setString(2, k.getSanPham().getMaSP());
            stmt.setInt(3, k.getSoLuong());
            stmt.setDouble(4, k.getThanhTien());

            int n = stmt.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public static boolean deleteChiTiecHoaDon(String tenSP) {

		int n = 0;
			PreparedStatement psmt = null;
		try {
			Connection con = Database.getInstance().getConnection();
			psmt = con.prepareStatement("DELETE FROM ChiTietHoaDon WHERE maSanPham=?;");
			psmt.setString(1, tenSP);

			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
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
}