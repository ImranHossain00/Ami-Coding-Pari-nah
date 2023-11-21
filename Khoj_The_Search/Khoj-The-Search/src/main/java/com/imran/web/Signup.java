package com.imran.web;

import com.imran.dto.UserDTO;
import com.imran.repository.JDBCUserRepositoryImpl;
import com.imran.service.UserService;
import com.imran.service.UserServiceImpl;
import com.imran.util.ValidationUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
        Map<String, String> errors = ValidationUtil.getInstance().validate(userDTO);
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("userDTO", userDTO);
            req.getRequestDispatcher("/WEB-INF/signup.jsp")
                    .forward(req, resp);
        } else if (userService.isNotUniqueUsername(userDTO)) {
            errors.put("username", "The username already exist. Please use a different user name.");
            req.setAttribute("errors", errors);
            req.setAttribute("userDTO", userDTO);
            req.getRequestDispatcher("/WEB-INF/signup.jsp")
                    .forward(req, resp);
        } else {
            userService.saveUser(userDTO);
            resp.sendRedirect("/home");
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
}
