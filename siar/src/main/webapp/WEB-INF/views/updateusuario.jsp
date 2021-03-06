<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<form action="/siar/usuarios/save" method="post">
            <input type="hidden" id="id" name="id" value="${usuarioUpdate.id}">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" value="${usuarioUpdate.nome}"/>
            <label for="email">Email</label>
            <input type="text" id="email" name="email" value="${usuarioUpdate.email}"/>
            <label for="cpf">CPF</label>
            <input type="text" id="cpf" name="cpf" value="${usuarioUpdate.cpf}"/>
            <label for="senha">Senha</label>
            <input type="text" id="senha" name="senha" value="${usuarioUpdate.senha}"/>
            
            <label for="tipoUsuario">Tipo de Usu�rio</label>
            <select id="tipoUsuario" name="tipoUsuario">
            	<option value="ADMINISTRADOR" ${usuarioUpdate.tipoUsuario == 'ADMINISTRADOR' ? 'selected="selected"' : ""}>Administrador</option>
            	<option value="COORDENADOR" ${usuarioUpdate.tipoUsuario == 'COORDENADOR' ? 'selected="selected"' : ""}>Coordenador</option>
            	<option value="ESPECIALISTA" ${usuarioUpdate.tipoUsuario == 'ESPECIALISTA' ? 'selected="selected"' : ""}>Especialista</option>
            	<option value="CHEFE_MISSAO" ${usuarioUpdate.tipoUsuario == 'CHEFE_MISSAO' ? 'selected="selected"' : ""}>Chefe de Miss�o</option>
            </select>
            
            <input type="submit" value="Submit"/>
        </form>
	</body>
</html>