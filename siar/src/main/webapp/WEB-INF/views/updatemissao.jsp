<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<form action="/siar/missoes/save" method="post">
            <input type="hidden" id="id" name="id" value="${missaoUpdate.id}">
            <label for="detalhes">Detalhes</label>
            <input type="text" id="detalhes" name="detalhes" value="${missaoUpdate.detalhes}"/>
            <label for="statusMissaoId">Status da Missão</label>
            <input type="text" id="statusMissaoId" name="statusMissaoId" value="${missaoUpdate.statusMissaoId}"/>
            
            <input type="submit" value="Submit"/>
        </form>
	</body>
</html>