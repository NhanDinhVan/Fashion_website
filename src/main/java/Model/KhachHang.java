package Model;

import java.sql.Date;
import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String ngaySinh;
	private String soDienThoai;
	private String diaChi;
	private String matKhau;
	private String tenDangNhap;
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKhachHang, String tenKhachHang, String ngaySinh, String soDienThoai, String diaChi,
			String matKhau, String tenDangNhap) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.tenDangNhap = tenDangNhap;
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
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diaChi, maKhachHang, matKhau, ngaySinh, soDienThoai, tenDangNhap, tenKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(maKhachHang, other.maKhachHang)
				&& Objects.equals(matKhau, other.matKhau) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(soDienThoai, other.soDienThoai) && Objects.equals(tenDangNhap, other.tenDangNhap)
				&& Objects.equals(tenKhachHang, other.tenKhachHang);
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", ngaySinh=" + ngaySinh
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", matKhau=" + matKhau + ", tenDangNhap="
				+ tenDangNhap + "]";
	}
	
}