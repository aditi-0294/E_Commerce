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

					<h3 align="center">Manage Products</h3>

				</div>
				<!-- End of panel-heading class -->

				<div class="panel-body">
					<!-- Start of panel-body class -->


					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<!-- modelAttribute name same as in m.addAttri ka name in ProductController.java -->
						<!-- Start of form-horizontal class -->

						<!-- for product name -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<label class="control-label col-md-4" for="prod_name">Enter
								Product Name : </label>

							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:input type="text" path="prod_name" id="prod_name"
									placeholder="Product Name" class="form-control" />
								<%-- 	<em class="help-block">Please enter Product Name ! </em>   --%>

								<sf:errors path="prod_name" cssClass="help-block" element="em" />

							</div>
							<!-- End of second col-md-8 class -->


						</div>
						<!-- End of form-group class -->


						<!-- for product description -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<label class="control-label col-md-4" for="prod_desc">Enter
								Product Description : </label>

							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:textarea path="prod_desc" id="prod_desc" rows="2"
									placeholder="Product Description" class="form-control"></sf:textarea>
								<%-- 	<em class="help-block">Please enter Product Description ! </em>    --%>

								<sf:errors path="prod_desc" cssClass="help-block" element="em" />

							</div>
							<!-- End of second col-md-8 class -->


						</div>
						<!-- End of form-group class -->



						<!-- for product price -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<label class="control-label col-md-4" for="prodprice">Enter
								Product Cost : </label>

							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:input type="number" path="prodprice" id="prodprice"
									placeholder="Product Cost in &#8377; " class="form-control" />
								
								<em class="help-block">Product Cost should be greater than Rs. 0 /- ! </em>	

								<sf:errors path="prodprice" cssClass="help-block" element="em" />

			
							</div>
							<!-- End of second col-md-8 class -->


						</div>
						<!-- End of form-group class -->



						<!-- for product quantity -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<label class="control-label col-md-4" for="prodqty">Enter
								Product Quantity Available : </label>

							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:input type="number" path="prodqty" id="prodqty"
									placeholder="Product Quantity available" class="form-control" />
						<!-- 		<em class="help-block">Please enter available quantity ! </em>		-->
							</div>
							<!-- End of second col-md-8 class -->


						</div>
						<!-- End of form-group class -->



						<!-- for Category Id. -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<label class="control-label col-md-4" for="catid" class="active">
								Select Category : </label>

							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:select class="form-control" path="catid" id="catid"
									items="${category}" itemLabel="cat_name" itemValue="catid" />

								<%-- 
								items="${category}" <!-- from where items will be fetched for dropdown menu -->
								itemLabel = "cat_name" <!-- to display text , i.e. , category name -->
								itemValue = "catid" <!-- to store id of category -->
								--%>



								<%-- 	<option value="1">Category 1</option>
									<option value="2">Category 2</option> 
								</select>		--%>
							</div>
							<!-- End of second col-md-8 class -->


						</div>
						<!-- End of form-group class -->


						<!-- for Supplier Id. -->
						<div class="form-group">
							<!-- Start of form-group class -->
							<label class="control-label col-md-4" for="supid" class="active">
								Select Supplier : </label>
							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:select class="form-control" path="supid" id="supid"
									items="${supplier}" itemLabel="sup_name" itemValue="supid" />


								<%-- 
								<select class="form-control" name="supid" id="supid">
									<option value="1">Supplier 1</option>
									<option value="2">Supplier 2</option>
								</select>
							--%>
							</div>
							<!-- End of second col-md-8 class -->
						</div>
						<!-- End of form-group class -->



						<!-- for File element to upload image -->
						<div class="form-group">
							<!-- Start of form-group class -->
							<label class="control-label col-md-4" for="file">Select
								an Image : </label>
							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->
								<input type="file" name="p_image" id="p_image"
									class="form-control" />
								<%-- 								<em class="help-block">Please select file to upload </em>							--%>
								<sf:errors path="p_image" cssClass="help-block" element="em" />
							</div>
							<!-- End of second col-md-8 class -->
						</div>
						<!-- End of form-group class -->


						<!-- for submit button - add product -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<%-- 	<label class="control-label col-md-4" for="prod_name">Enter
								Product Name : </label> --%>

							<div class="col-md-offset-4 col-md-8">
								<!-- Start of second col-md-8 class -->

								<input type="submit" name="submit" id="submit"
									value="Add Product" class="btn btn-primary" />
							</div>


							<!-- Hidden field -->
							<sf:hidden path="supid" />
							<sf:hidden path="prodid" />
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

	<!-- Start of Data table for admin  -->

	<div class="row">
		<!-- Start of second row class -->

		<div class="col-xs-12">
			<!-- Start of col-xs-12 class in second row class -->







		</div>
		<!-- End of col-xs-12 class in second row class -->


		<div class="col-xs-12">
			<!-- Start of col-xs-12 class again in second row class -->

			<h3>Available Products</h3>
			<hr />

			<div style="overflow: auto">
				<!-- Start of overflow style -->

				<!-- Products table for admin -->
				<table id="AdminProductsTable"
					class="table table-striped table-bordered">

					<thead>
						<tr>
							<th>ID</th>
							<th>&#160;</th>
							<th>Product Name</th>
							<th>Product Quantity Available</th>
							<th>Product Price</th>
							<th>Operation</th>
						</tr>
					</thead>

					<%-- --- Commented after adding jquery code ---
			<tbody>
				<tr>
					<td>2</td>
					
					<td>
						<img class = "adminDataTableImg" src = "${contextRoot}/resources/images/PRD5B406BD1BD.jpg" alt = "Half Girlfriend" />
					</td>
					
					<td>Half Girlfriend</td>
					
					<td>4</td>
					
					<td>&#8377; 250 </td>
					
					<td>
						<a href = "${contextRoot}/manage/2/product" class = "btn btn-info"> Edit </class> 
						<a href = "#" class = "btn btn-danger"> Delete </class>
					
					</td>
					
					
				
				
				
				</tr>
			
			
			</tbody>
--%>

					<tfoot>
						<tr>
							<th>ID</th>
							<th>&#160;</th>
							<th>Product Name</th>
							<th>Product Quantity Available</th>
							<th>Product Price</th>
							<th>Operation</th>
						</tr>
					</tfoot>





				</table>









			</div>
			<!-- End of overflow style -->





		</div>
		<!-- End of col-xs-12 class again in second row class -->



	</div>
	<!-- End of second row class -->


	<!-- End of Data table for admin -->
</div>
<!-- End of Container class -->