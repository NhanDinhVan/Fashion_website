package Model;

import java.util.Objects;

public class GioHang {
	private String maGioHang;
	private String maSanPham;
	private String maKhachHang;
	private int soLuong;
	public GioHang() {
		// TODO Auto-generated constructor stub
	}
	public GioHang(String maGioHang, String maSanPham, String maKhachHang,int soLuong) {
		super();
		this.maGioHang = maGioHang;
		this.maSanPham = maSanPham;
		this.maKhachHang = maKhachHang;
		this.soLuong = soLuong;
	}
	public String getMaGioHang() {
		return maGioHang;
	}
	public void setMaGioHang(String maGioHang) {
		this.maGioHang = maGioHang;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maGioHang, maKhachHang, maSanPham, soLuong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GioHang other = (GioHang) obj;
		return Objects.equals(maGioHang, other.maGioHang) && Objects.equals(maKhachHang, other.maKhachHang)
				&& Objects.equals(maSanPham, other.maSanPham) && soLuong == other.soLuong;
	}
	@Override
	public String toString() {
		return "GioHang [maGioHang=" + maGioHang + ", maSanPham=" + maSanPham + ", maKhachHang=" + maKhachHang
				+ ", soLuong=" + soLuong + "]";
	}

	
	
}
