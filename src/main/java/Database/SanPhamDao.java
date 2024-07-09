package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.QuanTriVien;
import Model.SanPham;

public class SanPhamDao implements DAOInterface<SanPham> {
	@Override
	public ArrayList<SanPham> selectAll() {
		// TODO Auto-generated method stub
		
		ArrayList<SanPham> ketqua = new ArrayList<SanPham>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM sanpham";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			// Bước 4:
			while(rs.next()) {
				String maSanPham = rs.getString("masanpham");			
				String tenSanPham = rs.getString("tensanpham");
				String soLuong = rs.getString("soluong");
				String giaSanPham = rs.getString("giasanpham");
				String nhaBanHang = rs.getString("nhabanhang");
				String linkHinhAnh = rs.getString("linkhinhanh");
				String nguocGoc = rs.getString("nguongoc");
				String hangSanXuat = rs.getString("hangsanxuat");
				String phanLoai = rs.getString("phanloai");
				
				
				SanPham qtv = new SanPham(maSanPham, tenSanPham, soLuong, giaSanPham, nhaBanHang, linkHinhAnh, nguocGoc, hangSanXuat, phanLoai);
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
	public SanPham selectById(SanPham t) {
		SanPham ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM sanpham where masanpham=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSanPham());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maSanPham = rs.getString("masanpham");			
				String tenSanPham = rs.getString("tensanpham");
				String soLuong = rs.getString("soluong");
				String giaSanPham = rs.getString("giasanpham");
				String nhaBanHang = rs.getString("nhabanhang");
				String linkHinhAnh = rs.getString("linkhinhanh");
				String nguocGoc = rs.getString("nguongoc");
				String hangSanXuat = rs.getString("hangsanxuat");
				String phanLoai = rs.getString("phanloai");
				
				
				
				ketQua = new SanPham(maSanPham, tenSanPham, soLuong, giaSanPham, nhaBanHang, linkHinhAnh, nguocGoc, hangSanXuat, phanLoai);
				System.out.println(ketQua);
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
	public int insert(SanPham t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO sanpham (masanpham,tensanpham,soluong,giasanpham,nhabanhang,linkhinhanh,nguongoc,hangsanxuat,phanloai) "+
					" VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSanPham());
			st.setString(2,t.getTenSanPham());
			st.setString(3,t.getSoLuong());
			st.setString(4,t.getGiaSanPham());
			st.setString(5,t.getNhaBanHang());
			st.setString(6,t.getLinkHinhAnh());
			st.setString(7,t.getNguonGoc());
			st.setString(8,t.getHangSanXuat());
			st.setString(9,t.getPhanLoai());
			
			
			
			
			
			
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
	public int insertAll(ArrayList<SanPham> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (SanPham sanPham : arr) {
			dem+=this.insert(sanPham);
			
		}
		return dem;
	}

	@Override
	public int delete(SanPham t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from sanpham "+
					 " WHERE masanpham=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSanPham());
			
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
	public int deleteAll(ArrayList<SanPham> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (SanPham sanPham : arr) {
			dem+=this.delete(sanPham);
			
		}
		return dem;
	}

	@Override
	public int update(SanPham t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE sanpham "+
					 " SET " +
					 " masanpham=?"+
					 ",tensanpham=?"+
					 ",soluong=?"+
					 ",giasanpham=?"+
					 ",nhabanhang=?"+
					 ",linkhinhanh=?"+
					 ",nguocgoc=?"+
					 ",hangsanxuat=?"+
					 ",phanloai=?"+
					 
					 " WHERE masanpham=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSanPham());
			st.setString(2,t.getTenSanPham());
			st.setString(3,t.getSoLuong());
			st.setString(4,t.getGiaSanPham());
			st.setString(5,t.getNhaBanHang());
			st.setString(6,t.getLinkHinhAnh());
			st.setString(7,t.getNguonGoc());
			st.setString(8,t.getHangSanXuat());
			st.setString(9,t.getPhanLoai());
			
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
	
	public ArrayList<SanPham> selectByNhaBanHang(SanPham t) {
		ArrayList<SanPham> ketqua = new ArrayList<SanPham>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM sanpham where nhabanhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSanPham());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maSanPham = rs.getString("masanpham");			
				String tenSanPham = rs.getString("tensanpham");
				String soLuong = rs.getString("soluong");
				String giaSanPham = rs.getString("giasanpham");
				String nhaBanHang = rs.getString("nhabanhang");
				String linkHinhAnh = rs.getString("linkhinhanh");
				String nguocGoc = rs.getString("nguongoc");
				String hangSanXuat = rs.getString("hangsanxuat");
				String phanLoai = rs.getString("phanloai");
				
				
				
				SanPham qtv = new SanPham(maSanPham, tenSanPham, soLuong, giaSanPham, nhaBanHang, linkHinhAnh, nguocGoc, hangSanXuat, phanLoai);
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
	
	public ArrayList<SanPham> selectByMaNhaBanHang(SanPham t) {
		ArrayList<SanPham> ketqua = new ArrayList<SanPham>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM sanpham where nhabanhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getNhaBanHang());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maSanPham = rs.getString("masanpham");			
				String tenSanPham = rs.getString("tensanpham");
				String soLuong = rs.getString("soluong");
				String giaSanPham = rs.getString("giasanpham");
				String nhaBanHang = rs.getString("nhabanhang");
				String linkHinhAnh = rs.getString("linkhinhanh");
				String nguocGoc = rs.getString("nguongoc");
				String hangSanXuat = rs.getString("hangsanxuat");
				String phanLoai = rs.getString("phanloai");
				
				
				

				SanPham listsp = new SanPham(maSanPham, tenSanPham, soLuong, giaSanPham, nhaBanHang, linkHinhAnh, nguocGoc, hangSanXuat, phanLoai);
				ketqua.add(listsp);
				
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
		
	}
	
	
	public static void main(String[] args) {
		SanPham sanpham = new SanPham("1234231", "", "", "", "", "", "", "", "");
		SanPhamDao spd = new SanPhamDao();
		SanPham view = spd.selectById(sanpham);
		System.out.print(view);
	}
}
