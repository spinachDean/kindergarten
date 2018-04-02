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

	public Integer addMenuList(MenuList menuList, ChangeStatus changeStatus) throws SQLException {
		Connection conn = DataConfig.getConn();
		PreparedStatement preparedStatement = conn.prepareStatement(
				"INSERT INTO t_menu_list (parent, name, url,icon,roles,t_menu_list.index,INSDATE,INSUSERID)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?)");
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
		rs.close();
		conn.close();
		return key;

	}
	public Integer deleteMenuList(Integer id) throws SQLException
	{
		Connection conn = DataConfig.getConn();
		PreparedStatement preparedStatement = conn.prepareStatement(
				"delete from t_menu_list where id=?");
		
		preparedStatement.setInt(1,id);
	
		int row = preparedStatement.executeUpdate();
		return row;
	}

	public Map<Integer, String> getRoleNameMap() throws SQLException {
		Map<Integer, String> map = new HashMap<>();
		Connection conn = DataConfig.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select roleID,roleName from t_role");
		while (rs.next()) {
			map.put(new Integer(rs.getInt(1)), rs.getString(2));
		}
		rs.close();
		conn.close();
		return map;
	}

}
