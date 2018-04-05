package com.hbu.kindergarten.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Administrator
 *
 */
@WebFilter(filterName = "encoding", urlPatterns = "/*")
public class EncodingFilter implements Filter {
	  private String charset = "UTF-8";
	    @Override
	    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
	        HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) resp;
	        request.setCharacterEncoding(charset);
	        response.setCharacterEncoding("UTF-8"); 
	        response.setHeader("Content-type", "text/html;charset=UTF-8");  
	       // System.out.println("编码过滤"+request.getServletPath());
	        chain.doFilter(request, response);
	        
	    }

	    @Override
	    public void destroy() {
	    }

		@Override
		public void init(FilterConfig arg0) throws ServletException {
			// TODO Auto-generated method stub
			
		}


}