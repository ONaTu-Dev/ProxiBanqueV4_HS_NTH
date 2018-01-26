<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Page d'acceuil login</title>

		<!-- link font style ecriture -->
			<link href="https://fonts.googleapis.com/css?family=Open+Sans:600|Playfair+Display"	rel="stylesheet">

		<!-- link bootstrap/css -->
			<link rel="stylesheet" href="resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="resources/css/Style.css">


</head>
<!-- header -->
		<header class="container-fluid header"> 
			<div class="container">
				<a href="#" class="logo"> ProxiBanque</a>
					<nav class="menu">
						<a href="#about"> A propos </a>
						
					</nav>
			</div>
	
		</header>	
		<!-- End header -->
	
	
		<!-- banniere -->
		<section class="container-fluid banner">
			<div class="ban">
				<img src="resources/image/11439.jpg" alt="banniere du site" />
					<div class ="inner-banner">
						<h1> Connectez vous</h1>
						<Form method="post" action="${pageContext.request.contextPath}/Welcome">
	
					
							<label for="pseudo-field">Login : </label>
							<input id="pseudo-field" name="user" required="required" placeholder=" Votre Login "/>
							<label for="password-field">Mot de passe : </label>
							<input id="password-field" name="password" required="required" placeholder=" Votre mot de passe" type="password" />
							<input class="btn btn-primary" type="submit" value="Submit">
						</Form>
					</div>
			</div>
		</section>
		<!-- End banniere -->

		<!-- a propos -->
		<section class="container-fluid about">
			<div class="container">
				<hr class="separator"></hr>
					<h3 id="about"> A propos de ProxiBanque :</h3>
	
						<div class="row">
	
							<article class="col-md-4 col-lg-4 col-xs-12 col-sm-12">
								<h2> Couverture </h2>
								<p> Un réseau d'agences accessible partout dans le monde</p></article>
							<article class="col-md-4 col-lg-4 col-xs-12 col-sm-12">
								<h2> Proximité</h2>
								<p> Un conseiller personnel vous est attribué pour gérèr l'ensemble de vos opérations. Nos conseiller on un nombre trés limité de client ce qui leur permets de rester disponible et efficace dans leur réponse à vos demandes</p></article>
							<article class="col-md-4 col-lg-4 col-xs-12 col-sm-12">
								<h2> Evolutive</h2>
								<p> Proxibanque utilse l'ensemble des technologies connecté pour vous offrir une expérience unique à la pointe de la technologies</p></article>
						</div>
			</div>
		</section>
		<!-- End a propos --> 
	
		<!-- Portfolio -->
		<section class="container-fluid portfolio"></section>
		<!-- End Portfolio --> 
	
		<!-- footer / contact -->
		<footer class="container-fluid footer"> </footer>
		<!-- End footer / contact -->


	</body>
</html>