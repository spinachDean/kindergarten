package com.hbu.kindergarten.service;

import java.security.MessageDigest;
import java.sql.SQLException;

import org.apache.tomcat.util.security.MD5Encoder;

import com.hbu.kindergarten.DAO.UserDAO;
import com.hbu.kindergarten.model.User;
import com.hbu.kindergarten.util.MD5Util;

public class UserService {
	private UserDAO userDAO=new UserDAO();
	private static class SingletonHolder {
		private static final UserService INSTANCE = new UserService();
	}
	public static final UserService getInstance() {
		return SingletonHolder.INSTANCE;
	}
	

	public User getUser(String username)
	{
		try {
			return userDAO.getUser(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean register(String username,String password,String roleName)
	{
		password=MD5Util.MD5(password);
		try {
			return userDAO.addUser(new User(username, password, roleName, null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
