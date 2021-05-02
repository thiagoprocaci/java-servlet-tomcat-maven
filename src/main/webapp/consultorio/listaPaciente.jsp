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
        Lista de Pacientes
    </h1>
    <table>
        <tr>
            <th>Nome</th>
            <th>Laudos</th>
        </tr>
     <%
       List<Paciente> pacienteList = (List<Paciente>) request.getAttribute("pacienteList");
       for(Paciente paciente : pacienteList) {
      %>
        <tr>
            <td><%=paciente.getNome()%></td>
            <td><a href="<%=request.getContextPath()%>/laudo/listar?idPaciente=<%=paciente.getId()%>">Ver Laudos</a></td>
        </tr>
      <%
       }
     %>
    </table>

</center>


</body>
</html>