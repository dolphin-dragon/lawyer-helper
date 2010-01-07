package com.law.bean;

import java.util.Date;

/**
 * 说明：案源类，对案源的基本信息进行描述
 *
 */
public class CaseSource {
	//案源标识
	private String id = "";
	//案源名称
	private String name = "";
	//案源创建者名称
	private String creator = "";
	//案源创建人标识
	private String creatorid = "";
	//接收案源时间，案源创建时间
	private Date sdate = null;
	//案源结束时间
	private Date edate = null;
	//案源提供者名称，一般是本系统内员工
	private String provider = "";
	//案源提供者标识
	private String providerid = "";
	//案源负责人，一般是创建者
	private String undertaker = "";
	//案源负责人标识
	private String undertakerid = "";
	//案源的联系人，即案源的当事人
	private String contacter = "";
	//案源的联系人标识
	private String contacterid = "";
	//联系人身份角色，联系人身份角色主要包括原告1、被告2两类
	private String contracteRole = "";
	//联系人身份角色名称，原告、被告
	private String contracteRoleName = "";
	
	//案源联系人的类型，包括普通联系人、联系单位两类
	private String contactType = "";
	//案源状态，一般分为潜在的跟踪案源1、签订委托协议的案源（案件，形成案源案卷）2、删除状态7（案源异常结束）、归档案源3（正常代理完毕后的案源）
	private String status = "";
	//案源状态标识
	private String statusid = "";
	//案源删除原因
	private String reason ="";

	//案源的类型
	private String type = "";
	//案源类型标识
	private String typeid = "";

	//案源描述
	private String desc = "";
	//系统标识
	private String sysid="";
	//接收案源方式，一般包括上级部门制定、所内制定、个人提供等
	private String caseWay = "";
	//案源编号
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