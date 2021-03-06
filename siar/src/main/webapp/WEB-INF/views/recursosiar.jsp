<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
		<link href="<c:url value="/resources/css/lista.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/components.css" />" rel="stylesheet">
		<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="<c:url value="/resources/js/error.js" />"></script>
	</head>
	
	<body>
		<div id="error-container" class="well ${cls}">${box_text}</div>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>

 		<div class="col-sm-12">
 			<div class="new-recurso-form">
	        <form class="form-inline" action="/siar/recursos/save" method="post" role="form">
		        	<div class="form-group">
			            <input placeholder="Nome" class="form-control" type="text" id="nome" name="nome"/>
		            </div>
		        	<div class="form-group">
			            <input placeholder="Descri��o" class="form-control" type="text" id="descricao" name="descricao"/>
		            </div>
		        	<div class="checkbox">
			            <label for="recursoHumano">
			            	RH?
			            	<input type="checkbox" id="recursoHumano" name="recursoHumano"/>
		            	</label>
		            </div>
		        	<div class="form-group">
		        		<label>
		        			Quantidade: 
			        		<select class="form-control" id="qtdPropria" name="qtdPropria">
				        		<c:forEach var="i" begin="1" end="20">
				        			<option><c:out value="${i}"/></option>
								</c:forEach>
				            </select>
			            </label>
		            </div>
	            	<div class="form-group">
	            		<input class="btn btn-success" type="submit" value="Criar"/>
	            	</div>
	    	</form>
	    	</div>
		</div>
		
		<div class="col-sm-12">
		    <table class="table table-condensed">
		        <tr>
		            <th>Nome</th>
		            <th>Descri��o</th>
		            <th>RH?</th>
		            <th>Qtd SiAR</th>
		            <th>Atualizar</th>
		            <th>Remover</th>
		        </tr>
		        <c:forEach var="recurso" items="${recursoSiarList}">
		            <tr>
		                <td><span>${recurso.nome}</span></td>
		                <td><span>${recurso.descricao}</span></td>
		                <td><span>${recurso.recursoHumano eq true ? 'Sim' : 'N�o'}</span></td>
		                <td><span>${recurso.qtdPropria}</span></td>
		                <td><a href="/siar/recursos/update/${recurso.id}"><button class="btn btn-warning">Update</button></a></td>
		                <td><a href="/siar/recursos/delete/${recurso.id}"><button class="btn">Remove</button></a></td>
		            </tr>
		        </c:forEach>
		    </table> 
		</div> 
    	<div class="footer col-sm-12">
    		
    	</div>
	</body>
</html>