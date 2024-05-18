import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerErrorException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Configuration
@WebFilter(filterName = "accessFilter", urlPatterns = "/*")
public class MyCorsFilter implements jakarta.servlet.Filter {
  public void doFilter(ServerHttpRequest req, ServerHttpResponse res, jakarta.servlet.Filter chain) throws IOException, ServerErrorException {
    jakarta.servlet.http.HttpServletResponse response = (HttpServletResponse) res;
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
    chain.doFilter(req, res);
  }
 
  public void init(FilterConfig filterConfig) {log.info("AccessFilter过滤器初始化！");}
 
  public void destroy() {}

@Override
public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'doFilter'");
}
}