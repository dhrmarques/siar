<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/mobile.css" />" rel="stylesheet">
		<title>Home</title>
	</head>
	<body>
		<div class="container">
		
			<div class="row">
				<div class="col-xs-12">
					<h1 class="title">
						${nome}
					</h1>
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-12">
					N�o h� nenhuma miss�o atribu�da a voc� no momento. Que t�dio...
				</div>
			</div>
			
			<a href="logout">
				Encerrar sess�o
			</a>
		</div>
	</body>
</html>
