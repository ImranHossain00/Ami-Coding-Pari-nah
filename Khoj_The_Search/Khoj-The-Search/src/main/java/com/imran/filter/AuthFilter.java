package com.imran.filter;

import com.imran.util.SecurityContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final String[] ALLOWED_CONTENTS
            = {".css", ".js", ".jpg", "home", "login", "signup"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var httpSevletRequest = (HttpServletRequest)request;
        var responseUri = httpSevletRequest.getRequestURI();

        boolean allowed
                = Stream.of(ALLOWED_CONTENTS)
                .anyMatch(responseUri::contains);
        if (responseUri.equals("/") || allowed || SecurityContext.isAuthenticated(httpSevletRequest)) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response)
                    .sendRedirect("/login");
        }

    }
}
