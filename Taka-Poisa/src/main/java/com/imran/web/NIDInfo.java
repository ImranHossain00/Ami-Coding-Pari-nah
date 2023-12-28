package com.imran.web;

import com.imran.dto.NIDInfoDTO;
import com.imran.repositories.JdbcUserRepo;
import com.imran.service.UserService;
import com.imran.service.UserServiceImpl;
import com.imran.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/nid-info")
@MultipartConfig(maxFileSize = 16177215)
public class NIDInfo extends HttpServlet {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(NIDInfo.class);
    private UserService userService
            = new UserServiceImpl(new JdbcUserRepo());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/nidInfo.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        var nidDTO = copyParamerters(req);
        var errors = ValidationUtil.getInstance().validate(nidDTO);

        if (nidDTO.getPhoto() == null || nidDTO.getPhoto().available() <= 0)
            errors.put("photo", "Photo required");
        if (!errors.isEmpty()) {
            LOGGER.info("User data is incorrect for nid.");
            req.setAttribute("errors", errors);
            req.setAttribute("dto", nidDTO);
            req.getRequestDispatcher("/WEB-INF/nidInfo.jsp")
                    .forward(req, resp);
        } else {
            LOGGER.info("Nid info got. Redirecting to address info");
            userService.saveNidData(nidDTO);
            resp.sendRedirect("/address-info");
        }
    }

    private NIDInfoDTO copyParamerters(HttpServletRequest req) throws ServletException, IOException {
        
        var dto = new NIDInfoDTO();
        Part part = req.getPart("photo");
        
        dto.setPhoto(part.getInputStream());
        dto.setNidNumber(req.getParameter("nidNumber"));
        dto.setName(req.getParameter("name"));
        dto.setDob(req.getParameter("dob"));

        return dto;
    }
}


