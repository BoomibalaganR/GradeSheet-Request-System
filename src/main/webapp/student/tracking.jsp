<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/component/allCSS.jsp"%>
<title>track the form</title>
<style type="text/css">
.card-sh {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 5);
}

ol.progtrckr {
	margin: 0;
	padding: 0;
	list-style-type
	none;
}

ol.progtrckr li {
	display: inline-block;
	text-align: center;
	line-height: 3.5em;
}

ol.progtrckr[data-progtrckr-steps="2"] li {
	width: 49%;
}

ol.progtrckr[data-progtrckr-steps="3"] li {
	width: 33%;
}

ol.progtrckr[data-progtrckr-steps="4"] li {
	width: 24%;
}

ol.progtrckr[data-progtrckr-steps="5"] li {
	width: 19%;
}

ol.progtrckr[data-progtrckr-steps="6"] li {
	width: 16%;
}

ol.progtrckr[data-progtrckr-steps="7"] li {
	width: 14%;
}

ol.progtrckr[data-progtrckr-steps="8"] li {
	width: 12%;
}

ol.progtrckr[data-progtrckr-steps="9"] li {
	width: 11%;
}

ol.progtrckr li.progtrckr-done {
	color: black;
	border-bottom: 4px solid yellowgreen;
}

ol.progtrckr li.progtrckr-todo {
	color: silver;
	border-bottom: 4px solid silver;
}

ol.progtrckr li:after {
	content: "\00a0\00a0";
}

ol.progtrckr li:before {
	position: relative;
	bottom: -2.5em;
	float: left;
	left: 50%;
	line-height: 1em;
}

ol.progtrckr li.progtrckr-done:before {
	content: "\2713";
	color: white;
	background-color: yellowgreen;
	height: 2.2em;
	width: 2.2em;
	line-height: 2.2em;
	border: none;
	border-radius: 2.2em;
}

ol.progtrckr li.progtrckr-todo:before {
	content: "\039F";
	color: silver;
	background-color: white;
	font-size: 2.2em;
	bottom: -1.2em;
}
</style>
</head>
<body class="bg-light">
	<c:if test="${empty loginStudent}">
		<c:redirect url="../StudentLogin.jsp"></c:redirect>
	</c:if>
	<%@include file="/component/navbar.jsp"%>

	<div class="container-xxl my-5">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card card-sh">
					<div>
						<p class="text-center fs-3 fw-bold ">Track Application Status</p>
					</div>
					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger fs-5 ">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>

					<div class="card-body">

						<form action="../TrackingServlet" method="post">
							<div class="mb-3">
								<label class="fst-normal mb-3 fw-bold">Reference Number
								</label> <input required type="text" value="" name="refNo"
									class="form-control" placeholder="Enter Reference Number">
								<c:remove var="ID" scope="session"></c:remove>
							</div>

							<div>
								<button class="btn btn-primary col-md-2">Track</button>

							</div>

						</form>
						<br> <br>

					</div>

					<c:if test="${not empty currentStatus }">

						<div>
							<ol class="progtrckr" data-progtrckr-steps="5">

								<c:if test="${currentStatus == 'form submission'}">
									<li class="progtrckr-done">Form Submission</li>
								</c:if>
								<c:if test="${currentStatus == 'form submission'}">
									<li class="progtrckr-todo">Form verification</li>
									<li class="progtrckr-todo">Payment Raised</li>
									<li class="progtrckr-todo">Payment Verified</li>
									<li class="progtrckr-todo">Dispatched</li>
									<c:remove var="currentStatus" scope="session" />
								</c:if>


								<c:if test="${currentStatus == 'form verified'}">
									<li class="progtrckr-done">Form Submission</li>
									<li class="progtrckr-done">Form verified</li>
								</c:if>
								<c:if test="${currentStatus == 'form verified'}">
									<li class="progtrckr-todo">Payment Raised</li>
									<li class="progtrckr-todo">Payment Verified</li>
									<li class="progtrckr-todo">Dispatched</li>
									<c:remove var="currentStatus" scope="session" />
								</c:if>


								<c:if test="${currentStatus == 'payment raised'}">
									<li class="progtrckr-done">Form Submission</li>
									<li class="progtrckr-done">Form verification</li>
									<li class="progtrckr-done">Payment Raised</li>
								</c:if>
								<c:if test="${currentStatus == 'payment raised'}">
									<li class="progtrckr-todo">Payment Verified</li>
									<li class="progtrckr-todo">Dispatched</li>
									<c:remove var="currentStatus" scope="session" />
								</c:if>


								<c:if test="${currentStatus == 'payment verification'}">
									<li class="progtrckr-done">Form Submission</li>
									<li class="progtrckr-done">Form verified</li>
									<li class="progtrckr-done">Payment Raised</li>
									<li class="progtrckr-done">Payment Verified</li>
								</c:if>
								<c:if test="${currentStatus == 'payment verification'}">
									<li class="progtrckr-todo">Dispatched</li>
									<c:remove var="currentStatus" scope="session" />
								</c:if>


								<c:if test="${currentStatus == 'dispatched'}">
									<li class="progtrckr-done">Form Submission</li>
									<li class="progtrckr-done">Form verification</li>
									<li class="progtrckr-done">Payment Raised</li>
									<li class="progtrckr-done">Payment Verified</li>
									<li class="progtrckr-done">Dispatched</li>
									<c:remove var="currentStatus" scope="session" />
								</c:if>

							</ol>
						</div>
					</c:if>
					<br> <br>
				</div>
			</div>
		</div>
	</div>

</body>
</html>