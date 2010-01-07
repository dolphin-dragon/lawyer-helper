package com.law.bean;
/**
 * 说明：单位联系人类，对联系人是单位类型的进行信息描述
 * 
 */
public class Organization implements IContacter{
	//联系单位标识
	private String id = "";
	//联系单位名称
	private String name="";
	//联系单位地址
	private String address="";
	//联系单位法人代表
	private String lawyer = "";
	//联系单位电话
	private String phone="";
	//联系单位说明
	private String desc="";
	//联系单位类型标识
	private final String type = IContacter.USER_TYPE.ORGANIZATION.name();
	//系统标识
	private String sysid = "";
	
	public Organization(String system,String id, String name) {
		this.sysid = system;
		this.id = id;
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLawyer() {
		return lawyer;
	}
	public void setLawyer(String lawyer) {
		this.lawyer = lawyer;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getSysid() {
		return sysid;
	}
}