<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-success bg-success">
	<a class="navbar-brand text-white" href="index.jsp"><i
		class="fa-regular fa-hospital m-2"></i>Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto">

			<c:if test="${ empty userObj}">

				<li class="nav-item active"><a class="nav-link text-white"
					href="admin_login.jsp"> <i
						class="fa-solid fa-right-to-bracket m-1"></i>ADMIN <span
						class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item active"><a class="nav-link text-white"
					href="doctor_login.jsp">DOCTOR <span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item active"><a class="nav-link text-white"
					href="user_login.jsp">APPOINTMENT <span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item active"><a class="nav-link text-white"
					href="user_login.jsp">USER <span class="sr-only">(current)</span>
				</a></li>

			</c:if>


			<c:if test="${not empty userObj}">
				<li class="nav-item active"><a class="nav-link text-white"
					href="user_appointment.jsp">APPOINTMENT <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link text-white"
					href="view_appointment.jsp">VIEW APPOINTMENT <span
						class="sr-only">(current)</span>
				</a></li>
				
				
				<div class="dropdown">
					<button class="btn btn-success dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">
						<i class="fa-solid fa-circle-user"></i> ${userObj.fullName }
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="change_password.jsp">Change
								Password</a></li>
						<li><a class="dropdown-item" href="userLogout">Logout</a></li>

					</ul>
				</div>


			</c:if>


		</ul>
	</div>
</nav>