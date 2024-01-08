package com.imran.web;

import com.imran.dto.SignupDTO;
import com.imran.exceptions.UserNotFoundException;
import com.imran.repositories.JdbcUserRepo;
import com.imran.service.UserService;
import com.imran.service.UserServiceImpl;
import com.imran.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        var dto = copy(req);
        var errors = ValidationUtil.getInstance().validate(dto);

        if (!errors.isEmpty()) {
            LOGGER.error("Validation error occurred in Signup");
            req.setAttribute("errors", errors);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/signup.jsp")
                    .forward(req, resp);
        } else if (!userService.isEmailUnique(dto.getEmail())) {
            LOGGER.error("User is trying to use duplicate email");
            errors.put("email", "Email is already taken try another");
            req.setAttribute("errors", errors);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/signup.jsp")
                    .forward(req, resp);
        } else {
            LOGGER.info("Validation is done. Redirecting to Login Page");
            userService.signup(dto);
            resp.sendRedirect("/login");
        }
    }

    private SignupDTO copy(HttpServletRequest req) {
        return new SignupDTO(
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("email"),
                req.getParameter("password"),
                req.getParameter("confirmPassword")
        );
    }

//    private boolean isNotEmailUnique(SignupDTO dto) {
//        try {
//            userService.isEmailUnique(dto.getEmail());
//        } catch (SQLException e) {
//            LOGGER.error("SQL exception occurred");
//        } catch (UserNotFoundException e) {
//            return false;
//        }
//        return true;
//    }
}
