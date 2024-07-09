package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Database.BannerDao;
import Model.Banner;

/**
 * Servlet implementation class AdminController
 */
@MultipartConfig
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String function = request.getParameter("function");
		if(function.equals("addBanner"))
		{
			AddBanner(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void AddBanner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameBanner = request.getParameter("name");
		Part image = request.getPart("image");
		String id = Double.toString(Math.random());
		
		String realPath = request.getServletContext().getRealPath("./assets/images/banner");
		String filename = Path.of(image.getSubmittedFileName()).getFileName().toString();
		
		if(!Files.exists(Path.of(realPath))){
			Files.createDirectory(Path.of(realPath));
			
		}
		image.write(realPath+"/"+filename);
		
		
		Banner banner = new Banner(id,nameBanner, filename);
		BannerDao bnd = new BannerDao();
		bnd.insert(banner);
		
		String url = "IndexController?page=adminBanner";
		
		response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", url);
	}

}
