<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<style type="text/css">
#slider .carousel-item {
	height: 500px;
}

.carousel-caption {
	font-size: 18px;
}

.carousel-item>img {
	width: 100%
	
}
.content{

}
</style>
</head>
<body>
	<%@include file="Menubarjsp.jsp"%>
	<div class="carousel slide container mr-3 " id="slider" data-ride="carousel">
		<!--indicators-->
		<ol class="carousel-indicators">
			<li data-target="#slider" data-slide-to="0" class="active"></li>
			<li data-target="#slider" data-slide-to="1"></li>
			<li data-target="#slider" data-slide-to="2"></li>
			<li data-target="#slider" data-slide-to="3"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img
					src="https://content.gallup.com/origin/gallupinc/GallupSpaces/Production/Cms/GMJ/hu9l0vsks02k2yoayrrzia.jpg"
					height="500" width="100">
				<div class="carousel-caption">
					<h4>Welcome</h4>
					<p>CIT Bank!</p>
				</div>
			</div>

			<div class="carousel-item" id="slide2">
				<img
					src="https://thumbs.dreamstime.com/b/smiling-middle-aged-female-realtor-handshake-excited-husband-closing-deal-overjoyed-first-time-buyers-couple-happy-spouse-157857926.jpg"
					height="500" width="100">
				<div class="carousel-caption">
					<h4>Welcome</h4>
					<p>CIT Bank!</p>
				</div>
			</div>
			<div class="carousel-item" id="slide2">
				<img
					src="https://cdn.pixabay.com/photo/2017/01/14/10/56/men-1979261__340.jpg"
					height="500" width="100">
				<div class="carousel-caption">
					<h4>Welcome</h4>
					<p>CIT Bank!</p>
				</div>
			</div>
			<div class="carousel-item" id="slide2">
				<img
					src="https://thumbs.dreamstime.com/b/happy-female-business-partners-shake-hands-sign-two-contracts-lawyer-mediation-meeting-smiling-businesswomen-handshake-144848581.jpg"
					height="500" width="100">
				<div class="carousel-caption">
					<h4>Welcome</h4>
					<p>CIT Bank!</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#slider" role="button"
			data-slide="prev"> <span class="carousel-control-prev-icon"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#slider" role="button"
			data-slide="next"> <span class="carousel-control-next-icon"
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
		<div id="content">
        <!-- We'll fill this with dummy content -->
    </div>
		<!-- <!-- Footer
		<footer class="page-footer font-small teal pt-4 bg-dark">

			Footer Text
			<div class="container-fluid text-center text-md-left">

				Grid row
				<div class="row">

					Grid column
					<div class="col-md-6 mt-md-0 mt-3">

						Content
						<h5 class="text-uppercase font-weight-bold text-white">About
							Application</h5>
						<p class="text-white">It is a bank mini application.This
							application helps to perform bank transactions.Before starting
							transactions user registering the website and submitting the form
							to create an account. Then bank create an account and sended to
							he/her official email along with all account details after that
							user started all type of transactions.</p>

					</div>
					Grid column

					<hr class="clearfix w-100 d-md-none pb-3">

					Grid column
					<div class="col-md-6 mb-md-0 mb-3">

						Content
						<h5 class="text-uppercase font-weight-bold text-white">About
							Technologies</h5>
						<p class="text-white">I developed this application using to
							different technologies like java,jdbc,spring,hibernate,jpa,itext
							api,servlets,html jsp,Bootstrap,java script,jQuery and etc.</p>

					</div>
					Grid column

				</div>
				Grid row

			</div>
			Footer Text

			Copyright
			<div class="footer-copyright text-center py-3">
				© 2020 Copyright: <a href="https://mdbootstrap.com/">
					MDBootstrap.com</a>
			</div>
			Copyright

		</footer>
		Footer -->
	</div>

</body>
</html>