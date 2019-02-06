package com.tbp.servlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "save-food-servlet",
        urlPatterns = "/food/SaveFood"
)
public class FoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/food/save.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String foodName = req.getParameter("foodName");
        String foodCalories = req.getParameter("foodCalories");
        String foodIngredients = req.getParameter("foodIngredients");
        req.setAttribute("successMessage", "The food " + foodName + " with " + foodCalories + " calories was saved. Ingredients: " + foodIngredients );
        req.getRequestDispatcher("/food/save.jsp").forward(req, resp);
    }


}
