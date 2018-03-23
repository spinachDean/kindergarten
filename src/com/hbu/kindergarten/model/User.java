package com.hbu.kindergarten.model;

import java.util.ArrayList;
import java.util.List;



/**
 * @author chensiming
 *用户类
 */

public class User {
	private String username;
	private String password;
	private String rolename;
	private Integer logintime;
	private Integer updatetime;
	private List<Menu> menus=new ArrayList<>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public User(String username, String password, String rolename, List<Menu> menus) {
		super();
		this.username = username;
		this.password = password;
		this.rolename = rolename;
		this.menus = menus;
	}
	
	public User() {}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", rolename=" + rolename + ", menus=" + menus
				+ "]";
	}
	public Integer getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getLogintime() {
		return logintime;
	}
	public void setLogintime(Integer logintime) {
		this.logintime = logintime;
	}
	
	
}
