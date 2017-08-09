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

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

<%-- 
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
--%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

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
					<a class="navbar-brand topnav" href="${contextRoot}/home">Back
						to home</a>
				</div>
			</div>
		</nav>




		<!-- End of Navigation  -->



		<!--My Page Content -->

		<div class="content">
			<!-- start of Content class  -->

			<div class="container">
				<!-- start of Container class  -->

				<div class="row">
					<!-- start of first row class  -->

					<div class="col-xs-12">
						<!-- start of Col-xs-12 class  -->



						<!-- Display errorTitle and errorDescription  -->
						<div class="jumbotron">
							<!-- start of jumbotron class  -->


							<h2>${errorTitle}</h2>
							<hr />


							<blockquote style="word-wrap: break-word">
								<!-- To bring StackTrace error inside the container - no need of horizontal scroll -->

								${errorDescription}

							</blockquote>




						</div>
						<!-- end of jumbotron class  -->



					</div>
					<!-- end of col-xs-12 class  -->



				</div>
				<!-- end of first row class  -->





			</div>
			<!-- end of Container class  -->




			<%-- 
		</div>
		<!-- End of Content class -->
		<!-- Loading the home content -->
		<c:if test="${userClickHome == true}">
			<%@ include file="home.jsp"%>
		</c:if>
		<!-- Loading the AboutUs content -->
		<c:if test="${userClickAboutUs == true}">
			<%@ include file="aboutUs.jsp"%>
		</c:if>
		<!-- Loading the All Products content -->
		<c:if
			test="${userClickAllProducts == true or userClickCategoryProducts == true}">
			<%@ include file="listProducts.jsp"%>
		</c:if>
		<!-- Loading the single Product content -->
		<c:if test="${userClickshowProduct == true}">
			<%@ include file="singleProduct.jsp"%>
		</c:if>
		<!-- Loading the Register content -->
		<c:if test="${userClickRegister == true}">
			<%@ include file="register.jsp"%>
		</c:if>
		<!-- Loading the login content -->
		<c:if test="${userClickLogin == true}">
			<%@ include file="login.jsp"%>
		</c:if>
	</div>
	<!-- End of Page content -->
--%>


			<!-- Footer -->
			<%@ include file="footer.jsp"%>
			<!-- End of footer -->

			<%-- 
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
--%>

		</div>
</body>

</html>