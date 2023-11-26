package com.imran.web;



import com.imran.dto.NumberListDTO;
import com.imran.util.ValidationUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@WebServlet("/home")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/home.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        NumberListDTO numberListDTO = copyParameters(req);
        var errors = ValidationUtil.getInstance().validate(numberListDTO);
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("numberListDTO", numberListDTO);
            req.getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(req, resp);
        } else if (!isValidInput(numberListDTO.getInputValues())) {
            errors.put("inputValues", "Input is not accurate format, please check your input");
            req.setAttribute("errors", errors);
            req.setAttribute("numberListDTO", numberListDTO);
            req.getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(req, resp);
        } else if (!isValidSearchValue(numberListDTO.getSearchValue())) {
            errors.put("searchValue", "Search value is not accurate format, please check your searchValue");
            req.setAttribute("errors", errors);
            req.setAttribute("numberListDTO", numberListDTO);
            req.getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(req, resp);
        } else {
            resp.sendRedirect("/home");
        }
    }

    private boolean isValidSearchValue(String searchValue) {
        Predicate<Character> isDigit = Character::isDigit;

        //Instead of using forEach,
        //I replaced it with allMatch in the stream to check
        //if all characters match the condition specified by the isDigit predicate.
        return searchValue
                .trim()
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toList())
                .stream()
                .allMatch(isDigit);// if all char are digit returns true otherwise false;

    }

    private boolean isValidInput(String inputValues) {
        Predicate<Character> isDigit = Character::isDigit;
        Predicate<Character> isSpace = c -> c == ' ';

        // It returns true if all characters are either
        // digits or spaces; otherwise, it returns false.
        return inputValues
                .replaceAll(",", " ")
                .trim()
                .chars()                              //Get an IntStream of characters
                .mapToObj(c -> (char)c)               //Convert to a Stream<Character>
                .collect(Collectors.toList())         //Collect to List<Character>
                .stream()
                .allMatch(isDigit.or(isSpace));
    }

    private NumberListDTO copyParameters(HttpServletRequest req) {
        NumberListDTO numberListDTO = new NumberListDTO();
        numberListDTO.setInputValues(req.getParameter("inputValues"));
        numberListDTO.setSearchValue(req.getParameter("searchValue"));
        return numberListDTO;
    }
}
