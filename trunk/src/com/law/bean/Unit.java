package com.law.bean;

import java.util.Date;
/**
 * ˵������֯�ṹ�ڵ���
 *
 */
public class Unit {
	//��֯�ڵ�����Ĳ��ű�ʶ
	private String depid = "";
	//��֯�ڵ���û���ʶ
	private String userid = "";
	//��Ա��������֯�ڵ��ʱ��
	private Date sdate = null;
	//��Ա������֯�ڵ�ʱ��
	private Date edate = null;
	//��Ա״̬
	private String status = "";
	//��֯�ڵ��ϼ����ű�ʶ
	private String superdepid = "";
	//������ϵͳ��ʶ
	private String sysid="";
	
	public Unit(String system,String depID,String userID) {
		this.sysid = system;
		this.depid = depID;
		this.userid = userID;
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

	public String getDepid() {
		return depid;
	}

	public String getUserid() {
		return userid;
	}

	public String getSuperdepid() {
		return superdepid;
	}

	public void setSuperdepid(String superdepid) {
		this.superdepid = superdepid;
	}

	public String getSysid() {
		return sysid;
	}
}