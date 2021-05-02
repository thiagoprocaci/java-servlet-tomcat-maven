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
        Lista de Pacientes
    </h1>
    <br>
    <table class="table">
        <tr>
            <th>Nome do Paciente</th>
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

</div>


</body>
</html>