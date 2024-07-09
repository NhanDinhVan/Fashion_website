package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Banner;
import Database.JDBCUtil;
import Model.Banner;

public class BannerDao implements DAOInterface<Banner> {

	@Override
	public ArrayList<Banner> selectAll() {
		ArrayList<Banner> ketqua = new ArrayList<Banner>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM banner";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			// Bước 4:
			while(rs.next()) {
				String maBanner = rs.getString("mabanner");			
				String nhaBanHang = rs.getString("nhabanhang");
				String linkBanner = rs.getString("linkbanner");
				
				Banner sv = new Banner(maBanner, nhaBanHang, linkBanner);
				ketqua.add(sv);
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
	public Banner selectById(Banner t) {
		Banner ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM banner where mabanner=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaBanner());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maBanner = rs.getString("mabanner");			
				String nhaBanHang = rs.getString("nhabanhang");
				String linkBanner = rs.getString("linkbanner");
				
				
				
				ketQua = new Banner(maBanner, nhaBanHang, linkBanner);
				
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
	public int insert(Banner t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO banner (mabanner,nhabanhang,linkbanner) "+
					" VALUES (?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaBanner());
			st.setString(2,t.getNhaBanHang());
			st.setString(3,t.getLinkBanner());
						
			
			
			
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
	public int insertAll(ArrayList<Banner> arr) {
		// TODO Auto-generated method stub
				int dem=0;
				for (Banner banner : arr) {
					dem+=this.insert(banner);
					
				}
				return dem;
	}

	@Override
	public int delete(Banner t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from banner "+
					 " WHERE mabanner=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaBanner());
			
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
	public int deleteAll(ArrayList<Banner> arr) {
		// TODO Auto-generated method stub
		int dem=0;
		for (Banner banner : arr) {
			dem+=this.delete(banner);
			
		}
		return dem;
	}

	@Override
	public int update(Banner t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE diem "+
					 " SET " +
					 " mabanner=?"+
					 ",nhabanhang=?"+
					 ",linkbanner=?"+					
					 " WHERE mabanner=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaBanner());
			st.setString(2,t.getNhaBanHang());
			st.setString(3,t.getLinkBanner());
			
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
