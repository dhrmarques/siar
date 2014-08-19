<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		<div class="col-sm-12">
			<form class="form-vertical well" action="/siar/missoes/save" method="post">
	            <input type="hidden" name="id" value="${missaoResponse.missao.id}">
	            <input type="hidden" name="acidenteId" value="${missaoResponse.missao.acidenteId}">
	            <input type="hidden" name="tipoMissaoId" value="${missaoResponse.missao.tipoMissaoId}">
	            <div class="form-group">
					<label>Tipo de missão:</label>
	            	<span>${missaoResponse.tipoMissao.titulo}</span>
	            </div>
	            <div class="form-group">
					<label for="detalhes">Detalhes</label>
	            	<input class="form-control" type="text" id="detalhes" name="detalhes" value="${missaoResponse.missao.detalhes}"/>
	            </div>
	            <div class="form-group">
		            <label>Status da Missão:</label>
		            <span>${missaoResponse.missao.status.legivel}</span>
	            </div>
	            <div class="form-group">
		            <label>Acidente:</label>
		            <span>${missaoResponse.acidente.descricao}</span>
	            </div>
	            <div class="form-group">
	            	<input type="submit" value="Alterar" class="btn btn-success"/>
	            </div>
	        </form>
        </div>
	</body>
</html>