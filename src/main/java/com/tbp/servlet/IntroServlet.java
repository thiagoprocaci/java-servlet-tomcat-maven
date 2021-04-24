package com.tbp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "intro-servlet",
        urlPatterns = "/intro"
)
public class IntroServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // imprime o html na tela
        PrintWriter writer = resp.getWriter();
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html>");
        buffer.append("<body>");
        buffer.append("<h1>");
        buffer.append("Meu primeiro servlet");
        buffer.append("</h1>");
        buffer.append("</body>");
        buffer.append("</html>");
        writer.println(buffer.toString());

    }
}
