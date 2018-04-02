package com.hbu.kindergarten.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hbu.kindergarten.DAO.MenuDAO;
import com.hbu.kindergarten.model.ChangeStatus;
import com.hbu.kindergarten.model.MenuList;
import com.hbu.kindergarten.util.CacheUtil;


public class MenuService {
	private MenuDAO menuDAO=new MenuDAO();
	private static class SingletonHolder {
		private static final MenuService INSTANCE = new MenuService();
	}
	public static final MenuService getInstance() {
		return SingletonHolder.INSTANCE;
	}
	public List<MenuList> getMenuList()
	{
		List<MenuList> menuLists=(List<MenuList>) CacheUtil.getCache("menulist");
		try {
			if(menuLists==null)
			{
				menuLists= menuDAO.getMenuList();
				CacheUtil.putCache("menulist", menuLists);
			}
			 return menuLists;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据角色id 获取角色名
	 * @param roleID
	 * @return
	 */
	public String getRoleName(String roleID)
	{
		Integer id=null;
		try {
			id=new Integer(roleID);
			Map<Integer,String> map=(Map<Integer, String>) CacheUtil.getCache("roleName");
			if(map==null)
			{
				map=menuDAO.getRoleNameMap();
				CacheUtil.putCache("roleName",map);
			
			}
			return map.get(roleID);
		}catch(Exception ex)
		{
			return null;
		}

		
	}
	public String addMenuList(MenuList m,String id)
	{
		ChangeStatus cs=new ChangeStatus();
		cs.setINSDATE(new Date());
		cs.setINSUSERID(id);
		try {
			menuDAO.addMenuList(m, cs);
			return "添加成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "出现错误";
		}
		
	}
	public static void main(String args[])
	{
		MenuService menuService=MenuService.getInstance();
		List<MenuList> l=menuService.getMenuList();
		System.out.println(l.size());
		l.forEach(
		m->{
			System.out.println(m.getName());
			m.getChildren().forEach(System.out::println);
		});
		
	}
}
