<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
		<link href="<c:url value="/resources/css/components.css" />" rel="stylesheet">
		<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="<c:url value="/resources/js/error.js" />"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		<div class="container">
			
		<div class="col-sm-12" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
			<div>
				<div class="modal-content">
					<div class="modal-header">
					</div>
					<div class="modal-body">
						<form action="/siar/acidentes/save" method="post" role="form">
							<input type="hidden" id="id" name="id" value="${acidenteUpdate.getId()}">
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<label for="descricao">Descrição</label>
										<input class="form-control" type="text" id="descricao" name="descricao" value="${acidenteUpdate.getDescricao()}"/>
									</div>
									<div class="form-group">
										<label for="prioridade">Prioridade</label>
										<select class="form-control" id="prioridade" name="prioridade">
											<c:forEach var="prioridade" items="${prioridadesList}">
												<option value="${prioridade}">${prioridade.desc}</option>
											</c:forEach>
										</select>
									</div>
									<h2>Local do acidente</h2>
									<div class="form-group">
										<label for="latitude">Latitude</label>
										<input class="form-control" type="text" id="latitude" name="latitude" placeholder="-23.4567" value="${acidenteUpdate.getLatitude()}" />
									</div>
									<div class="form-group">
										<label for="longitude">Longitude</label>
										<input class="form-control" type="text" id="longitude" name="longitude" placeholder="-46.8024" value="${acidenteUpdate.getLongitude()}"/>
									</div>
									<div class="form-group">
										<label for="logradouro">Logradouro</label>
										<input class="form-control" type="text" id="logradouro" name="logradouro" placeholder="R. das Avenidas" value="${acidenteUpdate.getLogradouro()}"/>
									</div>
									<div class="form-group">
										<label for="numero">Nº</label>
										<input class="form-control" type="text" id="numero" name="numero" placeholder="1234" value="${acidenteUpdate.getNumero()}"/>
									</div>
									<div class="form-group">
										<label for="referencia">Referência</label>
										<input class="form-control" type="text" id="referencia" name="referencia" placeholder="Em frente à praça" value="${acidenteUpdate.getReferencia()}"/>
									</div>
									<div class="form-group">
										<label for="cidade">Cidade</label>
										<input class="form-control" type="text" id="cidade" name="cidade" placeholder="São Paulo" value="${acidenteUpdate.getCidade()}"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<input class="btn btn-success" type="submit" value="Criar"/>
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
        </div>
	</body>
</html>