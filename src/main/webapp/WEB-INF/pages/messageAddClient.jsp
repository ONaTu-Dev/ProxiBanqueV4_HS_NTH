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
							<a href="${pageContext.request.contextPath}/showAllClient">Vos clients </a> 
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
			<h3 id="client">Le nouveau client est ajoutee dans la base de donnee</h3>
			
		</div>
		</div>
		<center><a href="#entete" class="entete"> --- Haut de page ---</a></center>
	
	<!-- End Footer / Creation Client -->
</body>
</html>