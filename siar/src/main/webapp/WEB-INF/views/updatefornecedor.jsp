<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<form action="/siar/fornecedores/save" method="post">
            <input type="hidden" id="id" name="id" value="${fornecedor.id}">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" value="${fornecedor.nome}"/>
            <label for="url">URL de Solicitação</label>
            <input type="text" id="url" name="urlSolicitacao" value="${fornecedor.urlSolicitacao}"/>
            
            <input type="submit" value="Alterar"/>
        </form>
	</body>
</html>