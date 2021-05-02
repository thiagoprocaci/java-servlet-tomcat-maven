<%@ page import ="java.util.*" %>
<%@ page import ="com.tbp.model.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consultório</title>
</head>
<body>
<center>
    <h1>
        <%
            Paciente paciente = (Paciente) request.getAttribute("paciente");
        %>
        Laudos do Paciente <%=paciente.getNome()%>
    </h1>
    <table>
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

</center>


</body>
</html>