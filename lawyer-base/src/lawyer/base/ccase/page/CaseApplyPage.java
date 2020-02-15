package lawyer.base.ccase.page;

import com.base.page.BasePage;

/**
 * <b>功能：</b>CaseApplyPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class CaseApplyPage extends BasePage {
		private java.lang.Integer status;//   状态	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer caseId;//   案件序号	private java.lang.String src;//   案件来源	private java.lang.String supply;//   案源人	private java.util.Date applyDate;//   申请公证日期	private java.lang.String applicant;//   公证书申请人	private java.lang.String forensics;//   取证人	private java.lang.String violateType;//   侵权类型	private java.lang.String violateDesc;//   侵权概况	private java.util.Date actionDate;//   案件可诉确认日期	private java.util.Date litigantAcDate;//   当事人确认日期
	
	private java.lang.String litigant;//   当事人
	private java.lang.String defendantName;//   被告名称
	private java.lang.String defendantRegCapital;//   被告注册资本
	private java.lang.String defendantArea;//   被告所在地
	private java.lang.String delFlag;//   删除标记
	
	private java.lang.String supplyName;
	private java.lang.String applicantName;
	private java.lang.String forensicsName;	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getCaseId() {	    return this.caseId;	}	public void setCaseId(java.lang.Integer caseId) {	    this.caseId=caseId;	}	public java.lang.String getSrc() {	    return this.src;	}	public void setSrc(java.lang.String src) {	    this.src=src;	}	public java.lang.String getSupply() {	    return this.supply;	}	public void setSupply(java.lang.String supply) {	    this.supply=supply;	}	public java.util.Date getApplyDate() {	    return this.applyDate;	}	public void setApplyDate(java.util.Date applyDate) {	    this.applyDate=applyDate;	}	public java.lang.String getApplicant() {	    return this.applicant;	}	public void setApplicant(java.lang.String applicant) {	    this.applicant=applicant;	}	public java.lang.String getForensics() {	    return this.forensics;	}	public void setForensics(java.lang.String forensics) {	    this.forensics=forensics;	}	public java.lang.String getViolateType() {	    return this.violateType;	}	public void setViolateType(java.lang.String violateType) {	    this.violateType=violateType;	}	public java.lang.String getViolateDesc() {	    return this.violateDesc;	}	public void setViolateDesc(java.lang.String violateDesc) {	    this.violateDesc=violateDesc;	}	public java.util.Date getActionDate() {	    return this.actionDate;	}	public void setActionDate(java.util.Date actionDate) {	    this.actionDate=actionDate;	}	public java.util.Date getLitigantAcDate() {	    return this.litigantAcDate;	}	public void setLitigantAcDate(java.util.Date litigantAcDate) {	    this.litigantAcDate=litigantAcDate;	}
	public java.lang.String getLitigant() {
		return litigant;
	}
	public void setLitigant(java.lang.String litigant) {
		this.litigant = litigant;
	}
	public java.lang.String getDefendantName() {
		return defendantName;
	}
	public void setDefendantName(java.lang.String defendantName) {
		this.defendantName = defendantName;
	}
	public java.lang.String getDefendantRegCapital() {
		return defendantRegCapital;
	}
	public void setDefendantRegCapital(java.lang.String defendantRegCapital) {
		this.defendantRegCapital = defendantRegCapital;
	}
	public java.lang.String getDefendantArea() {
		return defendantArea;
	}
	public void setDefendantArea(java.lang.String defendantArea) {
		this.defendantArea = defendantArea;
	}
	public java.lang.String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(java.lang.String delFlag) {
		this.delFlag = delFlag;
	}
	public java.lang.String getSupplyName() {
		return supplyName;
	}
	public void setSupplyName(java.lang.String supplyName) {
		this.supplyName = supplyName;
	}
	public java.lang.String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(java.lang.String applicantName) {
		this.applicantName = applicantName;
	}
	public java.lang.String getForensicsName() {
		return forensicsName;
	}
	public void setForensicsName(java.lang.String forensicsName) {
		this.forensicsName = forensicsName;
	}
}