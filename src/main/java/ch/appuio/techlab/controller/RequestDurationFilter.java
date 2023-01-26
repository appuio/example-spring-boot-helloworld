package ch.appuio.techlab.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@WebFilter("/*")
public class RequestDurationFilter implements Filter {

   private static final Logger LOGGER = LoggerFactory.getLogger(RequestDurationFilter.class);

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      // empty
   }

   @Override
   public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
      Instant start = Instant.now();
      try {
         chain.doFilter(req, resp);
      } finally {
         Instant finish = Instant.now();
         long time = Duration.between(start, finish).toMillis();
         LOGGER.trace("Request '{}' duration: {} ms", ((HttpServletRequest) req).getRequestURI(), time);
      }
   }

   @Override
   public void destroy() {
      // empty
   }
}
