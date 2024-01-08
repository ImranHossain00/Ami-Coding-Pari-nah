package com.imran.web;

import com.imran.dto.LoginDTO;
import com.imran.exceptions.UserNotFoundException;
import com.imran.repositories.JdbcUserRepo;
import com.imran.service.UserService;
import com.imran.service.UserServiceImpl;
import com.imran.util.SecurityContext;
import com.imran.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {

    private final static Logger LOGGER
            = LoggerFactory.getLogger(Login.class);
    private UserService userService
            = new UserServiceImpl(new JdbcUserRepo());
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        var dto = copy(req);
        var errors = ValidationUtil.getInstance().validate(dto);

        if (!errors.isEmpty()) {
            LOGGER.error("Validation error occurred in Login");
            req.setAttribute("errors", errors);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(req, resp);
        } else {
            try {
                var user = userService.verifyEmailAndPassword(dto);
                LOGGER.info("Login data is correct.");
                SecurityContext.login(req, user);
                resp.sendRedirect("/home");
            } catch (SQLException e) {
                LOGGER.error("Sql exception occurred");
                throw new RuntimeException("Unable to search");
            } catch (UserNotFoundException e) {
                LOGGER.error("User not found");
                errors.put("email", "Invalid password or email");
                req.setAttribute("errors", errors);
                req.setAttribute("dto", dto);
                req.getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(req, resp);
            }
        }
    }

    private LoginDTO copy(HttpServletRequest req) {
        return new LoginDTO(
                req.getParameter("email"),
                req.getParameter("password")
        );
    }

    private void login(HttpServletRequest req,
                       HttpServletResponse resp,
                       LoginDTO dto,
                       Map<String, String> errors) throws ServletException, IOException {
//        try {
//            var user = userService.verifyEmailAndPassword(dto);
//            LOGGER.info("Login data is correct.");
//            SecurityContext.login(req, user);
//            resp.sendRedirect("/login");
//        } catch (SQLException e) {
//            LOGGER.error("Sql exception occurred");
//            throw new RuntimeException("Unable to search");
//        } catch (UserNotFoundException e) {
//            LOGGER.error("User not found");
//            errors.put("email", "Invalid password or email");
//            req.setAttribute("errors", errors);
//            req.setAttribute("dto", dto);
//            req.getRequestDispatcher("/WEB-INF/login.jsp")
//                    .forward(req, resp);
//        }
    }
}
