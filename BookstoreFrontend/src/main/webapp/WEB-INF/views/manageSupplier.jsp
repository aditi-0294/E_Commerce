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

					<h3 align="center">Manage Supplier</h3>

				</div>
				<!-- End of panel-heading class -->

				<div class="panel-body">
					<!-- Start of panel-body class -->


					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="supplier"
						action="${contextRoot}/manage/supplier" method="POST">
						<!-- modelAttribute name same as in m.addAttri ka name in SupplierController.java -->
						<!-- Start of form-horizontal class -->

						<!-- for supplier name -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<label class="control-label col-md-4" for="sup_name">Enter
								Supplier Name : </label>

							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:input type="text" path="sup_name" id="sup_name"
									placeholder="Supplier Name" class="form-control" />
								<%--  	<em class="help-block">Please enter Supplier Name ! </em>  --%>

								<sf:errors path="sup_name" cssClass="help-block" element="em" />

							</div>
							<!-- End of second col-md-8 class -->


						</div>
						<!-- End of form-group class -->


						<!-- for supplier address -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<label class="control-label col-md-4" for="sup_addr">Enter
								Supplier Address : </label>

							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:textarea path="sup_addr" id="sup_addr" rows="3"
									placeholder="Supplier Address" class="form-control"></sf:textarea>
								<%-- 	<em class="help-block">Please enter Supplier Address ! </em>    --%>

								<sf:errors path="sup_addr" cssClass="help-block" element="em" />

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
									value="Add Supplier" class="btn btn-primary" />
							</div>


							<!-- Hidden field -->
							<sf:hidden path="supid" />


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

			<h3>Available Suppliers</h3>
			<hr />

		</div>
		<!-- End of first col-xs-12 class -->

		<div class="col-xs-12">
			<!-- Start of second col-xs-12 class -->

			<div style="overflow: auto">
				<!-- Start of overflow-auto style -->

				<!-- Supplier table for admin -->
				<table id="AdminSupplierTable"
					class="table table-striped table-bordered">

					<thead>
						<tr>
							<th>ID</th>
							<th>Supplier Name</th>
							<th>Supplier Address</th>
							<th>Operation</th>
						</tr>

					</thead>

					<tfoot>
						<tr>
							<th>ID</th>
							<th>Supplier Name</th>
							<th>Supplier Address</th>
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