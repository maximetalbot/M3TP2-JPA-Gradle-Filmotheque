<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<%@include file="template/head.jsp" %>
<body>

	<%@include file="template/nav.jsp" %>
	
	<div class="container">
		<h1 class="bleu">Liste des films</h1>
		<br>
		<br>
		<table class="table table-hover table-striped">
			<tr>
				<th>Titre</th>
				<th>Année</th>
				<th>Style</th>
				<th>Réalisateur</th>
				<th>Durée</th>
				<th>Vu</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${listeF}" var="f" varStatus="bStatus">
				<tr>
					<td><a href="afficher?index=${f.id}">${f.titre}</a></td>
					<td>${f.annee}</td>
					<td>${f.style.libelle}</td>
					<td>${f.real.prenom}${f.real.nom}</td>
					<td>${f.duree}</td>
					<td>${f.vu?"Oui":"Non"}</td>
					<td class="centre"><span
						class="modif glyphicon glyphicon-edit vert" id="m${f.id}"></span>
					</td>
					<td class="centre"><span
						class="glyphicon glyphicon-remove rouge supp" id="s${f.id}"></span>
					</td>
				</tr>
			</c:forEach>
		</table>


	</div>
	<%@include file="template/footer.jsp" %>

</body>
</html>