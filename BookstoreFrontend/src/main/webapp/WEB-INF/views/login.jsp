<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
--%>

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

<!-- Custom CSS -->
<link href="${css}/landing-page.css" rel="stylesheet">
<%-- <link href="${css}/login-page.css" rel="stylesheet"> 
<link href="${css}/login-page.css" rel="stylesheet"> --%>


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
		<%@ include file="securityHeader.jsp"%>
		<!-- End of Navigation  -->



		<!--My Page Content -->
		<div class="content">
			<!-- Start of content class  -->
			<div class="container">
				<!-- Start of container class -->


				<!-- To be displayed in case of Incorrect credentials -->
				<c:if test="${not empty message}">

					<div class="row">
						<!-- Start of first row class -->
						<div class="col-md-offset-3 col-md-6">
							<!-- start of col-md-3 class (3 and 6 resp) -->

							<div class="alert alert-danger">${message}</div>

						</div>
						<!-- End of first row class -->
					</div>
					<!-- End of col-md-3 class (3 and 6 resp) -->


				</c:if>



				<div class="row">
					<!-- Start of first row class -->
					<div class="col-md-offset-3 col-md-6">
						<!-- start of col-md-3 class (3 and 6 resp) -->
						<div class="panel panel-primary">
							<!-- Start of primary panel class -->
							<div class="panel-heading">
								<!-- Start of panel-heading class -->
								<h3>Login Page</h3>
							</div>
							<!-- End of panel-heading class -->

							<div class="panel-body">
								<!-- Start of panel-body class -->

								<!--  Start of form class -->
								<form action="${contextRoot}/login" method="POST"
									class="form-horizontal" id="loginForm">

									<!-- For username : -->
									<div class="form-group">
										<!-- Start of first form group -->

										<label for="username" class="col-md-4 control-label">
											UserName : </label>

										<div class="col-md-8">
											<!-- start of col-md-8 class -->

											<input type="text" name="username" id="username"
												class="form-control"  required/>

										</div>
										<!-- End of col-md-8 class -->

									</div>
									<!-- End of first form-group -->

									<!-- Username part ends -->


									<!-- For password : -->
									<div class="form-group">
										<!-- Start of second form group -->

										<label for="password" class="col-md-4 control-label">
											Password : </label>

										<div class="col-md-8">
											<!-- start of col-md-8 class -->

											<input type="password" name="password" id="password"
												class="form-control" required />

										</div>
										<!-- End of col-md-8 class -->

									</div>
									<!-- End of second form-group -->

									<!-- Password part ends -->


									<!-- For login button : -->
									<div class="form-group">
										<!-- Start of second form group -->

										<div class="col-md-8">
											<!-- start of col-md-8 class -->

											<input type="submit" value="Login / Sign-In" align = "center"
												class="btn btn-primary"  />
											<input type="hidden"
												name="${_csrf.parameterName}" value="${_csrf.token}" />

										</div>
										<!-- End of col-md-8 class -->

									</div>
									<!-- End of second form-group -->

									<!-- login button part ends -->


								</form>


								<!-- End of form-class -->

							</div>
							<!-- End of panel-body class -->

						</div>
						<!-- End of primary panel class -->
					</div>
					<!-- end of col-md-3 class (3 and 6 resp) -->
				</div>
				<!-- End of first row class -->
			</div>
			<!-- End of container class -->

		</div>
		<!-- End of Content class -->
		<!-- End of Page content -->


		<!-- Footer -->
		<%@ include file="footer.jsp"%>
		<!-- End of footer -->


		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>


		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>


		<!-- Self coded JavaScript file -->
		<script src="${js}/myapp.js"></script>



	</div>
</body>

</html>
