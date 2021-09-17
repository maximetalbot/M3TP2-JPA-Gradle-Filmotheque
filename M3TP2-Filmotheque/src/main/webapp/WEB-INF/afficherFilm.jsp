<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<%@include file="template/head.jsp" %>
<body>

	<%@include file="template/nav.jsp" %>
	
<div class="container">	
	<h1 class="bleu">Votre film</h1>
	<br><br>
		<div>
	<form class="form-horizontal" >
				<div class="form-group">			
					<label for="titre" class="col-xs-2 control-label">Titre :</label>
					<div class="col-xs-10">
						<input id="titre"  value="${film.titre }" readonly   class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="annee" class="col-xs-2 control-label">Année :</label>
					<div class="col-xs-10">
						<input id="annee"  value="${film.annee }" readonly    class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="style" class="col-xs-2 control-label">Style :</label>
					<div class="col-xs-10">
						<input id="style"  value="${film.style.libelle }" readonly    class="form-control" /> 
					</div>
				</div>
				<div class="form-group">			
					<label for="real" class="col-xs-2 control-label">Réalisateur :</label>
					<div class="col-xs-5">
						<input id="real" value="${film.real.prenom}" readonly   class="form-control" /> 
					</div>
					<div class="col-xs-5">
						<input value="${film.real.nom}"   readonly class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="duree" class="col-xs-2 control-label">Durée :</label>
					<div class="col-xs-10">
						<input id="duree" value="${film.duree}"  readonly   class="form-control" /> 
					</div>
				</div>


				<div class="form-group">			
					<label for="vu" class="col-xs-2 control-label">Vu :</label>
					<div class="col-xs-10">
						<input id="vu" value="${film.vu?'Oui':'Non'}" readonly   class="form-control" /> 
					</div>
				</div>


				<c:forEach items="${ film.acteurs}" var="act" varStatus="status">
					<div class="form-group">			
						<label for="acteur${status.index}" class="col-xs-2 control-label">Acteur ${status.index + 1} :</label>
						<div class="col-xs-5">
							<input id="acteur${status.index}" readonly value="${act.prenom}"   class="form-control"/>
						</div>
						<div class="col-xs-5">
							<input readonly value="${act.nom}"  class="form-control"/>
						</div>
					</div>
				</c:forEach>

				<div class="form-group">			
					<label for="synopsis" class="col-xs-2 control-label">Synopsis :</label>
					<div class="col-xs-10">
						<textarea id="synopsis"  rows="5" readonly  class="form-control" >${film.synopsis}</textarea> 
					</div>
				</div>
			
	</form>
	</div>
</div>
	<%@include file="template/footer.jsp" %>
	
</body>
</html>