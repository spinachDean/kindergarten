package com.hbu.kindergarten.model;

public class Menu {
	private Integer menuID;
	private String menuName;
	private String uri;
	public Menu() {}
	public Menu(String uri) {
		super();
		this.uri = uri;
	}
	public Integer getMenuID() {
		return menuID;
	}
	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	@Override
	public String toString() {
		return "Menu [menuID=" + menuID + ", menuName=" + menuName + ", uri="
				+ uri + "]";
	}
	/**
	 * @param uri
	 * @return
	 */
	public boolean equal(String uri)
	{
		char c1[]=uri.toCharArray();
		char c2[]=this.uri.toCharArray();
		for(int i=0,k=0;i<c2.length;i++,k++)
		{
			if(c2[i]=='*')
			{
				if(i>=c2.length-1)return true;//如果是末尾 比如/admin/* 则直接返回真
				i++;
				while(c2[i]!=c1[k])
				{
					k++;
					if(k>=c1.length)return false;
					
				}//找到下一次匹配
			}
			if(k>=c1.length)return false;
			if(i>=c2.length)return false;
			if(c2[i]!=c1[k])return false;
		
		}
		if(c1.length!=c2.length)return false;
		return true;
	}
public static void main(String[] args) {
	Menu m=new Menu();
	m.uri="/admin/*";
	System.out.println(m.equal("/admin/123"));
}

	

}
