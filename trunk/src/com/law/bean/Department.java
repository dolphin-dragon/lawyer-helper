package com.law.bean;

import java.util.Date;
/**
 * ˵����������������ϵͳ����֯�����еĲ��Ž�������
 * 
 */
public class Department {
	//���ű�ʶ
	private String id = "";
	//��������
	private String name = "";
	//����״̬��1������״̬  2δ����״̬
	private String status = "";
	//���ų���ʱ��
	private Date sdate = null;
	//���ų���ʱ��
	private Date edate = null;
	//����˵��
	private String remarks = "";
	//���Ÿ�����
	private String principal= "";
	//����������ϵͳ��ʶ
	private String sysID="";
	
	public Department(String systemID,String depid) {
		id = depid;
		sysID = systemID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getId() {
		return id;
	}
	public String getSysID(){
		return sysID;
	}
}