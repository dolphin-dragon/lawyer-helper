package com.law.bean;

import java.util.Date;
/**
 * 说明:联系人分组的描述
 * 
 */
public class ContacterGroup {
	//联系人分组标识
	private String id = "";
	//联系人组名称
	private String name = "";
	//联系人组创建者
	private String creator = "";
	//联系人组创建者标识
	private String creatorid="";
	//联系人组创建时间
	private Date sdate = null;
	//联系人组删除时间
	private Date edate = null;
	//联系人组状态
	private String status = "";
	//系统标识
	private String sysid = "";
	
	public ContacterGroup(String system,String subjectid,String groupid) {
		id = groupid;
		creatorid = subjectid;
		sysid = system;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public String getSysid() {
		return sysid;
	}
}