<%@ page import ="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liquor Store</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
<center>
    <h1>
        Inserting New Liquor
    </h1>
    <%
        String message = (String) request.getAttribute("sucessMessage");
        if(message != null) {
            out.println("<h2>" + message + "</h2>");
        }
    %>
    <form method="post" action="<%=request.getContextPath()%>/liquor/SaveLiquor">
        <br>
        Type:
        <input type="text" name="newType" >
        <br><br>
        Brand:
        <input type="text" name="newBrand" >
        <br><br>
        <input type="submit" >
    </form>

</center>


</body>
</html>