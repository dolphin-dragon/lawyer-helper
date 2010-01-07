package com.law.bean;

import java.util.Date;

/**
 * ˵������Դ�࣬�԰�Դ�Ļ�����Ϣ��������
 *
 */
public class CaseSource {
	//��Դ��ʶ
	private String id = "";
	//��Դ����
	private String name = "";
	//��Դ����������
	private String creator = "";
	//��Դ�����˱�ʶ
	private String creatorid = "";
	//���հ�Դʱ�䣬��Դ����ʱ��
	private Date sdate = null;
	//��Դ����ʱ��
	private Date edate = null;
	//��Դ�ṩ�����ƣ�һ���Ǳ�ϵͳ��Ա��
	private String provider = "";
	//��Դ�ṩ�߱�ʶ
	private String providerid = "";
	//��Դ�����ˣ�һ���Ǵ�����
	private String undertaker = "";
	//��Դ�����˱�ʶ
	private String undertakerid = "";
	//��Դ����ϵ�ˣ�����Դ�ĵ�����
	private String contacter = "";
	//��Դ����ϵ�˱�ʶ
	private String contacterid = "";
	//��ϵ����ݽ�ɫ����ϵ����ݽ�ɫ��Ҫ����ԭ��1������2����
	private String contracteRole = "";
	//��ϵ����ݽ�ɫ���ƣ�ԭ�桢����
	private String contracteRoleName = "";
	
	//��Դ��ϵ�˵����ͣ�������ͨ��ϵ�ˡ���ϵ��λ����
	private String contactType = "";
	//��Դ״̬��һ���ΪǱ�ڵĸ��ٰ�Դ1��ǩ��ί��Э��İ�Դ���������γɰ�Դ����2��ɾ��״̬7����Դ�쳣���������鵵��Դ3������������Ϻ�İ�Դ��
	private String status = "";
	//��Դ״̬��ʶ
	private String statusid = "";
	//��Դɾ��ԭ��
	private String reason ="";

	//��Դ������
	private String type = "";
	//��Դ���ͱ�ʶ
	private String typeid = "";

	//��Դ����
	private String desc = "";
	//ϵͳ��ʶ
	private String sysid="";
	//���հ�Դ��ʽ��һ������ϼ������ƶ��������ƶ��������ṩ��
	private String caseWay = "";
	//��Դ���
	private String caseCode = "";

	public CaseSource(String system,String id, String name){
		this.sysid = system;
		this.id = id;
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
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getUndertaker() {
		return undertaker;
	}
	public void setUndertaker(String undertaker) {
		this.undertaker = undertaker;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getContacter() {
		return contacter;
	}
	public void setContacter(String contacter) {
		this.contacter = contacter;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public String getUndertakerid() {
		return undertakerid;
	}
	public void setUndertakerid(String undertakerid) {
		this.undertakerid = undertakerid;
	}
	public String getContacterid() {
		return contacterid;
	}
	public void setContacterid(String contacterid) {
		this.contacterid = contacterid;
	}
	public String getProviderid() {
		return providerid;
	}
	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStatusid() {
		return statusid;
	}
	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSysid() {
		return sysid;
	}
	public String getContracteRole() {
		return contracteRole;
	}
	public void setContracteRole(String contracteRole) {
		this.contracteRole = contracteRole;
	}
	public String getContracteRoleName() {
		return contracteRoleName;
	}
	public void setContracteRoleName(String contracteRoleName) {
		this.contracteRoleName = contracteRoleName;
	}
	public String getCaseWay() {
		return caseWay;
	}
	public void setCaseWay(String caseWay) {
		this.caseWay = caseWay;
	}
	public String getCaseCode() {
		return caseCode;
	}
	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}
}