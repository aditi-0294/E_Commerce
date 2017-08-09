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

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<!-- Start of Container class -->

	<div class="row">
		<!-- Start of first row class -->


		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<!-- Start of col-xs-12 class -->

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${message}

				</div>



			</div>
			<!-- End of col-xs-12 class -->
		</c:if>



		<div class="col-md-offset-2 col-md-8">
			<!-- Start of first col-md-8 class -->

			<div class="panel panel-primary">
				<!-- Start of panel-primary class -->

				<div class="panel-heading">
					<!-- Start of panel-heading class -->

					<h3 align="center">Manage Category</h3>

				</div>
				<!-- End of panel-heading class -->

				<div class="panel-body">
					<!-- Start of panel-body class -->


					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST">
						<!-- modelAttribute name same as in m.addAttri ka name in CategoryController.java -->
						<!-- Start of form-horizontal class -->

						<!-- for category name -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<label class="control-label col-md-4" for="cat_name">Enter
								Category Name : </label>

							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:input type="text" path="cat_name" id="cat_name"
									placeholder="Category Name" class="form-control" />
								<%--  	<em class="help-block">Please enter Category Name ! </em> --%>

								<sf:errors path="cat_name" cssClass="help-block" element="em" />

							</div>
							<!-- End of second col-md-8 class -->


						</div>
						<!-- End of form-group class -->


						<!-- for category description -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<label class="control-label col-md-4" for="cat_desc">Enter
								Category Description : </label>

							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:textarea path="cat_desc" id="cat_desc" rows="2"
									placeholder="Category Description" class="form-control"></sf:textarea>
								<%-- 	<em class="help-block">Please enter Category Description ! </em>  --%>

								<sf:errors path="cat_desc" cssClass="help-block" element="em" />

							</div>
							<!-- End of second col-md-8 class -->


						</div>
						<!-- End of form-group class -->

						<!-- for submit button -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<div class="col-md-offset-4 col-md-8">
								<!-- Start of second col-md-8 class -->

								<input type="submit" name="submit" id="submit"
									value="Add Category" class="btn btn-primary" />
							</div>


							<!-- Hidden field -->
							<sf:hidden path="catid" />


							<!-- End of second col-md-8 class -->


						</div>
						<!-- End of form-group class -->




					</sf:form>
					<!-- End of form-horizontal class -->

				</div>
				<!-- End of panel-body class -->

			</div>
			<!-- End of panel-primary class -->

		</div>
		<!-- End of first col-md-8 class -->


	</div>
	<!-- End of first row class -->

	<!--  Start of Data Table for Admin -->

	<div class="row">
		<!-- Start of second row class -->

		<div class="col-xs-12">
			<!-- Start of first col-xs-12 class -->

			<h3>Available Categories</h3>
			<hr />

		</div>
		<!-- End of first col-xs-12 class -->

		<div class="col-xs-12">
			<!-- Start of second col-xs-12 class -->

			<div style="overflow: auto">
				<!-- Start of overflow-auto style -->

				<!-- Category table for admin -->
				<table id="AdminCategoryTable"
					class="table table-striped table-bordered">

					<thead>
						<tr>
							<th>ID</th>
							<th>Category Name</th>
							<th>Category Description</th>
							<th>Operation</th>
						</tr>

					</thead>

					<tfoot>
						<tr>
							<th>ID</th>
							<th>Category Name</th>
							<th>Category Description</th>
							<th>Operation</th>
						</tr>
					</tfoot>

				</table>

			</div>
			<!-- End of overflow-auto style -->

		</div>
		<!-- End of second col-xs-12 class -->

	</div>
	<!-- End of second row class -->



	<!--  End of data table for Admin -->
</div>
<!-- End of Container class -->