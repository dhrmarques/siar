<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/lista.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/components.css" />" rel="stylesheet">
		<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
		<script src="<c:url value="/resources/js/error.js" />"></script>
		<style type="text/css">
		</style>
		<title>${title}</title>
	</head>
	
	<body>
		<div id="error-container" class="well">${box_text}</div>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
	    
	    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
			new
		</button>

 		<div class="col-sm-12 modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 			<div class="modal-dialog new-acidente-form">
 				<div class="modal-content">
 					<div class="modal-header">
 					</div>
 					<div class="modal-body">
				        <form action="/siar/acidentes/save" method="post" role="form">
							<div>
								<div class="row">
									<div class="col-sm-12">
							        	<div class="form-group">
								            <label for="descricao">Descrição</label>
								            <input class="form-control" type="text" id="descricao" name="descricao"/>
							            </div>
							         
							            <div class="form-group">
								            <label for="prioridade">Prioridade</label>
								            <select class="form-control" id="prioridade" name="prioridade">
								            	<option>Muito Grave</option>
								            	<option>Grave</option>
								            	<option>Média</option>
								            	<option>Baixa</option>
								           </select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-4">
						            	<div class="form-group">
						            		<button class="btn btn-success" type="submit">submit</button>
						            	</div>
					            	</div>
					    		</div>
				    		</div>
				    	</form>
	    			</div>
	    			<div class="modal-footer">
	    			</div>
	    		</div>
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