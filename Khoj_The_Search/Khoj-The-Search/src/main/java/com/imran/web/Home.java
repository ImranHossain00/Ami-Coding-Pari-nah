package com.imran.web;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/home.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        var temperature = req.getParameter("temperature");
        if (temperature != null && temperature.length() > 0) {
            double temInC = Double.parseDouble(temperature);
            double temInF = (temInC * 9 / 5) + 32;

            req.setAttribute("ans", temInF);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/result.jsp");
        rd.forward(req, resp);
    }
}
