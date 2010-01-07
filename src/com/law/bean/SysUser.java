package com.law.bean;

import java.util.Calendar;
import java.util.Date;

/**
 * 说明：系统内成员，包括系统用户和系统管理员
 * 
 */
public class SysUser implements IContacter {
	//系统成员标识
	private String _ID = "";
	//系统成员名称
	private String name="";
	//系统成员性别
	private String sex = "";
	//系统成员联系电话
	private String phone="";
	//系统成员联系Email
	private String email="";
	//系统成员详细住址
	private String address = "";
	//系统成员出生日期
	private Date birthday = null;
	//隶属的系统标识
	private String sysid="";
	//系统成员进入时间
	private Date worksDate = null;
	//系统成员离开时间
	private Date workeDate = null;
	//系统内成员状态，包括正常在职1、离职2、删除3
	private String status = "";
	//系统内成员年龄
	private int age = 0;
	//受教育程度，一般分为本科、硕士、博士、专科等
	private String education="";
	
	//MSN号码
	private String MSN="";
	//QQ号码
	private String QQ="";
	//职务
	private String position = "";
	//民族
	private String nationality="";
	
	//联系人类型
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
			//根据生日计算年龄
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