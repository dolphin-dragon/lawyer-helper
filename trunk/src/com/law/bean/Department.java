package com.law.bean;

import java.util.Date;
/**
 * 说明：部门描述，对系统中组织机构中的部门进行描述
 * 
 */
public class Department {
	//部门标识
	private String id = "";
	//部门名称
	private String name = "";
	//部门状态，1是启用状态  2未启用状态
	private String status = "";
	//部门成立时间
	private Date sdate = null;
	//部门撤销时间
	private Date edate = null;
	//部门说明
	private String remarks = "";
	//部门负责人
	private String principal= "";
	//部门隶属的系统标识
	private String sysID="";
	
	public Department(String systemID,String depid) {
		id = depid;
		sysID = systemID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getId() {
		return id;
	}
	public String getSysID(){
		return sysID;
	}
}