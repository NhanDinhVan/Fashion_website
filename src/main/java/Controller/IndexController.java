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

import Database.BannerDao;
import Database.SanPhamDao;
import Model.Banner;
import Model.SanPham;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page")!=null?request.getParameter("page"):"";
		
		if(page.equals("index")||page.equals("")) {
			Index(request, response);
		}
		else if(page.equals("product")){
			ProductDetail(request, response);
		}
		else if(page.equals("login")){
			Login(request, response);
		}
		else if(page.equals("seller")){
			Seller(request, response);
		}
		else if(page.equals("logout")){
			Logout(request, response);
		}
		else if(page.equals("cart")){
			Cart(request, response);
		}
		else if(page.equals("checkout")){
			CheckOut(request, response);
		}
		else if(page.equals("orderpage")){
			OrderPage(request, response);
		}
// Admin 
		else if(page.equals("admin")){
			Admin(request, response);
		}else if(page.equals("adminBanner")){
			AdminBanner(request, response);
		}else if(page.equals("adminProduct")){
			AdminProduct(request, response);
		}else if(page.equals("adminUser")){
			AdminUser(request, response);
		}
		
		
		else {
			Index(request, response);
		}
			
		}
	
	
	protected void Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Index.jsp";
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void ProductDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/ProductDetail.jsp";
		String productId = request.getParameter("id");
		SanPham spInput = new SanPham(productId,"","","","","","","","");
		SanPhamDao spd = new SanPhamDao();
		SanPham sanPham = spd.selectById(spInput);
		
		HttpSession session = request.getSession();
		session.setAttribute("sanPham", sanPham);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Login.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void Seller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Seller/SellerIndex.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Index.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Cart.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void CheckOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/CheckOut.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void OrderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/OrderPage.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void Admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/AdminIndex.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void AdminProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/AdminProduct.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void AdminBanner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/AdminBanner.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void AdminUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/AdminUsers.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
