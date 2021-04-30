package com.tbp.servlet;

import com.tbp.model.Prato;
import com.tbp.repository.PratoRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "listar-prato-servlet",
        urlPatterns = "/prato/listar"
)
public class ListarPratoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/prato/listar.jsp");
        PratoRepository pratoRepository = new PratoRepository();
        List<Prato> pratoList = pratoRepository.listar();
        req.setAttribute("pratoList", pratoList);
        requestDispatcher.forward(req, resp);
    }
}
