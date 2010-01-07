package com.law.bean;

import java.util.Calendar;
import java.util.Date;

/**
 * ˵����ϵͳ�ڳ�Ա������ϵͳ�û���ϵͳ����Ա
 * 
 */
public class SysUser implements IContacter {
	//ϵͳ��Ա��ʶ
	private String _ID = "";
	//ϵͳ��Ա����
	private String name="";
	//ϵͳ��Ա�Ա�
	private String sex = "";
	//ϵͳ��Ա��ϵ�绰
	private String phone="";
	//ϵͳ��Ա��ϵEmail
	private String email="";
	//ϵͳ��Ա��ϸסַ
	private String address = "";
	//ϵͳ��Ա��������
	private Date birthday = null;
	//������ϵͳ��ʶ
	private String sysid="";
	//ϵͳ��Ա����ʱ��
	private Date worksDate = null;
	//ϵͳ��Ա�뿪ʱ��
	private Date workeDate = null;
	//ϵͳ�ڳ�Ա״̬������������ְ1����ְ2��ɾ��3
	private String status = "";
	//ϵͳ�ڳ�Ա����
	private int age = 0;
	//�ܽ����̶ȣ�һ���Ϊ���ơ�˶ʿ����ʿ��ר�Ƶ�
	private String education="";
	
	//MSN����
	private String MSN="";
	//QQ����
	private String QQ="";
	//ְ��
	private String position = "";
	//����
	private String nationality="";
	
	//��ϵ������
	private final String type = IContacter.USER_TYPE.SYSUSER.name();
	
	
	public SysUser(String sysid,String id,String name){
		this.sysid = sysid;
		this._ID = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
		if(null != birthday){
			//�������ռ�������
			int now = Calendar.getInstance().get(Calendar.YEAR);
			Calendar birth = Calendar.getInstance();
			birth.setTime(birthday);
			this.age = (now-birth.get(Calendar.YEAR));			
		}else
			this.age = 0;
	}
	public String get_ID() {
		return _ID;
	}
	public String getName() {
		return name;
	}
	public String getType(){
		return type;
	}
	public Date getWorksDate() {
		return worksDate;
	}
	public void setWorksDate(Date worksDate) {
		this.worksDate = worksDate;
	}
	public Date getWorkeDate() {
		return workeDate;
	}
	public void setWorkeDate(Date workeDate) {
		this.workeDate = workeDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSysid() {
		return sysid;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMSN() {
		return MSN;
	}
	public void setMSN(String mSN) {
		MSN = mSN;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}