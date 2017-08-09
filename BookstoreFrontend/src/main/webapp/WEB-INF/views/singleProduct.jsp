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
</html>	--%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="container">
	<!-- Start of container class -->

	<!-- Breadcrumb -->
	<div class="row">
		<!-- Start of first row class -->

		<div class="col-xs-12">
			<!-- Start of first col-xs-12 class -->

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home</a>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.prod_name}</li>

			</ol>

		</div>
		<!-- End of first col-xs-12 class -->

	</div>
	<!-- End of first row class -->


	<!-- To display product in another row  -->
	<div class="row">
		<!-- Start of second row class -->

		<!-- Display product image -->
		<div class="col-xs-12 col-sm-4">
			<!-- Start of col-sm-4 class -->

			<div class="thumbnail">
				<!-- Start of thumbnail class -->

				<img src="${images}/${product.code}.jpg " class="img img-responsive" />

			</div>
			<!-- End of thumbnail class -->


		</div>
		<!-- End of col-sm-4 class -->


		<!-- Display product description -->
		<div class="col-xs-12 col-sm-8">
			<!-- Start of col-sm-8 class -->

			<h2>${product.prod_name}</h2>
			<br />

			<p>${product.prod_desc}</p>
			<hr />

			<h5>
				Price : <strong> &#8377; ${product.prodprice} /- </strong>
			</h5>
			<hr />

			<c:choose>

				<c:when test="${product.prodqty < 1}">

					<h5>
						Available Quantity : <span style="color: magenta"> Out of
							stock !!</span>
					</h5>

				</c:when>


				<c:otherwise>

					<h5>Available Quantity : ${product.prodqty}</h5>
					<hr />

				</c:otherwise>

			</c:choose>


			<security:authorize access="hasAuthority('User')">

				<%--
		<!-- Quantity to be purchased -->
<br/>
<br/>
		
			
			<form action = "${contextRoot}/cart/addToCart/${product.prodid}/product" >
				<!-- Start of form-group class -->

				Enter Quantity (units) to be purchased : &#160;&#160;&#160; 
				<input type="text" name="units">

</form>


		
			<br /> <br /> 
			
						
			
<%--</form>

--%>




				<br />


				<c:choose>

					<c:when test="${product.prodqty < 1}">

						<a href="javascript:void(0)" class="btn btn-success disabled"><strike>Add
								to Cart</strike></a>&#160;&#160;&#160;

	<a href="${contextRoot}/show/all/products" class="btn btn-info">Back</a>

					</c:when>


					<c:otherwise>

						<!-- Quantity to be purchased -->



						<form
							action="${contextRoot}/cart/addToCart/${product.prodid}/product">
							<!-- Start of form-group class -->	

							Enter Quantity (units) to be purchased : &#160;&#160;&#160; <input
								type="text" name="units"> <br /> <br />

							
							<button type="submit" class="btn btn-success">Add To
								Cart</button>

					<%--									&#160;&#160;&#160; <a href="${contextRoot}/show/all/products"
								class="btn btn-info">Back</a>
--%>

						</form>		

						<br />
						
				<%--		<a href = "${contextRoot}/cart/addToCart/${product.prodid}/product" button type="submit" class="btn btn-success">Add To Cart</button>	--%>





						<%--
					
					<a href="${contextRoot}/cart/addToCart/${product.prodid}/product"
				class="btn btn-success">Add To Cart</a>&#160;&#160;&#160;
					
	--%>
						<%--	<a href="${contextRoot}/cart/add/${product.prodid}/product"
							class="btn btn-success">Add to cart</a>		--%>
						<%-- <a href = "${contextRoot}/cart/add/${product.prodid}/product" class = "btn btn-success"><span class = "glyphicon glyphicon-shopping-cart"></span>Add to cart</a> --%>

					</c:otherwise>


				</c:choose>

			</security:authorize>

			<security:authorize access="hasAuthority('Admin')">

				<a href="${contextRoot}/manage/${product.prodid}/product"
					class="btn btn-info"> Edit </a>&#160;&#160;
			
			</security:authorize>

			<%--
			<a href="${contextRoot}/show/all/products" class="btn btn-info">Back</a>
--%>


					
			
			&#160;&#160;&#160; <a href="${contextRoot}/show/all/products"
				class="btn btn-info">Back</a>


		</div>
		<!-- End of col-sm-8 class -->





	</div>
	<!-- End of second row class -->
</div>
<!-- End of container class -->