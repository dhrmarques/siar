<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
<body>
    <h2>Acidentes - Siar v.0.1</h2>
 
        <form action="/siar/acidentesiar/save" method="post">
            <label for="descricao">Descri��o</label>
            <input type="text" id="descricao" name="descricao"/>
                        <label for="prioridade">Prioridade</label>
            <input type="text" id="prioridade" name="prioridade"/>
            
            <input type="submit" value="Submit"/>
        </form>
 
    <table border="2">
        <c:forEach var="acidente" items="${acidenteSiarList}">
            <tr>
                <td>${acidente.descricao}</td>
                <td>${acidente.prioridade}</td>
                
            </tr>
        </c:forEach>
    </table>  
</body>
</html>