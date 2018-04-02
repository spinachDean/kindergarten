package com.hbu.kindergarten.model;

import java.util.Date;

public class Clas {

	private Integer cId;           //班级id
	private String cName;			//班级名称
	private String cAlias;			//班级别名
	private Integer cContent;		//班级容量
	private String cConcact;		//联系方式
	private String cDescription;     //班级描述
	private String username;       //用户名
	private String kgId;          //幼儿园id
	private Date INSDATE;        //插入日期
	private Integer INSUSERID;			//插入用户id
	private Date UPDATET;			//更新日期
	private Integer UPUSERID;			//更新用户id

	
	public Clas(Integer cId, String cName, String cAlias, Integer cContent, String cConcact, String cDescription,
			String username, String kgId, Date iNSDATE, Integer iNSUSERID, Date uPDATET, Integer uPUSERID) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cAlias = cAlias;
		this.cContent = cContent;
		this.cConcact = cConcact;
		this.cDescription = cDescription;
		this.username = username;
		this.kgId = kgId;
		INSDATE = iNSDATE;
		INSUSERID = iNSUSERID;
		UPDATET = uPDATET;
		UPUSERID = uPUSERID;
	}


	public Clas() {
		super();
	}


	@Override
	public String toString() {
		return "Class [cId=" + cId + ", cName=" + cName + ", cAlias=" + cAlias + ", cContent=" + cContent
				+ ", cConcact=" + cConcact + ", cDescription=" + cDescription + ", username=" + username + ", kgId="
				+ kgId + ", INSDATE=" + INSDATE + ", INSUSERID=" + INSUSERID + ", UPDATET=" + UPDATET + ", UPUSERID="
				+ UPUSERID + "]";
	}
}
