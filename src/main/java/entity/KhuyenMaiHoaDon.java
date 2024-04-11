package entity;

import java.math.BigDecimal;
import java.util.Date;

public class KhuyenMaiHoaDon {
    private String maKhuyenMai;
    private String tenKhuyenMai;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String loaiChuongTrinh;
    private boolean trangThai;
    private BigDecimal giaTriHoaDon;
    private float giamGiaHoaDon;

    public KhuyenMaiHoaDon(String maKhuyenMai, String tenKhuyenMai, Date ngayBatDau, Date ngayKetThuc, String loaiChuongTrinh, boolean trangThai, BigDecimal giaTriHoaDon, float giamGiaHoaDon) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.loaiChuongTrinh = loaiChuongTrinh;
        this.trangThai = trangThai;
        this.giaTriHoaDon = giaTriHoaDon;
        this.giamGiaHoaDon = giamGiaHoaDon;
    }

    // Getters và Setters cho maKhuyenMai
    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    // Getters và Setters cho tenKhuyenMai
    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    // Getters và Setters cho ngayBatDau
    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    // Getters và Setters cho ngayKetThuc
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    // Getters và Setters cho loaiChuongTrinh
    public String getLoaiChuongTrinh() {
        return loaiChuongTrinh;
    }

    public void setLoaiChuongTrinh(String loaiChuongTrinh) {
        this.loaiChuongTrinh = loaiChuongTrinh;
    }

    // Getters và Setters cho trangThai
    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    // Getters và Setters cho giaTriHoaDon
    public BigDecimal getGiaTriHoaDon() {
        return giaTriHoaDon;
    }

    public void setGiaTriHoaDon(BigDecimal giaTriHoaDon) {
        this.giaTriHoaDon = giaTriHoaDon;
    }

    // Getters và Setters cho giamGiaHoaDon
    public float getGiamGiaHoaDon() {
        return giamGiaHoaDon;
    }

    public void setGiamGiaHoaDon(float giamGiaHoaDon) {
        this.giamGiaHoaDon = giamGiaHoaDon;
    }

    // Phương thức toString() để in thông tin KhuyenMaiHoaDon
    @Override
    public String toString() {
        return "KhuyenMaiHoaDon{" +
                "maKhuyenMai='" + maKhuyenMai + '\'' +
                ", tenKhuyenMai='" + tenKhuyenMai + '\'' +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", loaiChuongTrinh='" + loaiChuongTrinh + '\'' +
                ", trangThai=" + trangThai +
                ", giaTriHoaDon=" + giaTriHoaDon +
                ", giamGiaHoaDon=" + giamGiaHoaDon +
                '}';
    }
}

