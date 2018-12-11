package com.tbp.servlet;

import com.tbp.service.LiquorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "select-liquor-servlet",
        urlPatterns = "/liquor/SelectLiquor"
)
public class SelectLiquorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/liquor/select.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String liquorType = req.getParameter("Type");
        LiquorService liquorService = new LiquorService();

        List<String> liquorBrands = liquorService.getAvaliableBrands(liquorType);
        req.setAttribute("brands", liquorBrands);
        RequestDispatcher view = req.getRequestDispatcher("/liquor/list.jsp");
        view.forward(req, resp);
    }
}
