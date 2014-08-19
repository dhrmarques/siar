<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
		<link href="<c:url value="/resources/css/lista.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/components.css" />" rel="stylesheet">
		<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="<c:url value="/resources/js/error.js" />"></script>
		<style type="text/css">
		</style>
	</head>
	
	<body>
		<div id="error-container" class="well ${cls}">${box_text}</div>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>

 		<div class="col-sm-12">
 			<div class="new-tipomissao-form with-padding-top">
	        <form class="form-inline" action="/siar/tiposmissao/save" method="post" role="form">
	        	<div class="container">
		        	<div class="form-group">
			            <label for="titulo">Título</label>
			            <input class="form-control" type="text" id="titulo" name="titulo"/>
		            </div>
		        	<div class="form-group">
			            <label for="descricao">Descrição</label>
			            <input class="form-control" type="text" id="descricao" name="descricao"/>
		            </div>
	            	<div class="form-group">
	            		<input class="btn btn-success" type="submit" value="Criar"/>
	            	</div>
	    		</div>
	    	</form>
	    	</div>
		</div>
		
		<div class="col-sm-12">
		    <table class="table table-condensed">
		        <tr>
		            <th>Título</th>
		            <th>Descrição</th>
		            <th>Alterar</th>
		            <th>Desativar</th>
		        </tr>
		        <c:forEach var="tipo" items="${tipoMissaoSiarList}">
		            <tr>
		                <td><span>${tipo.titulo}</span></td>
		                <td><span>${tipo.descricao}</span></td>
		                <td><a href="/siar/tiposmissao/update/${tipo.id}"><button class="btn btn-warning">Alterar</button></a></td>
		                <td><a href="/siar/tiposmissao/delete/${tipo.id}"><button class="btn">Desativar</button></a></td>
		            </tr>
		        </c:forEach>
		    </table> 
		</div> 

	</body>
</html>