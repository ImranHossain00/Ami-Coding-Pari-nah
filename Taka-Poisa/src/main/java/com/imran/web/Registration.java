package com.imran.web;

import com.imran.dto.RegDTO;
import com.imran.repositories.JdbcUserRepo;
import com.imran.service.UserService;
import com.imran.service.UserServiceImpl;
import com.imran.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    private final static Logger LOGGER
            = LoggerFactory.getLogger(Registration.class);
    private UserService userService
            = new UserServiceImpl(new JdbcUserRepo());

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        RegDTO regDTO = copyParamerters(req);
        var errors = ValidationUtil.getInstance().validate(regDTO); // validating regDTO attributes.
        

        if (!errors.isEmpty()) {
            LOGGER.info("User data is incorrect.");
            req.setAttribute("errors", errors);
            req.setAttribute("dto", regDTO);
            req.getRequestDispatcher("/WEB-INF/signup.jsp")
                    .forward(req, resp);
        } else {
            LOGGER.info("Redirecting to nid-info page");
            userService.saveSignupData(regDTO);
            resp.sendRedirect("/nid-info");
        }
    }

    private RegDTO copyParamerters(HttpServletRequest req) {
        var regDTO = new RegDTO();
        regDTO.setFirstName(req.getParameter("firstName"));
        regDTO.setLastName(req.getParameter("lastName"));
        regDTO.setPassword(req.getParameter("password"));
        regDTO.setConfirmPassword(req.getParameter("confirmPassword"));
        
        return regDTO;
    }
}

