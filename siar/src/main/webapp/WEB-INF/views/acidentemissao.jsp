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
		            <th>Descrição</th>
		            <th>Prioridade</th>
		            <th>Ação</th>
		        </tr>
		        <c:forEach var="acidente" items="${acidenteList}">
		            <tr>
		                <td><span>${acidente.descricao}</span></td>
		                <td><span>${acidente.prioridade}</span></td>
		                <td>
		                	<form action="/siar/missoes/new" method="post">
		                		<input type="hidden" name="acidenteId" value="${acidente.id}"/>
		                		<input type="submit" value="Criar missão" class="btn btn-primary"/>
		                	</form>
		                </td>
		            </tr>
		        </c:forEach>
		    </table> 
		</div> 

	</body>
</html>