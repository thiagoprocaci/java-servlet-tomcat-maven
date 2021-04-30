<%@ page import ="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Pratos</title>

</head>
<body>
<center>
    <h1>
        Realize o cadastro do prato
    </h1>
    <%
        String message = (String) request.getAttribute("mensagem");
        if(message != null) {
            out.println("<h2>" + message + "</h2>");
        }
    %>
    <form method="post" action="<%=request.getContextPath()%>/prato">
        <br>
        Nome:
        <input type="text" name="nomePrato" >
        <br><br>
        Calorias:
        <input type="text" name="caloriasPrato" >
        <br><br>
        Ingredientes (Separados por ;):
        <input type="text" name="ingredientesPrato" >
         <br><br>

        <input type="submit" >
    </form>

</center>


</body>
</html>