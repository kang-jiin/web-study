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
						<span class="mr-3"><a href="index.jsp">USER <i
								class="ion-ios-arrow-forward"></i></a></span> <span>Login</span>
					</p>
					<h1 class="mb-3 bread">Login</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row align-items-center justify-content-center">

				<div class="col-md-12 col-lg-8 mb-5">

					<form action="logincheck" method="post" class="p-5 bg-white">
						<c:if test="${not empty loginFlag}">
							<p style="color: red;">아이디 또는 비밀번호가 잘못되었습니다.</p>
						</c:if>
						<div class="form-group">
							<label for="signin-id" class="control-label sr-only">ID</label> <input
								type="text" class="form-control" id="id" value=""
								placeholder="ID" name="id">
						</div>
						<div class="form-group">
							<label for="signin-password" class="control-label sr-only">Password</label>
							<input type="password" class="form-control" id="pwd" value=""
								placeholder="Password" name="pwd">
						</div>

						<div class="row form-group" align="center">
							<div class="col-md-12">
								<button type="submit" class="btn btn-primary">로그인</button>
								<a href="signup" class="btn btn-warning">회원가입</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="../includes/scripts.jsp"%>

</body>

</html>
