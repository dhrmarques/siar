<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="<c:url value="/resources/js/error.js" />"></script>
		<title>${title}</title>
	</head>
	<body>
		<div id="error-container" class="well ${cls}">${box_text}</div>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<div id="form_container" class="col-sm-12">
			<div id="form_info" class="well">
				<strong>Acidente:</strong> ${acidente.descricao}<br/>
				<strong>Prioridade:</strong> ${acidente.prioridade}
			</div>
			<form action="/siar/missoes/save" method="POST" class="well form-vertical" style="margin:30px;">
				<input id="acidenteId" type="hidden" name="acidenteId" value="${acidente.id}"/>
				<div class="form-group">
					<label for="detalhes">Detalhes:</label>
					<input id="detalhes" type="text" name="detalhes" class="form-control"/>
				</div>
				<div class="form-group">
		            <label for="tipoMissaoId">Tipo de missão</label>
		            <select class="form-control" id="tipoMissaoId" name="tipoMissaoId">
		            	<option value="">Escolher tipo de missão</option>
		            <c:forEach var="tipoMissao" items="${tiposMissao}">
		            	<option value="${tipoMissao.id}">${tipoMissao.titulo}</option>
		            </c:forEach>
		        	</select>
            	</div>
				<div class="form-group">
		            <label for="recursoId">Recurso:</label>
		            <input id="quantidade" type="text" name="quantidade" class="form-control" value="1" style="max-width:100px;display:inline-block;"/>
		            <select class="form-control" id="recursoId" name="recursoId" style="max-width:50%;display:inline-block;">
		            	<option value="">Incluir recurso</option>
		            <c:forEach var="recurso" items="${recursos}">
		            	<option value="${recurso.id}">${recurso.nome}</option>
		            </c:forEach>
		        	</select>
            	</div>
				<div class="form-group">
		            <label for="recursoId">Recurso:</label>
		            <input id="quantidade" type="text" name="quantidade" class="form-control" value="1" style="max-width:100px;display:inline-block;"/>
		            <select class="form-control" id="recursoId" name="recursoId" style="max-width:50%;display:inline-block;">
		            	<option value="">Incluir recurso</option>
		            <c:forEach var="recurso" items="${recursos}">
		            	<option value="${recurso.id}">${recurso.nome}</option>
		            </c:forEach>
		        	</select>
            	</div>
				<input type="submit" value="Criar" class="form-control btn btn-default btn-success"/>
			</form>
		</div>
	
	</body>
</html>
