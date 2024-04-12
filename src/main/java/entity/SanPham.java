package entity;

import java.io.Serializable;
import java.sql.Date;

public class SanPham implements Serializable{
	private String maKM;
	private String tenKM;
	private String loai;
	private Date ngayHetHan;
	private Date ngaySanXuat;
	private Double donGiaNhap;
	private Double donGiaBan;
	private int soluongTon;
	private String DonViTinh;
	private String hinhAnhSanPham;
	private KhuyenMaiSanPham KhuyenMai;
	

	public SanPham(String maKM) {
		super();
		this.maKM = maKM;
	}
	
	
	public SanPham(String maKM, String tenKM, String loai, Date ngayHetHan, Date ngaySanXuat, Double donGiaNhap,
			Double donGiaBan, int soluongTon, String donViTinh, String hinhAnhSanPham, KhuyenMaiSanPham khuyenMai) {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.loai = loai;
		this.ngayHetHan = ngayHetHan;
		this.ngaySanXuat = ngaySanXuat;
		this.donGiaNhap = donGiaNhap;
		this.donGiaBan = donGiaBan;
		this.soluongTon = soluongTon;
		DonViTinh = donViTinh;
		this.hinhAnhSanPham = hinhAnhSanPham;
		KhuyenMai = khuyenMai;
	}

	public void set(String maKM, String tenKM, String loai, Date ngayHetHan, Date ngaySanXuat, Double donGiaNhap,
			Double donGiaBan, int soluongTon, String donViTinh, String hinhAnhSanPham, KhuyenMaiSanPham khuyenMai) {
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.loai = loai;
		this.ngayHetHan = ngayHetHan;
		this.ngaySanXuat = ngaySanXuat;
		this.donGiaNhap = donGiaNhap;
		this.donGiaBan = donGiaBan;
		this.soluongTon = soluongTon;
		DonViTinh = donViTinh;
		this.hinhAnhSanPham = hinhAnhSanPham;
		KhuyenMai = khuyenMai;
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
	public Date getNgayHetHan() {
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
	public String getDonViTinh() {
		return DonViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}
	public String getHinhAnhSanPham() {
		return hinhAnhSanPham;
	}
	public void setHinhAnhSanPham(String hinhAnhSanPham) {
		this.hinhAnhSanPham = hinhAnhSanPham;
	}
	public KhuyenMaiSanPham getKhuyenMai() {
		return KhuyenMai;
	}
	public void setKhuyenMai(KhuyenMaiSanPham khuyenMai) {
		KhuyenMai = khuyenMai;
	}
	public Double getDonGiaBan() {
		return donGiaBan;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	

}
