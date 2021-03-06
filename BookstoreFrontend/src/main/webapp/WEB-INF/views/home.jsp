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

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<div class="container">
	<h2>Welcome to online BookStore ...</h2>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">

			<div class="item active">
				<img src="${images}/logo_1.gif" alt="Welcome"
					style="width: 600px; height: 400px; margin: 0 auto">
				<div class="carousel-caption">
					<h3>Welcome to BooksArchive !!</h3>
					<p>An online bookstore portal .</p>
				</div>
			</div>

			<div class="item">
				<img src="${images}/carousel_2.gif" alt="Books World"
					style="width: 600px; height: 400px; margin: 0 auto">
				<div class="carousel-caption">
					<h3>Books World</h3>
					<p>Waiting to be read .</p>
				</div>
			</div>

			<div class="item">
				<img src="${images}/Carousel_3.jpg" alt="New York"
					style="width: 600px; height: 400px; margin: 0 auto; ">
				<div class="carousel-caption">
					<h3>Technical Books</h3>
					<p>Necessity of every Engineering student .</p>
				</div>
			</div>

		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<!-- End of my container -->

	<!-- Template page content -->
	<div class="content-section-b">
		<div class="container">
			<div class="row">
				<div class="col-lg-5 col-sm-6">

					<div class="clearfix"></div>
					<h2 class="section-heading">
						Fantasy Genre<br>
					</h2>
					<p class="lead">Explore into an imaginative , creative and
						narrative elements , journeys and quests that relies on the use
						real-world folklore and mythology as inspiration</p>
				</div>
				<div class="col-lg-5 col-lg-offset-2 col-sm-6">
					<img class="img-responsive" src="${images}/lp_fantasy.jpg" alt="">
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-b -->

	<div class="content-section-b">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">

					<div class="clearfix"></div>
					<h2 class="section-heading">
						Photography<br>
					</h2>
					<p class="lead">Learn Photography ... Turn your 2D designs into
						high quality, 3D product shots in seconds using free Photoshop
						actions by SDCovers!</p>
				</div>
				<div class="col-lg-5 col-sm-pull-6  col-sm-6">
					<img class="img-responsive" src="${images}/lp_photo.gif" alt=""
						style="width: 198px; height: 254px;">
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-b -->

	<div class="content-section-b">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-sm-6">

					<div class="clearfix"></div>
					<h2 class="section-heading">
						Romance genre<br>
					</h2>
					<p class="lead">Endure in a spirit of hope - the need of
						patience in adversity, and the importance of providence in human
						affairs. The natural good in humanity is put under pressure but
						preserved through the action of providence</p>
				</div>
				<div class="col-lg-5 col-lg-offset-2 col-sm-6">
					<img class="img-responsive" src="${images}/lp_romance.jpg" alt="">
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-b -->
	
	