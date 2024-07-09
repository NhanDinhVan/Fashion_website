<%@page import="Database.BannerDao"%>
<%@page import="Database.SanPhamDao"%>
<%@page import="Model.KhachHang"%>
<%@page import="Model.SanPham"%>
<%@page import="Model.Banner"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Database.GioHangDao"%>
<%@page import="Model.GioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<title>Insert title here</title>
	<script src="assets/js/main.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js%22%3E"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js%22%3E"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
	<script src="node_modules/jquery/dist/jquery.slim.min.js"></script>
	<script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
	<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<%
	Object objKH = session.getAttribute("khachHang");
	KhachHang khachHang =null;
	if(objKH!=null)
	{
		khachHang = (KhachHang) objKH;
	}
	GioHang gh = new GioHang(khachHang.getMaKhachHang(),"","",0);
	GioHangDao ghd = new GioHangDao();
	ArrayList<GioHang> listCart = ghd.selectGioHang(gh);
%>    
<body>
	<div id="nav-placeholder"></div>
	<div id="slider-placeholder"></div>

	<!-- content -->
		<div class="container" style="height: 75vh;">
  <div class="py-5 text-center">
    
    <h2>Checkout form</h2>
    <p class="lead">Below is an example form built entirely with Bootstrap 5 form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>
  </div>

  <div class="row">
    <div class="col-md-6 order-md-2 mb-4">
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">Your cart</span>
        <span class="badge badge-secondary badge-pill">3</span>
      </h4>
      <ul class="list-group mb-3">
      <% double total = 0;
      	for(GioHang sanpham :listCart){ 
      	SanPham spcheck = new SanPham(sanpham.getMaSanPham(), "", "", "", "", "", "", "", "");
      	SanPhamDao spd = new SanPhamDao();
      	SanPham sp = spd.selectById(spcheck);
      	total+=(sanpham.getSoLuong()*Double.parseDouble(sp.getGiaSanPham()));
      %>
        <li class="list-group-item d-flex justify-content-between lh-condensed">
          <div>
            <img alt="Error Image" width="100" src="./assets/images/products/<%=sp.getPhanLoai() %>/<%=sp.getLinkHinhAnh()%>">
            <h6 class="my-0"><%=sp.getTenSanPham() %></h6>
            <small class="text-muted">Quantity: <%=sanpham.getSoLuong() %></small>
          </div>
          <span class="text-muted fw-bold my-auto mx-3">$<%= sanpham.getSoLuong()*Double.parseDouble(sp.getGiaSanPham())%></span>
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
    <div class="col-md-6 order-md-1">
      <h4 class="mb-3">Billing address</h4>
      <form action="FunctionController" method="get" >
      <input name="function" id="function" type="hidden" value="checkout">
        <div class="row">
          <div class="col-md-12 mb-6">
            <label for="firstName">Full name</label>
            <input type="text" class="form-control" id="fullName" name="fullName" placeholder="" value="<%= khachHang.getTenKhachHang() %>" required>
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>
        </div>

        <div class="mb-3">
          <label for="phoneNumber">Phone Number</label>
          <div class="input-group">
            <input type="tel" id="phoneNumber" class="form-control" name="phoneNumber" pattern="[0-9]{10}" value="<%=khachHang.getSoDienThoai() %>" required="required">
            <div class="invalid-feedback" style="width: 100%;">
              Your phone number is required.
            </div>
          </div>
        </div>

        <div class="mb-3">
          <label for="email">Email <span class="text-muted">(Optional)</span></label>
          <input type="email" class="form-control" id="email" name="email" value="<%=khachHang.getMaKhachHang() %>" placeholder="you@example.com">
          <div class="invalid-feedback">
            Please enter a valid email address for shipping updates.
          </div>
        </div>

        <div class="mb-3">
          <label for="address">Address</label>
          <input type="text" class="form-control" id="address" name="address" value="<%=khachHang.getDiaChi() %>" placeholder="1234 Main St" required>
          <div class="invalid-feedback">
            Please enter your shipping address.
          </div>
        </div>
        <hr class="mb-4">
        <div class="custom-control custom-checkbox">
          <input type="checkbox" class="custom-control-input" id="save-info">
          <label class="custom-control-label" for="save-info">Save this information for next time</label>
        </div>
        <hr class="mb-4">
        <div class="text-center">
        	<button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
        </div>
        <input type="hidden" name="maKhachHang" id="maKhachHang" value="<%= khachHang.getMaKhachHang()%>">
      </form>
    </div>
  </div>

</div>
	<!-- content -->

	<div id="foot-placeholder"></div>
</body>

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
		
   	</Script>
</html>