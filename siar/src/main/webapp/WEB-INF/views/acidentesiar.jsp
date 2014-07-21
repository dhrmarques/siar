<%@ include file="/WEB-INF/views/headers.jsp" %>
<html>
<body>
    <h2>Acidentes - Siar v.0.1</h2>
 
        <form action="/siar/acidentesiar/save" method="post">
            <label for="descricao">Descrição</label>
            <input type="text" id="descricao" name="descricao"/>
            <label for="prioridade">Prioridade</label>
            <input type="text" id="prioridade" name="prioridade"/>
            
            <input type="submit" value="Submit"/>
        </form>
 
    <table border="2">
        <tr>
            <th>Descrição</th>
            <th>Prioridade</th>
            <th>Atualizar</th>
            <th>Remover</th>
        </tr>
        <c:forEach var="acidente" items="${acidenteSiarList}">
            <tr>
                <td>${acidente.descricao}</td>
                <td>${acidente.prioridade}</td>
                <td><a href="/siar/acidentesiar/updateacidente/${acidente.id}"><button>Update</button></a></td>
                <td><a href="/siar/acidentesiar/delete/${acidente.id}"><button>Remove</button></a></td>
            </tr>
        </c:forEach>
    </table>  
</body>
</html>