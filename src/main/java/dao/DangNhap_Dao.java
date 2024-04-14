package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class DangNhap_Dao {
	private static ArrayList<TaiKhoan>  dsTK = new ArrayList<TaiKhoan>();

	public static ArrayList<TaiKhoan> getAllTaiKhoan() {
		dsTK.clear();
		try {
			ConnectDB.getConnection();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TaiKhoan";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maTaiKhoan = rs.getString(1);
				String matKhau = rs.getString(2);
				boolean trangThai= rs.getBoolean(3);
				NhanVien nv = new NhanVien(rs.getString(4));
				String roleName = rs.getString(5);
				TaiKhoan tk = new TaiKhoan(maTaiKhoan, matKhau, trangThai, nv, roleName);
				dsTK.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsTK;
	}
	
	//hàm tìm mã nv và mk để tiến hành đăng nhập
	public boolean Timkiem(String maNV, String mk) {
        boolean found = false;
        try {
        	ConnectDB.getConnection();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from TaiKhoan where maTaiKhoan = N'" + maNV + "' and matkhau = N'" + mk + "'";
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if (rs.next()) {
                found = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }
	
	// hàm quên mk sau đó cập nhật lại mk mới 
	public boolean doiMatKhau(String soDienThoai, String matKhauMoi) {
		boolean updated = false;
		try {
			ConnectDB.getConnection();
			Connection con = ConnectDB.getConnection();
			// Kiểm tra xem số điện thoại có phù hợp với mã nhân viên không
			String sqlCheck = "select maNhanVien from NhanVien where soDienThoai = N'"+soDienThoai+"'";
			Statement staCheck = con.createStatement();
			ResultSet rsCheck = staCheck.executeQuery(sqlCheck);
			if(rsCheck.next()) {
				String maNV = rsCheck.getString(1);
				// Nếu phù hợp, cập nhật mật khẩu mới
				String sqlUpdate = "update TaiKhoan set matKhau = N'"+matKhauMoi+"' where maTaiKhoan = N'"+maNV+"'";
				Statement staUpdate = con.createStatement();
				int rowsUpdated = staUpdate.executeUpdate(sqlUpdate);
				if(rowsUpdated > 0) {
					updated = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updated;
	}
	// kiểm tra sdt có tồn tại trong hệ thống
	public boolean TimkiemSDT(String SDT){
		boolean found = false;
		try {
			ConnectDB.getConnection();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien where sdt = N'"+SDT+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			if(rs.next()) {
				found = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return found;
	}
//tìm mk theo manv
	public TaiKhoan LayMatKhauTheoMaNhanVien(String maNhanVien) {
	    TaiKhoan taiKhoan = null;
	    try {
	    	ConnectDB.getConnection();
	        Connection con = ConnectDB.getConnection();
	        String sql = "select TaiKhoan.* from TaiKhoan inner join NhanVien on TaiKhoan.maTaiKhoan = NhanVien.maNV where NhanVien.maNV = '" + maNhanVien + "'";
	        Statement stm = con.createStatement();
	        ResultSet rs = stm.executeQuery(sql);
	        if (rs.next()) {
	            String maTaiKhoan = rs.getString("maTaiKhoan");
	            String matKhau = rs.getString("matKhau");
	            boolean trangThai = rs.getBoolean("trangThai");
	            String roleName = rs.getString("roleName");
	            NhanVien nhanVien = new NhanVien(maNhanVien);
	            taiKhoan = new TaiKhoan(maTaiKhoan, matKhau, trangThai, nhanVien, roleName);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return taiKhoan;
	}
//đổi mk theo ma nv
	public boolean doiMatKhauTheoMaNV(String maNhanVien, String matKhauMoi) {
	    boolean updated = false;
	    try {
	    	ConnectDB.getConnection();
	        Connection con = ConnectDB.getConnection();
	        // Kiểm tra xem mã nhân viên có tồn tại không
	        String sqlCheck = "select maNV from NhanVien where maNV = N'"+maNhanVien+"'";
	        Statement staCheck = con.createStatement();
	        ResultSet rsCheck = staCheck.executeQuery(sqlCheck);
	        if(rsCheck.next()) {
	            // Nếu tồn tại, cập nhật mật khẩu mới
	            String sqlUpdate = "update TaiKhoan set matKhau = N'"+matKhauMoi+"' where maTaiKhoan = N'"+maNhanVien+"'";
	            Statement staUpdate = con.createStatement();
	            int rowsUpdated = staUpdate.executeUpdate(sqlUpdate);
	            if(rowsUpdated > 0) {
	                updated = true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return updated;
	}
	//thêm tk và  mk cho nv mới
	public boolean Them_taiKhoan_matKhau(TaiKhoan tk) {
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
			psmt = con.prepareStatement("insert into TaiKhoan values(?,?,?,?)");
			psmt.setString(1, tk.getMaTaiKhoan());
			psmt.setString(2, tk.getMatKhau());
			psmt.setBoolean(3, tk.isTrangThai());
			psmt.setString(4, tk.getRoleName());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return n > 0;
	}


	public String getRole(String maTaiKhoan, String matkhau) {
	    String role = null;
	    try {
	    	ConnectDB.getConnection();
	        Connection con = ConnectDB.getConnection();
	        String sql = "select roleName from TaiKhoan where maTaiKhoan = ? and matkhau = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, maTaiKhoan);
	        stmt.setString(2, matkhau);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            role = rs.getString("roleName");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return role;
	}
	public Boolean doiTrangThaiTheoMa(String ma, boolean trangThai) {
		try {
			ConnectDB.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    Connection con = null;
	    PreparedStatement psmt = null;
	    int n = 0;
	    try {
	        con = ConnectDB.getConnection();
	        psmt = con.prepareStatement(
	                "update TaiKhoan set trangThai=? where maTaiKhoan=?");
	        psmt.setBoolean(1, trangThai);
	        psmt.setString(2, ma);
	   
	        n = psmt.executeUpdate();
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    } finally {
	        try {
	            if (psmt != null) psmt.close();
	            
	        } catch (Exception e2) {
	            System.out.println("Error: " + e2.getMessage());
	        }
	    }
	    return n > 0;
	}
}
