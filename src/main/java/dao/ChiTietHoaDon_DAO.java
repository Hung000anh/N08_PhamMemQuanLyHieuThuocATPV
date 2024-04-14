package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Database;
import entity.*;


public class ChiTietHoaDon_DAO {
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
                HoaDon hd = HoaDon_DAO.layHoaDonTheoMa(maHD);
                SanPham s = SanPham_Dao.laySanPhamTheoMa(maSP);
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
}