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


<%@ taglib prefix="seurity"
	uri="http://www.springframework.org/security/tags"%>

<div class="container">

	<div class="row">

		<!-- Column to display sidebar -->
		<div class="col-md-3">

			<p class="lead">BooksArchive</p>

			<div class="list-group">

				<c:forEach items="${list}" var="category">
					<a href="${contextRoot}/show/category/${category.catid}/products"
						class="list-group-item" id="a_${category.cat_name}">${category.cat_name}</a>
				</c:forEach>

			</div>
			<!-- End of list-group class -->

		</div>
		<!-- End of class col-md-3 -->



		<!-- To display the actual products -->

		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<div class="row">


				<div class="col-lg-12">

					<!-- for All Products -->
					<c:if test="${userClickAllProducts == true }">

						<script>
							window.catid = '';
						</script>

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>

							<li class="active">All Products</li>

						</ol>
					</c:if>




					<!-- for Category Products -->

					<c:if test="${userClickCategoryProducts == true }">

						<script>
							window.catid = '${category.catid}';
						</script>



						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.cat_name}</li>

						</ol>
					</c:if>

				</div>
				<!-- End of col-lg-12 class -->

				<div class="row">
					<!-- start of row 2 -->

					<div class="col-xs-12">

						<table id="productListTable"
							class="table table-striped table-bordered">

							<thead>

								<tr>

									<%-- 	<th>ID</th>	  --%>
									<th>Image</th>
									<th>Name</th>
									<th>Quantity Available</th>
									<th>Price</th>
									<th>Action</th>
								</tr>

							</thead>

							<br />

							<tfoot>

								<tr>

									<%-- 	<th>ID</th>	  --%>
									<th>Image</th>
									<th>Name</th>
									<th>Quantity Available</th>
									<th>Price</th>
									<th>Action</th>
								</tr>

							</tfoot>


						</table>


					</div>
					<!-- End of col-xs-12 class -->






				</div>
				<!-- End of row 2 -->




			</div>
			<!-- End of row in col-md-9 -->

		</div>
		<!-- End of col-md-9 class -->

	</div>
	<!-- End of row -->

</div>
<!-- End of container class -->