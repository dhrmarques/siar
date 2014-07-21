<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
<body>
    <h2>Usuários - Siar v.0.2</h2>
 
        <form action="/siar/usuariosiar/save" method="post">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome"/>
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
            <th>CPF</th>
            <th>Tipo de Usuário</th>
            <th>Atualizar</th>
            <th>Remover</th>
        </tr>
        <c:forEach var="usuario" items="${usuarioSiarList}">
            <tr>
                <td>${usuario.nome}</td>
                <td>${usuario.cpf}</td>
                <td>${usuario.tipoUsuario}</td>
                <td><a href="/siar/usuariosiar/updateusuario/${usuario.id}"><button>Update</button></a></td>
                <td><a href="/siar/usuariosiar/delete/${usuario.id}"><button>Remove</button></a></td>
            </tr>
        </c:forEach>
    </table>  
</body>
</html>