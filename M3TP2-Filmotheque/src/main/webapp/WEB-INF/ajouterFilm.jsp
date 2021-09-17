<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<%@include file="template/head.jsp" %>
<body>

	<%@include file="template/nav.jsp" %>
	
<div class="container">	
	<h1 class="bleu">Ajout d'un film</h1>
	<br><br>
		<div>
	<form action="ajouter" method="POST" class="form-horizontal">
				<div class="form-group">			
					<label for="titre" class="col-xs-2 control-label">Titre :</label>
					<div class="col-xs-10">
						<input id="titre"  name="titre"  placeholder="Titre du film ..."  class="form-control" required/> 
					</div>
				</div>

				<div class="form-group">			
					<label for="annee" class="col-xs-2 control-label">Année :</label>
					<div class="col-xs-10">
						<input pattern="[0-9]{4}" id="annee" name="annee"  placeholder="Année de sortie ..."  class="form-control"  required/> 
					</div>
				</div>

				<div class="form-group">			
					<label for="style" class="col-xs-2 control-label">Style :</label>
					<div class="col-xs-10">
						<select name="style" id="style" class="form-control" required>
							<c:forEach items="${listeStyles}" var="s">
								<option value="${s.id}">${s.libelle}</option>
							</c:forEach>
						</select>					
					</div>
				</div>
				<div class="form-group">			
					<label for="real.prenom" class="col-xs-2 control-label">Réalisateur :</label>
					<div class="col-xs-5">
						<input id="real.prenom"  name="real.prenom"  placeholder="Prénom ..."  class="form-control" /> 
					</div>
					<div class="col-xs-5">
						<input id="real.nom" name="real.nom"  placeholder="Nom ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="duree" class="col-xs-2 control-label">Durée :</label>
					<div class="col-xs-10">
						<input id="duree" name="duree"  placeholder="Durée du film (en minutes) ..."  class="form-control" /> 
					</div>
				</div>


				<div class="form-group">			
					<label for="vu" class="col-xs-2 control-label">Vu :</label>
					<div class="col-xs-10">
						<select id="vu"  name="vu" class="form-control">
							<option value="true">Oui</option>
							<option value="false">Non</option>
						</select>					
					</div>
				</div>

				<c:forEach begin="0" end="4" var="ind">
					<div class="form-group">			
						<label for="prenom${ind}" class="col-xs-2 control-label">Acteur ${ind + 1} :</label>
						<div class="col-xs-5">
							<input id ="prenom${ind}" name="prenom${ind}" placeholder="Prénom ..." class="form-control"/>
						</div>
						<div class="col-xs-5">
							<input name ="nom${ind}"  placeholder="Nom ..." class="form-control"/>
						</div>
					</div>
				</c:forEach>

				<div class="form-group">			
					<label for="synopsis" class="col-xs-2 control-label">Synopsis :</label>
					<div class="col-xs-10">
						<textarea name="synopsis" id="synopsis" rows="5" placeholder="Résumé et commentaires ..."  class="form-control" ></textarea> 
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