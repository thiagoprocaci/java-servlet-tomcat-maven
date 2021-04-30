<%@ page import ="java.util.*" %>
<%@ page import ="com.tbp.model.Prato" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Pratos do cardapio
    </h1>
    <%
        List<Prato> result = (List<Prato>) request.getAttribute("pratoList");
        Iterator it = result.iterator();
        out.println("<br>Temos os pratos <br><br>");
        while(it.hasNext()) {
            out.println(it.next() + "<br>");
        }
    %>

</center>

</body>
</html>