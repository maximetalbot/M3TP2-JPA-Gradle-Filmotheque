<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<%@include file="template/head.jsp" %>
<body>

	<%@include file="template/nav.jsp" %>
	<div class="container">
		<h1 class="bleu">Gestion des styles</h1>
		<br> <br>
		<table class="table table-hover table-striped">
			<tr>
				<th>id</th>
				<th>Libelle</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${listeS}" var="s" varStatus="bStatus">
				<form action="modifStyle" method="Post">
					<tr>
						<input type="hidden" name="id" value="${s.id}" />
						<td>${s.id}</td>
						<td><input type="text" name="libelle" value="${s.libelle}" /></td>
						<td class="centre">
							<button type="submit" class="glyphicon glyphicon-edit vert"></button>

						</td>
						<td class="centre"><a href="supprimerStyle?index=${s.id}">
								<span class="glyphicon glyphicon-remove rouge"></span>
						</a></td>
					</tr>
				</form>
			</c:forEach>
		</table>

		<br>
		<br>
		<br>
		<h2 class="bleu">Nouveau style :</h2>
		<div>
			<form action="ajouterStyle" method="POST" class="form-horizontal">
				<div class="form-group">
					<div class="col-xs-10">
						<input name="libelle" placeholder="Libellé du style ..."
							class="form-control" />
					</div>
					<div class="col-xs-2">
						<button type="submit" class="btn btn-primary pull-right">Envoyer</button>
					</div>
				</div>

			</form>
		</div>

	</div>
	<%@include file="template/footer.jsp" %>

</body>
</html>