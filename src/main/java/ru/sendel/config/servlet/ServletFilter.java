package ru.sendel.config.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/servlet/*")
public class ServletFilter implements Filter {

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {

   }

   @Override
   public void doFilter(ServletRequest request,
       ServletResponse response, FilterChain chain)
       throws IOException, ServletException {
      chain.doFilter(request, response);
   }

   @Override
   public void destroy() {

   }
}