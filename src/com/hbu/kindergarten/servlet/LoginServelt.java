package com.hbu.kindergarten.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbu.kindergarten.model.User;
import com.hbu.kindergarten.service.UserService;
import com.hbu.kindergarten.util.MD5Util;
import com.mysql.cj.api.Session;

@WebServlet(name="login",urlPatterns="/login")
public class LoginServelt extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.sendRedirect("/login.html");
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		UserService userService=UserService.getInstance();
		User user=userService.getUser(username);
		if(user==null||user.getUsername()==null)
		{
			req.setAttribute("error","用户名不存在");
			req.getRequestDispatcher("/index").forward(req, resp);
		}
		else
		{
			if(user.getPassword().equals(MD5Util.MD5(req.getParameter("password"))))
			{
				req.getSession().setAttribute("username",user);
				req.getRequestDispatcher("/index").forward(req, resp);
			}
			else {
				req.setAttribute("error","用户名或密码错误");
				
				req.getRequestDispatcher("login.html").forward(req, resp);
			}
		}
	}
}
