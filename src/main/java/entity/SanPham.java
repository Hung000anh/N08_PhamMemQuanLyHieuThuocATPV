package entity;

import java.io.Serializable;
import java.util.Date;

public class SanPham implements Serializable{
	private String maSP;
	private String tenSP;
	private String loai;
	private Date ngayHetHan;
	private Date ngaySanXuat;
	private Double donGiaNhap;
	private int soluongTon;
	private Double donGiaBan;
	private String hinhAnhSanPham;
	private String DonViTinh;
	private KhuyenMaiSanPham KhuyenMai;
	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}
	public SanPham(String maSP, String tenSP, String loai, java.util.Date date1, java.util.Date date2, Double donGiaNhap,
			 int soluongTon, Double donGiaBan,String hinhAnhSanPham, String donViTinh, KhuyenMaiSanPham khuyenMai) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loai = loai;
		this.ngayHetHan = date1;
		this.ngaySanXuat = date2;
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
	public java.util.Date getNgayHetHan() {

		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	public Date getNgaySanXuat() {
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
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", loai=" + loai + ", ngayHetHan=" + ngayHetHan
				+ ", ngaySanXuat=" + ngaySanXuat + ", donGiaNhap=" + donGiaNhap + ", soluongTon=" + soluongTon
				+ ", donGiaBan=" + donGiaBan + ", hinhAnhSanPham=" + hinhAnhSanPham + ", DonViTinh=" + DonViTinh
				+ ", KhuyenMai=" + KhuyenMai + "]";
	}	

}
