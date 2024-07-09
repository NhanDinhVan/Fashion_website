<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object error = session.getAttribute("error");
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
	<link rel="stylesheet" href="./assets/css/login.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
		
		  <div class="container-fluid gradient-form">
		    <div class="row d-flex justify-content-center align-items-center py-5">
		      <div class="col-xl-8"> 
		        <div class="card rounded-3 text-black">
		          <div class="row g-0">
		            <div class="col-lg-6">
		              <div class="card-body p-md-5 mx-md-4">
		
		                <div class="text-center rounded-5">
		                  <img class="rounded-5" src="./assets/images/banner/logo.png"
		                    style="width: 185px;" alt="logo">
		                  <i> <h4 class="mt-1 mb-5 pb-1">Welcome to HT-ECOMMERCE</h4></i>
		                </div>
		
		                <form action="FunctionController?function=login" method="post">
		                  <p class="text-center">Please login to your account</p>
		
		                  <div class="form-outline mb-4">
		                    <input type="email" id="form2Example11" name="username" class="form-control"
		                      placeholder="Your email address" required="required"/>
		                    <i class="form-label" for="form2Example11">Username</i>
		                  </div>
		
		                  <div class="form-outline mb-4">
		                    <input type="password" id="form2Example22" name="password" class="form-control" required="required"/>
		                    <i class="form-label" for="form2Example22">Password</i>
		                  </div>
		
		                  <div class="text-center pt-1 mb-2 pb-1">
		                  	<div><i><%= error!=null?error:"" %></i></div>
		                    <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="submit">Login</button>
		                  </div>
		                  <div class="text-center mb-3">
		                  	<button type="button" class="btn btn-outline-danger">Create new</button>
						  </div>
		                  <div class="d-flex align-items-center justify-content-center pb-4">
		                    <a class="mb-0 me-2">Don't have an account?</a>
		                    <a class="text-muted" href="#!">Forgot password?</a>
		                  </div>
		                </form>
		              </div>
		            </div>
		            <div class=" col-lg-6 d-flex align-items-center gradient-custom-2">
		              <div class="text-white px-3 py-4 p-md-5 mx-md-4">
		                <h4 class="mb-4">We are more than just a company</h4>
		                <p class="small mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
		                  tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
		                  exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
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
    <!-- isotope js -->
    <script src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.js"></script>

    <script src="assets/js/main.js"></script>
</body>
</html>