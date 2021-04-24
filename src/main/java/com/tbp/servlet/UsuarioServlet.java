package com.tbp.servlet;


import com.tbp.repository.UsuarioRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@WebServlet(
        name = "usuario-servlet",
        urlPatterns = "/usuario"
)
public class UsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mensagem", "");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/usuario/formulario.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String nome = req.getParameter("nome");
       req.setAttribute("usuario", nome);

       // validando nome
       if(nome == null || nome.trim().length() == 0) {
           RequestDispatcher requestDispatcher = req.getRequestDispatcher("/usuario/formulario.jsp");
           req.setAttribute("mensagem", "Nome inválido.");
           requestDispatcher.forward(req, resp);
       } else {
           UsuarioRepository usuarioRepository = new UsuarioRepository();
           usuarioRepository.salvar(nome);

           DateFormat dateFormat = DateFormat.getDateInstance();
           String data = dateFormat.format(new Date());
           req.setAttribute("data", data);
           RequestDispatcher requestDispatcher = req.getRequestDispatcher("/usuario/apresentacao.jsp");
           requestDispatcher.forward(req, resp);
       }
    }
}
