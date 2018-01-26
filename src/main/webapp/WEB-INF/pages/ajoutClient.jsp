<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Welcome</title>

<!-- link font style ecriture -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:600|Playfair+Display"
	rel="stylesheet">

<!-- link bootstrap/css -->

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/Style_welcomCons.css">

</head>
<body>

	<!-- header -->
	
		<header class="container-fluid header">
				<div id="entete" class="container">
						<a href="#" class="logo"> ProxiBanque </a>
						<nav class="menu"> 
							<a href="${pageContext.request.contextPath}/displayClients">Vos clients </a> 
							<a href="${pageContext.request.contextPath}/displayCompteForClient"> Afficher un client </a> 
							<a href="${pageContext.request.contextPath}/ajoutClient"> Créer un client </a>
							<a href="http://localhost:8080/ProxiBanqueV3b/login.jsp">Deconnexion </a>
				</div>

		</header>
	<!-- End header -->

	<!-- banniere -->
	<section class="container-fluid banner">
	
	<div class="ban">
		<div class="inner-banner">
			<h3 id="a definir"></h3>
		<center><img src="resources/image/bankMinority.jpg" alt="banniere du site" /></center>

<!-- Footer / Creation Client -->
	
	<Form method="post" class="form-horizontal" action="${pageContext.request.contextPath}/ajoutClient">
<!-- 	<form class="form-horizontal" role="form"> -->

	<div class= "main register">
		
		<div class='row'>
			<div class="col-xs-12 col-sm-10 col-md-8 col-lg-4 ">
				<div id="creationClient" class="titleprghp">
				<h3><span class="prg">Création d'un nouveau client :</span></h3>
				</div>
			</div>
		</div>
		<div class='row'>

			<div class="col-lg-6">
				<!--<form class="form-horizontal" role="form">-->
				
				<div class="form-group">
					<label for="nom" class="col-sm-2 control-label">Nom :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="name" id="name" required="required">
						
					</div>
				</div>
				<div class="form-group">
					<label for="prenom" class="col-sm-2 control-label">Prenom :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="prenom" id="prenom" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="rue" class="col-sm-2 control-label">Rue :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="rue" id="rue" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="codepostale" class="col-sm-2 control-label">Code postale :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="codepostale" id="codepostale" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="ville" class="col-sm-2 control-label">Ville :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="ville" id="ville" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="mail" class="col-sm-2 control-label">Email :</label>
					<div class="col-sm-8">
						<input type="email" class="form-control" name="email" id="email">
					</div>
				</div>
				<div class="form-group">
					<label for="tel" class="col-sm-2 control-label">Telephone
						:</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="tel" id="tel">
					</div>	                                   
				</div>
				
				
				<div class="col-lg-1 col-md-1 col-xs-12">
					<button name="submit" id="cancel" type="reset" value="reset" 
				 			class="btn btn-default">Cancel<span class="btn btn-default"></span></button>
                </div>
                
                 <div class="col-lg-3 col-lg-offset-1 col-md-3 col-md-offset-1 col-xs-12">
                 		<button name="submit" id="submit" type="submit" value="submit" class="btn btn-default">
                 			<span class="glyphicon glyphicon-floppy-disk"></span>Enregistrer la fiche contact<span 
                 			class="btn btn-default"></span></button>
				</div>
			</div>	
		</div>
		</div>
		<center><a href="#entete" class="entete"> --- Haut de page ---</a></center>
	
	</form>
	
	<!-- End Footer / Creation Client -->
</body>
</html>