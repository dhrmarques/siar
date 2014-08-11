<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/mobile.css" />" rel="stylesheet">
		<title>Home</title>
	</head>
	<body>
		<div class="container">
			<p></p>
			<div class="row">
				<div class="col-xs-12">
					<form method="post" action="chefe/save">
						<input type="hidden" name="missaoId" value="${missaoResponse.missao.id}"/>
						<div class="form-group">
							<select name="status" id="status" class="form-control">
							<c:forEach var="status" items="${statusPossiveis}">
								<option value="${status}">${status.legivel}</option>
							</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<textarea class="form-control" name="comentario" id="comentario" placeholder="Insira aqui possíveis comentários"></textarea>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-default btn-primary" value="Atualizar Missão">
						</div>
					</form>
				</div>
			</div>
		
			<div class="row">
				<div class="col-xs-12">
					<b>Acidente:</b> ${missaoResponse.acidente.descricao}<br/>
					<b>Missão:</b> ${missaoResponse.missao.detalhes}<br/>
					<b>Tipo de missão:</b> ${missaoResponse.tipoMissao.titulo}<br/>
					<b>Status atual:</b> ${missaoResponse.missao.status.legivel}<br/>
				</div>
			</div>
		
			<div class="row">
				<div class="col-xs-12">
					<h1 class="title">
						${nome}
					</h1>
				</div>
			</div>
			
			<a href="logout">
				Logout
			</a>
		</div>
	</body>
</html>
