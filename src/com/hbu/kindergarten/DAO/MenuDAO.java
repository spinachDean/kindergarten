package com.hbu.kindergarten.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hbu.kindergarten.config.DataConfig;
import com.hbu.kindergarten.model.ChangeStatus;
import com.hbu.kindergarten.model.MenuList;

/**
 * 访问有关菜单的数据库
 * 
 * @author chensiming
 *
 */
public class MenuDAO {
	public List<MenuList> getMenuList() throws SQLException {
		System.out.println("执行查找菜单操作");
		List<MenuList> menuList = new ArrayList<>();
		HashMap<Integer, MenuList> map = new HashMap<>();
		Connection conn = DataConfig.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(
				"select id,parent,m.name,url,icon,roles,m.index from t_menu_list m order by parent,m.index");
		while (rs.next()) {
			MenuList menu = new MenuList();
			Integer parent = rs.getInt("parent");
			Integer id = rs.getInt("id");
			menu.setId(id);
			menu.setParent(parent);
			menu.setIcon(rs.getString("icon"));
			menu.setIndex(rs.getInt("index"));
			menu.setName(rs.getString("name"));
			String[] roles = rs.getString("roles").split(",");
			Map<String, Boolean> rolemap = new HashMap<>();
			for (String r : roles)
				rolemap.put(r, true);
			menu.setRoleMap(rolemap);
			menu.setUrl(rs.getString("url"));
			if (parent == -1) {
				menuList.add(menu);
				map.put(id, menu);
			} else {
				MenuList parentMenu = map.get(parent);
				if (parentMenu != null)
					parentMenu.getChildren().add(menu);
			}

		}
		rs.close();
		conn.close();
		return menuList;
	}

	public Integer addMenuList(MenuList menuList, ChangeStatus changeStatus) throws Exception {
		Connection conn = DataConfig.getConn();
		conn.setAutoCommit(false);
		try {
		PreparedStatement preparedStatement = conn.prepareStatement(
				"INSERT INTO t_menu_list (parent, name, url,icon,roles,t_menu_list.index,INSDATE,INSUSERID)"
						+ " VALUES (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setInt(1, menuList.getParent());
		preparedStatement.setString(2, menuList.getName());
		preparedStatement.setString(3, menuList.getUrl());
		preparedStatement.setString(4, menuList.getIcon());
		preparedStatement.setString(5, menuList.getRolesString());
		preparedStatement.setInt(6, menuList.getIndex());
		preparedStatement.setDate(7, new Date(changeStatus.getINSDATE().getTime()) );
		preparedStatement.setString(8, changeStatus.getINSUSERID());
		int row = preparedStatement.executeUpdate();
		ResultSet rs = preparedStatement.getGeneratedKeys();
		Integer key = null;
		if (rs.next()) {
			key = rs.getInt(row);
		
		}
		conn.commit();
		return key;
		}catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw new Exception("添加错误");
		}finally {
		conn.close();
		}
		

	}
	public Integer deleteMenuList(Integer id,ChangeStatus changeStatus) throws Exception
	{
		Connection conn = DataConfig.getConn();
		conn.setAutoCommit(false);
		try {
		PreparedStatement preparedStatement = conn.prepareStatement(
				"delete from t_menu_list where id=?");
		
		preparedStatement.setInt(1,id);
	
		int row = preparedStatement.executeUpdate();
		conn.commit();
		return row;
		}catch (Exception e) {
			conn.rollback();
			throw new Exception("删除错误");
		}finally {
			conn.close();
		}
		
	}
	public Integer updateMenuList(MenuList menuList,ChangeStatus changeStatus) throws Exception
	{
		Connection conn = DataConfig.getConn();
		conn.setAutoCommit(false);
		try {
		PreparedStatement preparedStatement = conn.prepareStatement(
				"update  t_menu_list set name=?,parent=?,url=?,icon=?,index=?,UPDATET=?,UPUSERID=?"
				+  " where id=?");
		
		preparedStatement.setString(1,menuList.getName());
		preparedStatement.setInt(2,menuList.getParent());
		preparedStatement.setString(3,menuList.getUrl());
		preparedStatement.setString(4, menuList.getIcon());
		preparedStatement.setInt(5, menuList.getIndex());
		preparedStatement.setDate(6,new Date(changeStatus.getUPDATET().getTime()));
		preparedStatement.setString(7, changeStatus.getUPUSERID());
		preparedStatement.setInt(8, menuList.getId());
	
		int row = preparedStatement.executeUpdate();
		conn.commit();
		return row;
		}catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw new Exception("更新错误");
		}finally {
			conn.close();
		}
		
	}

	public Map<String, String> getRoleNameMap() throws SQLException {
		Map<String, String> map = new HashMap<>();
		Connection conn = DataConfig.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select roleID,roleName from t_role");
		while (rs.next()) {
			map.put(rs.getString(1), rs.getString(2));
		}
		rs.close();
		conn.close();
		return map;
	}



}
