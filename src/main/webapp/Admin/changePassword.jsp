<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>change password</title>
<%@ include file="../component/allCSS.jsp"%>
<style type="text/css">
.card-sh {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 3);
}
</style>
</head>
<body>


	<div class="container p-$ my-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card card-sh">
					<div>
						<p class="text-center fs-3">Password Reset</p>
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty regError }">
							<p class="text-center text-danger fs-5">${regError}</p>
							<c:remove var="regError" scope="session" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="../AdminReset" method="post">
							<div class="mb-3">
							
								<input required type="text" name="regno" placeholder="Admin Id"
									class="form-control"> <br> <input required type="password"
									name="newPsd" placeholder="Enter Password" class="form-control">
								<br> <input required type="password" name="conPsd"
									placeholder="Confirm Password" class="form-control">
							</div>
							<div class="d-grid gap-2 col-7 mx-auto">
								<button class="btn btn-success col-md-10">Reset
									password</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>