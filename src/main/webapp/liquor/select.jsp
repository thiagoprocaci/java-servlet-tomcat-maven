<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liquor Store</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>
        Select the type of Liquor
    </h1>
    <form method="post" action="<%=request.getContextPath()%>/liquor/SelectLiquor">
        <select name="Type" size="1" >
            <%
              List<String> result = (List<String>) request.getAttribute("types");
              for(String type : result) {
                out.println("<option>" + type + "</option>");
              }
            %>
        </select>
        <br><br>
        <input type="submit" class="btn btn-sm btn-success" >
    </form>

</center>


</body>
</html>