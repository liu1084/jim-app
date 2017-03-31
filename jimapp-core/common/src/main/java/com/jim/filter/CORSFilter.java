package com.jim.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jim on 2017/4/1.
 * This class is ...
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, DELETE, OPTIONS, HEADER");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with");
		response.setHeader("Access-Control-Max-Age","3600");

		if (request.getMethod() != "OPTIONS"){
			filterChain.doFilter(request, response);
		}else{}
	}

	@Override
	public void destroy() {

	}
}
