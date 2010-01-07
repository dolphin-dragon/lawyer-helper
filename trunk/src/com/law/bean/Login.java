package com.law.bean;

import java.util.Date;
import java.util.List;
/**
 * ˵������½�����࣬�Ե�½�����������
 *
 */
public class Login {
	//��½��ʶ
	private String id="";
	//�����û���ʶ
	private String userid = "";
	//��½����
	private String name = "";
	//����
	private String pw = "";
	//״̬
	private String status="";
	//����ʱ��
	private Date sdate = null;
	//��ֹʱ��
	private Date edate = null;
	//��ɫ�б�
	private List<String> role = null;
	
	//ϵͳ��ʶ
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