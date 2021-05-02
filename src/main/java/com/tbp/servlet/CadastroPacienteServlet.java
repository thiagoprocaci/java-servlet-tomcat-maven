package com.tbp.servlet;

import com.tbp.service.ConsultorioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "cadastro-paciente-servlet",
        urlPatterns = "/paciente/cadastro"
)
public class CadastroPacienteServlet extends HttpServlet {

    private ConsultorioService consultorioService = new ConsultorioService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/consultorio/paciente.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("cpf");
        String nome = req.getParameter("nome");
        String planoSaude = req.getParameter("planoSaude");
        consultorioService.salvarPaciente(cpf, nome, planoSaude);
        req.setAttribute("mensagem", "Paciente salvo com sucesso");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/consultorio/paciente.jsp");
        requestDispatcher.forward(req, resp);
    }
}
