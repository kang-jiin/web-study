<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="includes/header.jsp" %>

<body>
	<%@ include file="includes/navbar.jsp" %>

	<div class="hero-wrap hero-wrap-2" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-start">
          <div class="col-md-12 ftco-animate text-center mb-5">          
            <h1 class="mb-3 bread">Board</h1>
          </div>
        </div>
      </div>
    </div>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 pr-lg-4">
					<% String userId = (String)session.getAttribute("userID"); 
						if(userId != null) { %>
					<form method="POST" action="insertBoard">
	                	<div class="row">
		                    <div class="form-group col-10">
		                        <input type="text" class="form-control" id="content" name="content">
		                    </div>
		                    <div class="form-group col-2">
		                        <button class="btn btn-secondary" type="submit">글쓰기</button>
		                    </div>
						</div>
            		</form>
					<% } %>

					<div class="row">
						<c:forEach items="${blist}" var="blist">
							<div class="col-md-12 ftco-animate">
								<div
									class="job-post-item p-4 d-block d-lg-flex align-items-center">
									<div class="one-third mb-4 mb-md-0">
										<div class="d-block d-md-flex align-items-center">
											<span class="subadge">
											${ blist.id}.
											</span>
											<h5 class="ml-3">
												${ blist.writer}    
											</h5>
										</div>
										<div class="align-items-center">
											<h2 class="mr-3 text-black">
												${ blist.content}  
											</h2>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					
				</div>
			</div>
		</div>
	</section>



	<%@ include file="includes/scripts.jsp" %>


</body>

</html>