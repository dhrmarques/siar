<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<form class="form-vertical well" action="/siar/tiposmissao/save" method="post">
            <input type="hidden" name="id" value="${tipo.id}">
            <div class="form-group">
				<label for="titulo">Título</label>
            	<input class="form-control" type="text" id="titulo" name="titulo" value="${tipo.titulo}"/>
            </div>
            <div class="form-group">
				<label for="descricao">Descrição</label>
            	<input class="form-control" type="text" id="descricao" name="descricao" value="${tipo.descricao}"/>
            </div>
            <div class="form-group">
            	<input type="submit" value="Alterar" class="btn btn-success"/>
            </div>
        </form>
	</body>
</html>