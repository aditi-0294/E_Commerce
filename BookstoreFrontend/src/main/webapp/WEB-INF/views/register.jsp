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
</html>  --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<!-- Start of container class -->



	<div class="row">
		<!-- Start of first row class -->

<%-- original : <c:if> and delete <c:choose> --%>
<c:choose>

		<c:when test="${not empty message}">
			<div class="col-xs-12">
				<!-- Start of col-xs-12 class -->

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${message}

				</div>



			</div>
			<!-- End of col-xs-12 class -->
		</c:when>
		
<c:when test="${not empty username}">
			<div class="col-xs-12">
				<!-- Start of col-xs-12 class -->

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${username}

				</div>



			</div>
			<!-- End of col-xs-12 class -->
		</c:when>


<c:when test="${not empty email}">
			<div class="col-xs-12">
				<!-- Start of col-xs-12 class -->

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${email}

				</div>



			</div>
			<!-- End of col-xs-12 class -->
		</c:when>

</c:choose>
<br/>




		<div class="col-md-offset-2 col-md-8">
			<!-- Start of col-md-6 class -->

			<div class="panel panel-primary">
				<!-- Start of panel-primary class -->

				<div class="panel-heading">
					<!-- Start of panel-heading class -->

					<h3>Registration Page</h3>

				</div>
				<!-- End of panel-heading class -->

				<div class="panel-body">
					<!-- Start of panel body class -->

					<!-- Start of form class -->
					<form action="${contextRoot}/register/newUser" method="POST"
						class="form-horizontal">

						<!-- For Customer Name : -->
						<div class="form-group">
							<!-- Start of first form-group -->

							<label for="customer_name" class="col-md-4 control-label">
								Customer Name : </label>

							<div class="col-md-8">
								<!-- Start of col-md-8 class -->

								<input type="text" name="customer_name" id="customer_name"
									class="form-control" />

							</div>
							<!-- End of col-md-8 class -->

						</div>
						<!-- End of first form-group -->

						<!-- End of Customer_Name part -->


						<!-- For username : -->
						<div class="form-group">
							<!-- Start of first form-group -->

							<label for="username" class="col-md-4 control-label">
								UserName : </label>

							<div class="col-md-8">
								<!-- Start of col-md-8 class -->

								<input type="text" name="username" id="username"
									class="form-control" /> 
									

							</div>
							<!-- End of col-md-8 class -->

						</div>
						<!-- End of first form-group -->

						<!-- End of username part -->


						<!-- For Email Address : -->
						<div class="form-group">
							<!-- Start of first form-group -->

							<label for="email" class="col-md-4 control-label">
								Email-Id. : </label>

							<div class="col-md-8">
								<!-- Start of col-md-8 class -->

								<input type="text" name="email" id="email" class="form-control"
									required
									pattern="[A-Za-z0-9._%+-]{3,}@[a-zA-Z]{3,}([.]{1}[a-zA-Z]{2,}|[.]{1}[a-zA-Z]{2,}[.]{1}[a-zA-Z]{2,})" />
									
						
								
								

							</div>
							<!-- End of col-md-8 class -->

						</div>
						<!-- End of first form-group -->

						<!-- End of Email Address part -->


						<!-- For Password : -->
						<div class="form-group">
							<!-- Start of first form-group -->

							<label for="password" class="col-md-4 control-label">
								Password : </label>

							<div class="col-md-8">
								<!-- Start of col-md-8 class -->

								<input type="password" name="password" id="password"
									class="form-control" required /> <em class="help-block">Please
									enter valid password ! </em>

							</div>
							<!-- End of col-md-8 class -->

						</div>
						<!-- End of first form-group -->

						<!-- End of Password part -->


						<!-- For Address : -->
						<div class="form-group">
							<!-- Start of first form-group -->

							<label for="address" class="col-md-4 control-label">
								Address : </label>

							<div class="col-md-8">
								<!-- Start of col-md-8 class -->

								<textarea name="address" id="address" rows="3"
									class="form-control">
								</textarea>

							</div>
							<!-- End of col-md-8 class -->

						</div>
						<!-- End of first form-group -->

						<!-- End of Address part -->


						<!-- For Mobile Number : -->
						<div class="form-group">
							<!-- Start of first form-group -->

							<label for="mobile_number" class="col-md-4 control-label">
								Contact Number : </label>

							<div class="col-md-8">
								<!-- Start of col-md-8 class -->

								<input type="text" name="mobile_number" id="mobile_number"
									pattern="[0-9]{10}" class="form-control" required /> <em
									class="help-block">Please enter valid 10 digit number ! </em>

							</div>
							<!-- End of col-md-8 class -->

						</div>
						<!-- End of first form-group -->

						<!-- End of Mobile Number part -->


						<!-- For Register button : -->
						<div class="form-group">
							<!-- Start of second form-group class -->

							<div class="col-md-4 col-md-8">
								<!-- Start of col-md-8 class -->

								<input type="submit" value="Register / Sign-Up"
									class="btn btn-primary" /> <input type="hidden"
									name="${_csrf.parameterName}" value="${_csrf.token}" />


							</div>
							<!-- End of col-md-8 class -->

						</div>
						<!-- End of second form-group class -->

					</form>
					<!-- End of form-class -->

				</div>
				<!-- End of panel body class -->

			</div>
			<!-- End of panel-primary class -->

		</div>
		<!-- End of col-md-6 class -->

	</div>
	<!-- End of first row class -->

</div>
<!-- End of container class -->



<!--  email pattern : pattern="[A-Za-z0-9._%+-]{3,}@[a-zA-Z]{3,}([.]{1}[a-zA-Z]{2,}|[.]{1}[a-zA-Z]{2,}[.]{1}[a-zA-Z]{2,})" 

number pattern : maxlength="10"  pattern="[0-9]{10}"
-->