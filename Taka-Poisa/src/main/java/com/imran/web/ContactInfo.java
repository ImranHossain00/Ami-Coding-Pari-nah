package com.imran.web;

import com.imran.dto.ContactDTO;
import com.imran.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contact-info")
public class ContactInfo extends HttpServlet {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(ContactInfo.class);

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/contact.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        var contactDTO = copyParameters(req);
        var errors = ValidationUtil.getInstance().validate(contactDTO);

        if (!errors.isEmpty()) {
            LOGGER.error("Information is not properly provided");
            req.setAttribute("errors", errors);
            req.setAttribute("dto", contactDTO);
            req.getRequestDispatcher("/WEB-INF/contact.jsp")
                    .forward(req, resp);
        }
        else {
            LOGGER.info("Information is saved");
            resp.sendRedirect("/home");
        }
    }

    private ContactDTO copyParameters(HttpServletRequest req) {
        var dto = new ContactDTO();
        dto.setEmail(req.getParameter("email"));
        dto.setPhoneNumber(req.getParameter("phoneNumber"));

        return dto;
    }
}

