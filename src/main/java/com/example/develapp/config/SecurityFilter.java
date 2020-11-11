package com.example.develapp.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getRemoteAddr().equals("127.0.0.1")) {
            chain.doFilter(request, response);
        } else {
            response.getWriter().write("Tego Pana nie obsługujemy");
        }
    }

    @Override
    public void destroy() {
    }
}
