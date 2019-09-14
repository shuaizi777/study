package study.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/30 17:10
 */
@Component
public class FilterTest implements Filter {
    private static final Logger log = LoggerFactory.getLogger(FilterTest.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("filterTest--doFilter-----------");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
