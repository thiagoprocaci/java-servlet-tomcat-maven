<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
       Menu
       <br><br>
       <a href="<%=request.getContextPath()%>/medico/cadastro">Cadastro de Médico</a>
       <br><br>
       <a href="<%=request.getContextPath()%>/paciente/cadastro">Cadastro de Paciente</a>
       <br><br>
       <a href="<%=request.getContextPath()%>/laudo/cadastro">Cadastro de Laudo</a>
       <br><br>
       <a href="<%=request.getContextPath()%>/paciente/listar">Listar Pacientes</a>
    </body>
</html>