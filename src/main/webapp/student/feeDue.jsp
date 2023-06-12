<%@page import="org.hibernate.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.List,model.Entity.FeeDueDetail"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/component/allCSS.jsp"%>
<meta charset="UTF-8">
<title>fee due</title>

<script type="text/javascript">
	function terms_changed(termsCheckBox) {
		//If the checkbox has been checked
		if (termsCheckBox.checked) {
			//Set the disabled property to FALSE and enable the button.
			document.getElementById("submit_button").disabled = false;
		} else {
			//Otherwise, disable the submit button.
			document.getElementById("submit_button").disabled = true;
		}
	}
</script>
</head>
<body>
	<c:if test="${empty loginStudent}">
		<c:redirect url="../StudentLogin.jsp"></c:redirect>
	</c:if>
	<%@ include file="/component/navbar.jsp"%>


	<div class="container-xxl my-5">
		<form action="payment.jsp" method="post">

			<div class="row">
				<div class="col-md-8 offset-md-2">


					<table class="table table-bordered border-light ">
						<thead>
							<tr class="table-primary">
								<th scope="col"></th>
								<th scope="col">Institution</th>
								<th scope="col">Particulars</th>
								<th scope="col">Due Amount</th>
								<th scope="col">Due Date</th>
							</tr>
						</thead>
						<c:if test="${not empty feeDetail}">
							<tbody>
								<%
								List<FeeDueDetail> fd = (List<FeeDueDetail>) session.getAttribute("feeDetail");

								for (FeeDueDetail f : fd) {
								%>
								<tr>
									<th rowspan="1" scope="row" class="text-center"><div>
											<div>
												<input type="checkbox" id="terms_and_conditions" value="1"
													onclick="terms_changed(this)" />
											</div>
										</div></th>
									<%!int total = 0;%>

									<%
									total = total + f.getDueAmount();
									%>

									<td class="text-center">SASTRA</td>
									<td class="text-center"><%=f.getParticular()%></td>
									<td class="text-end"><%=f.getDueAmount()%></td>
									<td class="text-center"><%=f.getDueDate()%></td>
								</tr>
								<%
								}
								%>
							</tbody>
							<tbody>
								<tr class="table-dark">
									<td colspan="3" class="table-active text-end fs-4 fw-bold">Total:</td>
									<td colspan="1" class="table-active text-end"><%=total%></td>
									<%
									total = 0;
									%>
									<td class="table-active"></td>
								</tr>
							</tbody>
						</c:if>
						<c:if test="${not empty emptyFee }">
							<tbody>
								<tr>
									<td colspan="5" class="table-active text-center fs-6 fw-bold">
										${emptyFee}</td>
								</tr>
							</tbody>
							<c:remove var="emptyFee" scope="session" />
						</c:if>

					</table>

					<c:if test="${ not empty feeDetail  }">
						<div class="text-center">
							<button type="submit" class="btn btn-primary btn-sm "
								id="submit_button" disabled>Pay Online</button>
						</div>
						<c:remove var="feeDetail" scope="session" />
					</c:if>
				</div>
			</div>

		</form>

	</div>

</body>
</html>