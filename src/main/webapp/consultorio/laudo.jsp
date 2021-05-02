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
        Cadastro de Laudos
    </h1>
    <%
        String message = (String) request.getAttribute("mensagem");
        if(message != null) {
            out.println("<h2>" + message + "</h2>");
        }
    %>
    <form method="post" action="<%=request.getContextPath()%>/laudo/cadastro">
       <br>
        <select name="idMedico">
          <%
           List<Medico> medicoList = (List<Medico>) request.getAttribute("medicoList");
           for(Medico medico : medicoList) {
          %>
            <option value="<%=medico.getId()%>"><%=medico.getNome()%></option>
          <%
           }
         %>
        </select>
        <br><br>
        <select name="idPaciente">
          <%
           List<Paciente> pacienteList = (List<Paciente>) request.getAttribute("pacienteList");
           for(Paciente paciente : pacienteList) {
          %>
            <option value="<%=paciente.getId()%>"><%=paciente.getNome()%></option>
          <%
           }
         %>
        </select>
        <br><br>
        <textarea name="descricao"  rows="5" cols="33"></textarea>
         <br><br>
        <input type="submit">
    </form>


</center>


</body>
</html>