
package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.GioHang;
import Model.SanPham;
import Database.JDBCUtil;


public class GioHangDao implements DAOInterface<GioHang> {
	@Override
	public ArrayList<GioHang> selectAll() {
		// TODO Auto-generated method stub
		
		ArrayList<GioHang> ketqua = new ArrayList<GioHang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM giohang";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			// Bước 4:
			while(rs.next()) {
				String maGioHang = rs.getString("magiohang");			
				String maSanPham = rs.getString("masanpham");
				String maKhachHang = rs.getString("makhachhang");
				int soLuong = rs.getInt("soluong");
				
				
				GioHang gh = new GioHang(maGioHang, maSanPham, maKhachHang,soLuong);
				ketqua.add(gh);
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
	public GioHang selectById(GioHang t) {
		return t;	
		
		
	}
	
	public ArrayList<GioHang> selectSanPham(GioHang t) {
		ArrayList<GioHang> ketQua = new ArrayList<GioHang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM giohang where magiohang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaGioHang());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maGioHang = rs.getString("magiohang");			
				String maSanPham = rs.getString("masanpham");
				String maKhachHang = rs.getString("makhachhang");
				int soLuong = rs.getInt("soluong");
				
				
				GioHang gh = new GioHang(maGioHang, maSanPham, maKhachHang,soLuong);
				ketQua.add(gh);
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
	public int insert(GioHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO giohang (magiohang,masanpham,makhachhang,soluong) "+
					" VALUES (?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaGioHang());
			st.setString(2,t.getMaSanPham());
			st.setString(3,t.getMaKhachHang());
			st.setInt(4,t.getSoLuong());
			
			
			
			
			
			
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
	public int insertAll(ArrayList<GioHang> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (GioHang gioHang : arr) {
			dem+=this.insert(gioHang);
			
		}
		return dem;
	}

	@Override
	public int delete(GioHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from giohang "+
					 " WHERE magiohang=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaGioHang());
			
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
	public int deleteAll(ArrayList<GioHang> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (GioHang gioHang : arr) {
			dem+=this.delete(gioHang);
			
		}
		return dem;
	}

	@Override
	public int update(GioHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE giohang "+
					 " SET " +
					 " magiohang=?"+
					 ",masanpham=?"+
					 ",makhachhang=?"+
					 ",soluong=?"+
					 " WHERE magiohang=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaGioHang());
			st.setString(2,t.getMaSanPham());
			st.setString(3,t.getMaKhachHang());
			st.setInt(4,t.getSoLuong());
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
	

	public GioHang selectByIdAndSanPham(GioHang t) {
		GioHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM giohang where magiohang=? and masanpham=? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaGioHang());
			st.setString(2, t.getMaSanPham());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maGioHang = rs.getString("magiohang");			
				String maSanPham = rs.getString("masanpham");
				String maKhachHang = rs.getString("makhachhang");
				int soLuong = rs.getInt("soluong");
				
				
				
				ketQua = new GioHang(maGioHang, maSanPham, maKhachHang,soLuong);
				
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
		
	}
	public int deleteSanPham(GioHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from giohang "+
					 " WHERE magiohang=? and masanpham=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaGioHang());
			st.setString(2, t.getMaSanPham());
			
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
	
	public ArrayList<GioHang> selectGioHang(GioHang t) {
		ArrayList<GioHang> ketQua = new ArrayList<GioHang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM giohang where magiohang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaGioHang());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maGioHang = rs.getString("magiohang");			
				String maSanPham = rs.getString("masanpham");
				String maKhachHang = rs.getString("makhachhang");
				int soLuong = rs.getInt("soluong");
				
				
				
				
				GioHang gh = new GioHang(maGioHang, maSanPham, maKhachHang,soLuong);
				ketQua.add(gh);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
		
	}
	public int delete1sanpham(GioHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from giohang "+
					 " WHERE magiohang=? and masanpham=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaGioHang());
			st.setString(2, t.getMaSanPham());
			
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
	
}
