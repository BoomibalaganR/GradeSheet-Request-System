<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../component/allCSS.jsp"%>
<meta charset="UTF-8">
<title>login page</title>

<style type="text/css">
.card-sh {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 5);
}
</style>
</head>

<body class="bg-light"> 

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>
	<%@include file="/component/navbar.jsp"%>

	<div class="container p-$ my-5">
		<div class="row">
			<div class="col-md-5 offset-md-4">
				<div class="card card-sh">
					<div>
						<p class="text-center fs-2">Admin Login</p>
					</div>

					<div class="card-body">
						<c:if test="${ not empty errorMsg}">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${ not empty successMsg}">
							<p class="text-center text-success fs-5">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>
						<form action="AdminLogin" method="post">
							<div class="mb-3">
								<label>Admin Id</label> <input required type="text" name="adminId"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Password</label> <input required type="password" name="password"
									class="form-control">
							</div>

							<div>
								<button class="btn btn-primary col-md-12">Login</button>

							</div>
							<!-- <div>
								<br> <a href="Admin/changePassword.jsp">Forgot password?</a>
							</div> -->
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
