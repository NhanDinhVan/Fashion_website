package Model;

import java.util.Objects;

public class DonHang {
	private String maDonHang;
	private String tenKhachHang;
	private String soDienThoai;
	private String email;
	private String diachi;
	private String maKhachHang;
	public DonHang() {
		// TODO Auto-generated constructor stub
	}
	public DonHang(String maDonHang, String tenKhachHang, String soDienThoai, String email, String diachi,String maKhachHang) {
		super();
		this.maDonHang = maDonHang;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diachi = diachi;
		this.maKhachHang = maKhachHang;
	}
	public String getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diachi, email, maDonHang, soDienThoai, tenKhachHang,maKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHang other = (DonHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang) && Objects.equals(diachi, other.diachi) && Objects.equals(email, other.email)
				&& Objects.equals(maDonHang, other.maDonHang) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenKhachHang, other.tenKhachHang);
	}
	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", tenKhachHang=" + tenKhachHang + ", soDienThoai="
				+ soDienThoai + ", email=" + email + ", diachi=" + diachi +", maKhachHang=" + maKhachHang + "]";
	}
	
}
