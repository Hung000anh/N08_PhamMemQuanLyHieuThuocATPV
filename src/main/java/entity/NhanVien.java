package entity;

import java.math.BigDecimal;
import java.util.Date;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String sdt;
    private boolean gioiTinh;
    private BigDecimal luong;
    private String caTruc;
    private Date ngaySinh;
    private String chucVu;
    private String trangThaiLV;
    private String hinhAnhNhanVien;

    public NhanVien(String maNV, String tenNV, String sdt, boolean gioiTinh, BigDecimal luong, String caTruc, Date ngaySinh, String chucVu, String trangThaiLV, String hinhAnhNhanVien) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.luong = luong;
        this.caTruc = caTruc;
        this.ngaySinh = ngaySinh;
        this.chucVu = chucVu;
        this.trangThaiLV = trangThaiLV;
        this.hinhAnhNhanVien = hinhAnhNhanVien;
    }

    // Getters và Setters cho maNV
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    // Getters và Setters cho tenNV
    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    // Getters và Setters cho sdt
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // Getters và Setters cho gioiTinh
    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    // Getters và Setters cho luong
    public BigDecimal getLuong() {
        return luong;
    }

    public void setLuong(BigDecimal luong) {
        this.luong = luong;
    }

    // Getters và Setters cho caTruc
    public String getCaTruc() {
        return caTruc;
    }

    public void setCaTruc(String caTruc) {
        this.caTruc = caTruc;
    }

    // Getters và Setters cho ngaySinh
    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    // Getters và Setters cho chucVu
    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    // Getters và Setters cho trangThaiLV
    public String getTrangThaiLV() {
        return trangThaiLV;
    }

    public void setTrangThaiLV(String trangThaiLV) {
        this.trangThaiLV = trangThaiLV;
    }

    // Getters và Setters cho hinhAnhNhanVien
    public String getHinhAnhNhanVien() {
        return hinhAnhNhanVien;
    }

    public void setHinhAnhNhanVien(String hinhAnhNhanVien) {
        this.hinhAnhNhanVien = hinhAnhNhanVien;
    }

    // Phương thức toString() để in thông tin NhanVien
    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV + '\'' +
                ", tenNV='" + tenNV + '\'' +
                ", sdt='" + sdt + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", luong=" + luong +
                ", caTruc='" + caTruc + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", chucVu='" + chucVu + '\'' +
                ", trangThaiLV='" + trangThaiLV + '\'' +
                ", hinhAnhNhanVien='" + hinhAnhNhanVien + '\'' +
                '}';
    }
}
