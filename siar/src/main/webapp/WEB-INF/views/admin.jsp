<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		<ul>
			<li><a href="usuariosiar/">Gerenciar usuários</a></li>
			<li><a href="recursosiar/">Gerenciar recursos</a></li>
		</ul>
	</body>
</html>
