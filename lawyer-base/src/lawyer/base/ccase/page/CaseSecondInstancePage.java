package lawyer.base.ccase.page;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <b>功能：</b>CaseSecondInstancePage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class CaseSecondInstancePage extends CaseInfoPage {
		private java.lang.Integer status;//   状态	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer caseId;//   案件序号	private java.lang.String lawyer;//   二审主办律师
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date scourtDate;//   二审开庭日期	private java.lang.String judge;//   主办法官	private java.lang.String judgeContact;//   联系方式
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date sjudgmentEffectiveDate;//   二审判决生效日期	private java.lang.String isApology;//   是否致歉	private java.lang.String defendantCompensationTotal;//   一审被告赔偿总额	private java.lang.String defendantExpenses;//   一审被告承担合理开支费用	private java.lang.String plaintiffCosts;//   一审原告承担诉费	private java.math.BigDecimal defendantCosts;//   一审被告承担诉费	private java.lang.String isClose;//   是否结案
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date executionDeadline;//   执行截止日期	private java.lang.String remark;//   备注

	private java.lang.String isCarryOut;//是否需要执行

	private java.lang.String lawyerName;	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getCaseId() {	    return this.caseId;	}	public void setCaseId(java.lang.Integer caseId) {	    this.caseId=caseId;	}	public java.lang.String getLawyer() {	    return this.lawyer;	}	public void setLawyer(java.lang.String lawyer) {	    this.lawyer=lawyer;	}	public java.util.Date getScourtDate() {
		return scourtDate;
	}
	public void setScourtDate(java.util.Date scourtDate) {
		this.scourtDate = scourtDate;
	}
	public java.lang.String getJudge() {	    return this.judge;	}	public void setJudge(java.lang.String judge) {	    this.judge=judge;	}	public java.lang.String getJudgeContact() {	    return this.judgeContact;	}	public void setJudgeContact(java.lang.String judgeContact) {	    this.judgeContact=judgeContact;	}
	public java.util.Date getSjudgmentEffectiveDate() {
		return sjudgmentEffectiveDate;
	}
	public void setSjudgmentEffectiveDate(java.util.Date sjudgmentEffectiveDate) {
		this.sjudgmentEffectiveDate = sjudgmentEffectiveDate;
	}
	public java.lang.String getIsApology() {	    return this.isApology;	}	public void setIsApology(java.lang.String isApology) {	    this.isApology=isApology;	}	public java.lang.String getDefendantCompensationTotal() {	    return this.defendantCompensationTotal;	}	public void setDefendantCompensationTotal(java.lang.String defendantCompensationTotal) {	    this.defendantCompensationTotal=defendantCompensationTotal;	}	public java.lang.String getDefendantExpenses() {	    return this.defendantExpenses;	}	public void setDefendantExpenses(java.lang.String defendantExpenses) {	    this.defendantExpenses=defendantExpenses;	}	public java.lang.String getPlaintiffCosts() {	    return this.plaintiffCosts;	}	public void setPlaintiffCosts(java.lang.String plaintiffCosts) {	    this.plaintiffCosts=plaintiffCosts;	}	public java.math.BigDecimal getDefendantCosts() {	    return this.defendantCosts;	}	public void setDefendantCosts(java.math.BigDecimal defendantCosts) {	    this.defendantCosts=defendantCosts;	}	public java.lang.String getIsClose() {	    return this.isClose;	}	public void setIsClose(java.lang.String isClose) {	    this.isClose=isClose;	}	public java.util.Date getExecutionDeadline() {	    return this.executionDeadline;	}	public void setExecutionDeadline(java.util.Date executionDeadline) {	    this.executionDeadline=executionDeadline;	}	public java.lang.String getRemark() {	    return this.remark;	}	public void setRemark(java.lang.String remark) {	    this.remark=remark;	}
	public java.lang.String getLawyerName() {
		return lawyerName;
	}
	public void setLawyerName(java.lang.String lawyerName) {
		this.lawyerName = lawyerName;
	}
	public java.lang.String getIsCarryOut() {
		return isCarryOut;
	}
	public void setIsCarryOut(java.lang.String isCarryOut) {
		this.isCarryOut = isCarryOut;
	}
}