package com.law.bean;

import java.util.Date;
/**
 * ˵��:��ϵ�˷��������
 * 
 */
public class ContacterGroup {
	//��ϵ�˷����ʶ
	private String id = "";
	//��ϵ��������
	private String name = "";
	//��ϵ���鴴����
	private String creator = "";
	//��ϵ���鴴���߱�ʶ
	private String creatorid="";
	//��ϵ���鴴��ʱ��
	private Date sdate = null;
	//��ϵ����ɾ��ʱ��
	private Date edate = null;
	//��ϵ����״̬
	private String status = "";
	//ϵͳ��ʶ
	private String sysid = "";
	
	public ContacterGroup(String system,String subjectid,String groupid) {
		id = groupid;
		creatorid = subjectid;
		sysid = system;
	}
	public String getName() {
		return name;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public String getSysid() {
		return sysid;
	}
}