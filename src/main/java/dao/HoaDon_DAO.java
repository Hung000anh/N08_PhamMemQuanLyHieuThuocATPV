package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connectDB.ConnectDB;
import connectDB.Database;
import entity.*;


public class HoaDon_DAO {
    private static ArrayList<HoaDon> DanhSachHoaDon  = new ArrayList<HoaDon>();

    public HoaDon_DAO() {
    	docTubang();
    }

    public static ArrayList<HoaDon> docTubang() {
    	DanhSachHoaDon.clear();
        try {
            Connection con = Database.getInstance().getConnection();
            String sql = "SELECT * FROM HoaDon"; // Corrected table name
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            	String maHD = rs.getString(1); 
            	String maKhachHang = rs.getString(2);
            	KhachHang khachHang;
				khachHang =new KhachHang(maKhachHang);
            	String maNV = rs.getString(3);
            	NhanVien nhanVien = NhanVien_Dao.getNhanVienTheoMa(maNV);
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
<<<<<<< HEAD
//<<<<<<< HEAD
=======

>>>>>>> vantrung

    // gọi docTuBang() trước
    public static HoaDon layHoaDonTheoMa(String maHD) {
    	for (HoaDon hd : DanhSachHoaDon) {
    		if (maHD.equals(hd.getMaHD()))
    			return hd;
    	}
    	return new HoaDon(maHD); // TRÁNH LỖI
    }

    // gọi docTuBang() trước
    public static int laySLHoaDonTheoNgay(String ngay) {
    	int num = 0;
    	for (HoaDon hd : DanhSachHoaDon) {
    		java.util.Date date = hd.getNgayXuat();
            DateFormat dateFormat = new SimpleDateFormat("ddMMyy");  
            String strDate = dateFormat.format(date);
    		if (ngay.equals(strDate))
    			num++;
    	}
    	return num;
    }

    public static boolean them(HoaDon k) {
        try (Connection con = Database.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("INSERT INTO HoaDon VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            // Thiết lập các giá trị cho câu lệnh truy vấn
            stmt.setString(1, k.getMaHD());
            stmt.setString(2, k.getKhachHang().getMaKhachHang());
            stmt.setString(3, k.getNhanVien().getMaNV()); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setDate(4, new java.sql.Date(k.getNgayXuat().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stmt.setString(5, k.getLoaiHD());
            stmt.setString(6, k.getGhiChu());
            if (k.getKhuyenMai() == null)
            		stmt.setNull(7,  Types.VARCHAR);
            else
            		stmt.setString(7, k.getKhuyenMai().getMaKM());

            int n = stmt.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
<<<<<<< HEAD
    }

//=======
=======
    
}

>>>>>>> vantrung
    public boolean addHoaDon(HoaDon hd) {
        try {
            ConnectDB.getConnection();
        } catch (Exception e) {
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
            if(hd.getKhuyenMai() != null) {
                psmt.setString(7, hd.getKhuyenMai().getMaKM());
            } else {
                psmt.setNull(7, java.sql.Types.VARCHAR);
            }
            n = psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                psmt.close();
            } catch (Exception e2) {
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
<<<<<<< HEAD
//>>>>>>> vantrung
=======

>>>>>>> vantrung
