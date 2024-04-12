package entity;

import java.util.Objects;

public class TaiKhoan {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maTaiKhoan;
	private String matKhau;
	private boolean trangThai;
	private NhanVien nhanVien;
	private String roleName;
	public TaiKhoan(String ma, String matKhau2) {
		super();
		
	}
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(String maTaiKhoan, String matKhau, boolean trangThai, String roleName) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
		this.roleName = roleName;
	}

	public TaiKhoan(String maTaiKhoan, String matKhau, boolean trangThai, NhanVien nhanVien, String roleName) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
		this.nhanVien = nhanVien;
		this.roleName = roleName;
	}
	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}
	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTaiKhoan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maTaiKhoan, other.maTaiKhoan);
	}
	@Override
	public String toString() {
		return String.format("TaiKhoan [maTaiKhoan=%s, matKhau=%s, trangThai=%s, nhanVien=%s, roleName=%s]", maTaiKhoan,
				matKhau, trangThai, nhanVien, roleName);
	}
	
}
