<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Entity.MarkSheetRequest"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/component/allCSS.jsp"%>
<title>Request form</title>
<style type="text/css">
.card-sh {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 5);
}
</style>

</head>
<body >


	<%@include file="/component/navbar.jsp"%>
	<div class="container p-$ my-5">
		<div class="row">
			<div class="col-md-9 offset-md-2">
				<div class="card card-sh">
					<div>
						<p class="text-center fs-2  fw-bold">MarkSheet Request</p>
					</div>

					<div class="card-body">

						<form action="../RequestRaise" method="post">

							<div class="mb-3">
								<label>Name <span
									class="text-center text-danger fw-bold  fs-5">*</span>
								</label><input required type="text" name="name" value="${name}"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Department <span
									class="text-center text-danger fw-bold fs-5">*</span></label><input
									required type="text" name="department" class="form-control">
							</div>
							<div class="mb-3">
								<label>Required Grade Sheet <span
									class="text-center text-danger fw-bold fs-5">*</span></label><input
									required type="text" name="reqGradeSheet" class="form-control">
							</div>
							<div class="mb-3">
								<label>Mobile no <span
									class="text-center text-danger fw-bold fs-5">*</span></label><input
									required type="text" name="mobileNo" class="form-control">
							</div>

							<label>Dispatch type <span
								class="text-center text-danger fw-bold fs-5">*</span></label><br>

							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="flexRadioDefault" id="flexRadioDefault1" value="By post">
								<label class="form-check-label" for="flexRadioDefault1">
									By post </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="flexRadioDefault" value="In person"
									id="flexRadioDefault2"> <label class="form-check-label"
									for="flexRadioDefault2"> In person </label>
							</div>
							<br>
							<div class="mb-3">
								<label>Address </label> <input required type="text"
									name="address" class="form-control">
							</div>

							<div>
								<button class="btn btn-primary col-md-12">Request Raise</button>

							</div>
						</form>


						

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>