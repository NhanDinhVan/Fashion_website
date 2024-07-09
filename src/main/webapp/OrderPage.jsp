<%@page import="Database.ChiTietDonHangDao"%>
<%@page import="Model.ChiTietDonHang"%>
<%@page import="Database.DonHangDao"%>
<%@page import="Model.DonHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="Model.Banner"%>
<%@page import="Database.BannerDao"%>
<%@page import="Database.SanPhamDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.SanPham"%>
<%@page import="Model.KhachHang"%>
<%@page import="Database.GioHangDao"%>
<%@page import="Model.GioHang"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>E-Portrait</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="icon" type="image/x-icon" href="./imgs/banner/main-logo.png">
	
	<link
		href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
		rel="stylesheet">
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
	
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
	<script src="assets/js/main.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js%22%3E"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js%22%3E"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
	<script src="node_modules/jquery/dist/jquery.slim.min.js"></script>
	<script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
	<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
	
	<link rel="stylesheet" href="./main.css">
	<link rel="stylesheet" href="./data/css/bootstrap.min.css">
</head>
<body>
	<%
	Object obj = session.getAttribute("khachHang");
	KhachHang khachHang = null;
	if (obj != null) {
		khachHang = (KhachHang) obj;
	}
	DonHang dh = new DonHang("","","","","",khachHang.getMaKhachHang());
	DonHangDao dhd = new DonHangDao();
	ArrayList<DonHang> listOders = dhd.selectByMaKhachHang(dh);
	%>
	
	<div id="nav-placeholder"></div>


<% for(DonHang donHang :listOders){
	ChiTietDonHang ctdh = new ChiTietDonHang(donHang.getMaDonHang(),"","");
	ChiTietDonHangDao ctdhd = new ChiTietDonHangDao();
	ArrayList<ChiTietDonHang> ListCtdh = ctdhd.selectByMaDonHang(ctdh);
%> 
<div class="col-md-6 order-md-2 mb-4">
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">Your cart</span>
        <span class="badge badge-secondary badge-pill">3</span>
      </h4>
      <ul class="list-group mb-3">
      <% double total = 0;
      	for(ChiTietDonHang chiTietDonHang : ListCtdh){ 
      	SanPham spcheck = new SanPham(chiTietDonHang.getMaSanPham(), "", "", "", "", "", "", "", "");
      	SanPhamDao spd = new SanPhamDao();
      	SanPham sp = spd.selectById(spcheck);
      	
      		total+=(Integer.parseInt(chiTietDonHang.getSoLuong())*Double.parseDouble(sp.getGiaSanPham()));
        
      %>
     
        <li class="list-group-item d-flex justify-content-between lh-condensed">
          <div>
            <img alt="" width="100" src="./assets/images/products/<%=sp.getPhanLoai() %>/<%=sp.getLinkHinhAnh()%>">
            <h6 class="my-0"><%=sp.getTenSanPham() %></h6>
            <small class="text-muted">Quantity: <%= chiTietDonHang.getSoLuong() %></small>
          </div>
          <span class="text-muted fw-bold my-auto mx-3">$<%= Double.parseDouble(chiTietDonHang.getSoLuong())*Double.parseDouble(sp.getGiaSanPham()) %></span>
        </li>
        <%} %>
        <li class="list-group-item d-flex justify-content-between">
          <span>Total (USD)</span>
          <strong>$<%=total %></strong>
        </li>
      </ul>

      <form class="card p-2">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Promo code">
          <div class="input-group-append">
            <button type="submit" class="btn btn-secondary">Redeem</button>
          </div>
        </div>
      </form>
    </div>
	<%} %>


	<div id="foot-placeholder"></div>
	<!--scirpts-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<!-- jquery -->
	<script src="./data/js/jquery-3.6.0.js"></script>
	<!-- isotope js -->
	<script src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.js"></script>

	<script
		src="./assets/bootstrap-5.3.0-alpha3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="main.js"></script>
	<Script>
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