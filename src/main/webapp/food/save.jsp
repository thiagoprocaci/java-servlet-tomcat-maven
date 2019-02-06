<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liquor Store</title>
    <link rel="stylesheet" href="../liquor/estilos.css">
</head>
<body>
<center>
    <h1>
        Inserting New Food
    </h1>
      <%
           String message = (String) request.getAttribute("successMessage");
           if(message != null) {
            out.println("<h2>" + message + "</h2>");
           }
       %>

    <form method="post" action="<%=request.getContextPath()%>/food/SaveFood">
        <br>
        Name:
        <input type="text" name="foodName" >
        <br> <br>
        Calories:
        <input type="number" name="foodCalories" >
        <br><br>
        Ingredients:
        <input type="text" name="foodIngredients" >
         <br><br>
        <input type="submit">
    </form>
    <br><br>

</center>


</body>
</html>