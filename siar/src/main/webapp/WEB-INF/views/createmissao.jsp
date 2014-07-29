<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<div id="form_container">
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
		            	<option value="0">Escolher tipo de missão</option>
		            <c:forEach var="tipoMissao" items="${tiposMissao}">
		            	<option value="${tipoMissao.id}">${tipoMissao.titulo}</option>
		            </c:forEach>
		        	</select>
            	</div>
				<input type="submit" value="Criar" class="btn btn-default"/>
			</form>
		</div>
	
	</body>
</html>
