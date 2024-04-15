package entity;

public class KhachHang {
<<<<<<< HEAD
=======


>>>>>>> vantrung
	private String maKhachHang;
	private String tenKhachHang;
	private String soDienThoai;
	private boolean gioiTinh;
	private int tuoi;
	private String hinhAnhKhachHang;
<<<<<<< HEAD

=======


	public KhachHang() {
		super();
	}


>>>>>>> vantrung
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}
<<<<<<< HEAD
=======

>>>>>>> vantrung

	public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, boolean gioiTinh, int tuoi,
			String hinhAnhKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.tuoi = tuoi;
		this.hinhAnhKhachHang = hinhAnhKhachHang;
	}

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

<<<<<<< HEAD
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
=======
>>>>>>> vantrung

	public String getHinhAnhKhachHang() {
		return hinhAnhKhachHang;
	}


	public void setHinhAnhKhachHang(String hinhAnhKhachHang) {
		this.hinhAnhKhachHang = hinhAnhKhachHang;
	}


	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}


	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", soDienThoai="
				+ soDienThoai + ", gioiTinh=" + gioiTinh + ", tuoi=" + tuoi + ", hinhAnhKhachHang=" + hinhAnhKhachHang
				+ "]";
	}
<<<<<<< HEAD
}
=======


   
}
>>>>>>> vantrung
