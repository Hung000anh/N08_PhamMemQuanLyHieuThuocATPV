package entity;

import java.io.Serializable;
import java.util.Date;

public class KhuyenMaiSanPham implements Serializable{
	private String maKM; 
	private String tenKM;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private Boolean loaiChuongTrinh;
	private Boolean trangThai;
	private Double giamGiaSanPham;
	
	
	
	public KhuyenMaiSanPham(String maKM) {
		super();
		this.maKM = maKM;
	}

	public KhuyenMaiSanPham(String maKM, String tenKM, Date ngayBatDau, Date ngayKetThuc, Boolean loaiChuongTrinh,
			Boolean trangThai, Double giamGiaSanPham) {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc; 
		this.loaiChuongTrinh = loaiChuongTrinh;
		this.trangThai = trangThai;
		this.giamGiaSanPham = giamGiaSanPham;
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
	public Double getGiamGiaSanPham() {
		return giamGiaSanPham;
	}
	public void setGiamGiaSanPham(Double giamGiaSanPham) {
		this.giamGiaSanPham = giamGiaSanPham;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
}
