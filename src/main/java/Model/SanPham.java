package Model;

import java.util.Objects;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private String soLuong;
	private String giaSanPham;
	private String nhaBanHang;
	private String linkHinhAnh;
	private String nguonGoc;
	private String hangSanXuat;
	private String phanLoai;
	public SanPham() {
		// TODO Auto-generated constructor stub
	}
	public SanPham(String maSanPham, String tenSanPham, String soLuong, String giaSanPham, String nhaBanHang,
			String linkHinhAnh, String nguonGoc, String hangSanXuat, String phanLoai) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.giaSanPham = giaSanPham;
		this.nhaBanHang = nhaBanHang;
		this.linkHinhAnh = linkHinhAnh;
		this.nguonGoc = nguonGoc;
		this.hangSanXuat = hangSanXuat;
		this.phanLoai = phanLoai;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	public String getGiaSanPham() {
		return giaSanPham;
	}
	public void setGiaSanPham(String giaSanPham) {
		this.giaSanPham = giaSanPham;
	}
	public String getNhaBanHang() {
		return nhaBanHang;
	}
	public void setNhaBanHang(String nhaBanHang) {
		this.nhaBanHang = nhaBanHang;
	}
	public String getLinkHinhAnh() {
		return linkHinhAnh;
	}
	public void setLinkHinhAnh(String linkHinhAnh) {
		this.linkHinhAnh = linkHinhAnh;
	}
	public String getNguonGoc() {
		return nguonGoc;
	}
	public void setNguonGoc(String nguonGoc) {
		this.nguonGoc = nguonGoc;
	}
	public String getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	public String getPhanLoai() {
		return phanLoai;
	}
	public void setPhanLoai(String phanLoai) {
		this.phanLoai = phanLoai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaSanPham, hangSanXuat, linkHinhAnh, maSanPham, nguonGoc, nhaBanHang, phanLoai, soLuong,
				tenSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(giaSanPham, other.giaSanPham) && Objects.equals(hangSanXuat, other.hangSanXuat)
				&& Objects.equals(linkHinhAnh, other.linkHinhAnh) && Objects.equals(maSanPham, other.maSanPham)
				&& Objects.equals(nguonGoc, other.nguonGoc) && Objects.equals(nhaBanHang, other.nhaBanHang)
				&& Objects.equals(phanLoai, other.phanLoai) && Objects.equals(soLuong, other.soLuong)
				&& Objects.equals(tenSanPham, other.tenSanPham);
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", soLuong=" + soLuong
				+ ", giaSanPham=" + giaSanPham + ", nhaBanHang=" + nhaBanHang + ", linkHinhAnh=" + linkHinhAnh
				+ ", nguonGoc=" + nguonGoc + ", hangSanXuat=" + hangSanXuat + ", phanLoai=" + phanLoai + "]";
	}
	
	
}
