package com.hbu.kindergarten.servlet.menulist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
@WebServlet(name = "getmenulist", urlPatterns = "/menulist")
public class GetMenuListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入");
		MenuService menuService = MenuService.getInstance();
		List<MenuList> menuList = menuService.getMenuList();
		
		HashMap<Integer,List<String>> rolesNameMap=new HashMap<>();
		for(MenuList mList:menuList)
		{
			List<String> rolesName=new ArrayList<>();
			for(String id:mList.getRoleMap().keySet())
			{
				rolesName.add(menuService.getRoleName(id));
			}
			rolesNameMap.put(mList.getId(), rolesName);
			//遍历子菜单
			for(MenuList mList2:mList.getChildren())
			{
				List<String> rolesName2=new ArrayList<>();
				for(String id:mList2.getRoleMap().keySet())
				{
					rolesName2.add(menuService.getRoleName(id));
				}
				rolesNameMap.put(mList2.getId(), rolesName2);
			}
		}
		req.setAttribute("menulist", menuList);
		req.setAttribute("rolesName", rolesNameMap);
		
		req.getRequestDispatcher("/menulist/menulist.jsp").forward(req, resp);
		
		return;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return;
	}

}
