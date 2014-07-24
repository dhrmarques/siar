<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
	</head>
	<body>
	    <%@ include file="/WEB-INF/views/layout_header.jsp" %>

        <form action="/siar/usuariosiar/save" method="post">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome"/>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
            <label for="senha">Senha</label>
            <input type="password" id="senha" name="senha"/>
            <label for="cpf">CPF</label>
            <input type="text" id="cpf" name="cpf"/>
            <label for="tipoUsuario">Tipo de Usuário</label>
            <select id="tipoUsuario" name="tipoUsuario">
            	<option value="ADMINISTRADOR">Administrador</option>
            	<option value="COORDENADOR">Coordenador</option>
            	<option value="ESPECIALISTA">Especialista</option>
            	<option value="CHEFE_MISSAO">Chefe de Missão</option>
            </select>
            
            <input type="submit" value="Submit"/>
        </form>
 
    <table border="1">
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
                <td><a href="/siar/usuariosiar/updateusuario/${usuario.id}"><button>Update</button></a></td>
                <td><a href="/siar/usuariosiar/delete/${usuario.id}"><button>Remove</button></a></td>
            </tr>
        </c:forEach>
    </table>  
</body>
</html>