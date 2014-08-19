<%@ include file="/WEB-INF/views/headers.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
		<style type="text/css">
			form div.form-group {
				margin-right:20px;
			}
		</style>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
	
		<div class="col-sm-12" style="text-align:center;">
			<form action="/siar/relatorios" method="post" class="well form-inline">
				<div class="form-group">
					<label for="mes">Mês</label>
					<select class="form-control" name="mes" id="mes">
						<option value="0">Janeiro</option>
						<option value="1">Fevereiro</option>
						<option value="2">Março</option>
						<option value="3">Abril</option>
						<option value="4">Maio</option>
						<option value="5">Junho</option>
						<option value="6">Julho</option>
						<option value="7">Agosto</option>
						<option value="8">Setembro</option>
						<option value="9">Outubro</option>
						<option value="10">Novembro</option>
						<option value="11">Dezembro</option>
					</select>
				</div>
			
				<div class="form-group">
					<label for="ano">Ano</label>
					<select class="form-control" name="ano" id="ano"><c:forEach var="ano" items="${anosList}">
						<option value="${ano}">${ano}</option>
					</c:forEach>
					</select>
				</div>
			
				<div class="form-group">
					<input value="Gerar relatório" type="submit" class="btn btn-primary">
				</div>
			</form>
		</div>
		
	</body>
</html>