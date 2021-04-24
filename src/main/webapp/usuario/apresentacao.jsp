<%@ page import ="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <body>

        <h2>Bom dia <%= request.getAttribute("usuario") %>. Hoje é <%= request.getAttribute("data") %>.</h2>

        <br>

        <a href="<%=request.getContextPath()%>/usuario">Voltar</a>
    </body>
</html>