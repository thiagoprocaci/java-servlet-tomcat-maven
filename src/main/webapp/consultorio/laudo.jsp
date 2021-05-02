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
        Cadastro de Laudos
    </h1>
    <%
        String message = (String) request.getAttribute("mensagem");
        if(message != null) {
            out.println("<h2>" + message + "</h2>");
        }
    %>
    <br>
    <form method="post" action="<%=request.getContextPath()%>/laudo/cadastro">
       <div class="form-group row">
            <label for="idMedico" class="col-sm-2 col-form-label">Médico</label>
             <div>
                <select name="idMedico" id="idMedico">
                  <%
                   List<Medico> medicoList = (List<Medico>) request.getAttribute("medicoList");
                   for(Medico medico : medicoList) {
                  %>
                    <option value="<%=medico.getId()%>"><%=medico.getNome()%></option>
                  <%
                   }
                 %>
                </select>
             </div>
        </div>
        <div class="form-group row">
            <label for="idPaciente" class="col-sm-2 col-form-label">Paciente</label>
            <div>
                <select name="idPaciente" id="idPaciente">
                  <%
                   List<Paciente> pacienteList = (List<Paciente>) request.getAttribute("pacienteList");
                   for(Paciente paciente : pacienteList) {
                  %>
                    <option value="<%=paciente.getId()%>"><%=paciente.getNome()%></option>
                  <%
                   }
                 %>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="descricao" class="col-sm-2 col-form-label">Descrição</label>
            <textarea name="descricao" id="descricao"></textarea>
        </div>
        <div class="form-group">
            <input type="submit">
        </div>
    </form>


</div>


</body>
</html>