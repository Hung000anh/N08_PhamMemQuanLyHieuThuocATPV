package entity;

import java.io.Serializable;
import java.sql.Date;

public class SanPham implements Serializable{
	private String maSP;
	private String tenSP;
	private String loai;
	private java.util.Date ngayHetHan;
	private java.util.Date ngaySanXuat;
	private Double donGiaNhap;
	private int soluongTon;
	private Double donGiaBan;
	private String hinhAnhSanPham;
	private String DonViTinh;
	private KhuyenMaiSanPham KhuyenMai;
	
<<<<<<< HEAD
	
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public java.util.Date getNgayHetHan() {
=======
	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}
	public SanPham(String maSP, String tenSP, String loai, Date ngayHetHan, Date ngaySanXuat, Double donGiaNhap,
			int soluongTon, Double donGiaBan, String hinhAnhSanPham, String donViTinh, KhuyenMaiSanPham khuyenMai) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loai = loai;
		this.ngayHetHan = ngayHetHan;
		this.ngaySanXuat = ngaySanXuat;
		this.donGiaNhap = donGiaNhap;
		this.soluongTon = soluongTon;
		this.donGiaBan = donGiaBan;
		this.hinhAnhSanPham = hinhAnhSanPham;
		DonViTinh = donViTinh;
		KhuyenMai = khuyenMai;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public Date getNgayHetHan() {
>>>>>>> vantrung
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	public java.util.Date getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(Date ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}
	public Double getDonGiaNhap() {
		return donGiaNhap;
	}
	public void setDonGiaNhap(Double donGiaNhap) {
		this.donGiaNhap = donGiaNhap;
	}
	public int getSoluongTon() {
		return soluongTon;
	}
	public void setSoluongTon(int soluongTon) {
		this.soluongTon = soluongTon;
	}
	public Double getDonGiaBan() {
		return donGiaBan;
	}
	public void setDonGiaBan(Double donGiaBan) {
		this.donGiaBan = donGiaBan;
	}
	public String getHinhAnhSanPham() {
		return hinhAnhSanPham;
	}
	public void setHinhAnhSanPham(String hinhAnhSanPham) {
		this.hinhAnhSanPham = hinhAnhSanPham;
	}
	public String getDonViTinh() {
		return DonViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}
	public KhuyenMaiSanPham getKhuyenMai() {
		return KhuyenMai;
	}
	public void setKhuyenMai(KhuyenMaiSanPham khuyenMai) {
		KhuyenMai = khuyenMai;
	}
<<<<<<< HEAD
	public Double getDonGiaBan() {
		return donGiaBan;
	}
	public SanPham(String maSP, String tenSP, String loai, java.util.Date date, java.util.Date date2, Double donGiaNhap,
			Double donGiaBan, int soluongTon, String donViTinh, String hinhAnhSanPham, KhuyenMaiSanPham khuyenMai) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loai = loai;
		this.ngayHetHan = date;
		this.ngaySanXuat = date2;
		this.donGiaNhap = donGiaNhap;
		this.donGiaBan = donGiaBan;
		this.soluongTon = soluongTon;
		DonViTinh = donViTinh;
		this.hinhAnhSanPham = hinhAnhSanPham;
		KhuyenMai = khuyenMai;
=======
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", loai=" + loai + ", ngayHetHan=" + ngayHetHan
				+ ", ngaySanXuat=" + ngaySanXuat + ", donGiaNhap=" + donGiaNhap + ", soluongTon=" + soluongTon
				+ ", donGiaBan=" + donGiaBan + ", hinhAnhSanPham=" + hinhAnhSanPham + ", DonViTinh=" + DonViTinh
				+ ", KhuyenMai=" + KhuyenMai + "]";
>>>>>>> vantrung
	}
	
	
	
	
<<<<<<< HEAD
	
	
	
}
=======
}
>>>>>>> vantrung
