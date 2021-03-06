<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<div id="form_container" class="col-sm-12">
			<div id="form_info" class="well">
				<strong>Acidente:</strong> ${missaoResponse.acidente.descricao}<br/>
				<strong>Prioridade:</strong> ${missaoResponse.acidente.prioridade}<br/>
				<strong>Miss�o:</strong> ${missaoResponse.missao.detalhes}<br/>
				<strong>Tipo de miss�o:</strong> ${missaoResponse.tipoMissao.titulo}
			</div>
			<form action="/siar/alocacao/save" method="POST" class="well form-vertical" style="margin:30px;">
				<input id="missaoId" type="hidden" name="missaoId" value="${missaoResponse.missao.id}"/>
				<div class="form-group">
		            <label for="chefeId">Chefe de miss�o</label>
		            <select class="form-control" id="chefeId" name="chefeId">
		            	<option value="">Escolher chefe de miss�o</option>
		            <c:forEach var="chefe" items="${chefesList}">
		            	<option value="${chefe.id}">${chefe.nome}</option>
		            </c:forEach>
		        	</select>
            	</div>
            	<c:forEach var="response" items="${necessidadesList}">
					<div class="form-group">
			            <input id="necessidadeId" type="hidden" name="necessidadeId" value="${response.necessidade.id}"/>
						<input id="quantidade" type="hidden" name="quantidade" value="${response.necessidade.quantidadeTotal}"/>
						<label for="fornecedorId">Recurso: <span style="font-weight:normal;">${response.necessidade.quantidadeTotal} x</span> ${response.recurso.nome}</label>
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
