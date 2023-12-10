package com.imran.web;

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

@WebServlet("/file-upload")
@MultipartConfig
public class FileUpload extends HttpServlet {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(FileUpload.class);

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/fileUpload.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        Part part = req.getPart("file");
        String fileName = part.getSubmittedFileName();


        LOGGER.info("File {} successfully uploaded", fileName);
    }
}
