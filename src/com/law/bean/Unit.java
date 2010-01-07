package com.law.bean;

import java.util.Date;
/**
 * 说明：组织结构节点类
 *
 */
public class Unit {
	//组织节点关联的部门标识
	private String depid = "";
	//组织节点的用户标识
	private String userid = "";
	//成员户进入组织节点的时间
	private Date sdate = null;
	//成员调出组织节点时间
	private Date edate = null;
	//成员状态
	private String status = "";
	//组织节点上级部门标识
	private String superdepid = "";
	//隶属的系统标识
	private String sysid="";
	
	public Unit(String system,String depID,String userID) {
		this.sysid = system;
		this.depid = depID;
		this.userid = userID;
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

	public String getDepid() {
		return depid;
	}

	public String getUserid() {
		return userid;
	}

	public String getSuperdepid() {
		return superdepid;
	}

	public void setSuperdepid(String superdepid) {
		this.superdepid = superdepid;
	}

	public String getSysid() {
		return sysid;
	}
}