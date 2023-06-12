<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<%@include file="/component/allCSS.jsp" %>
<title>Payment Page</title>
</head>
<body>

	<div class="container p-$ my-5">
		<div class="row">
			<div class="col-md-5 offset-md-4">
				<div class="card card-sh">
					<div>
						<p class="text-center fs-2 fw-bold">Payment Page</p>
					</div>

					<div class="card-body">

						<form action="#" method="post">
							<div class="mb-3">
								<label>Card Number</label> <input required type="text"
									name="cardNumber" class="form-control">
							</div>
							<div class="mb-3">
								<label>Card Holder</label> <input required type="text"
									name="cardHolder" class="form-control">
							</div>
							<div class="mb-3">
								<label>Expiry Date</label> <input required type="text"
									name="expiryDate" placeholer="MM/YY" class="form-control">
							</div>
							<div class="mb-3">
								<label>CVV</label> <input required type="text"
									name="cvvNo" class="form-control">
							</div>


							<div>
								<button class="btn btn-success col-md-12">Submit Payment</button>

							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>