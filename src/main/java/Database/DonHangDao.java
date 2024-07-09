package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.DonHang;
import Model.KhachHang;

public class DonHangDao implements DAOInterface<DonHang> {

	@Override
	public ArrayList<DonHang> selectAll() {
		// TODO Auto-generated method stub
		
				ArrayList<DonHang> ketqua = new ArrayList<DonHang>();
				try {
					// Bước 1: tạo kết nối đến CSDL
					Connection con = JDBCUtil.getConnection();
					
					// Bước 2: tạo ra đối tượng statement
					String sql = "SELECT * FROM donhang";
					PreparedStatement st = con.prepareStatement(sql);
					
					// Bước 3: thực thi câu lệnh SQL
					System.out.println(sql);
					ResultSet rs = st.executeQuery();
					// Bước 4:
					while(rs.next()) {
						String maDonHang = rs.getString("madonhang");			
						String tenKhachHang = rs.getString("tenkhachhang");
						String soDienThoai = rs.getString("sodienthoai");
						String email = rs.getString("email");
						String diaChi = rs.getString("diachi");	
						String maKhachHang = rs.getString("makhachhang");	
						DonHang dh = new DonHang(maDonHang, tenKhachHang, soDienThoai, email, diaChi, maKhachHang);
						ketqua.add(dh);
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
	public DonHang selectById(DonHang t) {
		DonHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM donhang where madonhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maDonHang = rs.getString("madonhang");			
				String tenKhachHang = rs.getString("tenkhachhang");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				String diaChi = rs.getString("diachi");	
				String maKhachHang = rs.getString("makhachhang");
				ketQua = new DonHang(maDonHang, tenKhachHang, soDienThoai, email, diaChi, maKhachHang);
				
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
	public int insert(DonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO donhang (madonhang,tenkhachhang,sodienthoai,email,diachi,makhachhang) "+
					" VALUES (?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getMaDonHang());
			st.setString(2,t.getTenKhachHang());
			st.setString(3,t.getSoDienThoai());
			st.setString(4,t.getEmail());
			st.setString(5,t.getDiachi());
			st.setString(6,t.getMaKhachHang());
			
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
	public int insertAll(ArrayList<DonHang> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from donhang "+
					 " WHERE madonhang=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			
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
	public int deleteAll(ArrayList<DonHang> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(DonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE donhang "+
					 " SET " +
					 "madonhang=?"+
					 ",tenkhachhang=?"+
					 ",sodienthoai=?"+
					 ",email=?"+ 
					 ",diachi=?"+
					 " WHERE makhachhang=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			st.setString(2,t.getTenKhachHang());
			st.setString(3,t.getSoDienThoai());
			st.setString(4,t.getEmail());
			st.setString(5,t.getDiachi());
			
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
	public ArrayList<DonHang> selectByMaKhachHang(DonHang t) {
		// TODO Auto-generated method stub
		
				ArrayList<DonHang> ketqua = new ArrayList<DonHang>();
				try {
					// Bước 1: tạo kết nối đến CSDL
					Connection con = JDBCUtil.getConnection();
					
					// Bước 2: tạo ra đối tượng statement
					String sql = "SELECT * FROM donhang Where makhachhang=?";
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, t.getMaKhachHang());
					// Bước 3: thực thi câu lệnh SQL
					System.out.println(sql);
					ResultSet rs = st.executeQuery();
					// Bước 4:
					while(rs.next()) {
						String maDonHang = rs.getString("madonhang");			
						String tenKhachHang = rs.getString("tenkhachhang");
						String soDienThoai = rs.getString("sodienthoai");
						String email = rs.getString("email");
						String diaChi = rs.getString("diachi");	
						String maKhachHang = rs.getString("makhachhang");	
						DonHang dh = new DonHang(maDonHang, tenKhachHang, soDienThoai, email, diaChi, maKhachHang);
						ketqua.add(dh);
					}
					// Bước 5:
					JDBCUtil.closeConnection(con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return ketqua;
			
	}

}
