package entity;

public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private boolean gioiTinh;
    private int tuoi;

    public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, boolean gioiTinh, int tuoi) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
    }

    // Getters và Setters cho mỗi thuộc tính
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    // Phương thức toString() để in thông tin KhachHang
    @Override
    public String toString() {
        return "KhachHang{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", tuoi=" + tuoi +
                '}';
    }
}
