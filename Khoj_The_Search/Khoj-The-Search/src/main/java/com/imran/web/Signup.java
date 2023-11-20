package com.imran.web;

import com.imran.dto.UserDTO;
import com.imran.repository.JDBCUserRepositoryImpl;
import com.imran.service.UserService;
import com.imran.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.io.IOException;
import java.util.Set;

@WebServlet("/signup")
public class Signup extends HttpServlet {

    private UserService userService
            = new UserServiceImpl(new JDBCUserRepositoryImpl());
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
        UserDTO userDTO = copyParamerters(req);
        if (isValid(userDTO)) {
            userService.saveUser(userDTO);
            resp.sendRedirect("/home");
        } else {
            req.getRequestDispatcher("/WEB-INF/signup.jsp")
                    .forward(req, resp);
        }
    }

    // In this method we're retrieving the values from
    // the object of HttpServletRequest and creating a new UserDTO object
    // and setting up the properties of the userDTO object.
    private UserDTO copyParamerters(HttpServletRequest req) {
        var userDTO = new UserDTO();
        userDTO.setUsername(req.getParameter("username"));
        userDTO.setPassword(req.getParameter("password"));
        userDTO.setConfirmPassword(req.getParameter("confirmPassword"));
        return userDTO;
    }

    private boolean isValid(UserDTO userDTO) {
        var validatorFactory
                = Validation.buildDefaultValidatorFactory();
        var validator
                = validatorFactory.getValidator();

        Set<ConstraintViolation<UserDTO>> violations
                = validator.validate(userDTO);
        return violations.isEmpty();
    }
}
