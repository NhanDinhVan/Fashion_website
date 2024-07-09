package Model;

import java.util.Objects;

public class ChiTietDonHang {
	private String maDonHang;
	private String maSanPham;
	private String soLuong;
	public ChiTietDonHang() {
		// TODO Auto-generated constructor stub
	}
	public ChiTietDonHang(String maDonHang, String maSanPham, String soLuong) {
		super();
		this.maDonHang = maDonHang;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
	}
	public String getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDonHang, maSanPham, soLuong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHang other = (ChiTietDonHang) obj;
		return Objects.equals(maDonHang, other.maDonHang) && Objects.equals(maSanPham, other.maSanPham)
				&& Objects.equals(soLuong, other.soLuong);
	}
	@Override
	public String toString() {
		return "ChiTietDonHang [maDonHang=" + maDonHang + ", maSanPham=" + maSanPham + ", soLuong=" + soLuong + "]";
	}
	
	
}
