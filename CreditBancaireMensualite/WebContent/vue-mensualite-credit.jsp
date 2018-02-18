<%@page import="web.ModelMensualiteCredit"%>
<%
	ModelMensualiteCredit model = (ModelMensualiteCredit)request.getAttribute("model");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Calcul mensualité crédit</title>
		<link rel="Stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	</head>
	<body>
		<p></p>
		<div class="container col-md-4 col-md-offset-4">
		<p></p>
		<p>Calculer le montant de vos mensualités pour votre crédit bancaire</p>
		<div>
			<form action="controleur.do" method="post">
				<table class="table table-striped">
					<tr>
						<td>Montant</td>
						<td><input type="text" name="montant" value="<%=model.getMontant()%>"/></td>
						<td>euros</td>
					</tr>
					<tr>
						<td>Durée</td>
						<td><input type="text" name="duree" value="<%=model.getDuree()%>"/></td>
						<td>mois</td>
					</tr>
					<tr>
						<td>Taux (TAEG)</td>
						<td><input type="text" name="taux" value="<%=model.getTaux()%>"/></td>
						<td>%</td>
					<tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Calculer"/></td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<table class="table table-striped">
				<tr>
					<td>Mensualité : </td>
					<td><% out.println(model.getMensualite()); %></td>
					<td>euros</td>
				</tr>
			</table>
		</div>
		</div>
	</body>
</html>