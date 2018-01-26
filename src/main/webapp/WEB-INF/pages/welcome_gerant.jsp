<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<meta charset="ISO-8859-1">
				<title>Welcome</title>

		<!-- link font style ecriture -->
			<link href="https://fonts.googleapis.com/css?family=Open+Sans:600|Playfair+Display"	rel="stylesheet">

		<!-- link bootstrap/css -->
			<link rel="stylesheet" href="resources/css/bootstrap.min.css">
			<link rel="stylesheet" href="resources/css/Style.css">

	</head>
<body>

		<!-- header -->
		<header class="container-fluid header"> 
			<div class="container">
				<a href="#" class="logo"> ProxiBanque</a>
					<nav class="menu">
						<a href="#client">Bienvenue ${a} </a>
<!-- 						<a href="#Idclient">  </a> -->
						<a href="http://localhost:8080/ProxiBanqueV3b/login.jsp"> Deconnexion </a>
<!-- 						<a href="#contact"> Contact </a> -->
					</nav>
			</div>
	
		</header>	
		<!-- End header -->
	
	
		<!-- banniere -->
		<section class="container-fluid banner">
			<div class="ban">
				<img src="resources/image/fond-bleu.jpg" alt="banniere du site" />
					<div class ="inner-banner">
						<h3 id="client"> Vos conseillers :</h3>
							<table class="table table-striped table-bordered table-hover table condensed">
								<thead>
									<tr>
										<td>Identifiant</td>
										<td>Nom </td>
										<td>Prenom</td>
										<td>Login</td>
									
									</tr>
								</thead>
								
								<tbody>

									<tr>
											<c:forEach var="myList" items="${conseillers}">
										<tr>
											<th>${myList.id}</th>
											<th>${myList.nom}</th>
											<th>${myList.prenom}</th>
											<th>${myList.login}</th>
								
									</tr>
											</c:forEach>
										</tr>
										

							</table>
							
											
					</div>
			</div>
		</section>
		<!-- End banniere -->

		<Form method="post" action="ClientServlet">
									<fieldset>
											<legend id="idclient"> Choisissez un compte client pour faire des opérations</legend>
													<p />
														*IdClient : <input type="text" name="idClient" required="required" placeholder=" IdClient " />
																	
													<p />
									</fieldset>
											<input type="submit" value="envoyer">
								</Form>	













</body>
</html>