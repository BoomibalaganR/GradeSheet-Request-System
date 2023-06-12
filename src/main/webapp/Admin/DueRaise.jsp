<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
	import="model.Entity.MarkSheetRequest,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/component/allCSS.jsp"%>
<title>Due Raise</title>
</head>
<body>
	<c:if test="${empty loginAdmin}">
		<c:redirect url="../AdminLogin.jsp"></c:redirect>
	</c:if>
	<%@include file="/component/navbar.jsp"%>



	<div class="container-xxl my-5">


		<div class="row">
			<div class="col-md-8 offset-md-2">
				<table class="table table-hover table-bordered border-light ">
					<thead>
						<c:if test="${not empty succesRaise}">
							<p>${succesRaise}</p>
							<c:remove var="succesRaise" scope="session" />
						</c:if>
						<tr class="table-primary ">
							<th scope="col">Reg No</th>
							<th scope="col">Name</th>
							<th scope="col">Department</th>
							<th scope="col">Req. Gradesheet</th>
							<th scope="col">Dispatch Type</th>
							<th scope="col">status</th>
							<th scope="col">Due Raise</th>
						</tr>
					</thead>
					<c:if test="${not empty errorMsg}">
						<tbody>
							<tr>
								<td colspan="7" class="table-active text-center fs-6 fw-bold">
									${errorMsg}</td>
							</tr>
						</tbody>
						<c:remove var="errorMsg" scope="session" />
					</c:if>

					<c:if test="${not empty listOfDue }">
						<tbody>
							<%
							List<MarkSheetRequest> msq = (List<MarkSheetRequest>) session.getAttribute("listOfDue");
							for (MarkSheetRequest obj : msq) {
							%>

							<tr>
								<td class="text-center"><%=obj.getRegno()%></td>
								<td class="text-center"><%=obj.getName()%></td>
								<td class="text-center"><%=obj.getDepartment()%></td>
								<td class="text-center"><%=obj.getReqGradesheet()%></td>
								<td class="text-center"><%=obj.getDispatchType()%></td>
								<td class="text-center"><%=obj.getTrackId().getCurrentstatus()%></td>
								<td class="text-center">
									<%--session.setAttribute("raiseStudentId", obj.getTrackId().getTrackID()); --%>
									<form action="../DueRaiseServlet?k=<%=obj.getTrackId().getTrackID()%>" method="post">
										<button type="submit" class="btn btn-danger btn-sm">
											Due Raise</button>
									</form>
								</td>
							</tr>

							<%
							}
							%>
						</tbody>

					</c:if>
				</table>

			</div>
		</div>

	</div>



</body>
</html>