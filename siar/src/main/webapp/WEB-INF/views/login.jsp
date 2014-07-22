<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<title>${title}</title>
		<style>
			input.form-control {
				font-weight:normal;
			}
		</style>
	</head>
	<body>
		
		<div style="text-align:center;">
			<div class="well" style="visibility:${show_box}; border-color:red;">
				${box_text}
			</div>
			<form action="login" method="POST" class="well" style="margin:30px;">
				<div class="form-group">
					<label>email: <input type="text" name="login_email" class="form-control" value="${email}"/></label>
				</div>
				<div class="form-group">
					<label>senha: <input type="password" name="login_password" class="form-control"/></label>
				</div>
				<input type="submit" value="OK" class="btn btn-default"/>
			</form>
		</div>
	
	</body>
</html>
