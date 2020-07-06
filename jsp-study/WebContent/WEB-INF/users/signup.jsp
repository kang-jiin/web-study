<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp"%>

<body>
	<%@ include file="../includes/navbar.jsp"%>

	<div class="hero-wrap hero-wrap-2"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-end justify-content-start">
				<div class="col-md-12 ftco-animate text-center mb-5">
					<p class="breadcrumbs mb-0">
						<span class="mr-3">USER <i class="ion-ios-arrow-forward"></i></span> 
						<span>Sign Up</span>
					</p>
					<h1 class="mb-3 bread">Sign Up</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row align-items-center justify-content-center">

				<div class="col-md-12 col-lg-8 mb-5">

					<form action="signupok" method="post" class="p-5 bg-white">
						<div class="form-group" align="left">
							<label for="name">이름</label> <input type="text"
								class="form-control" id="name" name="name">
						</div>
						<div class="form-group" align="left">
							<label for="">아이디</label> 
							<input type="text" class="form-control" id="id" name="id">
						</div>
						<div class="form-group" align="left">
							<label for="">비밀번호</label> 
							<input type="password" class="form-control" id="pwd" name="pwd">
						</div>
						<div class="form-group" align="center">
							<button type="submit" class="btn btn-primary">회원가입</button>
							<button type="reset" class="btn btn-warning">초기화</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="../includes/scripts.jsp"%>

</body>

</html>

