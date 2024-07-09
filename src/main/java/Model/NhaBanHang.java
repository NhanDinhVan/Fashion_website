package Model;

import java.util.Objects;

public class NhaBanHang {
	private String maNhaBanHang;
	private String tenNhaBanHang;
	private String soDienThoai;
	private String matKhau;
	private String tenDangNhap;
	public NhaBanHang() {
		
		// TODO Auto-generated constructor stub
	}
	public NhaBanHang(String maNhaBanHang, String tenNhaBanHang, String soDienThoai, String matKhau,
			String tenDangNhap) {
		super();
		this.maNhaBanHang = maNhaBanHang;
		this.tenNhaBanHang = tenNhaBanHang;
		this.soDienThoai = soDienThoai;
		this.matKhau = matKhau;
		this.tenDangNhap = tenDangNhap;
	}
	public String getMaNhaBanHang() {
		return maNhaBanHang;
	}
	public void setMaNhaBanHang(String maNhaBanHang) {
		this.maNhaBanHang = maNhaBanHang;
	}
	public String getTenNhaBanHang() {
		return tenNhaBanHang;
	}
	public void setTenNhaBanHang(String tenNhaBanHang) {
		this.tenNhaBanHang = tenNhaBanHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
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
		return Objects.hash(maNhaBanHang, matKhau, soDienThoai, tenDangNhap, tenNhaBanHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaBanHang other = (NhaBanHang) obj;
		return Objects.equals(maNhaBanHang, other.maNhaBanHang) && Objects.equals(matKhau, other.matKhau)
				&& Objects.equals(soDienThoai, other.soDienThoai) && Objects.equals(tenDangNhap, other.tenDangNhap)
				&& Objects.equals(tenNhaBanHang, other.tenNhaBanHang);
	}
	@Override
	public String toString() {
		return "NhaBanHang [maNhaBanHang=" + maNhaBanHang + ", tenNhaBanHang=" + tenNhaBanHang + ", soDienThoai="
				+ soDienThoai + ", matKhau=" + matKhau + ", tenDangNhap=" + tenDangNhap + "]";
	}
	
	
}
