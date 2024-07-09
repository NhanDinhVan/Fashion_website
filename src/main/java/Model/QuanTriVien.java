package Model;

import java.util.Objects;

public class QuanTriVien {
	private String maQtv;
	private String hoTen;
	private String tenDangNhap;
	private String matKhau;
	private String soDienThoai;
	public QuanTriVien() {
	
		// TODO Auto-generated constructor stub
	}
	public QuanTriVien(String maQtv, String hoTen, String tenDangNhap, String matKhau, String soDienThoai) {
		super();
		this.maQtv = maQtv;
		this.hoTen = hoTen;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.soDienThoai = soDienThoai;
	}
	public String getMaQtv() {
		return maQtv;
	}
	public void setMaQtv(String maQtv) {
		this.maQtv = maQtv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(hoTen, maQtv, matKhau, soDienThoai, tenDangNhap);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuanTriVien other = (QuanTriVien) obj;
		return Objects.equals(hoTen, other.hoTen) && Objects.equals(maQtv, other.maQtv)
				&& Objects.equals(matKhau, other.matKhau) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenDangNhap, other.tenDangNhap);
	}
	@Override
	public String toString() {
		return "QuanTriVien [maQtv=" + maQtv + ", hoTen=" + hoTen + ", tenDangNhap=" + tenDangNhap + ", matKhau="
				+ matKhau + ", soDienThoai=" + soDienThoai + "]";
	}
	
	
}
