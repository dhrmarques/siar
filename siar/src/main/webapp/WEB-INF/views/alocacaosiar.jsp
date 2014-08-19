<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
		<link href="<c:url value="/resources/css/lista.css" />" rel="stylesheet">
	</head>
	
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<div class="col-sm-12">
		    <table class="table table-condensed">
		        <tr>
		            <th>Acidente</th>
		            <th>Tipo</th>
		            <th>Detalhes</th>
		            <th>Alocar</th>
		        </tr>
		        <c:forEach var="response" items="${missoesList}">
		            <tr>
		                <td>${response.acidente.descricao}</td>
		                <td>${response.tipoMissao.titulo}</td>
		                <td>${response.missao.detalhes}</td>
		                <td>
		                	<form action="/siar/alocacao/new" method="post">
		                		<input type="hidden" name="missaoId" value="${response.missao.id}"/>
		                		<input type="submit" value="Alocar recursos" class="btn btn-primary"/>
		                	</form>
		                </td>
		            </tr>
		        </c:forEach>
		    </table> 
		</div> 

	</body>
</html>