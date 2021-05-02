<%@ page import ="java.util.*" %>
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
        Cadastro de Pacientes
    </h1>
    <%
        String message = (String) request.getAttribute("mensagem");
        if(message != null) {
            out.println("<h2>" + message + "</h2>");
        }
    %>
    <br>
    <form method="post" action="<%=request.getContextPath()%>/paciente/cadastro">
        <div class="form-group row">
            <label for="nome" class="col-sm-2 col-form-label">Nome:</label>
            <div>
                <input type="text" name="nome" id="nome">
            </div>
        </div>
        <div class="form-group row">
           <label for="cpf" class="col-sm-2 col-form-label">CPF:</label>
            <div>
                <input type="text" name="cpf" id="cpf">
            </div>
        </div>
        <div class="form-group row">
          <label for="planoSaude" class="col-sm-2 col-form-label">Plano de Saúde:</label>
          <div>
             <input type="text" name="planoSaude" id="planoSaude">
          </div>
        </div>
       <div class="form-group ">
            <input type="submit">
        </div>
    </form>
</div>



</body>
</html>