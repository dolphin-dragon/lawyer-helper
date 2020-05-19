package lawyer.base.ccase.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * <b>功能：</b>ArbitrationCaseEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-04-28 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class ArbitrationCase extends BaseEntity {
	private java.lang.Integer status;//   状态	private java.lang.String delFlag;//   删除标记	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人
	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人
	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer id;//   案件序号	private java.lang.String src;//   案件来源	private java.lang.String supply;//   案源人	private java.lang.String litigant;//   当事人	private java.lang.String cause;//   案由	private java.lang.String applicant;//   申请人	private java.lang.String respondent;//   被申请人	private java.lang.String request;//   反请求状况
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date trustDate;//   委托协议日期	private java.lang.String lawyer;//   主办律师	private java.lang.String agent;//   出庭代理人	private java.lang.String chiefArbitrator;//   首席仲裁员	private java.lang.String ourSide;//   我方边裁	private java.lang.String otherSide;//   对方边裁	private java.lang.String arbSecretary;//   仲裁秘书	private java.lang.String secretaryContact;//   仲裁秘书联系方式	private java.lang.String opCourtNums;//   开庭次数
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date opCourtDate;//   开庭日期	private java.lang.String closType;//   结案方式
	
	private java.lang.String supplyName;
	private java.lang.String lawyerName;
	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(java.lang.String delFlag) {	    this.delFlag=delFlag;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getSrc() {	    return this.src;	}	public void setSrc(java.lang.String src) {	    this.src=src;	}	public java.lang.String getSupply() {	    return this.supply;	}	public void setSupply(java.lang.String supply) {	    this.supply=supply;	}	public java.lang.String getLitigant() {	    return this.litigant;	}	public void setLitigant(java.lang.String litigant) {	    this.litigant=litigant;	}	public java.lang.String getCause() {	    return this.cause;	}	public void setCause(java.lang.String cause) {	    this.cause=cause;	}	public java.lang.String getApplicant() {	    return this.applicant;	}	public void setApplicant(java.lang.String applicant) {	    this.applicant=applicant;	}	public java.lang.String getRespondent() {	    return this.respondent;	}	public void setRespondent(java.lang.String respondent) {	    this.respondent=respondent;	}	public java.lang.String getRequest() {	    return this.request;	}	public void setRequest(java.lang.String request) {	    this.request=request;	}	public java.util.Date getTrustDate() {	    return this.trustDate;	}	public void setTrustDate(java.util.Date trustDate) {	    this.trustDate=trustDate;	}	public java.lang.String getLawyer() {	    return this.lawyer;	}	public void setLawyer(java.lang.String lawyer) {	    this.lawyer=lawyer;	}	public java.lang.String getAgent() {	    return this.agent;	}	public void setAgent(java.lang.String agent) {	    this.agent=agent;	}	public java.lang.String getChiefArbitrator() {	    return this.chiefArbitrator;	}	public void setChiefArbitrator(java.lang.String chiefArbitrator) {	    this.chiefArbitrator=chiefArbitrator;	}	public java.lang.String getOurSide() {	    return this.ourSide;	}	public void setOurSide(java.lang.String ourSide) {	    this.ourSide=ourSide;	}	public java.lang.String getOtherSide() {	    return this.otherSide;	}	public void setOtherSide(java.lang.String otherSide) {	    this.otherSide=otherSide;	}	public java.lang.String getArbSecretary() {	    return this.arbSecretary;	}	public void setArbSecretary(java.lang.String arbSecretary) {	    this.arbSecretary=arbSecretary;	}	public java.lang.String getSecretaryContact() {	    return this.secretaryContact;	}	public void setSecretaryContact(java.lang.String secretaryContact) {	    this.secretaryContact=secretaryContact;	}	public java.lang.String getOpCourtNums() {	    return this.opCourtNums;	}	public void setOpCourtNums(java.lang.String opCourtNums) {	    this.opCourtNums=opCourtNums;	}	public java.util.Date getOpCourtDate() {	    return this.opCourtDate;	}	public void setOpCourtDate(java.util.Date opCourtDate) {	    this.opCourtDate=opCourtDate;	}	public java.lang.String getClosType() {	    return this.closType;	}	public void setClosType(java.lang.String closType) {	    this.closType=closType;	}
	public java.lang.String getSupplyName() {
		return supplyName;
	}
	public void setSupplyName(java.lang.String supplyName) {
		this.supplyName = supplyName;
	}
	public java.lang.String getLawyerName() {
		return lawyerName;
	}
	public void setLawyerName(java.lang.String lawyerName) {
		this.lawyerName = lawyerName;
	}
}