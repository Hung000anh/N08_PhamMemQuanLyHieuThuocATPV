package entity;

import java.util.Date;

public class HoaDon {
    private String maHD;
    private Date ngayXuat;
    private NhanVien nhanVien;
    private String loaiHD;
    private String ghiChu;
    private KhachHang khachHang;
    private KhuyenMaiHoaDon khuyenMai;
    
    

    public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}

	public HoaDon(String maHD, KhachHang khachHang, NhanVien nhanVien, Date ngayXuat, String loaiHD, String ghiChu, KhuyenMaiHoaDon khuyenMai) {
        this.maHD = maHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ngayXuat = ngayXuat;
        this.loaiHD = loaiHD;
        this.ghiChu = ghiChu;
        this.khuyenMai = khuyenMai;
    }

    // Getter và Setter cho maHD
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    // Getter và Setter cho ngayXuat
    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    // Getter và Setter cho nhanVien
    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    // Getter và Setter cho loaiHD
    public String getLoaiHD() {
        return loaiHD;
    }

    public void setLoaiHD(String loaiHD) {
        this.loaiHD = loaiHD;
    }

    // Getter và Setter cho ghiChu
    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    // Getter và Setter cho khachHang
    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    // Getter và Setter cho khuyenMai
    public KhuyenMaiHoaDon getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMaiHoaDon khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
}
