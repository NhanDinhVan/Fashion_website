package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.KhachHang;
import Database.JDBCUtil;


public class KhachHangDao implements DAOInterface<KhachHang> {
	@Override
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub
		
		ArrayList<KhachHang> ketqua = new ArrayList<KhachHang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			// Bước 4:
			while(rs.next()) {
				String maKhachHang = rs.getString("makhachhang");			
				String tenKhachHang = rs.getString("tenkhachhang");
				String ngaySinh = rs.getString("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String diaChi = rs.getString("diachi");				
				
				
				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, ngaySinh, soDienThoai, diaChi, soDienThoai, diaChi);
				ketqua.add(kh);
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketqua;
	
		
		
		
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang where makhachhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maKhachHang = rs.getString("makhachhang");			
				String tenKhachHang = rs.getString("tenkhachhang");
				String ngaySinh = rs.getString("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String diaChi = rs.getString("diachi");	
				
				
				
				ketQua = new KhachHang(maKhachHang, tenKhachHang, ngaySinh, soDienThoai, diaChi, soDienThoai, diaChi);
				
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
		
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO khachhang (makhachhang,tenkhachhang,ngaysinh,sodienthoai,diachi,matkhau,tendangnhap) "+
					" VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());
			st.setString(2,t.getTenKhachHang());
			st.setString(3,t.getNgaySinh());
			st.setString(4,t.getSoDienThoai());
			st.setString(5,t.getDiaChi());
			st.setString(6,t.getMatKhau());
			st.setString(7,t.getTenDangNhap());
		
			
			
			
			
			
			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;	
		}

	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (KhachHang khachHang : arr) {
			dem+=this.insert(khachHang);
			
		}
		return dem;
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from khachhang "+
					 " WHERE makhachhang=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;	
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (KhachHang khachHang : arr) {
			dem+=this.delete(khachHang);
			
		}
		return dem;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE diem "+
					 " SET " +
					 "makhachhang=?"+
					 ",tenkhachhang=?"+
					 ",ngaysinh=?"+
					 ",sodienthoai=?"+ 
					 ",diachi=?"+
					 ",matkhau=?"+
					 ",tendangnhap=?"+
					 
					 " WHERE makhachhang=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhachHang());
			st.setString(2,t.getTenKhachHang());
			st.setString(3,t.getNgaySinh());
			st.setString(4,t.getSoDienThoai());
			st.setString(5,t.getDiaChi());
			st.setString(6,t.getMatKhau());
			st.setString(7,t.getTenDangNhap());
			
			
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
		
	}
	public KhachHang selectByIdAndPass(KhachHang t) {
		KhachHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang WHERE tendangnhap=? and matkhau=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, t.getTenDangNhap());
			st.setString(2, t.getMatKhau());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maKhachHang = rs.getString("makhachhang");			
				String tenKhachHang = rs.getString("tenkhachhang");
				String ngaySinh = rs.getString("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String diaChi = rs.getString("diachi");
				
				
				
				
				
				ketQua = new KhachHang(maKhachHang, tenKhachHang, ngaySinh, soDienThoai, diaChi, soDienThoai, diaChi);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	
}
