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
</html>
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
	<!--  Start of container -->

	<div class="row">
		<!-- Start of first row class -->
	</div>

	<br />

	<div class="row">

		<div class="col-md-12">
			<!-- Start of col-md-8 class -->

			<h2 align="center">Welcome :
				${pageContext.request.userPrincipal.name}</h2>

			<br /> <br /> <a href="${contextRoot}/cart/deleteCart/${cart.cartid}"
				class="btn btn-danger pull-left">Clear Cart</a> 
				
				<a href="${contextRoot}/cart/orderForm/${cart.cartid}"
				class="btn btn-success pull-right">Check Out</a>


		</div>
		<!-- End of col-md-8 class -->







	</div>
	<!-- End of first row class -->


	<div class="row">
		<!-- Start of second row class -->

		<div class="col-xs-12">
			<!-- Start of col-xs-12 class in second row class -->







		</div>
		<!-- End of col-xs-12 class in second row class -->

		<br />

		<div class="col-xs-12">
			<!-- Start of col-xs-12 class again in second row class -->

			<h3>Available Products in Cart</h3>
			<hr />

			<div style="overflow: auto">
				<!-- Start of overflow style -->

				<!-- Cart table for user -->
				<table id="UserCartTable" class="table table-striped table-bordered">

					<thead>
						<tr>
							<th>Product Name</th>
							<th>Product Quantity Purchased</th>
							<th>Price per Quantity</th>
							<%-- (Price per quantity) --%>
							<th>Total Price</th>
							<%--(Price per quantity * number of products purchased) --%>
							<th>Action</th>
						</tr>
					</thead>


					<%-- -- --- Static testing ---%>
					<%--
			 <tbody>
				<tr>
					<td>2</td>
					
					<td>Half Girlfriend</td>
					
					<td>4</td>
					
					<td>&#8377; 250 </td>
					
					<td>
						<a href = "#" class = "btn btn-danger"> Remove </class>
					</td>
					
					
				
				
				
				</tr>
			
			
			</tbody>
			
--%>


					<!-- for grandTotal part -->

					<c:set var="grandTotal" value="0"></c:set>

					<c:forEach items="${cart.cartItems}" var="cartItem">


						<tbody>
							<tr>

								<td>${cartItem.product.prod_name}</td>

								<td>${cartItem.cartqty}</td>

								<td>${cartItem.product.prodprice}</td>

								<td>&#8377;&#160; ${cartItem.unitPrice}</td>

								<td><a
									href="${contextRoot}/cart/deleteCartItem/${cartItem.cartItemId}"
									class="btn btn-danger"> Remove </a></td>



							</tr>
						</tbody>

						<c:set var="grandTotal" value="${cartItem.unitPrice + grandTotal}"></c:set>

					</c:forEach>

					<tfoot>
						<tr>

							<th>Product Name</th>
							<th>Product Quantity Purchased</th>
							<th>Price per Quantity</th>
							<%-- (Price per quantity) --%>
							<th>Total Price</th>
							<%--(Price per quantity * number of products purchased) --%>
							<th>Action</th>

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

	<hr />
	<br /> Grand Total = &#160;&#8377;&#160; ${grandTotal} /- <br /> <br />


	<a href="${contextRoot}/show/all/products" class="btn btn-info">Back</a>



</div>
<!-- End of Container class -->





