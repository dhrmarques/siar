<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>${title}</title>
	</head>
	<body>
		<h1>Login</h1>
		
		<form action="login" method="POST">
			<p>
				<label>email: <input type="text" name="login_email"/></label>
			</p>
			<p>
				<label>senha: <input type="password" name="login_password"/></label>
			</p>
			<input type="submit" value="OK"/>
		</form>
	
	</body>
</html>
