package com.hbu.kindergarten.servlet.menulist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbu.kindergarten.model.MenuList;
import com.hbu.kindergarten.model.User;
import com.hbu.kindergarten.service.MenuService;

/**
 * @author chensiming
 *获取菜单的列表
 */
@WebServlet(name = "delmenulist", urlPatterns = "/menulist/delete")
public class DeleteMenuListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.parseInt(req.getParameter("id"));
		MenuService menuService=MenuService.getInstance();
		User user = (User) req.getSession().getAttribute("username");
		if(user==null)return;
		String str=menuService.deleteMenuList(user.getUsername(), id);
		PrintWriter pw = resp.getWriter();
		pw.println(str);
		pw.flush();
		pw.close();
	}
	

}
