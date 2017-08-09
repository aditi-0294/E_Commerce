<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%--	<%@ page isELIgnored="false"%>		--%>
<jsp:useBean id="now" class="java.util.Date" />

<div class="container-wrapper">
	<div class="container">
	<%--	<div class="page-header">		--%>
			<p class="lead"><h1>Order confirmation</h1></p>
	<%--	</div>		--%>

		<div class="container">
			<form:form action="${contextRoot}/cart/confirm/${cart.cartid}"
			
			
				modelAttribute="order">

				<div class="row">

					<div
						class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

						<div class="txt-center">
							<h1>Receipt</h1>
						</div>
						ORDER ID: ${order.orderid }
						<br/>
						<br/>
						Payment Mode : Cash-On-Delivery
						<br/>
						<br/>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong>Billing Address</strong><br />
									${order.cart.userDetail.address}
								</address>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 text-right">
								<p>
									Shipping Date:
									<fmt:formatDate type="date" value="${now}" />
								</p>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong>Shipping Address</strong><br />
									${order.cart.userDetail.address}
								</address>
							</div>
						</div>

						<div class="row">
							<table class="table table-hover">
								<thead>
									<tr>
										<td>Product</td>
										<td>Quantity Purchased</td>
										<td class="text-center">Price per product</td>
										<td class="text-center">Total Price</td>
									</tr>
								</thead>
								<tbody>
									<c:set var="grandTotal" value="0.0"></c:set>
									<c:forEach var="cartItem" items="${order.cart.cartItems}">
										<tr>
											<td class="col-md-9"><em>${cartItem.product.prod_name}</em></td>
											<td class="col-md-1" style="text-align: center">${cartItem.cartqty}</td>
											<td class="col-md-1" style="text-align: center">${cartItem.product.prodprice}</td>
											<td class="col-md-1" style="text-align: center">${cartItem.unitPrice}</td>
											<c:set var="grandTotal"
												value="${grandTotal + cartItem.unitPrice }"></c:set>
										</tr>
									</c:forEach>

									<tr>
										<td></td>
										<td></td>
										<td class="text-right">
											<h4>
												<strong>Grand Total:</strong>
											</h4>
										</td>
										<td class="text-center text-danger">
											<h4>
												<strong>${grandTotal}</strong>
											</h4>
										</td>
									</tr>

								</tbody>
							</table>
							
							
							<input type="submit" class="btn1" value="Confirm">			
							
							

						</div>



					</div>

				</div>

			</form:form>
		</div>
		
		
<%-- 

<div class = "col-md-offset-2 col-md-8">
		
	<div class="jumbotron jumbotron-fluid">
	<!-- Start of Jumbotron Class -->

	<div class="container">
		<!-- Start of Container class -->

		<h2 class="section-heading">Thank you for Shopping !!!</h2>

		<br />

		<p class="lead"> Your order will be delivered in 7-8 business days ... !</p>


</div>
	</div>
	<!-- End of Container class -->

</div>
<!-- End of Jumbotron Class -->

		
		
		
		
		
		
--%>
	
	</div>
</div>
