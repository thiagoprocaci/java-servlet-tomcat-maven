<%@ page import ="java.util.*" %>
<%@ page import ="com.tbp.model.Usuario" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <body>

        <h2>Lista de Usuários</h2>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarioList");
            for(Usuario u : usuarios) {
                out.println(u.getNome() + "<br><br>");
            }

        %>

    </body>
</html>