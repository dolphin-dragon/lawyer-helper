package com.law.bean;
/**
 * ˵������λ��ϵ���࣬����ϵ���ǵ�λ���͵Ľ�����Ϣ����
 * 
 */
public class Organization implements IContacter{
	//��ϵ��λ��ʶ
	private String id = "";
	//��ϵ��λ����
	private String name="";
	//��ϵ��λ��ַ
	private String address="";
	//��ϵ��λ���˴���
	private String lawyer = "";
	//��ϵ��λ�绰
	private String phone="";
	//��ϵ��λ˵��
	private String desc="";
	//��ϵ��λ���ͱ�ʶ
	private final String type = IContacter.USER_TYPE.ORGANIZATION.name();
	//ϵͳ��ʶ
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