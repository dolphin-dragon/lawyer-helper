package lawyer.base.ccase.page;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <b>功能：</b>CasePreLitigationPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class CasePreLitigationPage extends CaseInfoPage {
		private java.lang.Integer status;//   状态	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer caseId;//   案件序号	private java.lang.String letter;//   律师函编号	private java.lang.String letteror;//   律师函主办人
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date sendDate;//   律师函发送日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date deliveryDate;//   律师函送达日期	private java.lang.String isClose;//   是否结案	private java.lang.String remark;//   备注

	private java.lang.String isDirectAction;//是否诉讼

	private java.lang.String letterorName;	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getCaseId() {	    return this.caseId;	}	public void setCaseId(java.lang.Integer caseId) {	    this.caseId=caseId;	}	public java.lang.String getLetter() {	    return this.letter;	}	public void setLetter(java.lang.String letter) {	    this.letter=letter;	}	public java.lang.String getLetteror() {	    return this.letteror;	}	public void setLetteror(java.lang.String letteror) {	    this.letteror=letteror;	}	public java.util.Date getSendDate() {	    return this.sendDate;	}	public void setSendDate(java.util.Date sendDate) {	    this.sendDate=sendDate;	}	public java.util.Date getDeliveryDate() {	    return this.deliveryDate;	}	public void setDeliveryDate(java.util.Date deliveryDate) {	    this.deliveryDate=deliveryDate;	}	public java.lang.String getIsClose() {	    return this.isClose;	}	public void setIsClose(java.lang.String isClose) {	    this.isClose=isClose;	}	public java.lang.String getRemark() {	    return this.remark;	}	public void setRemark(java.lang.String remark) {	    this.remark=remark;	}
	public java.lang.String getLetterorName() {
		return letterorName;
	}
	public void setLetterorName(java.lang.String letterorName) {
		this.letterorName = letterorName;
	}
	public java.lang.String getIsDirectAction() {
		return isDirectAction;
	}
	public void setIsDirectAction(java.lang.String isDirectAction) {
		this.isDirectAction = isDirectAction;
	}
}