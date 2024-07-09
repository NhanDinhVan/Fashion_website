package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.GioHang;
import Model.KhachHang;
import Model.NhaBanHang;

public class NhaBanHangDao implements DAOInterface<NhaBanHang> {
	@Override
	public ArrayList<NhaBanHang> selectAll() {
		// TODO Auto-generated method stub
		
		ArrayList<NhaBanHang> ketqua = new ArrayList<NhaBanHang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM nhabanhang";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			// Bước 4:
			while(rs.next()) {
				String manhaBanHang = rs.getString("tennbh");			
				String tenNhaBanHang = rs.getString("sodienthoai");
				String matKhau = rs.getString("matkhau");
				String tenDangNhap = rs.getString("tendangnhap");
				
				
				NhaBanHang nbh = new NhaBanHang(manhaBanHang, tenNhaBanHang, tenNhaBanHang, matKhau, tenDangNhap);
				ketqua.add(nbh);
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
	public NhaBanHang selectById(NhaBanHang t) {
		NhaBanHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM nhabanhang where manbh=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaNhaBanHang());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String manhaBanHang = rs.getString("manbh");			
				String tenNhaBanHang = rs.getString("tennbh");
				String soDienThoai = rs.getString("sodienthoai");				
				String matKhau = rs.getString("matkhau");
				String tenDangNhap = rs.getString("tendangnhap");
				
				
				
				ketQua = new NhaBanHang(manhaBanHang, tenNhaBanHang, soDienThoai, matKhau, tenDangNhap);
				
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
	public int insert(NhaBanHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO nhabanhang (manbh,tennbh,sodienthoai,matkhau,tendangnhap) "+
					" VALUES (?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaNhaBanHang());
			st.setString(2,t.getTenNhaBanHang());
			st.setString(3,t.getSoDienThoai());
			st.setString(4,t.getMatKhau());
			st.setString(5,t.getTenDangNhap());
			
			
			
			
			
			
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
	public int insertAll(ArrayList<NhaBanHang> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (NhaBanHang nhaBanHang : arr) {
			dem+=this.insert(nhaBanHang);
			
		}
		return dem;
	}

	@Override
	public int delete(NhaBanHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from nhabanhang "+
					 " WHERE manbh=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaNhaBanHang());
			
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
	public int deleteAll(ArrayList<NhaBanHang> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (NhaBanHang nhaBanHang : arr) {
			dem+=this.delete(nhaBanHang);
			
		}
		return dem;
	}

	@Override
	public int update(NhaBanHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE nhabanhang "+
					 " SET " +
					 " manbh=?"+
					 ",tennbh=?"+
					 ",sodienthoai=?"+
					 ",matkhau=?"+
					 ",tendangnhap=?"+
					 
					 " WHERE manbh=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaNhaBanHang());
			st.setString(2,t.getTenNhaBanHang());
			st.setString(3,t.getSoDienThoai());
			st.setString(4,t.getMatKhau());
			st.setString(5,t.getTenDangNhap());
			
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
	public NhaBanHang selectByIdAndPass(NhaBanHang t) {
		NhaBanHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM nhabanhang WHERE manbh=? and matkhau=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, t.getMaNhaBanHang());
			st.setString(2, t.getMatKhau());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String manhaBanHang = rs.getString("manbh");			
				String tenNhaBanHang = rs.getString("tennbh");
				String soDienThoai = rs.getString("sodienthoai");				
				String matKhau = rs.getString("matkhau");
				String tenDangNhap = rs.getString("tendangnhap");
				
				
				
				
				
				ketQua = new NhaBanHang(manhaBanHang, tenNhaBanHang, soDienThoai, matKhau, tenDangNhap);
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
