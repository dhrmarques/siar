<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		<div class="col-sm-12">
			<form class="form-inline one-liner-form" action="/siar/recursos/save" method="post">
	            <input type="hidden" id="id" name="id" value="${recursoUpdate.id}">
	            <div class="form-group">
		            <label for="nome">Nome</label>
		            <input class="form-control" type="text" id="nome" name="nome" value="${recursoUpdate.nome}"/>
	            </div>
	            <div class="form-group">
		            <label for="descricao">Descrição</label>
		            <input class="form-control" type="text" id="descricao" name="descricao" value="${recursoUpdate.descricao}"/>
	           	</div>
	           	<div class="form-group">
		            <label for="recursoHumano">RH?</label>
					<input type="checkbox" id="recursoHumano" name="recursoHumano"/>
	            </div>
	            <div class="form-group">
	            	<label for="qtdPropria">Quantidade</label>
		            <select class="form-control" id="qtdPropria" name="qtdPropria">
						<option clas="selected">${recursoUpdate.qtdPropria}</option>
						<c:forEach var="i" begin="1" end="20">
				  			<option><c:out value="${i}"/></option>
						</c:forEach>
			        </select>
	            </div>
	            <input class="btn btn-default btn-success" type="submit" value="Submit"/>
	        </form>
        </div>
	</body>
</html>