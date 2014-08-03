<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/lista.css" />" rel="stylesheet">
		<style type="text/css">
		</style>
		<title>${title}</title>
	</head>
	
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>

 		<div class="col-sm-12">
 			<div class="new-acidente-form">
	        <form class="form-inline" action="/siar/acidentes/save" method="post" role="form">
	        	<div class="container">
		        	<div class="form-group col-sm-4">
			            <label for="descricao">Descrição</label>
			            <input class="form-control" type="text" id="descricao" name="descricao"/>
		            </div>
		            <div class="form-group col-sm-4">
			            <label for="prioridade">Prioridade</label>
			            <select class="form-control" id="prioridade" name="prioridade">
			            	<option>Muito Grave</option>
			            	<option>Grave</option>
			            	<option>Média</option>
			            	<option>Baixa</option>
			           </select>
	            	</div>
	            	<div class="form-group col-sm-4">
	            		<button class="btn btn-success" type="submit">submit</button>
	            	</div>
	    		</div>
	    	</form>
	    	</div>
		</div>
		
		<div class="col-sm-12">
		    <table class="table table-condensed">
		        <tr>
		            <th>Descrição</th>
		            <th>Prioridade</th>
		            <th>Atualizar</th>
		            <th>Remover</th>
		        </tr>
		        <c:forEach var="acidente" items="${acidenteSiarList}">
		            <tr>
		                <td><span>${acidente.descricao}</span></td>
		                <td><span>${acidente.prioridade}</span></td>
		                <td><a href="/siar/acidentes/update/${acidente.id}"><button class="btn btn-warning">Update</button></a></td>
		                <td><a href="/siar/acidentes/delete/${acidente.id}"><button class="btn">Remove</button></a></td>
		            </tr>
		        </c:forEach>
		    </table> 
		</div> 
    	<div class="footer col-sm-12">
    		
    	</div>
	</body>
</html>