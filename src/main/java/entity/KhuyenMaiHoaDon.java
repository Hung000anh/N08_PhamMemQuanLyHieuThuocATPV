package entity;

import java.util.Date;

public class KhuyenMaiHoaDon {
	private String maKM; 
	private String tenKM;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private Boolean loaiChuongTrinh;
	private Boolean trangThai;
	private Double giaTriHoaDon;
	private Double giamGiaHoaDon;
	
	
	public KhuyenMaiHoaDon(String maKM, String tenKM, Date ngayBatDau, Date ngayKetThuc, Boolean loaiChuongTrinh,
			Boolean trangThai, Double giaTriHoaDon, Double giamGiaHoaDon)  {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.loaiChuongTrinh = loaiChuongTrinh;
		this.trangThai = trangThai;
		this.giaTriHoaDon = giaTriHoaDon;
		this.giamGiaHoaDon = giamGiaHoaDon;
	}
	public KhuyenMaiHoaDon(String maKM) {
		// TODO Auto-generated constructor stub
		this.maKM = maKM;
	}
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public String getTenKM() {
		return tenKM;
	}
	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public Boolean getLoaiChuongTrinh() {
		return loaiChuongTrinh;
	}
	public void setLoaiChuongTrinh(Boolean loaiChuongTrinh) {
		this.loaiChuongTrinh = loaiChuongTrinh;
	}
	public Boolean getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}
	public Double getGiaTriHoaDon() {
		return giaTriHoaDon;
	}
	public void setGiaTriHoaDon(Double giaTriHoaDon) {
		this.giaTriHoaDon = giaTriHoaDon;
	}
	public Double getGiamGiaHoaDon() {
		return giamGiaHoaDon;
	}
	public void setGiamGiaHoaDon(Double giamGiaHoaDon) {
		this.giamGiaHoaDon = giamGiaHoaDon;
	}
	
	
}
