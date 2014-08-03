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
 			<div class="new-recurso-form">
	        <form class="form-inline" action="/siar/recursos/save" method="post" role="form">
		        	<div class="form-group">
			            <input placeholder="Nome" class="form-control" type="text" id="nome" name="nome"/>
		            </div>
		        	<div class="form-group">
			            <input placeholder="Descrição" class="form-control" type="text" id="descricao" name="descricao"/>
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
				        		<c:forEach var="i" begin="0" end="20">
				        			<option><c:out value="${i}"/></option>
								</c:forEach>
				            </select>
			            </label>
		            </div>
	            	<div class="form-group">
	            		<button class="btn btn-success" type="submit">submit</button>
	            	</div>
	    	</form>
	    	</div>
		</div>
		
		<div class="col-sm-12">
		    <table class="table table-condensed">
		        <tr>
		            <th>Nome</th>
		            <th>Descrição</th>
		            <th>RH?</th>
		            <th>Qtd SiAR</th>
		            <th>Atualizar</th>
		            <th>Remover</th>
		        </tr>
		        <c:forEach var="recurso" items="${recursoSiarList}">
		            <tr>
		                <td><span>${recurso.nome}</span></td>
		                <td><span>${recurso.descricao}</span></td>
		                <td><span>${recurso.recursoHumano eq true ? 'Sim' : 'Não'}</span></td>
		                <td><span>${recurso.qtdPropria}</span></td>
		                <td><a href="/siar/recursos/update/${recurso.id}"><button class="btn btn-warning">Update</button></a></td>
		                <td><a href="/siar/recursos/delete/${recurso.id}"><button class="btn">Remove</button></a></td>
		            </tr>
		        </c:forEach>
		    </table> 
		</div> 
    	<div class="footer col-sm-12">
    		
    	</div>
    </div>
</body>
</html>