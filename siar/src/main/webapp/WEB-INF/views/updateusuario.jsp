<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<body>
		<h2>Editar Usuário</h2>
		
		<form action="/siar/usuariosiar/save" method="post">
            <input type="hidden" id="id" name="id" value="${usuarioUpdate.id}">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" value="${usuarioUpdate.nome}"/>
            <label for="cpf">CPF</label>
            <input type="text" id="cpf" name="cpf" value="${usuarioUpdate.cpf}"/>
            
            <label for="tipoUsuario">Tipo de Usuário</label>
            <select id="tipoUsuario" name="tipoUsuario">
            	<option value="ADMINISTRADOR" ${usuarioUpdate.tipoUsuario == 'ADMINISTRADOR' ? 'selected="selected"' : ""}>Administrador</option>
            	<option value="COORDENADOR" ${usuarioUpdate.tipoUsuario == 'COORDENADOR' ? 'selected="selected"' : ""}>Coordenador</option>
            	<option value="ESPECIALISTA" ${usuarioUpdate.tipoUsuario == 'ESPECIALISTA' ? 'selected="selected"' : ""}>Especialista</option>
            	<option value="CHEFE_MISSAO" ${usuarioUpdate.tipoUsuario == 'CHEFE_MISSAO' ? 'selected="selected"' : ""}>Chefe de Missão</option>
            </select>
            
            <input type="submit" value="Submit"/>
        </form>
	</body>
</html>