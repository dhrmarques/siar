<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<form class="form-vertical well" action="/siar/tiposmissao/save" method="post">
            <input type="hidden" name="id" value="${tipo.id}">
            <div class="form-group">
				<label for="titulo">T�tulo</label>
            	<input class="form-control" type="text" id="titulo" name="titulo" value="${tipo.titulo}"/>
            </div>
            <div class="form-group">
				<label for="descricao">Descri��o</label>
            	<input class="form-control" type="text" id="descricao" name="descricao" value="${tipo.descricao}"/>
            </div>
            <div class="form-group">
            	<input type="submit" value="Alterar" class="btn btn-success"/>
            </div>
        </form>
	</body>
</html>