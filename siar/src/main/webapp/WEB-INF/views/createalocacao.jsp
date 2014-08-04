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
				<strong>Acidente:</strong> ${missaoResponse.acidente.descricao}<br/>
				<strong>Prioridade:</strong> ${missaoResponse.acidente.prioridade}<br/>
				<strong>Missão:</strong> ${missaoResponse.missao.detalhes}<br/>
				<strong>Tipo de missão:</strong> ${missaoResponse.tipoMissao.titulo}
			</div>
			<form action="/siar/alocacao/save" method="POST" class="well form-vertical" style="margin:30px;">
				<input id="missaoId" type="hidden" name="missaoId" value="${missaoResponse.missao.id}"/>
				<div class="form-group">
		            <label for="chefeId">Chefe de missão</label>
		            <select class="form-control" id="chefeId" name="chefeId">
		            	<option value="">Escolher chefe de missão</option>
		            <c:forEach var="chefe" items="${chefesList}">
		            	<option value="${chefe.id}">${chefe.nome}</option>
		            </c:forEach>
		        	</select>
            	</div>
            	<c:forEach var="necessidade" items="${necessidadesResponse}">
					<div class="form-group">
			            <input id="necessidadeId" type="hidden" name="necessidadeId" value="${necessidade.id}"/>
						<input id="quantidade" type="hidden" name="quantidade" value="${necessidade.quantidadeLocal}"/>
						<label for="fornecedorId"><b>Recurso:</b> ${necessidade.recurso.nome}</label>
			            <select class="form-control" id="fornecedorId" name="fornecedorId">
			            	<option value="">Escolher fornecedor</option>
			            <c:forEach var="fornecedor" items="${fornecedoresList}">
			            	<option value="${fornecedor.id}">${fornecedor.nome}</option>
			            </c:forEach>
			        	</select>
	            	</div>
            	</c:forEach>
				<input type="submit" value="Alocar" class="btn btn-default"/>
			</form>
		</div>
	
	</body>
</html>
