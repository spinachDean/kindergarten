package com.hbu.kindergarten.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbu.kindergarten.model.Menu;
import com.hbu.kindergarten.model.User;

@WebFilter(filterName = "auth", urlPatterns = "/*")
public class AuthFilter implements Filter {
	private static List<String> ignoreURL=new ArrayList<>();
	static {
		ignoreURL.add("/login*");
		ignoreURL.add("/register*");
		ignoreURL.add("/");
		ignoreURL.add("/unauthorized.jsp");
		ignoreURL.add("/temp/*");
		ignoreURL.add("/static/*");
		ignoreURL.add("/lib/*");
		ignoreURL.add("/404.html");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public boolean ignore(String url)
	{
		for(String s:ignoreURL)
		{
			Menu m=new Menu(s);
			if(m.equal(url))return true;
		}
		return false;
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse reps, FilterChain fc)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		String url=request.getServletPath();
		if(ignore(url))
		{	fc.doFilter(req, reps);
			return;
		}
		User user=(User) request.getSession().getAttribute("username");
		System.out.println("权限检查");
		if(user!=null)
		{
			for(Menu menu:user.getMenus())
			{
				
				if(menu.equal(url))
				{
					fc.doFilter(req, reps);
					return;
				}

			}
		}
		HttpServletResponse response=(HttpServletResponse)reps;
		
		response.sendRedirect(request.getContextPath()+"/unauthorized.jsp");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
