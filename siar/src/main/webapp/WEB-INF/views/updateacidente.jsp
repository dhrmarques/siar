<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		<div class="container">
			
			<div class="col-sm-12">
				<form class="form-inline" action="/siar/acidentes/save" method="post">
		            <input type="hidden" id="id" name="id" value="${acidenteUpdate.id}">
		            <div class="form-group">
			            <label for="descricao">Descrição</label>
			            <input class="form-control" type="text" id="descricao" name="descricao" value="${acidenteUpdate.descricao}"/>
		           	</div>
		           	<div class="form-group">
		            <label for="prioridade">Prioridade</label>
		            <select class="form-control" id="prioridade" name="prioridade">
						<c:forEach var="prioridade" items="${prioridadesList}">
							<option value="${prioridade}">${prioridade.desc}</option>
						</c:forEach>
					</select>
					</div>
		            <input class="btn btn-default btn-success" type="submit" value="Submit"/>
		        </form>
	        </div>
        </div>
	</body>
</html>