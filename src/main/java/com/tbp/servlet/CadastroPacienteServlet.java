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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
