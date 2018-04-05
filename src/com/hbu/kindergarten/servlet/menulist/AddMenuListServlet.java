package com.hbu.kindergarten.servlet.menulist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbu.kindergarten.model.Menu;
import com.hbu.kindergarten.model.MenuList;
import com.hbu.kindergarten.model.User;
import com.hbu.kindergarten.service.MenuService;
import com.hbu.kindergarten.util.CacheUtil;

/**
 * @author chensiming
 *实现对菜单列表的增加和修改
 *需要传入parent,icon,index,name,url,role等参数 且为post方法
 */
@WebServlet(name = "addmenulist", urlPatterns = "/menulist/add")
public class AddMenuListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuService menuService = MenuService.getInstance();
		List<MenuList> menuList = menuService.getMenuList();
		Map<String,String> roleMap=(Map<String, String>) CacheUtil.getCache(MenuService.ROLECACHE);
		String id=req.getParameter("id");
		//如果有id代表是修改方法
		
		req.setAttribute("menulist", menuList);
		req.setAttribute("rolesName", roleMap);
		req.setAttribute("menuinfo", new MenuList());
		if(id!=null&&!"".equals(id))
		{
			req.setAttribute("id", id);
			for(MenuList m:menuList)
			{
				if(id.equals(m.getId()+""))
				{
					req.setAttribute("menuinfo", m);
					break;
				}
			}
		}
		
		req.getRequestDispatcher("/menulist/menulist-add.jsp").forward(req, resp);
		
		return;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		
		MenuList menuList = new MenuList();
		String parent=req.getParameter("parent");
		if(parent!=null&&!parent.equals(""))
		menuList.setParent(new Integer(parent));
		menuList.setIcon(req.getParameter("icon"));
		String index=req.getParameter("index");
		if(index!=null&!index.equals(""))
		menuList.setIndex(new Integer(index));
		menuList.setName(req.getParameter("name"));
		menuList.setUrl(req.getParameter("url"));
		String roles[] = req.getParameterValues("role");
		for (String role : roles) {
			if(!role.equals(""))
			menuList.getRoleMap().put(role, true);
		} // 添加角色
		MenuService menuService = MenuService.getInstance();
		//如果有id代表是查看方法
		if(id!=null&&!"".equals(id))
		{
			menuList.setId(new Integer(id));
		}
		PrintWriter pw = resp.getWriter();
		User user = (User) req.getSession().getAttribute("username");
		String str = menuService.addMenuList(menuList, user.getUsername());
		pw.println(str);
		pw.flush();
		pw.close();
	}

}
