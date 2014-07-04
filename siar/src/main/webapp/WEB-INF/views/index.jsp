<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
<head>
	<title>Index</title>
</head>
	<body>
		<h1>
			List of friends that came today  
		</h1>
		<c:if test="${friend eq null}">
			<p>There are no friends in your list!</p>
		</c:if>
		<p><c:out value="${friend}"/></p>
		<p>Have a nice day!</p>
	</body>
</html>