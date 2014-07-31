<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/lista.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
	    
	    <div class="col-sm-12">
	    	<ul class="menu nav nav-tabs">
	    		<li><a href="acidentes">Acidentes</a></li>
	    		<li class="active"><a href="#">Missões</a></li>
	    		<li><a href="tiposmissao">Tipos de missão</a></li>
	    	</ul>
	    </div>
		
		<div class="col-sm-12">
		    <table class="table table-condensed">
		        <tr>
		            <th>Acidente</th>
		            <th>Tipo</th>
		            <th>Detalhes</th>
		            <th>Status</th>
		            <th>Atualizar</th>
		            <th>Remover</th>
		        </tr>
		        <c:forEach var="response" items="${responseList}">
		            <tr>
		                <td>${response.acidente.descricao}</td>
		                <td>${response.tipoMissao.titulo}</td>
		                <td>${response.missao.detalhes}</td>
		                <td>${response.missao.status.legivel}</td>
		                <td><a href="/siar/missoes/update/${response.missao.id}"><button class="btn btn-warning">Update</button></a></td>
		                <td><a href="/siar/missoes/delete/${response.missao.id}"><button class="btn">Remove</button></a></td>
		            </tr>
		        </c:forEach>
		    </table> 
		</div> 
    	<div class="footer col-sm-12">
    		
    	</div>
</body>
</html>