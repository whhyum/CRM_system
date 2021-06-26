package com.crm_system.springbootback.config;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.LogRecord;

@Component
public class CORSFilter implements Filter {
 
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletResponse res = (HttpServletResponse) response;
    res.addHeader("Access-Control-Allow-Credentials", "true");
    res.addHeader("Access-Control-Allow-Origin", "*");
    res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    res.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");
    res.addHeader("Access-Control-Expose-Headers","X-forwarded-port,X-forwarded-host");
    res.addHeader("Access-Control-expose-Headers","Authorization,BiToken,cookie");
    res.addHeader("Set-Cookie","SamSite=None");
    if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
      response.getWriter().println("ok");
      return;
    }
    chain.doFilter(request, response);
  }
  @Override
  public void destroy() {
  }
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

}
