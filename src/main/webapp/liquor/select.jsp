<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liquor Store</title>
</head>
<body>
<center>
    <h1>
        Select the type of Liquor
    </h1>
    <form method="post" action="<%=request.getContextPath()%>/liquor/SelectLiquor">
       <br>
        <select name="Type" size="1">
          <%
           List<String> result = (List<String>) request.getAttribute("types");
           for(String type : result) {
             out.println("<option>" + type + "</option>");
           }

           %>

        </select>
        <br><br>
        <input type="submit">
    </form>
</center>


</body>
</html>