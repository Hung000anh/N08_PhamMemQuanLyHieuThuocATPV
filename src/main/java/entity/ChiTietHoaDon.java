package entity;

public class ChiTietHoaDon {
    private HoaDon hoaDon;
    private SanPham sanPham;
    private int soLuong;

    // Constructor
    public ChiTietHoaDon(HoaDon hoaDon, SanPham sanPham, int soLuong) {
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    // Getters
    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getThanhTien() {
        double thanhtien = sanPham.getDonGiaBan() * soLuong;
        double giamgiahoadon = 0;
        double giamgiasanpham = 0;
        
        KhuyenMaiHoaDon kmhd = hoaDon.getKhuyenMai();
        KhuyenMaiSanPham kmsp = sanPham.getKhuyenMai();
        
        if (kmhd != null && kmhd.getGiamGiaHoaDon() != null)
        	giamgiahoadon = thanhtien*kmhd.getGiamGiaHoaDon();
        if (kmsp != null && kmsp.getGiamGiaSanPham() != null)
        	giamgiasanpham = thanhtien*kmsp.getGiamGiaSanPham();
        
        return thanhtien - giamgiahoadon - giamgiasanpham;
    }

    // Setters
    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
