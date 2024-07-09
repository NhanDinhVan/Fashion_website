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
	
	BannerDao bnd = new BannerDao();
	ArrayList<Banner> bannerList = bnd.selectAll() ;
	
	SanPhamDao spd = new SanPhamDao();
	ArrayList<SanPham> productList = spd.selectAll() ;
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
</head>
<body>

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
	<!--banner-slider -->
    <section class="main-banner-slider container-fluid px-0  mx-0 ">

        <div class="  fullhome-banner px-0 mx-0 container-fluid ">
            <div class="row ">
                <div class="fullhome-main-banner col-12 px-0 mx-0">
                    
                        <div class="  image_slider  ">
                        	<%
                        	for(Banner banner : bannerList){
                        	%>
	                            <div class="image_item">    
	                                <div class="image">
	                                    <img class="rounded-1" src="./assets/images/banner/<%=banner.getLinkBanner()%>" alt="">                    
	                                </div>
	                            </div>
	                        <%} %>
                        </div>
                </div>
            </div>

        </div>
    </section>
<!--end of banner-slider-->


        
         <!-- Product -->
    <section id = "collection" class = "py-5">
        <div class = "container">
            <div class = "title text-center">
                <h2 class = "position-relative d-inline-block">Shop now</h2>
            </div>

            <div class = "row g-0 bg-light py-4" >
               <div class="col-12 col-lg-2"> 
                <div class = "d-flex flex-wrap justify-content-center mt-5 filter-button-group  px-0 mx-0">
                    <button type = "button" class = "col-2 col-lg-12 btn m-2  text-dark active-filter-btn" data-filter = "*">All</button>
                    <button type = "button" class = "col-2 col-lg-12 btn m-2  text-dark" data-filter = ".technology">Technology</button>
                    <button type = "button" class = "col-2 col-lg-12 btn m-2  text-dark" data-filter = ".fashion">Fashions</button>
                    <button type = "button" class = "col-2 col-lg-12 btn m-2  text-dark" data-filter = ".sport">sports</button>
                </div>
              </div>
                <div class = "collection-list mt-4 row gx-0 gy-3 col-12 col-lg-10">
                
                	<% for(SanPham product : productList){ %>
	                    <div class = "col-4 col-md-3 col-lg-2 p-2 bg-white <%= product.getPhanLoai()%>">
	                        <div class = "collection-img position-relative special-img overflow-hidden rounded-2">
	                            <img src = "./assets/images/products/<%=product.getPhanLoai() %>/<%=product.getLinkHinhAnh() %>" class = "w-100">
	                            <span class = "position-absolute d-flex align-items-center justify-content-center text-primary fs-4">
	                                <i class = "fas fa-heart"></i>
	                            </span>
	                        </div>
	                        <div class = "text-center">
	                            <div class = "rating mt-1">
	                                <span class = "text-warning"><i class = "fas fa-star"></i></span>
	                                <span class = "text-warning"><i class = "fas fa-star"></i></span>
	                                <span class = "text-warning"><i class = "fas fa-star"></i></span>
	                                <span class = "text-warning"><i class = "fas fa-star"></i></span>
	                                <span class = "text-warning"><i class = "fas fa-star"></i></span>
	                            </div>
	                            <div class = "text-center">
	                                <p class = "text-capitalize mt-1 mb-1"><%=product.getTenSanPham() %></p>
	                                <span class = "fw-bold d-block">$ <%=product.getGiaSanPham() %></span>
	                                <a href = "IndexController?page=product&id=<%=product.getMaSanPham() %>" class = "btn btn-primary mt-1">Add to Cart</a>
	                            </div>
	                        </div>
	                    </div>
                    <% } %>
                </div>
            </div>
        </div>
    </section>
    <!-- end of product -->



    <!-- special products -->
    <section id = "special" class = "py-5 ">
        <div class = "title text-center py-5">
                <h2 class = "position-relative d-inline-block">Special Selection</h2>
        </div>
        <div class = "container bg-light p-3 rounded-3">
            
            <div class = "special-list row g-0">
                
                <div class = "col-md-6 col-lg-4 col-xl-3 p-2">
                    <div class = "special-img position-relative overflow-hidden">
                        <img src = "./assets/images/products/Fashion/special_product_1.jpg" class = "w-100">
                        <span class = "position-absolute d-flex align-items-center justify-content-center text-primary fs-4">
                            <i class = "fas fa-heart"></i>
                        </span>
                    </div>
                    <div class = "text-center">
                        <div class = "rating mt-3">
                        </div>
                        <p class = "text-capitalize mt-3 mb-1">gray shirt</p>
                        <span class = "fw-bold d-block">$ 45.50</span>
                        <a href = "#" class = "btn btn-primary mt-3">Add to Cart</a>
                    </div>
                </div>




                <div class = "col-md-6 col-lg-4 col-xl-3 p-2">
                    <div class = "special-img position-relative overflow-hidden">
                        <img src = "./assets/images/products/Fashion/special_product_2.jpg" class = "w-100">
                        <span class = "position-absolute d-flex align-items-center justify-content-center text-primary fs-4">
                            <i class = "fas fa-heart"></i>
                        </span>
                    </div>
                    <div class = "text-center">
                        <p class = "text-capitalize mt-3 mb-1">gray shirt</p>
                        <span class = "fw-bold d-block">$ 45.50</span>
                        <a href = "#" class = "btn btn-primary mt-3">Add to Cart</a>
                    </div>
                </div>

                <div class = "col-md-6 col-lg-4 col-xl-3 p-2">
                    <div class = "special-img position-relative overflow-hidden">
                        <img src = "./assets/images/products/Fashion/special_product_3.jpg" class = "w-100">
                        <span class = "position-absolute d-flex align-items-center justify-content-center text-primary fs-4">
                            <i class = "fas fa-heart"></i>
                        </span>
                    </div>
                    <div class = "text-center">
                        <p class = "text-capitalize mt-3 mb-1">gray shirt</p>
                        <span class = "fw-bold d-block">$ 45.50</span>
                        <a href = "#" class = "btn btn-primary mt-3">Add to Cart</a>
                    </div>
                </div>

                <div class = "col-md-6 col-lg-4 col-xl-3 p-2">
                    <div class = "special-img position-relative overflow-hidden">
                        <img src = "./assets/images/products/Fashion/special_product_4.jpg" class = "w-100">
                        <span class = "position-absolute d-flex align-items-center justify-content-center text-primary fs-4">
                            <i class = "fas fa-heart"></i>
                        </span>
                    </div>
                    <div class = "text-center">
                        <p class = "text-capitalize mt-3 mb-1">gray shirt</p>
                        <span class = "fw-bold d-block">$ 45.50</span>
                        <a href = "#" class = "btn btn-primary mt-3">Add to Cart</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- end of special products -->
 

    <!-- newsletter -->
    <section id = "newsletter" class = "py-5">
        <div class = "container">
            <div class = "d-flex flex-column align-items-center justify-content-center">
                <div class = "title text-center pt-3 pb-5">
                    <h2 class = "position-relative d-inline-block ms-4">Newsletter Subscription</h2>
                </div>

                <p class = "text-center text-muted">Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus rem officia accusantium maiores quisquam dolorum?</p>
                <div class = "input-group mb-3 mt-3">
                    <input type = "text" class = "form-control" placeholder="Enter Your Email ...">
                    <button class = "btn btn-primary" type = "submit">Subscribe</button>
                </div>
            </div>
        </div>
    </section>
    <!-- end of newsletter -->

    <!-- footer -->
    <footer id="aboutus" class = "bg-dark py-5">
        <div class = "container">
            <div class = "row text-white g-4">
                <div class = "col-md-6 col-lg-3">
                    <a class = "text-uppercase text-decoration-none brand text-white" href = "index.html">Portrait</a>
                    <p class = "text-white text-white mt-3">Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum mollitia quisquam veniam odit cupiditate, ullam aut voluptas velit dolor ipsam?</p>
                </div>

                <div class = "col-md-6 col-lg-3">
                    <h5 class = "fw-light">Links</h5>
                    <ul class = "list-unstyled">
                        <li class = "my-3">
                            <a href = "#" class = "text-white text-decoration-none text-white">
                                <i class = "fas fa-chevron-right me-1"></i> Home
                            </a>
                        </li>
                        <li class = "my-3">
                            <a href = "#" class = "text-white text-decoration-none text-white">
                                <i class = "fas fa-chevron-right me-1"></i> Collection
                            </a>
                        </li>
                        <li class = "my-3">
                            <a href = "#" class = "text-white text-decoration-none text-white">
                                <i class = "fas fa-chevron-right me-1"></i> Blogs
                            </a>
                        </li>
                        <li class = "my-3">
                            <a href = "#" class = "text-white text-decoration-none text-white">
                                <i class = "fas fa-chevron-right me-1"></i> About Us
                            </a>
                        </li>
                    </ul>
                </div>

                <div class = "col-md-6 col-lg-3">
                    <h5 class = "fw-light mb-3">Contact Us</h5>
                    <div class = "d-flex justify-content-start align-items-start my-2 text-white">
                        <span class = "me-3">
                            <i class = "fas fa-map-marked-alt"></i>
                        </span>
                        <span class = "fw-light">
                            275/Nguyen Cong Tru, Da Nang, VietNam
                        </span>
                    </div>
                    <div class = "d-flex justify-content-start align-items-start my-2 text-white">
                        <span class = "me-3">
                            <i class = "fas fa-envelope"></i>
                        </span>
                        <span class = "fw-light">
                            Portrait.support@gmail.com
                        </span>
                    </div>
                    <div class = "d-flex justify-content-start align-items-start my-2 text-white">
                        <span class = "me-3">
                            <i class = "fas fa-phone-alt"></i>
                        </span>
                        <span class = "fw-light">
                            +0905 579 xxx
                        </span>
                    </div>
                </div>

                <div class = "col-md-6 col-lg-3">
                    <h5 class = "fw-light mb-3">Follow Us</h5>
                    <div>
                        <ul class = "list-unstyled d-flex">
                            <li>
                                <a href = "#" class = "text-white text-decoration-none text-white fs-4 me-4">
                                    <i class = "fab fa-facebook-f"></i>
                                </a>
                            </li>
                            <li>
                                <a href = "#" class = "text-white text-decoration-none text-white fs-4 me-4">
                                    <i class = "fab fa-twitter"></i>
                                </a>
                            </li>
                            <li>
                                <a href = "#" class = "text-white text-decoration-none text-white fs-4 me-4">
                                    <i class = "fab fa-instagram"></i>
                                </a>
                            </li>
                            <li>
                                <a href = "#" class = "text-white text-decoration-none text-white fs-4 me-4">
                                    <i class = "fab fa-pinterest"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- end of footer -->
         


        
      
    </div>
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
    <!-- jquery -->
    <script src = "./assets/js/jquery-3.6.0.js"></script>
    <!-- isotope js -->
    <script src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.js"></script>

    <script src="./assets/bootstrap-5.3.0-alpha3-dist/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>
</html>