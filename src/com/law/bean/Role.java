package com.law.bean;
/**
 * ˵������ɫ��
 *
 */
public class Role {
	//��ɫ��ʶ
	private String id = "";
	//��ɫ����
	private String name = "";
	//��ɫ˵��
	private String descript = "";
	//��ɫ״̬
	private String status = "";
	
	//ϵͳ��ʶ
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