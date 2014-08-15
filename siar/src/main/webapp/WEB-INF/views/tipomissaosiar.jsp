<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/lista.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/components.css" />" rel="stylesheet">
		<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="<c:url value="/resources/js/error.js" />"></script>
		<style type="text/css">
		</style>
		<title>${title}</title>
	</head>
	
	<body>
		<div id="error-container" class="well ${cls}">${box_text}</div>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>

 		<div class="col-sm-12">
 			<div class="new-tipomissao-form with-padding-top">
	        <form class="form-inline" action="/siar/tiposmissao/save" method="post" role="form">
	        	<div class="container">
		        	<div class="form-group">
			            <label for="titulo">T�tulo</label>
			            <input class="form-control" type="text" id="titulo" name="titulo"/>
		            </div>
		        	<div class="form-group">
			            <label for="descricao">Descri��o</label>
			            <input class="form-control" type="text" id="descricao" name="descricao"/>
		            </div>
	            	<div class="form-group">
	            		<button class="btn btn-success" type="submit">submit</button>
	            	</div>
	    		</div>
	    	</form>
	    	</div>
		</div>
		
		<div class="col-sm-12">
		    <table class="table table-condensed">
		        <tr>
		            <th>T�tulo</th>
		            <th>Descri��o</th>
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