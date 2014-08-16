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
		<div id="error-container" class="well ${cls}">${box_text}</div>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<div class="form-group col-sm-12" style="margin-top:15px;">
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
				Cadastrar acidente
			</button>
		</div>

		<div class="col-sm-12 modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
			<div class="modal-dialog new-acidente-form">
				<div class="modal-content">
					<div class="modal-header">
					</div>
					<div class="modal-body">
						<form action="/siar/acidentes/save" method="post" role="form">
						
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<label for="descricao">Descrição</label>
										<input class="form-control" type="text" id="descricao" name="descricao"/>
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
										<input class="form-control" type="text" id="latitude" name="latitude" placeholder="-23.4567"/>
									</div>
									<div class="form-group">
										<label for="longitude">Longitude</label>
										<input class="form-control" type="text" id="longitude" name="longitude" placeholder="-46.8024"/>
									</div>
									<div class="form-group">
										<label for="logradouro">Logradouro</label>
										<input class="form-control" type="text" id="logradouro" name="logradouro" placeholder="R. das Avenidas"/>
									</div>
									<div class="form-group">
										<label for="numero">Nº</label>
										<input class="form-control" type="text" id="numero" name="numero" placeholder="1234"/>
									</div>
									<div class="form-group">
										<label for="referencia">Referência</label>
										<input class="form-control" type="text" id="referencia" name="referencia" placeholder="Em frente à praça"/>
									</div>
									<div class="form-group">
										<label for="cidade">Cidade</label>
										<input class="form-control" type="text" id="cidade" name="cidade" placeholder="São Paulo"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<button class="btn btn-success" type="submit">Criar</button>
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
					<th>Local</th>
					<th>Atualizar</th>
					<th>Remover</th>
				</tr>
			<c:forEach var="acidente" items="${acidenteSiarList}">
				<tr>
						<td><span>${acidente.descricao}</span></td>
						<td><span>${acidente.prioridade.desc}</span></td>
						<td><span>${acidente.localResumido}</span></td>
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