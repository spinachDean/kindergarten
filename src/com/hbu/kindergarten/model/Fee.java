package com.hbu.kindergarten.model;

import java.util.Date;

import com.mysql.cj.core.conf.ReadableStringProperty;

/**
 * 费用管理实体
 * 
 * @author 李曜铮
 *
 */
public class Fee {

	private Integer fId; // 费用id
	private String fName; // 费用名称
	private Double fDcost; // 日花费， *30为显示的费用
	private String fDescription; // 费用描述
	private Date fBegin; // 费用开始时间
	private Date fEnd; // 费用结束时间
	private Date INSDATE; // 插入日期
	private Integer INSUSERID; // 插入用户id
	private Date UPDATET; // 更新日期
	private Integer UPUSERID; // 更新用户id
	public Integer getfId() {
		return fId;
	}
	public void setfId(Integer fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public Double getfDcost() {
		return fDcost;
	}
	public void setfDcost(Double fDcost) {
		this.fDcost = fDcost;
	}
	public String getfDescription() {
		return fDescription;
	}
	public void setfDescription(String fDescription) {
		this.fDescription = fDescription;
	}
	public Date getfBegin() {
		return fBegin;
	}
	public void setfBegin(Date fBegin) {
		this.fBegin = fBegin;
	}
	public Date getfEnd() {
		return fEnd;
	}
	public void setfEnd(Date fEnd) {
		this.fEnd = fEnd;
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
	public Date getUPDATET() {
		return UPDATET;
	}
	public void setUPDATET(Date uPDATET) {
		UPDATET = uPDATET;
	}
	public Integer getUPUSERID() {
		return UPUSERID;
	}
	public void setUPUSERID(Integer uPUSERID) {
		UPUSERID = uPUSERID;
	}
	
	
	@Override
	public String toString() {
		return "Fee [fId=" + fId + ", fName=" + fName + ", fDcost=" + fDcost + ", fDescription=" + fDescription
				+ ", fBegin=" + fBegin + ", fEnd=" + fEnd + ", INSDATE=" + INSDATE + ", INSUSERID=" + INSUSERID
				+ ", UPDATET=" + UPDATET + ", UPUSERID=" + UPUSERID + "]";
	}
	public Fee(Integer fId, String fName, Double fDcost, String fDescription, Date fBegin, Date fEnd, Date iNSDATE,
			Integer iNSUSERID, Date uPDATET, Integer uPUSERID) {
		super();
		this.fId = fId;
		this.fName = fName;
		this.fDcost = fDcost;
		this.fDescription = fDescription;
		this.fBegin = fBegin;
		this.fEnd = fEnd;
		INSDATE = iNSDATE;
		INSUSERID = iNSUSERID;
		UPDATET = uPDATET;
		UPUSERID = uPUSERID;
	}

	
	
}
