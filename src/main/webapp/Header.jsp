    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <link
        rel="stylesheet"
        type="text/css"
        href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"
      />

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
	}
	
	SanPhamDao spd = new SanPhamDao();
	ArrayList<SanPham> productList = spd.selectAll();
%>

  
    <div class="app ">

<!--header-->
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
                        <img class=" main-logo" src = "./assets/images/banner/logo.png" alt = "site icon">
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

                        <a href="<%= khachHang==null?"IndexController?page=login":"IndexController?page=cart" %>" id="cart-icon" type = "button" class = "btn position-relative">
                            <i class = "fa fa-shopping-cart"></i>
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
            
<!--end of header-->