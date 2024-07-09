<%@page import="Model.GioHang"%>
<%@page import="Database.GioHangDao"%>
<%@page import="Database.BannerDao"%>
<%@page import="Database.SanPhamDao"%>
<%@page import="Model.KhachHang"%>
<%@page import="Model.SanPham"%>
<%@page import="Model.Banner"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Object obj = session.getAttribute("khachHang");
	KhachHang khachHang = null;
	if (obj != null)
	{
		khachHang = (KhachHang) obj;
	}else{
		String url = "/Login.jsp";		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	/*  */
	GioHang gioHangInput = new GioHang(khachHang.getMaKhachHang(),"","",0);
	GioHangDao ghd = new GioHangDao();
	ArrayList<GioHang> sanPhamTrongGioHang = ghd.selectGioHang(gioHangInput);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="./assets/css/cart.css">
		<link rel="stylesheet" href="./assets/css/main.css">
		<link rel="stylesheet" href="./assets/css/base.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="js/jquery-1.11.1.min.js"></script>
		
</head>
<body>
		<!-- Header -->
			<header class="position-relative">

<!--navbar-->

            <div class="top-nav  ">
                <div class="container d-flex justify-content-around lh-sm py-0 my-0">
                    <div class = "col-3  nav-btns d-none d-sm-inline-flex order-0 text-center ">        
                        <button type = "button " class = "btn position-relative border-0">
                            <a href="">
                            <i class="fa-brands fa-facebook"></i>
                        </a>
                        </button>
                        <button type = "button" class = "btn position-relative border-0 ">
                            <a href="">
                            <i class="fa-brands fa-instagram "></i>
                            </a>
                        </button>
                        <button type = "button" class = "btn position-relative border-0  ">
                            <a href="">
                            <i class="fa-brands fa-twitter "></i>
                            </a> 
                        </button>
                    </div>

                    <div class="col-3 ">
                        <p class="py-2 my-2 d-none d-sm-block text-center">Shopping now with E-portrait</p>
                   </div>

                    <div class = "col-3 d-none d-sm-inline-flex align-content-center order-2 border-0" >
                        <ul class = " nav mx-auto text-center d-flex">                                                     
                            <li class = " px-2 py-2 dropdown ">                               
                                <a class="nav-link dropdown-toggle  border-0 text-dark"  role="button" data-bs-toggle="dropdown"> <i> language </i></a>
                                <ul class="dropdown-menu ">
                                    <li><i class="dropdown-item text-dark ">English</i></li>
                                    <li><i class="dropdown-item text-dark " >Vietnamese</i></li>                                      
                                </ul>                                  
                            </li>                          
                            <li class = "d-none d-md-block px-2 py-2">                               
                                <a class = "nav-link  border-0 text-dark" href = "#"> <i class="fa-solid fa-cloud-arrow-down"></i> <i>Download</i> </a>
                            </li>
                        </ul>
                    </div> 
                    
                </div>
            </div>

		        <section class="main-navbar mx-0 ">
		            <nav class = "navbar navbar-expand-md navbar-light  py-sm-0 py-3">       
		                
		                <div class = "container">
		                    <a id="logo" class = "col-md-3 col-2 navbar-brand d-flex  align-items-center order-md-0" href = "IndexController?page=index">
		                        <img class=" main-logo" src = "./assets/images/banner/main-logo.png" alt = "site icon">
		                        <span class = "text-uppercase fw-lighter ms-2 ">HT-Ecommerce</span>                        
		                    </a>
		
		                    <div class = " col-md-3 col-6 nav-btns order-md-2 position-relative text-center">
		                        <button id="search-icon" type = "button" class = "btn position-relative">
		                            <i class = "fa fa-search"></i>
		                        </button>
		
		                <!-- search-form -->
		                        <form id="search-form" class="search-form position-absolute input-group" action="" method="get">
		                            <input type="text" name="content" id="content" class="form-control" required="required"">
		                            <button class="input-group-text" type="submit">
		                            <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
		                            </button>
		                        </form>
		                <!-- end-search-form -->
		
		                        <a href="IndexController?page=orderpage" id="cart-icon" type = "button" class = "btn position-relative">
		                            <i class="fa-thin fa-cart-circle-check"></i>
		                            <span class = "position-absolute top-0 start-100 translate-middle badge bg-primary">5</span>
		                        </a>
		                        <a href="<%= khachHang==null?"IndexController?page=login":"IndexController?page=logout" %>" id="heart-icon" type = "button" class = "btn position-relative">
		                            <%= khachHang==null?"<i class=\"fa-solid fa-user\"></i>":"<i class=\"fw-bold\">"+khachHang.getTenKhachHang()+"</i>" %>
		                            <span class = "position-absolute top-0 start-100 translate-middle badge bg-primary">.</span>
		                        </a>
		                    </div>
		        
		                    <button class = "navbar-toggler border-0" type = "button" data-bs-toggle = "collapse" data-bs-target = "#navMenu">
		                        <span class = "navbar-toggler-icon"></span>
		                    </button>
		        
		                    <div class = "collapse navbar-collapse order-md-1 col-6 " id = "navMenu">
		                        <ul class = "navbar-nav mx-auto text-center justify-content-center">
		                            <li class = "nav-item px-2 py-2">
		                                <a class = "nav-link text-uppercase text-dark" href = "IndexController?page=index #header">home</a>
		                            </li>
		                            <li class = "nav-item px-2 py-2">
		                                <a class = "nav-link text-uppercase text-dark" href = "IndexController?page=index #collection">Shop now</a>
		                            </li>
		                            <li class = "nav-item px-2 py-2">
		                                <a class = "nav-link text-uppercase text-dark" href = "IndexController?page=index #special">specials</a>
		                            </li>
		                            <li class = "nav-item px-2 py-2">
		                                <a class = "nav-link text-uppercase text-dark" href = "IndexController?page=index #aboutus">about us</a>
		                            </li>
		                            
		                       </ul>
		                    </div>
		                </div>
		            </nav>                 
		        </section>
		<!-- end of navbar --> 
		    </header>
		<!-- End Header -->
		<!-- Cart -->
			<section class=" vh-100 bg-light p-5 m-3">
				<h2 class="text-center">Your Cart</h2>
				<div class="container"> 
				 <table id="cart" class="table table-hover table-condensed"> 
				  
				  
				  <% int dem = 0 ;
				  for(GioHang sanPham : sanPhamTrongGioHang){ 
					    dem++;
				  		SanPham sanPhamInput = new SanPham(sanPham.getMaSanPham(),"", "", "", "", "", "", "", ""); 
				  		SanPhamDao spd = new SanPhamDao();
				  		SanPham chiTietSanPham = spd.selectById(sanPhamInput);
				  %>
				  	<thead> 
				   <tr class="bg-warning"> 
				    <th style="width:50%">Tên sản phẩm</th> 
				    <th style="width:10%">Giá</th> 
				    <th style="width:8%">Số lượng</th> 
				    <th style="width:22%" class="text-center">Thành tiền</th> 
				    <th style="width:10%"> </th> 
				   </tr> 
				  </thead> 
				  <tbody>
					  <tr>
						  	<td data-th="Product"> 
							    <div class="row"> 
							     <a href="IndexController?page=product&id=<%=chiTietSanPham.getMaSanPham()%>" class="col-sm-2 hidden-xs">
							     	<img src="./assets/images/products/<%=chiTietSanPham.getPhanLoai()%>/<%=chiTietSanPham.getLinkHinhAnh() %>" alt="Sản phẩm 1" class="img-responsive" width="100">
							     </a> 
							     <div class="col-sm-10"> 
							      <h4 class="nomargin text-capitalize"><%= chiTietSanPham.getTenSanPham() %></h4> 
							      <p class="text-capitalize pt-3"><%=chiTietSanPham.getHangSanXuat() %></p> 
							     </div> 
							    </div> 
							   </td> 
							   <td data-th="Price"><%=chiTietSanPham.getGiaSanPham()%>$</td> 
							   <td data-th="Quantity"><input class="form-control text-center" value="<%=sanPham.getSoLuong() %>" type="number">
							   </td> 
							   <td data-th="Subtotal" class="text-center"><%= Double.parseDouble(chiTietSanPham.getGiaSanPham())*sanPham.getSoLuong() %>$</td> 
							   <td class="actions mx-auto my-auto" data-th="">
							    <button class="btn btn-info btn-sm "><i class="fa-solid fa-rotate-right"></i>
							    </button> 
							    <a href="FunctionController?function=deleteCart&id=<%=sanPham.getMaSanPham()%>&kh=<%=sanPham.getMaGioHang()%>" class="btn btn-danger btn-sm"><i class="fa-solid fa-trash"></i>
							    </a>
						   </td>						  					   
					  </tr> 
				   <%}%>
				  </tbody>
				  <tfoot> 
				  <% if(dem !=0){ %>
				   <tr class="visible-xs"> 
				    <td class="text-center"><strong>Tổng 200.000 đ</strong>
				    </td> 
				   </tr> 
				   <tr> 
				    <td><a href="IndexController?page=index#collection" class="btn btn-warning"><i class="fa fa-angle-left"></i> Tiếp tục mua hàng</a>
				    </td> 
				    <td colspan="2" class="hidden-xs"> </td> 
				    <td class="hidden-xs text-center"><strong>Tổng tiền 500.000 đ</strong>
				    </td> 
				    <td><a href="IndexController?page=checkout" class="btn btn-success btn-block">Thanh toán <i class="fa fa-angle-right"></i></a>
				    </td> 
				   </tr>
				   <%}else{ %>
				   	<h1 class="mx-auto my-auto text-center">No Product In YourCart !</h1>
				   <%} %>
				  </tfoot>
				  
				 </table>
				</div>
			</section>
		<!-- End Cart -->
		
	<!-- footer -->
		   <div id="foot-placeholder" <%if(dem==0){%>class="fixed-bottom"<% } %>></div>
    <!-- end of footer -->
    <!--scirpts-->
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-1.11.0.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"
    ></script>
    <!-- isotope js -->
    <script src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.js"></script>

    <script src="assets/js/main.js"></script>
    <script >
    /* Load element */
	  $(function(){
	  	$("#nav-placeholder").load("Header.jsp");
	  });
	  
	  $(function(){
	  	$("#foot-placeholder").load("Footer.jsp");
	  });
	  
	  $(function(){
		  	$("#slider-placeholder").load("Slider.jsp");
	  });
    </script>
</body>

</html>