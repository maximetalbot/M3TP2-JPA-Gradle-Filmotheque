<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<%@include file="template/head.jsp" %>
<body>

	<%@include file="template/nav.jsp" %>
	
<div class="container">	
	<h1 class="bleu">Edition d'un film</h1>
	<br><br>
		<div>
	<form action="editer" method="POST" class="form-horizontal" >
				<input type="hidden" name="id" value="${film.id}" /> 
				<div class="form-group">			
					<label for="titre" class="col-xs-2 control-label">Titre :</label>
					<div class="col-xs-10">
						<input required id="titre" name="titre" value="${film.titre}"  placeholder="Titre du film ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="annee" class="col-xs-2 control-label">Année :</label>
					<div class="col-xs-10">
						<input required pattern="[0-9]{4}"  id="annee" name="annee" value="${film.annee}"  placeholder="Année de sortie ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="style.id" class="col-xs-2 control-label">Style :</label>
					<div class="col-xs-10">
						<select required name = "style" id="style" class="form-control">
						<c:forEach items="${listeStyles}" var="s">
							<option value="${s.id}" ${s.id == film.style.id ? "selected" : ""}>${s.libelle}</option>
						</c:forEach>
						</select>					
					</div>
				</div>
				<div class="form-group">			
					<label for="real.prenom" class="col-xs-2 control-label">Réalisateur :</label>
					<div class="col-xs-5">
						<input id="real.prenom"  name="real.prenom" value="${film.real.prenom}" placeholder="Prénom ..."  class="form-control" /> 
					</div>
					<div class="col-xs-5">
						<input name="real.nom"  value="${film.real.nom}" placeholder="Nom ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="duree" class="col-xs-2 control-label">Durée :</label>
					<div class="col-xs-10">
						<input id="duree"  name="duree"  value="${film.duree}" placeholder="Durée du film (minutes) ..."  class="form-control" /> 
					</div>
				</div>


				<div class="form-group">			
					<label for="vu" class="col-xs-2 control-label">Vu :</label>
					<div class="col-xs-10">
						<select name = "vu" id="vu" class="form-control">
							<option value="true" ${film.vu ? "selected" : ""}>Oui</option>
							<option value="false"${film.vu ? "" : "selected"}>Non</option>
						</select>					
					</div>
				</div>

<%-- 				<c:forEach items="${ film.acteurs}" var="acteur" varStatus="status"> --%>
<!-- 					<div class="form-group">			 -->
<%-- 						<label for="duree" class="col-xs-2 control-label">Acteur ${status.index + 1} :</label> --%>
<!-- 						<div class="col-xs-5"> -->
<%-- 							<input name="prenom${status.index}" value="${acteur.prenom}"  placeholder="Prénom ..." class="form-control"/> --%>
<!-- 						</div> -->
<!-- 						<div class="col-xs-5"> -->
<%-- 							<input name="nom${status.index}" value="${acteur.nom}"  placeholder="Nom ..." class="form-control"/> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</c:forEach> --%>

				<c:forEach begin="0" end="4" var="ind">
					<div class="form-group">			
						<label for="prenom${ind}" class="col-xs-2 control-label">Acteur ${ind + 1} :</label>
						<div class="col-xs-5">
							<input id ="prenom${ind}" name="prenom${ind}" value="${film.acteurs[ind].prenom}" placeholder="Prénom ..." class="form-control"/>
						</div>
						<div class="col-xs-5">
							<input name ="nom${ind}" value="${film.acteurs[ind].nom}" placeholder="Nom ..." class="form-control"/>
						</div>
					</div>
				</c:forEach>

				<div class="form-group">			
					<label for="synopsis" class="col-xs-2 control-label">Synopsis :</label>
					<div class="col-xs-10">
						<textarea id="synopsis" name="synopsis" rows="5" placeholder="Résumé et commentaires ..."  class="form-control" >${film.synopsis}</textarea> 
					</div>
				</div>

				<div class="form-group" >
					<div class="col-xs-offset-2 col-xs-10">
						<button type="submit" class="btn btn-primary">Envoyer</button>			
					</div>
				</div>	
			
	</form>
	</div>
</div>
	<%@include file="template/footer.jsp" %>
	
</body>
</html>