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
           List result = (List) request.getAttribute("types");
           Iterator it = result.iterator();
            while(it.hasNext()){
                    out.println("<option>" + it.next() + "</option>");
            }

           %>

        </select>
        <br><br>
        <input type="submit">
    </form>
</center>


</body>
</html>