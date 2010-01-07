package com.law.bean;

import java.util.Date;
import java.util.List;
/**
 * 说明：登陆对象类，对登陆对象进行描述
 *
 */
public class Login {
	//登陆标识
	private String id="";
	//关联用户标识
	private String userid = "";
	//登陆名称
	private String name = "";
	//密码
	private String pw = "";
	//状态
	private String status="";
	//启用时间
	private Date sdate = null;
	//终止时间
	private Date edate = null;
	//角色列表
	private List<String> role = null;
	
	//系统标识
	private String sysid = "";
	
	public Login(String system,String loginID) {
		this.sysid = system;
		this.id = loginID;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public String getSysid() {
		return sysid;
	}
}