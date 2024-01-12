package com.imran.web;

import com.imran.repositories.JdbcUserRepo;
import com.imran.service.UserService;
import com.imran.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(Logout.class);
    private UserService userService
            = new UserServiceImpl(new JdbcUserRepo());

    /**
     *<p>I am using {@link javax.servlet.http.HttpServlet#doGet(HttpServletRequest, HttpServletResponse)} method instead of
     *{@link javax.servlet.http.HttpServlet#doGet(HttpServletRequest, HttpServletResponse)}
     *</p>
     *
     * @see HttpServlet#doPost(HttpServletRequest, HttpServletResponse)
     *
     */
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        LOGGER.info("Logging out");
        userService.logout(req);
        resp.sendRedirect("/login?logout=true");
    }
}
