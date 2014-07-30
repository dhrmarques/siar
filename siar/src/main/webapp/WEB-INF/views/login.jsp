<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/components.css" />" rel="stylesheet">
		<title>${title}</title>
		<style>
			input.form-control {
				font-weight:normal;
			}
		</style>
	</head>
	<body>
		<div class="container">
		
		<div id="login_container">
			<div id="login_warning" class="well" style="visibility:${show_box};">
				${box_text}
			</div>
			<div class="row">
			
			<form action="login" method="POST" class="well" style="margin:30px;">
				<h1 class="title">Login</h1>
				<div class="line-break"></div>
				<div class="form-group">
					<input placeholder="Email" id="login_email" type="text" name="login_email" class="form-control" value="${email}"/>
				</div>
				<div class="form-group">
					<input placeholder="Senha" id="login_password" type="password" name="login_password" class="form-control"/>
				</div>
				<input type="submit" value="Login" class="btn btn-default btn-primary"/>
			</form>
			</div>
		</div>
		</div>
	</body>
</html>
