package com.tbp.servlet;

import com.tbp.service.LiquorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        name = "save-liquor-servlet",
        urlPatterns = "/liquor/SaveLiquor"
)
public class SaveLiquorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/liquor/save.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("newType");
        String brand = req.getParameter("newBrand");
        LiquorService liquorService = new LiquorService();
        liquorService.saveLiquor(type, brand);
        req.setAttribute("successMessage", "Type " + type + " saved!" );
        req.getRequestDispatcher("/liquor/save.jsp").forward(req, resp);
    }
}
