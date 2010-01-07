package com.law.bean;
/**
 * 说明：联系人，指普通的自然人联系人
 *
 */
public class LinkMan implements IContacter {
	//联系人标识
	private String id="";
	//联系人名称
	private String name="";
	//联系人性别标识
	private String sex="";
	//联系人性别名称
	private String sexName="";
	//联系人电话
	private String phone="";
	//联系人Email
	private String email="";
	//系统标识
	private String sysid="";
	//创建人标识
	private String creator = "";
	
	public LinkMan(String system,String id,String name) {
		this.sysid = system;
		this.id = id;
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getSysid() {
		return sysid;
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
	
}