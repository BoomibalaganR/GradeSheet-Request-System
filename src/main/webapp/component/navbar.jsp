<%@page import="model.Entity.StudentLoginDetail"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">


		<div class="collapse navbar-collapse" id="navbarSupportedContent">


			<c:if test="${not empty loginAdmin}">
				<ul class="navbar-nav me-auto ms-2 mb-lg-0">
					<li class="nav-item fw-bold fs-5"><a class="nav-link active"
						aria-current="page" href="home.jsp"><i
							class="bi bi-house-door"></i> Home</a></li>
				</ul>
				<ul class="navbar-nav ms-auto ms-2 mb-lg-0">
					<li class="nav-item fw-bold"><a class="nav-link active"
						aria-current="page" href="../ViewRequest"><i
							class="bi bi-app-indicator"></i> viewRequest</a></li>
					<li class="nav-item fw-bold"><a class="nav-link active"
						aria-current="page" href="../DueRaiseServlet"> FeeDueRaise</a></li>
					<li class="nav-item fw-bold"><a class="nav-link active "
						aria-current="page" href="../PaymentVerifyServlet">
							PaymentVerification</a></li>
					<li class="nav-item fw-bold "><a class="nav-link active"
						aria-current="page" href="../AdminLogout"><i
							class="bi bi-box-arrow-in-right"></i> Log out</a></li>
				</ul>
			</c:if>


			<c:if test="${empty loginStudent && empty loginAdmin }">

				<ul class="navbar-nav me-auto ms-2 mb-lg-0">
					<li class="nav-item fw-bold fs-5"><a class="nav-link active"
						aria-current="page" href="./index.jsp"><i
							class="bi bi-house-door"></i> Home</a></li>
				</ul>
				<ul class="navbar-nav ms-auto ms-2 mb-lg-0">
					<li class="nav-item fw-bold"><a class="nav-link active"
						aria-current="page" href="./AdminLogin.jsp"
						class="bi bi-person-circle"><i class="bi bi-person-circle"></i>
							Admin</a></li>
					<li class="nav-item fw-bold"><a class="nav-link active"
						aria-current="page" href="./StudentLogin.jsp"> <i class="bi bi-person-plus-fill"></i> Student </a></li>
				</ul>

			</c:if>

			<c:if test="${not empty loginStudent}">
				<ul class="navbar-nav me-auto ms-2 mb-lg-0">

					<li class="nav-item fw-bold fs-5"><a class="nav-link active"
						aria-current="page" href="home.jsp"><i
							class="bi bi-house-door"></i> Home </a></li>

				</ul>

				<ul class="navbar-nav ms-auto ms-2 mb-lg-0">
					<li class="nav-item fw-bold"><a class="nav-link active"
						aria-current="page" href="markSheetRequest.jsp"> Request </a></li>
					<li class="nav-item fw-bold"><a class="nav-link active"
						aria-current="page" href="tracking.jsp"><i
							class="bi bi-geo-alt-fill"></i> Track </a></li>
					<li class="nav-item fw-bold"><a class="nav-link active"
						aria-current="page" href="../FeeDueServlet"> FeeDue </a></li>
					<div class="collapse navbar-collapse fw-bold"
						id="navbarNavDarkDropdown">
						<ul class="navbar-nav">

							<li class="nav-item dropdown "><a
								class="nav-link active" href="#" id="navbarDarkDropdownMenuLink"
								role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
									class="bi bi-person-circle"></i> <%
 StudentLoginDetail sld = (StudentLoginDetail) session.getAttribute("loginStudent");
 out.println(sld.getPersonalDetail().getName());
 %> </a>
								<ul class="dropdown-menu dropdown-menu-dark"
									aria-labelledby="dropdownMenuLink">
									<li class="nav-item fw-bold"><a class="nav-link active"
										aria-current="page" href="../StudentLogout"><i
											class="bi bi-box-arrow-in-right"></i> Log out</a></li>

								</ul></li>

						</ul>

					</div>


				</ul>

			</c:if>

		</div>

	</div>

</nav>