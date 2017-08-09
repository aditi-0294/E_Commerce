<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
</body>
</html> --%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default navbar-fixed-top topnav"
	role="navigation">

	<div class="container topnav">
		<!-- Brand and toggle get grouped for better mobile display -->

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand topnav" href="${contextRoot}/home">BooksArchive</a>
		</div>
		<!-- End of navbar-header -->

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-left">


				<!--  Home Page -->
				<li id="home"><a href="${contextRoot}/home">Home</a></li>
				<!-- End of Home Page -->


				<!-- Category - dropdown -->

			<%--	<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">		--%>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Categories <span class="caret"></span></a>
						<ul class="dropdown-menu">

							<c:forEach items="${list}" var="category">
								<a
									href="${contextRoot}/show/category/${category.catid}/products"
									class="list-group-item">${category.cat_name}</a>
							</c:forEach>

							<%-- 
							<!-- Category - dropdown menu list -->
							<li><a href="#">Medical-Thriller Genre</a></li>
							<li><a href="#">Fantasy Genre</a></li>
							<li><a href="#">Romance and Tragedy Genre</a></li>
							<li><a href="#">Technical Engineering Books</a></li> --%>
						</ul></li>
					<!-- End of Category - dropdown -->



					<!-- Products -->
					<li id="listProducts"><a
						href="${contextRoot}/show/all/products">Products</a> <!-- Displays all products -->
					</li>
					<!-- End of Products -->

		<%--		</c:if>			--%>



				<!-- About Us -->
				<li id="about"><a href="${contextRoot}/aboutUs">About Us</a></li>
				<!-- End of About Us -->

				<security:authorize access="hasAuthority('Admin')">
					<!-- Manage product - admin part -->
					<li id="manageProducts"><a
						href="${contextRoot}/manage/products">Manage Products</a> <!-- Displays all products -->
					</li>
					<!-- End of manage Product - admin part -->

					<!-- Manage category - admin part -->
					<li id="manageCategory"><a
						href="${contextRoot}/manage/category">Manage Category</a> <!-- Displays all category -->
					</li>
					<!-- End of manage category - admin part -->

					<!-- Manage Supplier - admin part -->
					<li id="manageSupplier"><a
						href="${contextRoot}/manage/supplier">Manage Supplier</a> <!-- Displays all category -->
					</li>
					<!-- End of manage supplier - admin part -->
				</security:authorize>
			</ul>

			<ul class="nav navbar-nav navbar-right">




				<li><c:if
						test="${pageContext.request.userPrincipal.name != null}">
						<a href=""><span class="glyphicon glyphicon-user">&nbsp;${pageContext.request.userPrincipal.name}</span></a>
					</c:if> <!-- Cart - User Part --> <security:authorize
						access="hasAuthority('User')">

						<li id="cart"><a href="${contextRoot}/cart/getCart"><span
								class="glyphicon glyphicon-shopping-cart">&nbsp;Cart</span></a></li>


					</security:authorize> <!--
				 
					<a href="">
					<span 
						class = "glyphicon glyphicon-user">&nbsp;${pageContext.request.userPrincipal.name}
					</span>
					</a>
					
				--></li>


				<!-- SignUp / Register Page -->

				<security:authorize access="isAnonymous()">
					<c:if test="${pageContext.request.userPrincipal.name == null}">

						<li id="register"><a href="${contextRoot}/register/newUser"><span
								class="glyphicon glyphicon-user"></span> Register</a></li>
						<!-- End of Sign Up / Register Page -->



						<!-- Sign In / Login Page -->
						<li id="login"><a href="${contextRoot}/login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
						<!-- End Of Login Page -->

					</c:if>


				</security:authorize>


				<!-- Logout / Sign out -->

				<c:if test="${pageContext.request.userPrincipal.name != null}">

					<li id="logout"><a href="${contextRoot}/logout"> <span
							class="glyphicon glyphicon-log-out"> Logout </span></a></li>

				</c:if>


			</ul>


		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>