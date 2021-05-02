<%@ page import ="java.util.*" %>
<%@ page import ="com.tbp.model.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Consultório</title>
</head>
<body>
<div class="container p-3">
    <h1>
        <%
            Paciente paciente = (Paciente) request.getAttribute("paciente");
        %>
        Laudos do Paciente <%=paciente.getNome()%>
    </h1>
    <br>
    <table class="table">
        <tr>
            <th>Médico</th>
            <th>Descrição</th>
        </tr>
     <%
       List<Laudo> laudoList = paciente.getLaudoList() ;
       for(Laudo laudo : laudoList) {
      %>
        <tr>
            <td><%=laudo.getMedico().getNome()%></td>
            <td><%=laudo.getDescricao()%></td>

        </tr>
      <%
       }
     %>
    </table>

</div>


</body>
</html>