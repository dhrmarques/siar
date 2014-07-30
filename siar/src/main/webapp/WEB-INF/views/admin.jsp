<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		<div class="col-sm-12">
	    	<ul class="menu nav nav-tabs">
	    		<li><a href="usuariosiar">Usuários</a></li>
	    		<li><a href="recursos">Recursos</a></li>
	    	</ul>
	    </div>
	</body>
</html>
