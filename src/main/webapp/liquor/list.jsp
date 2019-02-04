<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liquor Store</title>
     <link rel="stylesheet" href="estilos.css">
</head>
<body>
<center>
<h1>
    Available Brands
</h1>
    <%
    List result= (List) request.getAttribute("brands");
    Iterator it = result.iterator();
    out.println("<br>We have <br><br>");
    while(it.hasNext()){
        out.println(it.next()+"<br>");
    }
    %>
</center>
</body>
</html>