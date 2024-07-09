package Model;

import java.util.Objects;

public class Banner {
	private String maBanner;
	private String nhaBanHang;
	private String linkBanner;
	
	
	public Banner() {
		
		// TODO Auto-generated constructor stub
	}


	public Banner(String maBanner, String nhaBanHang, String linkBanner) {
		super();
		this.maBanner = maBanner;
		this.nhaBanHang = nhaBanHang;
		this.linkBanner = linkBanner;
	}


	public String getMaBanner() {
		return maBanner;
	}


	public void setMaBanner(String maBanner) {
		this.maBanner = maBanner;
	}


	public String getNhaBanHang() {
		return nhaBanHang;
	}


	public void setNhaBanHang(String nhaBanHang) {
		this.nhaBanHang = nhaBanHang;
	}


	public String getLinkBanner() {
		return linkBanner;
	}


	public void setLinkBanner(String linkBanner) {
		this.linkBanner = linkBanner;
	}


	@Override
	public int hashCode() {
		return Objects.hash(linkBanner, maBanner, nhaBanHang);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banner other = (Banner) obj;
		return Objects.equals(linkBanner, other.linkBanner) && Objects.equals(maBanner, other.maBanner)
				&& Objects.equals(nhaBanHang, other.nhaBanHang);
	}


	@Override
	public String toString() {
		return "Banner [maBanner=" + maBanner + ", nhaBanHang=" + nhaBanHang + ", linkBanner=" + linkBanner + "]";
	}
	
}