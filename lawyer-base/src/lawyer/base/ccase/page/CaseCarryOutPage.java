package lawyer.base.ccase.page;

/**
 * <b>功能：</b>CaseCarryOutPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class CaseCarryOutPage extends CaseInfoPage {
		private java.lang.Integer status;//   状态	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer caseId;//   案件序号	private java.lang.String lawyer;//   执行主办律师	private java.util.Date appDate;//   执行申请日期	private java.math.BigDecimal appTotal;//   申请执行总额	private java.lang.String judge;//   执行主办法官	private java.lang.String judgeContact;//   联系方式	private java.math.BigDecimal actualTotal;//   实际执行总额	private java.lang.String fcollectionSubject;//   首位收款主体	private java.lang.String remark;//   备注
	
	private java.lang.String lawyerName;	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getCaseId() {	    return this.caseId;	}	public void setCaseId(java.lang.Integer caseId) {	    this.caseId=caseId;	}	public java.lang.String getLawyer() {	    return this.lawyer;	}	public void setLawyer(java.lang.String lawyer) {	    this.lawyer=lawyer;	}	public java.util.Date getAppDate() {	    return this.appDate;	}	public void setAppDate(java.util.Date appDate) {	    this.appDate=appDate;	}	public java.math.BigDecimal getAppTotal() {	    return this.appTotal;	}	public void setAppTotal(java.math.BigDecimal appTotal) {	    this.appTotal=appTotal;	}	public java.lang.String getJudge() {	    return this.judge;	}	public void setJudge(java.lang.String judge) {	    this.judge=judge;	}	public java.lang.String getJudgeContact() {	    return this.judgeContact;	}	public void setJudgeContact(java.lang.String judgeContact) {	    this.judgeContact=judgeContact;	}	public java.math.BigDecimal getActualTotal() {	    return this.actualTotal;	}	public void setActualTotal(java.math.BigDecimal actualTotal) {	    this.actualTotal=actualTotal;	}	public java.lang.String getFcollectionSubject() {
	    return this.fcollectionSubject;
	}
	public void setFcollectionSubject(java.lang.String fcollectionSubject) {
	    this.fcollectionSubject=fcollectionSubject;
	}	public java.lang.String getRemark() {	    return this.remark;	}	public void setRemark(java.lang.String remark) {	    this.remark=remark;	}
	public java.lang.String getLawyerName() {
		return lawyerName;
	}
	public void setLawyerName(java.lang.String lawyerName) {
		this.lawyerName = lawyerName;
	}
}