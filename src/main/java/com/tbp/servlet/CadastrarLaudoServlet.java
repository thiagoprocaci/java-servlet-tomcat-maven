package com.tbp.servlet;

import com.tbp.model.Medico;
import com.tbp.model.Paciente;
import com.tbp.service.ConsultorioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "cadastro-laudo-servlet",
        urlPatterns = "/laudo/cadastro"
)
public class CadastrarLaudoServlet extends HttpServlet {

    private ConsultorioService consultorioService = new ConsultorioService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Medico> medicoList = consultorioService.listarMedicos();
        List<Paciente> pacienteList = consultorioService.listarPacientes();
        req.setAttribute("medicoList", medicoList);
        req.setAttribute("pacienteList", pacienteList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/consultorio/laudo.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idMedico = Integer.parseInt(req.getParameter("idMedico"));
        Integer idPaciente = Integer.parseInt(req.getParameter("idPaciente"));
        String descricao = req.getParameter("descricao");
        consultorioService.salvarLaudo(idPaciente, idMedico, descricao);
        req.setAttribute("mensagem", "Laudo salvo com sucesso");

        List<Medico> medicoList = consultorioService.listarMedicos();
        List<Paciente> pacienteList = consultorioService.listarPacientes();
        req.setAttribute("medicoList", medicoList);
        req.setAttribute("pacienteList", pacienteList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/consultorio/laudo.jsp");
        requestDispatcher.forward(req, resp);
    }
}
