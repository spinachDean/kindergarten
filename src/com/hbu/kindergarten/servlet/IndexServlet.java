package com.hbu.kindergarten.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbu.kindergarten.service.MenuService;

@WebServlet(name="index",urlPatterns="/index")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		MenuService menuService=MenuService.getInstance();
		req.setAttribute("menulist", menuService.getMenuList());
		
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		}
	
}
