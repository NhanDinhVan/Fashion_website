package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.ChiTietDonHangDao;
import Database.DonHangDao;
import Database.GioHangDao;
import Database.KhachHangDao;
import Database.NhaBanHangDao;
import Database.QuanTriVienDao;
import Database.SanPhamDao;
import Model.ChiTietDonHang;
import Model.DonHang;
import Model.GioHang;
import Model.KhachHang;
import Model.NhaBanHang;
import Model.QuanTriVien;
import Model.SanPham;

/**
 * Servlet implementation class function
 */
@WebServlet("/FunctionController")
public class FunctionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FunctionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String function = request.getParameter("function");
		
		if(function.equals("login"))
		{
			Login(request, response);
		}else if(function.equals("add_product"))
		{
			AddProduct(request, response);
		}else if(function.equals("checkout"))
		{
			CheckOut(request, response);
		}else if(function.equals("deleteCart"))
		{
			DeleteCart(request, response);
		}
	}
	protected void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		NhaBanHang sellerInput = new NhaBanHang(username, password, password, password, password);
		NhaBanHangDao nbhd = new NhaBanHangDao();
		NhaBanHang seller = nbhd.selectByIdAndPass(sellerInput);
		
		HttpSession session = request.getSession();
		
		String url = "IndexController?page=login";
		if(seller!=null)
		{
			url = "IndexController?page=seller";
			session.setAttribute("seller", seller);
		}else 
		{
			QuanTriVien qtvInput = new QuanTriVien("", "", username,password,"");
			QuanTriVienDao qtvd = new QuanTriVienDao();
			QuanTriVien qtv = qtvd.selectByIdAndPass(qtvInput);
			if(qtv!=null)
			{
				url = "IndexController?page=admin";
				session.setAttribute("admin", qtv);
			}else
			{
				KhachHang khachHangInput = new KhachHang("", "", "", "", "", password, username);
				KhachHangDao khd = new KhachHangDao();
				KhachHang khachHang = khd.selectByIdAndPass(khachHangInput);
				if(khachHang!=null)
				{
					url = "IndexController?page=index";
					session.setAttribute("khachHang", khachHang);
				}else
				{
					url = "IndexController?page=login";
					session.setAttribute("error", "Username or Password not found !");
				}
			}
		}
		response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", url);
	}
	protected void AddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSanPham = request.getParameter("masanpham");
		String nhaBanHang = request.getParameter("nhabanhang");
		String maGioHang = request.getParameter("makhachhang");
		String soLuong = request.getParameter("soluong");
		int soLuongg = Integer.parseInt(soLuong);
		
		GioHang ghcheck = new GioHang(maGioHang, maSanPham, maGioHang,soLuongg);
		GioHangDao ghd = new GioHangDao();
		
		GioHang gioHangCheck = ghd.selectByIdAndSanPham(ghcheck);
		
		String url="";
		if(gioHangCheck !=null) {
			
			
			SanPham spcheck = new SanPham(maSanPham, "", "", "", "", "", "", "", "");
			SanPhamDao spdcheck = new SanPhamDao();
			SanPham sanPhamCheck = spdcheck.selectById(spcheck);
			int soLuongCon = Integer.parseInt(sanPhamCheck.getSoLuong());
			if(soLuongCon>= gioHangCheck.getSoLuong()) {
	
			int soLuongUpdate = gioHangCheck.getSoLuong() + soLuongg;
			
			
			GioHang gh = new GioHang(maGioHang, maSanPham, maGioHang,soLuongUpdate);
			ghd.deleteSanPham(ghcheck);
			ghd.insert(gh);
			
			 HttpSession session = request.getSession();
			 session.setAttribute("gioHang", session);
			 url="http://localhost:8080/portrait_ecommerce/IndexController?page=product&id="+maSanPham;
			}else {
				
				request.setAttribute("baoLoi", "Overload! You have to reduce the amount");
				url="http://localhost:8080/portrait_ecommerce/IndexController?page=product&id="+maSanPham;
				
			}
		}
		else {
				url="http://localhost:8080/portrait_ecommerce/IndexController?page=product&id="+maSanPham;
				ghd.insert(ghcheck);
			}
//		
//		 RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
//			rd.forward(request, response);
		
			 // New location to be redirected
	        
	        response.setStatus(response.SC_MOVED_TEMPORARILY);
	        response.setHeader("Location", url);
	}
	protected void CheckOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maDonHang = Double.toString(Math.random());
		String name = request.getParameter("fullName");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String maKhachHang = request.getParameter("maKhachHang");
		
		DonHangDao dhd = new DonHangDao();
		DonHang dh = new DonHang( maDonHang,name, phoneNumber, email, address, maKhachHang);
		int insertdh = dhd.insert(dh);
		GioHang gh = new GioHang(maKhachHang, "", "", 0);
		GioHangDao ghd = new GioHangDao();
		ArrayList<GioHang> listSpGioHang = ghd.selectGioHang(gh);
		for(GioHang spGioHang : listSpGioHang) {
			
			GioHangDao ghdSpGioHang = new GioHangDao();
			ghdSpGioHang.delete(spGioHang);
			ChiTietDonHangDao ctdhd = new ChiTietDonHangDao();
			ChiTietDonHang ctdh = new ChiTietDonHang(maDonHang, spGioHang.getMaSanPham(), Integer.toString(spGioHang.getSoLuong()));
			ctdhd.insert(ctdh);
		}
		String url ="IndexController?page=cart";
		response.setStatus(response.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", url);
	}
	protected void DeleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSanPham = request.getParameter("id");
		String maGioHang = request.getParameter("kh");
		
		GioHang gioHang = new GioHang(maGioHang, maSanPham, "", 0);
		GioHangDao ghd = new GioHangDao();
		ghd.delete1sanpham(gioHang);
		
		String url ="IndexController?page=cart";			
		 
		response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", url);	
	}
}
