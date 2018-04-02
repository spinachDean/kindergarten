package com.hbu.kindergarten.model;

import java.util.Date;

public class Clas {

	private Integer cId;           //班级id
	private String cName;			//班级名称
	private String cAlias;			//班级别名
	private Integer cContent;		//班级容量
	private String cTeacher;		//联系方式
	private String cDescription;     //班级描述
	private String username;       //用户名
	private Integer kgId;
	private String kgName;          //幼儿园名称
	private Date INSDATE;        //插入日期
	private Integer INSUSERID;			//插入用户id
	private Date UPDATE;			//更新日期
	private Integer UPUSERID;			//更新用户id
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcAlias() {
		return cAlias;
	}
	public void setcAlias(String cAlias) {
		this.cAlias = cAlias;
	}
	public Integer getcContent() {
		return cContent;
	}
	public void setcContent(Integer cContent) {
		this.cContent = cContent;
	}
	public String getcTeacher() {
		return cTeacher;
	}
	public void setcTeacher(String cTeacher) {
		this.cTeacher = cTeacher;
	}
	public String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getKgId() {
		return kgId;
	}
	public void setKgId(Integer kgId) {
		this.kgId = kgId;
	}
	public String getKgName() {
		return kgName;
	}
	public void setKgName(String kgName) {
		this.kgName = kgName;
	}
	public Date getINSDATE() {
		return INSDATE;
	}
	public void setINSDATE(Date iNSDATE) {
		INSDATE = iNSDATE;
	}
	public Integer getINSUSERID() {
		return INSUSERID;
	}
	public void setINSUSERID(Integer iNSUSERID) {
		INSUSERID = iNSUSERID;
	}
	public Date getUPDATE() {
		return UPDATE;
	}
	public void setUPDATE(Date uPDATE) {
		UPDATE = uPDATE;
	}
	public Integer getUPUSERID() {
		return UPUSERID;
	}
	public void setUPUSERID(Integer uPUSERID) {
		UPUSERID = uPUSERID;
	}
	public Clas(Integer cId, String cName, String cAlias, Integer cContent, String cTeacher, String cDescription,
			String username, Integer kgId, String kgName, Date iNSDATE, Integer iNSUSERID, Date uPDATE,
			Integer uPUSERID) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cAlias = cAlias;
		this.cContent = cContent;
		this.cTeacher = cTeacher;
		this.cDescription = cDescription;
		this.username = username;
		this.kgId = kgId;
		this.kgName = kgName;
		INSDATE = iNSDATE;
		INSUSERID = iNSUSERID;
		UPDATE = uPDATE;
		UPUSERID = uPUSERID;
	}
	public Clas() {
		super();
	}
	@Override
	public String toString() {
		return "Clas [cId=" + cId + ", cName=" + cName + ", cAlias=" + cAlias + ", cContent=" + cContent + ", cTeacher="
				+ cTeacher + ", cDescription=" + cDescription + ", username=" + username + ", kgId=" + kgId
				+ ", kgName=" + kgName + ", INSDATE=" + INSDATE + ", INSUSERID=" + INSUSERID + ", UPDATE=" + UPDATE
				+ ", UPUSERID=" + UPUSERID + "]";
	}


}
