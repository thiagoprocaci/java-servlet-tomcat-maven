package com.tbp.servlet;

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
        name = "listar-paciente-servlet",
        urlPatterns = "/paciente/listar"
)
public class ListarPacienteServlet extends HttpServlet {

    private ConsultorioService consultorioService = new ConsultorioService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Paciente> pacienteList = consultorioService.listarPacientes();
        req.setAttribute("pacienteList", pacienteList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/consultorio/listaPaciente.jsp");
        requestDispatcher.forward(req, resp);
    }
}
