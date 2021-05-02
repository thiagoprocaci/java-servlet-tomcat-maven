<%@ page import ="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Consultório</title>
</head>
<body>
<center>
    <h1>
        Cadastro de Médicos
    </h1>
    <%
        String message = (String) request.getAttribute("mensagem");
        if(message != null) {
            out.println("<h2>" + message + "</h2>");
        }
    %>

    <form method="post" action="<%=request.getContextPath()%>/medico/cadastro">
        <br>
        Nome:
        <input type="text" name="nome" >
        <br> <br>
        CPF:
        <input type="text" name="cpf" >
        <br><br>
        CRM:
        <input type="text" name="crm" >
        <br><br>

        <input type="submit">
    </form>

</center>


</body>
</html>