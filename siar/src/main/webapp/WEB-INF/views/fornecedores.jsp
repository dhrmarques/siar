<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/lista.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/components.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
		<div id="error-container" class="well ${cls}">${box_text}</div>
	    <%@ include file="/WEB-INF/views/layout_header.jsp" %>

		<div class="col-sm-12">
			<div class="one-liner-form">
		        <form class="form-inline" action="/siar/fornecedores/save" method="post">
		        	<div class="form-group">
			            <input placeholder="Nome" class="form-control" type="text" id="nome" name="nome"/>
		            </div>
		            <div class="form-group">
			            <input placeholder="URL de solicitação" class="form-control" type="text" id="url" name="urlSolicitacao"/>
		            </div>
		            
		            <input class="btn btn-success" type="submit" value="Criar"/>
		        </form>
			</div>
		</div> 
	<div class="col-sm-12">
	    <table class="table table-condensed">
	        <tr>
	            <th>Nome</th>
	            <th>URL de solicitação</th>
	            <th>Atualizar</th>
	            <th>Remover</th>
	        </tr>
	        <c:forEach var="fornecedor" items="${fornecedoresList}">
	            <tr>
	                <td>${fornecedor.nome}</td>
	                <td>${fornecedor.urlSolicitacao}</td>
	                <td><a href="/siar/fornecedores/update/${fornecedor.id}"><button class="btn btn-warning">Alterar</button></a></td>
	                <td><a href="/siar/fornecedores/delete/${fornecedor.id}"><button class="btn">Deletar</button></a></td>
	            </tr>
	        </c:forEach>
	    </table>  
	</div>
</body>
</html>