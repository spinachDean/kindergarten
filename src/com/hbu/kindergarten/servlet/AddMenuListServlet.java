package com.hbu.kindergarten.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbu.kindergarten.model.MenuList;
import com.hbu.kindergarten.model.User;
import com.hbu.kindergarten.service.MenuService;

@WebServlet(name = "addmenulist", urlPatterns = "/menulist/add")
public class AddMenuListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		return;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuList menuList = new MenuList();
		menuList.setParent(new Integer(req.getParameter("parent")));
		menuList.setIcon(req.getParameter("icon"));
		menuList.setIndex(new Integer(req.getParameter("index")));
		menuList.setName(req.getParameter("name"));
		menuList.setUrl(req.getParameter("url"));
		String roles[] = req.getParameterValues("role");
		for (String role : roles) {
			menuList.getRoleMap().put(role, true);
		} // 添加角色
		MenuService menuService = MenuService.getInstance();
		PrintWriter pw = resp.getWriter();
		User user = (User) req.getSession().getAttribute("username");
		String str = menuService.addMenuList(menuList, user.getUsername());
		pw.println(str);
		pw.flush();
		pw.close();
	}

}
