package com.law.bean;
/**
 * 说明：角色类
 *
 */
public class Role {
	//角色标识
	private String id = "";
	//角色名称
	private String name = "";
	//角色说明
	private String descript = "";
	//角色状态
	private String status = "";
	
	//系统标识
	private String sysid = "";
	
	public Role(String system,String roleID) {
		this.sysid = system;
		id = roleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
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
	public String getSysid() {
		return sysid;
	}
}