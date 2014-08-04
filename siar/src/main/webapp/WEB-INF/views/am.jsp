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
					<form method="post" action="am/save">
						<div class="form-group">
							<select name="status" id="status">
							<c:forEach var="status" items="${statusPossiveis}">
								<option value="${status}">${status.legivel}</option>
							</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<input class="btn btn-default btn-primary" value="Atualizar Missão">
						</div>
						<div class="form-group">
							<textarea class="form-control" name="comentario" id="comentario"></textarea>
						</div>
					</form>
				</div>
			</div>
			
			<a href="logout">
				Encerrar sessão
			</a>
		</div>
	</body>
</html>
