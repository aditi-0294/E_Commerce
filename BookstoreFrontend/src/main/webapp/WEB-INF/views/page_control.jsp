<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%--
<meta name="_csrf" content="$_csrf.token">
<meta name="_csrf_header" content="$_csrf.headerName">
--%>
<title>BooksArchive - ${title}</title>


<!-- Script Element to solve the problem of active menu -->
<script type="text/javascript">
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>



<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">


<!-- Bootstrap Theme -->
<link href="${css}/bootstrap-darkly-theme.css" rel="stylesheet">


<!-- Bootstrap DataTable CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<%-- <link href="${css}/jquery.dataTables.css" rel="stylesheet"> --%>
<%-- <link href="${css}/dataTables.css" rel="stylesheet"> --%>


<!-- Custom CSS -->
<link href="${css}/landing-page.css" rel="stylesheet">
<%-- <link href="${css}/login-page.css" rel="stylesheet"> --%>


<!-- Custom Fonts -->
<link href="${css}/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<%-- <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css"> --%>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@ include file="header.jsp"%>
		<!-- End of Navigation  -->



		<!--My Page Content -->

		<div class="content">

			<!-- Loading the home content -->
			<c:if test="${userClickHome == true}">
				<%@ include file="home.jsp"%>
			</c:if>

			<!-- Loading the AboutUs content -->
			<c:if test="${userClickAboutUs == true}">
				<%@ include file="aboutUs.jsp"%>
			</c:if>
			
			<!-- Loading the ContactUs content -->
			<c:if test="${userClickContactUs == true}">
				<%@ include file="contactUs.jsp"%>
			</c:if>

			<!-- Loading the All Products content -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@ include file="listProducts.jsp"%>
			</c:if>

			<!-- Loading the All single page / individual Products content -->
			<c:if test="${userClickShowProduct == true}">
				<%@ include file="singleProduct.jsp"%>
			</c:if>

			<!-- Loading the Products Management content -->
			<c:if test="${userClickManageProducts == true}">
				<%@ include file="manageProducts.jsp"%>
			</c:if>

			<!-- Loading the Category Management content -->
			<c:if test="${userClickManageCategory == true}">
				<%@ include file="manageCategory.jsp"%>
			</c:if>

			<!-- Loading the Supplier Management content -->
			<c:if test="${userClickManageSupplier == true}">
				<%@ include file="manageSupplier.jsp"%>
			</c:if>

			
			<!-- Loading the Register content -->
			<c:if test="${userClickRegister == true}">
				<%@ include file="register.jsp"%>
			</c:if>

			<!-- Loading the login content -->
			<c:if test="${userClickLogin == true}">
				<%@ include file="login.jsp"%>
			</c:if>

			<!-- Loading the cart content  -->
			<c:if test="${userClickCart == true}">
				<%@include file="cart.jsp" %>
			</c:if>

			<!-- Loading Order (to Confirm) Content  -->
			<c:if test="${userClickOrder == true}">
				<%@ include file = "order.jsp" %>
			</c:if>				


			<!-- Loading thank you page -->
			<c:if test="${userClickThanks == true}">
				<%@ include file = "thanks.jsp" %>
			</c:if>


		</div>
		<!-- End of Page content -->


		<!-- Footer -->
		<%@ include file="footer.jsp"%>
		<!-- End of footer -->


		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>


		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>


		<!-- Data-Table Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>


		<!-- Data-Table Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>


		<!-- Self coded JavaScript file -->
		<script src="${js}/myapp.js"></script>



	</div>
</body>

</html>
