package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.ChiTietDonHang;
import Model.GioHang;
import Model.KhachHang;

public class ChiTietDonHangDao implements DAOInterface<ChiTietDonHang> {

	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		// TODO Auto-generated method stub
		
				ArrayList<ChiTietDonHang> ketqua = new ArrayList<ChiTietDonHang>();
				try {
					// Bước 1: tạo kết nối đến CSDL
					Connection con = JDBCUtil.getConnection();
					
					// Bước 2: tạo ra đối tượng statement
					String sql = "SELECT * FROM chitietdonhang";
					PreparedStatement st = con.prepareStatement(sql);
					
					// Bước 3: thực thi câu lệnh SQL
					System.out.println(sql);
					ResultSet rs = st.executeQuery();
					// Bước 4:
					while(rs.next()) {
						String maDonHang = rs.getString("madonhang");			
						String maSanPham = rs.getString("masanpham");
						String soLuong = rs.getString("soluong");
						ChiTietDonHang ctdh = new ChiTietDonHang(maDonHang, maSanPham, soLuong);
						ketqua.add(ctdh);
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
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		ChiTietDonHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM chitietdonhang where madonhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maKhachHang = rs.getString("madonhang");			
				String tenKhachHang = rs.getString("masanpham");
				String ngaySinh = rs.getString("soluong");
				
				ketQua = new ChiTietDonHang(maKhachHang, tenKhachHang, ngaySinh);
				
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
	public int insert(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO chitietdonhang (madonhang,masanpham,soluong) "+
					" VALUES (?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			st.setString(2,t.getMaSanPham());
			st.setString(3,t.getSoLuong());
			
			
			
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
	public int insertAll(ArrayList<ChiTietDonHang> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<ChiTietDonHang> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<ChiTietDonHang> selectByMaDonHang(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		ArrayList<ChiTietDonHang> ketqua = new ArrayList<ChiTietDonHang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM chitietdonhang WHERE madonhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			// Bước 4:
			while(rs.next()) {
				String maDonHang = rs.getString("madonhang");			
				String maSanPham = rs.getString("masanpham");
				String soLuong = rs.getString("soluong");
				ChiTietDonHang ctdh = new ChiTietDonHang(maDonHang, maSanPham, soLuong);
				ketqua.add(ctdh);
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
