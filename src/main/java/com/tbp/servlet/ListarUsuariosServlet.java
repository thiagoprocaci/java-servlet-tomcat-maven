package com.tbp.servlet;

import com.tbp.model.Usuario;
import com.tbp.repository.UsuarioRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "listar-servlet",
        urlPatterns = "/listar"
)
public class ListarUsuariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        List<Usuario> usuarioList = usuarioRepository.listar();
        req.setAttribute("usuarioList", usuarioList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/usuario/listar.jsp");
        requestDispatcher.forward(req, resp);
    }
}
