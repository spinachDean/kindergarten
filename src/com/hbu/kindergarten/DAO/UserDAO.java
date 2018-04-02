package com.hbu.kindergarten.DAO;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbu.kindergarten.config.DataConfig;
import com.hbu.kindergarten.model.Menu;
import com.hbu.kindergarten.model.User;

/**
 * 对用户的操作
 * 
 * @author chensiming
 *
 */
public class UserDAO {
	
	
	public User getUser(String username) throws SQLException {
		User user = null;
		Connection conn = DataConfig.getConn();
		PreparedStatement pr = conn.prepareStatement(
				"select u.roleID roleid,username,password,roleName,uri from t_user u,t_role r,t_menu m,t_rolemenu rm where username=? and "
						+ "u.roleID=r.roleID and r.roleID=rm.roleID and rm.menuID=m.menuID");
		pr.setString(1, username);
		ResultSet rs = pr.executeQuery();
		if(rs.next())
		{
			user= new User();
			user.setUsername(username);
			user.setPassword(rs.getString("password"));
			user.setRolename(rs.getString("roleName"));
			user.setRoleid(rs.getString("roleid"));
			user.getMenus().add(new Menu(rs.getString("uri")));
			while (rs.next()) {
				user.getMenus().add(new Menu(rs.getString("uri")));
			}
		}
		rs.close();
		pr.close();
		conn.close();
		return user;
	}

	public boolean addUser(User user) throws SQLException {

		Connection conn = DataConfig.getConn();

		PreparedStatement pr = conn.prepareStatement("select roleID from t_role where rolename=?");
		pr.setString(1, user.getRolename());

		ResultSet rs = pr.executeQuery();
		rs.next();
		Integer roleID = rs.getInt(1);
		rs.close();
		pr = conn.prepareStatement("insert into user values(?,?,?)");
		pr.setString(1, user.getUsername());
		pr.setString(2, user.getPassword());
		pr.setInt(3, roleID);
		boolean result = pr.execute();

		rs.close();
		pr.close();
		conn.close();
		return result;
	}

	public static void main(String[] args) {
		System.out.println(123);
		UserDAO userDAO = new UserDAO();
		try {
			User user = userDAO.getUser("admin");
			user.setUsername("test");
			user.setRolename("院长");
			userDAO.addUser(user);
			System.out.println(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
