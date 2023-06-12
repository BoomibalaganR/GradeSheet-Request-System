<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
	import="model.Entity.MarkSheetRequest,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/component/allCSS.jsp"%>
<title>payment verification</title>
</head>
<body>
	<%@include file="/component/navbar.jsp"%>
	<c:if test="${empty loginAdmin}">
		<c:redirect url="../AdminLogin.jsp"></c:redirect>
	</c:if>
	<div class="container-xxl my-5">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<table class="table table-hover table-bordered border-light ">
					<c:if test="${not empty successMsg}">
						<p class="text-center text-success fs-5">${successMsg}</p>
						<c:remove var="successMsg" scope="session" />
					</c:if>
					<thead>
						<tr class="table-primary ">
							<th scope="col">Reg No</th>
							<th scope="col">Name</th>
							<th scope="col">Department</th>
							<th scope="col">Req. Gradesheet</th>
							<th scope="col">Dispatch Type</th>
							<th scope="col">Status</th>
							<th scope="col">Transaction ID</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<c:if test="${not empty errorMsg}">
						<tbody>
							<tr>
								<td colspan="8" class="table-active text-center fs-6 fw-bold">
									${errorMsg}</td>
							</tr>
						</tbody>
						<c:remove var="errorMsg" scope="session" />
					</c:if>

					<c:if test="${not empty listOfPaid }">
						<%
						List<MarkSheetRequest> msq = (List<MarkSheetRequest>) session.getAttribute("listOfPaid");
						for (MarkSheetRequest obj : msq) {
						%>
						<tbody>

							<tr>
								<td class="text-center"><%=obj.getRegno()%></td>
								<td class="text-center"><%=obj.getName()%></td>
								<td class="text-center"><%=obj.getDepartment()%></td>
								<td class="text-center"><%=obj.getReqGradesheet()%></td>
								<td class="text-center"><%=obj.getDispatchType()%></td>
								<td class="text-center"><%=obj.getFd().getStatus()%></td>
								<td class="text-center"><%=1233445665%></td>

								<%
								if (obj.getDispatchType().equals("By Post")) {
								%>
								<td><form action="../PaymentVerifyServlet" method="post">
										<button type="submit" class="btn btn-danger btn-sm">
											continue..</button>
									</form></td>
								<%
								} else {
								%>
								<td><form
										action="../PaymentVerifyServlet?k=<%=obj.getReqId()%>"
										method="post">
										<button type="submit" class="btn btn-success btn-sm">
											verify</button>
									</form></td>
								<%
								}
								%>
							</tr>

						</tbody>
						<%
						}
						%>
						<c:remove var="listOfRequest" scope="session" />
					</c:if>
				</table>

			</div>
		</div>
	</div>

</body>
</html>