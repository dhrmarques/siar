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
	    		<li><a href="usuariosiar">Usuários</a></li>
	    		<li class="active"><a href="#">Recursos</a></li>
	    	</ul>
	    </div>

 		<div class="col-sm-12">
 			<div class="new-recurso-form">
	        <form class="form-inline" action="/siar/recursos/save" method="post" role="form">
	        	<div class="container">
		        	<div class="form-group col-sm-2">
			            <label for="nome">Nome</label>
			            <input class="form-control" type="text" id="nome" name="nome"/>
		            </div>
		        	<div class="form-group col-sm-2">
			            <label for="descricao">Descrição</label>
			            <input class="form-control" type="text" id="descricao" name="descricao"/>
		            </div>
		        	<div class="form-group col-sm-2">
			            <label for="rh">RH?</label>
			            <input class="form-control" type="checkbox" id="recursoHumano" name="recursoHumano"/>
		            </div>
		        	<div class="form-group col-sm-2">
			            <label for="qtdPropria">Qtd SiAR</label>
			            <input class="form-control" type="text" id="qtdPropria" name="qtdPropria"/>
		            </div>
	            	<div class="form-group col-sm-2">
	            		<button class="btn btn-success" type="submit">submit</button>
	            	</div>
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