package com.law.bean;
/**
 * ˵������ϵ�ˣ�ָ��ͨ����Ȼ����ϵ��
 *
 */
public class LinkMan implements IContacter {
	//��ϵ�˱�ʶ
	private String id="";
	//��ϵ������
	private String name="";
	//��ϵ���Ա��ʶ
	private String sex="";
	//��ϵ���Ա�����
	private String sexName="";
	//��ϵ�˵绰
	private String phone="";
	//��ϵ��Email
	private String email="";
	//ϵͳ��ʶ
	private String sysid="";
	//�����˱�ʶ
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