package net.socialgamer.cah;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;


public class CacheControlFilter implements Filter {

  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response,
      final FilterChain chain) throws IOException, ServletException {

    final HttpServletResponse resp = (HttpServletResponse) response;

    final DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");

    resp.setHeader("Expires", "Tue, 03 Jul 2001 06:00:00 GMT");
    resp.setHeader("Last-Modified", format.format(new Date()));
    resp.setHeader("Cache-Control", "must-revalidate, max-age=0");

    chain.doFilter(request, response);
  }

  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {
    // pass
  }

  @Override
  public void destroy() {
    // TODO pass
  }

}
