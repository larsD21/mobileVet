package de.vet.jwt;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


//author Lars Diekmann
@WebFilter("/*")
public class CorsResponseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Allow credentials
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

        // Set CORS headers only for specific origins (replace '*' with the actual origin)
        httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        // Handle preflight OPTIONS request
        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) request).getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // Continue the filter chain
        chain.doFilter(request, response);
    }



    @Override
    public void destroy() {
        // Cleanup logic, if needed
    }
}