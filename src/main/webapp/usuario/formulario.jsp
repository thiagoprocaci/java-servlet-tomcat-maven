<%@ page import ="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <body>

        <h2>Preencha os seus dados</h2>
        <h3><%=request.getAttribute("mensagem")%></h3>

        <form action="<%=request.getContextPath()%>/usuario" method="post">
            <label for="nome">Nome:</label><br>
            <input type="text" id="nome" name="nome" value=""><br><br>
            <input type="submit" value="Enviar">
        </form>

    </body>
</html>