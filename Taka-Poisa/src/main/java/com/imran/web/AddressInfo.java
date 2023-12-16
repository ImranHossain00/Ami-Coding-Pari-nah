package com.imran.web;

import com.imran.dto.AddressDTO;
import com.imran.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/address-info")
public class AddressInfo extends HttpServlet {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(AddressInfo.class);
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/address.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        var addressDTO = copyParameters(req);
        var errors = ValidationUtil.getInstance().validate(addressDTO);

        if (!errors.isEmpty()) {
            LOGGER.info("User data is incorrect.");
            req.setAttribute("errors", errors);
            req.setAttribute("dto", addressDTO);
            req.getRequestDispatcher("/WEB-INF/address.jsp")
                    .forward(req, resp);
        } else {
            LOGGER.info("Address info gotted. Redirecting to Contact info");
            resp.sendRedirect("/contact-info");
        }

    }

    private AddressDTO copyParameters(HttpServletRequest req) {
        var dto = new AddressDTO();
        dto.setRoad(req.getParameter("road"));
        dto.setThana(req.getParameter("thana"));
        dto.setDistrict(req.getParameter("district"));
        dto.setDivision(req.getParameter("division"));

        return dto;
    }
}
