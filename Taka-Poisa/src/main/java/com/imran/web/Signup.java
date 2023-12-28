package com.imran.web;

import com.imran.repositories.JdbcUserRepo;
import com.imran.service.UserService;
import com.imran.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class Signup extends HttpServlet {
    private final static Logger LOGGER
            = LoggerFactory.getLogger(Signup.class);
    private UserService userService
            = new UserServiceImpl(new JdbcUserRepo());
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/signup.jsp");
        rd.forward(req,resp);
    }
}
