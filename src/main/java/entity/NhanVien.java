package entity;

import java.sql.Date;

public class NhanVien {
	private String maNV,tenNV;
	private String sdt;
	private boolean gioiTinh;
	private Double luong;
	private String caTruc;
	private Date ngaySinh;
	private boolean trangThaiLV;
	private boolean chucVu;
	private String hinhAnhNhanVien;
	
	public NhanVien() {
		super();
		
	}
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	public NhanVien(String maNV, String tenNV, String sdt, boolean gioiTinh, Double luong, String caTruc, Date ngaySinh,
			boolean trangThaiLV, boolean chucVu, String hinhAnhNhanVien) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.luong = luong;
		this.caTruc = caTruc;
		this.ngaySinh = ngaySinh;
		this.trangThaiLV = trangThaiLV;
		this.chucVu = chucVu;
		this.hinhAnhNhanVien = hinhAnhNhanVien;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Double getLuong() {
		return luong;
	}
	public void setLuong(Double luong) {
		this.luong = luong;
	}
	public String getCaTruc() {
		return caTruc;
	}
	public void setCaTruc(String caTruc) {
		this.caTruc = caTruc;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isTrangThaiLV() {
		return trangThaiLV;
	}
	public void setTrangThaiLV(boolean trangThaiLV) {
		this.trangThaiLV = trangThaiLV;
	}
	public boolean isChucVu() {
		return chucVu;
	}
	public void setChucVu(boolean chucVu) {
		this.chucVu = chucVu;
	}
	public String getHinhAnhNhanVien() {
		return hinhAnhNhanVien;
	}
	public void setHinhAnhNhanVien(String hinhAnhNhanVien) {
		this.hinhAnhNhanVien = hinhAnhNhanVien;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", luong="
				+ luong + ", caTruc=" + caTruc + ", ngaySinh=" + ngaySinh + ", trangThaiLV=" + trangThaiLV + ", chucVu="
				+ chucVu + ", hinhAnhNhanVien=" + hinhAnhNhanVien + "]";
	}
	
	
	
}
