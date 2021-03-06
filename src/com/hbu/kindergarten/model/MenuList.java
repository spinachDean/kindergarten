package com.hbu.kindergarten.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuList {
	private Integer id;
	private Integer parent=-1;
	private String name;
	private String url="/";
	private String icon="&#xe643;";
	private Integer index=0;
	/**
	 * 存取子菜单
	 */
	private List<MenuList> children;
	/**
	 * 用户图，用来根据不同用户展示不同的菜单按钮
	 */
	private Map<String, Boolean> roleMap;
	public MenuList()
	{
		setChildren(new ArrayList<>());
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public List<MenuList> getChildren() {
		return children;
	}
	public void setChildren(List<MenuList> children) {
		this.children = children;
	}
	public Map<String, Boolean> getRoleMap() {
		if(roleMap==null)
			roleMap=new HashMap<>();
		return roleMap;
	}
	public void setRoleMap(Map<String, Boolean> rolemap2) {
		this.roleMap = rolemap2;
	}
	//返回用户列表字符串，方便插入
	public String getRolesString()
	{
		StringBuilder sb=new StringBuilder();
		for(String role:roleMap.keySet())
		{
			sb.append(role+",");
		}
		return sb.toString();
	}

	
}
