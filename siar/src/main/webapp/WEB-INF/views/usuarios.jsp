<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/lista.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/components.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
		<div id="error-container" class="well ${cls}">${box_text}</div>
	    <%@ include file="/WEB-INF/views/layout_header.jsp" %>

		<div class="col-sm-12">
			<div class="one-liner-form">
		        <form class="form-inline" action="/siar/usuarios/save" method="post">
		        	<div class="form-group">
			            <input placeholder="Nome" class="form-control" type="text" id="nome" name="nome"/>
		            </div>
		            <div class="form-group">
			            <input placeholder="Email" class="form-control" type="text" id="email" name="email"/>
		            </div>
		            <div class="form-group">
			            <input placeholder="Senha" class="form-control" type="password" id="senha" name="senha"/>
		            </div>
		            <div class="form-group">
			            <input placeholder="CPF" class="form-control" type="text" id="cpf" name="cpf"/>
		            </div>
		            <div class="form-group">
			            <select class="form-control" id="tipoUsuario" name="tipoUsuario">
			            	<option value="ADMINISTRADOR">Administrador</option>
			            	<option value="COORDENADOR">Coordenador</option>
			            	<option value="ESPECIALISTA">Especialista</option>
			            	<option value="CHEFE_MISSAO">Chefe de Missão</option>
			            </select>
		            </div>
		            
		            <input class="btn btn-success" type="submit" value="Submit"/>
		        </form>
			</div>
		</div> 
	<div class="col-sm-12">
	    <table class="table table-condensed">
	        <tr>
	            <th>Nome</th>
	            <th>Email</th>
	            <th>CPF</th>
	            <th>Tipo de Usuário</th>
	            <th>Atualizar</th>
	            <th>Remover</th>
	        </tr>
	        <c:forEach var="usuario" items="${usuarioSiarList}">
	            <tr>
	                <td>${usuario.nome}</td>
	                <td>${usuario.email}</td>
	                <td>${usuario.cpf}</td>
	                <td>${usuario.tipoUsuario}</td>
	                <td><a href="/siar/usuarios/update/${usuario.id}"><button class="btn btn-warning">Update</button></a></td>
	                <td><a href="/siar/usuarios/delete/${usuario.id}"><button class="btn">Remove</button></a></td>
	            </tr>
	        </c:forEach>
	    </table>  
	</div>
</body>
</html>