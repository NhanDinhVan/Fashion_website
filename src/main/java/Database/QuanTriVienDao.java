package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.NhaBanHang;
import Model.QuanTriVien;

public class QuanTriVienDao implements DAOInterface<QuanTriVien> {
	@Override
	public ArrayList<QuanTriVien> selectAll() {
		// TODO Auto-generated method stub
		
		ArrayList<QuanTriVien> ketqua = new ArrayList<QuanTriVien>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM quantrivien";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			// Bước 4:
			while(rs.next()) {
				String maQtv = rs.getString("maqtv");			
				String hoTen = rs.getString("hoten");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String soDienThoai = rs.getString("sodienthoai");
				
				
				QuanTriVien qtv = new QuanTriVien(maQtv, hoTen, tenDangNhap, matKhau, soDienThoai);
				ketqua.add(qtv);
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
	public QuanTriVien selectById(QuanTriVien t) {
		QuanTriVien ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM quantrivien where maqtv=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaQtv());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maQtv = rs.getString("maqtv");			
				String hoTen = rs.getString("hoten");
				String tenDangNhap = rs.getString("tendangnhap");				
				String matKhau = rs.getString("matkhau");
				String soDienThoai = rs.getString("sodienthoai");
				
				
				
				ketQua = new QuanTriVien(maQtv, hoTen, tenDangNhap, matKhau, soDienThoai);
				
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
	public int insert(QuanTriVien t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO quantrivien (maqtv,hoten,tendangnhap,matkhau,sdienthoai) "+
					" VALUES (?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaQtv());
			st.setString(2,t.getHoTen());
			st.setString(3,t.getTenDangNhap());
			st.setString(4,t.getMatKhau());
			st.setString(5,t.getSoDienThoai());
			
			
			
			
			
			
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
	public int insertAll(ArrayList<QuanTriVien> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (QuanTriVien quanTriVien : arr) {
			dem+=this.insert(quanTriVien);
			
		}
		return dem;
	}

	@Override
	public int delete(QuanTriVien t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from quantrivien "+
					 " WHERE maqtv=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaQtv());
			
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
	public int deleteAll(ArrayList<QuanTriVien> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (QuanTriVien quanTriVien : arr) {
			dem+=this.delete(quanTriVien);
			
		}
		return dem;
	}

	@Override
	public int update(QuanTriVien t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE quantrivien "+
					 " SET " +
					 " maqtv=?"+
					 ",hoten=?"+
					 ",tendangnhap=?"+
					 ",matkhau=?"+
					 ",sodienthoai=?"+
					 
					 " WHERE maqtv=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaQtv());
			st.setString(2,t.getHoTen());
			st.setString(3,t.getTenDangNhap());
			st.setString(4,t.getMatKhau());
			st.setString(5,t.getSoDienThoai());
			
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
	public QuanTriVien selectByIdAndPass(QuanTriVien t) {
		QuanTriVien ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM quantrivien where tendangnhap=? and matkhau=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenDangNhap());
			st.setString(2, t.getMatKhau());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maQtv = rs.getString("maqtv");			
				String hoTen = rs.getString("hoten");
				String tenDangNhap = rs.getString("tendangnhap");				
				String matKhau = rs.getString("matkhau");
				String soDienThoai = rs.getString("sodienthoai");
				
				
				
				ketQua = new QuanTriVien(maQtv, hoTen, tenDangNhap, matKhau, soDienThoai);
				
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
