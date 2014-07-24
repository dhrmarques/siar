<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>Home</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>	
		<ul>
			<li><a href="missaosiar">Gerenciar missões</a></li>
			<li><a href="tipomissaosiar">Gerenciar tipos de missão</a></li>
		</ul>
	</body>
</html>
