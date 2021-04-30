package com.tbp.servlet;

import com.tbp.exception.PratoException;
import com.tbp.repository.PratoRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "prato-servlet",
        urlPatterns = "/prato"
)
public class PratoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/prato/save.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nomePrato");
        String calorias = req.getParameter("caloriasPrato");
        String ingredientes = req.getParameter("ingredientesPrato");

        PratoRepository pratoRepository = new PratoRepository();
        String mensagem;
        try {
            pratoRepository.salvar(nome, calorias, ingredientes);
            mensagem = "Prato " + nome + " salvo com sucesso.";
        } catch (PratoException e) {
            mensagem = e.getMessage();
        }
        req.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/prato/save.jsp");
        requestDispatcher.forward(req, resp);

    }
}
