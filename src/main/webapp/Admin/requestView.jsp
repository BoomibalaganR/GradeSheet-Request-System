<%@page import="org.hibernate.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.List,model.Entity.MarkSheetRequest"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/component/allCSS.jsp"%>
<title>view request</title>
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
						<tr class="table-primary ">
							<th scope="col">Reg No</th>
							<th scope="col">Name</th>
							<th scope="col">Department</th>
							<th scope="col">Req. Gradesheet</th>
							<th scope="col">Dispatch Type</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<c:if test="${not empty errorMsg}">
						<tbody>
							<tr>
								<td colspan="6" class="table-active text-center fs-6 fw-bold">
									${errorMsg}</td>
							</tr>
						</tbody>
						<c:remove var="errorMsg" scope="session" />
					</c:if>

					<c:if test="${not empty listOfRequest }">
						<tbody>
							<%
							List<MarkSheetRequest> msq = (List<MarkSheetRequest>) session.getAttribute("listOfRequest");
							for (MarkSheetRequest i : msq) {
								//session.setAttribute("reqList", i);
							%>

							<tr>
								<td class="text-center"><%=i.getRegno()%></td>
								<td class="text-center"><%=i.getName()%></td>
								<td class="text-center"><%=i.getDepartment()%></td>
								<td class="text-center"><%=i.getReqGradesheet()%></td>
								<td class="text-center"><%=i.getDispatchType()%></td>
								<td class="text-center"><a
									href="../Admin/requestFormVerify.jsp?k=<%= i.getReqId()%>">View Form</a></td>
							</tr>
							<%
							}
							%>
						</tbody>
						<c:remove var="listOfRequest" scope="session" />
					</c:if>
				</table>

			</div>
		</div>
	</div>




</body>
</html>