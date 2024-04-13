package entity;

public class chiTiecHoaDon {
	private HoaDon hoaDon;
	private SanPham sanPham;
	private int soLuong;
	private Double thanhTien;
	
	
	public chiTiecHoaDon() {
		super();
	}


	public chiTiecHoaDon(HoaDon hoaDon, SanPham sanPham, int soLuong) {
		super();
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		setThanhTien();
	}


	public HoaDon getHoaDon() {
		return hoaDon;
	}


	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}


	public SanPham getSanPham() {
		return sanPham;
	}


	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public Double getThanhTien() {
		return thanhTien;
	}


	public void setThanhTien() {
		this.thanhTien = getSanPham().getDonGiaBan()*getSoLuong();
	}


	@Override
	public String toString() {
		return "chiTiecHoaDon [hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", soLuong=" + soLuong + ", thanhTien="
				+ thanhTien + "]";
	}
	
	
}
