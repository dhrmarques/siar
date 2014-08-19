<%@ include file="/WEB-INF/views/headers.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/views/include_head.jsp" %>
		<style>
			div#cameras_container {margin:50px;}
			div#cameras_container iframe {margin:10px;display:inline-block;}
		</style>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
	
		<div class="well" id="cameras_container">
			<iframe width="250" height="190" src="http://www.vejoaovivo.com.br/embed/sp/sao-paulo/transito-av-paulista?type_embed=camera"></iframe>
			<iframe width="250" height="190" src="http://www.vejoaovivo.com.br/embed/sp/sao-paulo/rua-santa-efigenia-221-centro?type_embed=camera"></iframe>
			<iframe width="250" height="190" src="http://www.vejoaovivo.com.br/embed/sp/sao-paulo/rua-da-consolacao-2418?type_embed=camera"></iframe>
			<iframe width="250" height="190" src="http://www.vejoaovivo.com.br/embed/sp/sao-paulo/rua-da-consolacao-825?type_embed=camera"></iframe>
			<iframe width="250" height="190" src="http://www.vejoaovivo.com.br/embed/sp/sao-paulo/av-brigadeiro-luiz-antonio-273?type_embed=camera"></iframe>
			<iframe width="250" height="190" src="http://www.vejoaovivo.com.br/embed/sp/sao-paulo/av-nove-de-julho-3110?type_embed=camera"></iframe>
			<iframe width="250" height="190" src="http://www.vejoaovivo.com.br/embed/sp/sao-paulo/marginal-direita-tiete-952?type_embed=camera"></iframe>
			<iframe width="250" height="190" src="http://www.vejoaovivo.com.br/embed/sp/sao-paulo/elevado-costa-e-silva?type_embed=camera"></iframe>
			<iframe width="250" height="190" src="http://www.vejoaovivo.com.br/embed/sp/sao-paulo/av-ipiranga-esquina-com-av-sao-joao?type_embed=camera"></iframe>
			<iframe width="250" height="190" src="http://www.vejoaovivo.com.br/embed/sp/sao-paulo/avenida-dos-bandeirantes-549?type_embed=camera"></iframe>
		</div>
	</body>
</html>