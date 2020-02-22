package lawyer.base.ccase.page;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <b>功能：</b>CaseFirstInstancePage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class CaseFirstInstancePage extends CaseInfoPage {
		private java.lang.Integer status;//   状态	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer caseId;//   案件序号	private java.lang.String firstor;//   第一责任人	private java.lang.String lawyer;//   一审主办律师
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date submitDate;//   提交立案材料日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date establishDate;//   立案日期	private java.math.BigDecimal litigationCosts;//   诉讼费用	private java.math.BigDecimal announcementCosts;//   公告费用	private java.math.BigDecimal notaryCosts;//   公证费用	private java.math.BigDecimal otherCosts;//   其它费用	private java.lang.String adjudicationCourt;//   受理法院	private java.lang.String judge;//   主办法官	private java.lang.String judgeContact;//   联系方式
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date fcourtDate;//   一审开庭日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date fverdictDate;//   一审判决书落款日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date fverdictReceiveDate;//   一审判决书收到日期	private java.lang.String isApology;//   是否致歉	private java.math.BigDecimal defendantCompensationTotal;//   被告赔偿总额	private java.math.BigDecimal defendantExpenses;//   被告承担合理开支总额	private java.math.BigDecimal plaintiffCosts;//   原告承担诉费	private java.math.BigDecimal defendantCosts;//   被告承担诉费	private java.lang.String isClose;//   是否结案
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date appealDate;//   上诉截止日期	private java.lang.String remark;//   备注
	
	private java.lang.String isPreMediation;//是否诉前调解
	private java.lang.String isActionMediation;//是否诉中调解
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private java.util.Date mediationDate;//调解书日期
	private java.lang.String isAppeal;//是否上诉
	private java.lang.String appellant;//上诉人
	private java.lang.String isCarryOut;//是否需要执行
	
	private java.lang.String lawyerName;	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getCaseId() {	    return this.caseId;	}	public void setCaseId(java.lang.Integer caseId) {	    this.caseId=caseId;	}	public java.lang.String getFirstor() {	    return this.firstor;	}	public void setFirstor(java.lang.String firstor) {	    this.firstor=firstor;	}	public java.lang.String getLawyer() {	    return this.lawyer;	}	public void setLawyer(java.lang.String lawyer) {	    this.lawyer=lawyer;	}	public java.util.Date getSubmitDate() {	    return this.submitDate;	}	public void setSubmitDate(java.util.Date submitDate) {	    this.submitDate=submitDate;	}	public java.util.Date getEstablishDate() {	    return this.establishDate;	}	public void setEstablishDate(java.util.Date establishDate) {	    this.establishDate=establishDate;	}	public java.math.BigDecimal getLitigationCosts() {	    return this.litigationCosts;	}	public void setLitigationCosts(java.math.BigDecimal litigationCosts) {	    this.litigationCosts=litigationCosts;	}	public java.math.BigDecimal getAnnouncementCosts() {	    return this.announcementCosts;	}	public void setAnnouncementCosts(java.math.BigDecimal announcementCosts) {	    this.announcementCosts=announcementCosts;	}	public java.math.BigDecimal getNotaryCosts() {	    return this.notaryCosts;	}	public void setNotaryCosts(java.math.BigDecimal notaryCosts) {	    this.notaryCosts=notaryCosts;	}	public java.math.BigDecimal getOtherCosts() {	    return this.otherCosts;	}	public void setOtherCosts(java.math.BigDecimal otherCosts) {	    this.otherCosts=otherCosts;	}	public java.lang.String getAdjudicationCourt() {	    return this.adjudicationCourt;	}	public void setAdjudicationCourt(java.lang.String adjudicationCourt) {	    this.adjudicationCourt=adjudicationCourt;	}	public java.lang.String getJudge() {	    return this.judge;	}	public void setJudge(java.lang.String judge) {	    this.judge=judge;	}	public java.lang.String getJudgeContact() {	    return this.judgeContact;	}	public void setJudgeContact(java.lang.String judgeContact) {	    this.judgeContact=judgeContact;	}	public java.util.Date getFcourtDate() {
		return fcourtDate;
	}
	public void setFcourtDate(java.util.Date fcourtDate) {
		this.fcourtDate = fcourtDate;
	}
	public java.util.Date getFverdictDate() {
		return fverdictDate;
	}
	public void setFverdictDate(java.util.Date fverdictDate) {
		this.fverdictDate = fverdictDate;
	}
	public java.util.Date getFverdictReceiveDate() {
		return fverdictReceiveDate;
	}
	public void setFverdictReceiveDate(java.util.Date fverdictReceiveDate) {
		this.fverdictReceiveDate = fverdictReceiveDate;
	}	public java.lang.String getIsApology() {	    return this.isApology;	}	public void setIsApology(java.lang.String isApology) {	    this.isApology=isApology;	}	public java.math.BigDecimal getDefendantCompensationTotal() {	    return this.defendantCompensationTotal;	}	public void setDefendantCompensationTotal(java.math.BigDecimal defendantCompensationTotal) {	    this.defendantCompensationTotal=defendantCompensationTotal;	}	public java.math.BigDecimal getDefendantExpenses() {	    return this.defendantExpenses;	}	public void setDefendantExpenses(java.math.BigDecimal defendantExpenses) {	    this.defendantExpenses=defendantExpenses;	}	public java.math.BigDecimal getPlaintiffCosts() {	    return this.plaintiffCosts;	}	public void setPlaintiffCosts(java.math.BigDecimal plaintiffCosts) {	    this.plaintiffCosts=plaintiffCosts;	}	public java.math.BigDecimal getDefendantCosts() {	    return this.defendantCosts;	}	public void setDefendantCosts(java.math.BigDecimal defendantCosts) {	    this.defendantCosts=defendantCosts;	}	public java.lang.String getIsClose() {	    return this.isClose;	}	public void setIsClose(java.lang.String isClose) {	    this.isClose=isClose;	}	public java.util.Date getAppealDate() {	    return this.appealDate;	}	public void setAppealDate(java.util.Date appealDate) {	    this.appealDate=appealDate;	}	public java.lang.String getRemark() {	    return this.remark;	}	public void setRemark(java.lang.String remark) {	    this.remark=remark;	}
	public java.lang.String getLawyerName() {
		return lawyerName;
	}
	public void setLawyerName(java.lang.String lawyerName) {
		this.lawyerName = lawyerName;
	}
	public java.lang.String getIsPreMediation() {
		return isPreMediation;
	}
	public void setIsPreMediation(java.lang.String isPreMediation) {
		this.isPreMediation = isPreMediation;
	}
	public java.lang.String getIsActionMediation() {
		return isActionMediation;
	}
	public void setIsActionMediation(java.lang.String isActionMediation) {
		this.isActionMediation = isActionMediation;
	}
	public java.util.Date getMediationDate() {
		return mediationDate;
	}
	public void setMediationDate(java.util.Date mediationDate) {
		this.mediationDate = mediationDate;
	}
	public java.lang.String getIsAppeal() {
		return isAppeal;
	}
	public void setIsAppeal(java.lang.String isAppeal) {
		this.isAppeal = isAppeal;
	}
	public java.lang.String getAppellant() {
		return appellant;
	}
	public void setAppellant(java.lang.String appellant) {
		this.appellant = appellant;
	}
	public java.lang.String getIsCarryOut() {
		return isCarryOut;
	}
	public void setIsCarryOut(java.lang.String isCarryOut) {
		this.isCarryOut = isCarryOut;
	}
}