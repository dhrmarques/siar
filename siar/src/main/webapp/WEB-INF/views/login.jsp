<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
		<style>
			input.form-control {
				font-weight:normal;
			}
		</style>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layout_header.jsp" %>
		
		<div id="login_container">
			<div id="login_warning" class="well" style="visibility:${show_box};">
				${box_text}
			</div>
			<form action="login" method="POST" class="well" style="margin:30px;">
				<div class="form-group">
					<label for="login_email">email:</label>
					<input id="login_email" type="text" name="login_email" class="form-control" value="${email}"/>
				</div>
				<div class="form-group">
					<label for="login_email">senha:</label>
					<input id="login_password" type="password" name="login_password" class="form-control"/>
				</div>
				<input type="submit" value="Login" class="btn btn-default"/>
			</form>
		</div>
	
	</body>
</html>
