<%@page import="Database.BannerDao"%>
<%@page import="Database.SanPhamDao"%>
<%@page import="Model.KhachHang"%>
<%@page import="Model.SanPham"%>
<%@page import="Model.Banner"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
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
	Object obj = session.getAttribute("khachHang");
	KhachHang khachHang = null;
	if (obj != null)
	{
		khachHang = (KhachHang) obj;
	}
	
	Object objSanPham = session.getAttribute("sanPham");
	SanPham sanPham = null;
	if(objSanPham!=null)
	{
		sanPham = (SanPham) objSanPham;
	}
%>
<body>
	<div id="nav-placeholder"></div>
	<div id="slider-placeholder"></div>

		<!-- content -->
	<form action="FunctionController?function=add_product" method="post" class="bg-light d-flex justify-content-center" style=" width: 100vw">
		<input type="hidden" name="masanpham" id="masanpham" value="<%= sanPham.getMaSanPham()%>">
		<input type="hidden" name="nhabanhang" id="nhabanhang" value="<%= sanPham.getNhaBanHang()%>">
		<input type="hidden" name="makhachhang" id="makhachhang" value="<%=(khachHang==null)?"":khachHang.getMaKhachHang()%>">
		<section class=" align-self-center col-12" >
		  <div class="container-fluid">
		    <div class="row" style="height: 100vh;">
		      <aside class="col-lg-6 d-flex justify-content-center">
		        <div class=" rounded-4 col-12 mb-3 d-flex justify-content-center">
		          <a data-fslightbox="mygalley" class="rounded-4 align-self-center" target="_blank" data-type="image" href="./assets/images/products/<%= sanPham.getPhanLoai()%>/<%= sanPham.getLinkHinhAnh()%>">
		            <img style="max-width: 100%;border-radius: 15px; max-height: 100vh; margin: auto;" class="rounded-4 fit" src="./assets/images/products/<%= sanPham.getPhanLoai() %>/<%= sanPham.getLinkHinhAnh()%>" />
		          </a>
		        </div>
		        <!-- thumbs-wrap.// -->
		        <!-- gallery-wrap .end// -->
		      </aside>
		      <main class="col-lg-6 pt-3 d-flex">
		        <div class="ps-lg-3 col-12 align-self-center" >
		          <h3 class="title text-dark">
		            <%= sanPham.getTenSanPham() %>
		          </h3>
		          <div class="d-flex flex-row my-3">
		            <div class="text-warning mb-1 me-2">
		              <i class="fa fa-star"></i>
		              <i class="fa fa-star"></i>
		              <i class="fa fa-star"></i>
		              <i class="fa fa-star"></i>
		              <i class="fas fa-star-half-alt"></i>
		              <span class="ms-1">
		                4.5
		              </span>
		            </div>
		            <span class="text-muted"><i class="fas fa-shopping-basket fa-sm mx-1"></i>154 orders</span>
		            <span class="text-success ms-2">In stock</span>
		          </div>
		
		          <div class="mb-3">
		            <h4 class="d-inline-block"><span class="text-muted">Price:  </span></h4>
		            <strong class="h5">$<%=sanPham.getGiaSanPham() %></strong>
		          </div>
		          
		          <div class="row">
		            <dt class="col-4">Type:</dt>
		            <dd class="col-8"><%=sanPham.getPhanLoai()%></dd>
		            
					<dt class="col-4">Originating from:</dt>
		            <dd class="col-8"><%= sanPham.getNguonGoc()%></dd>
		
		            <dt class="col-4">Brand:</dt>
		            <dd class="col-8"><%=sanPham.getHangSanXuat()%></dd>
		          </div>
		
		          <hr/>
		
		          <div class="row mb-4">
		            <!-- col.// -->
		            <div class="col-md-4 col-6 mb-3">
		              <label class="mb-2 d-block">Quantity</label>
		              <div class="input-group mb-3" style="width: 170px;">
		                <button class="btn btn-white border border-secondary px-3 minus-btn" onclick="handleMinus()" type="button" id="button-addon1" data-mdb-ripple-color="dark">
		                  <i class="fas fa-minus"></i>
		                </button>
		                <input type="text" name="soluong" id="soluong" class="form-control text-center border border-secondary" placeholder="1" value="1" aria-label="Example text with button addon" aria-describedby="button-addon1" readonly="readonly" />
		                <button class="btn btn-white border border-secondary px-3 plus-btn" onclick="handlePlus()" type="button" id="button-addon2" data-mdb-ripple-color="dark">
		                  <i class="fas fa-plus"></i>
		                </button>
		              </div>
		            </div>
		          </div>
		          <% if(khachHang!=null){ %>
		          <button type="submit" class="btn btn-primary shadow-0"> <i class="me-1 fa fa-shopping-basket"></i> Add to cart </button>
		          <%}else{ %>
		          <a href="./Login.jsp" class="btn btn-primary shadow-0"> <i class="me-1 fa fa-shopping-basket"></i> Add to cart </a>
		          <%} %>
		          <a href="#" class="btn btn-light border border-secondary py-2 icon-hover px-3"> <i class="me-1 fa fa-heart fa-lg"></i> Save </a>
		        </div>
		      </main>
		    </div>
		  </div>
		</section>
	</form>
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
		  
	/* Nut tang giam */
		let amountElement = document.getElementById('soluong');
		let amount = amountElement.value;
		
		let render =(amount) => {
			amountElement.value = amount
		}
		//Handle plus
		let handlePlus = () => {
			if(amount<<%=sanPham.getSoLuong() %>)
			amount++
			render(amount);
		}
		let handleMinus = () => {
			if(amount>1)
			amount--
			render(amount);
		}
   	</Script>
</html>