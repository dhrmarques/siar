<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<form action="/siar/recursos/save" method="post">
            <input type="hidden" id="id" name="id" value="${recursoUpdate.id}">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" value="${recursoUpdate.nome}"/>
            <label for="descricao">Descrição</label>
            <input type="text" id="descricao" name="descricao" value="${recursoUpdate.descricao}"/>
            <label for="recursoHumano">RH?</label>
			<input class="form-control" type="checkbox" id="recursoHumano" name="recursoHumano"/>
            <label for="qtdPropria">Prioridade</label>
            <input type="text" id="qtdPropria" name="qtdPropria" value="${recursoUpdate.qtdPropria}"/>
            
            <input type="submit" value="Submit"/>
        </form>
	</body>
</html>