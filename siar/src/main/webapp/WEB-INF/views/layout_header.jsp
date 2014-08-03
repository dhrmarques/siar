<div id="header_container">
	<div id="header_left">
		<div id="header_logo"><img src="https://c1.staticflickr.com/1/32/99786897_d5cec91880.jpg"/></div>
		<div id="header_title">${title}</div>
	</div>
	<div id="header_right" style="display:${hide_header_right == true ? 'none' : 'block'};">
		<b>${nome}</b><br/>
		${tipo_usuario.desc}<br/>
		<a href="/siar/logout">Logout</a>
	</div>
</div>
<div id="link_list_container" class="col-sm-12">
	<ul class="menu nav nav-tabs">
	<c:forEach var="link" items="${linklist}">
		<li class="${link.path == active_path ? 'active' : ''}"><a href="/siar${link.path}">${link.label}</a></li>
	</c:forEach>
	</ul>
</div>