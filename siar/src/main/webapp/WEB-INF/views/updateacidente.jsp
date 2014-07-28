<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<form action="/siar/acidentesiar/save" method="post">
            <input type="hidden" id="id" name="id" value="${acidenteUpdate.id}">
            <label for="descricao">Descrição</label>
            <input type="text" id="descricao" name="descricao" value="${acidenteUpdate.descricao}"/>
            <label for="prioridade">Prioridade</label>
            <input type="text" id="prioridade" name="prioridade" value="${acidenteUpdate.prioridade}"/>
            
            <input type="submit" value="Submit"/>
        </form>
	</body>
</html>