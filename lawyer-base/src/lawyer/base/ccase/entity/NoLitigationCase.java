package lawyer.base.ccase.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * <b>功能：</b>NoLitigationCaseEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-10 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class NoLitigationCase extends BaseEntity {
	private java.lang.Integer status;//   状态	private java.lang.String delFlag;//   删除标记	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer id;//   案件序号	private java.lang.Integer nolitigationCustomerId;//   非诉业务客户ID	private java.lang.String billingModel;//   计费模式	private java.lang.String billingStandard;//   计费标准
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date receiveDate;//   需求接收日期	private java.lang.String src;//   接收途径	private java.lang.String workContent;//   工作内容	private java.lang.String partyDraftName;//   当事人底稿名称	private java.lang.String contractParty;//   合同相对放
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date respDate;//   返稿日期	private java.lang.String respFileName;//   律师返稿文件名称	private java.lang.String accountTime;//   核算用时	private java.lang.String remark;//   特殊情况备注
	
	private java.lang.String custDelFlag;
	private java.lang.String client;
	private java.lang.String principal;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date commissionSdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date commissionEdate;
		public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(java.lang.String delFlag) {	    this.delFlag=delFlag;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.Integer getNolitigationCustomerId() {	    return this.nolitigationCustomerId;	}	public void setNolitigationCustomerId(java.lang.Integer nolitigationCustomerId) {	    this.nolitigationCustomerId=nolitigationCustomerId;	}	public java.lang.String getBillingModel() {	    return this.billingModel;	}	public void setBillingModel(java.lang.String billingModel) {	    this.billingModel=billingModel;	}	public java.lang.String getBillingStandard() {	    return this.billingStandard;	}	public void setBillingStandard(java.lang.String billingStandard) {	    this.billingStandard=billingStandard;	}	public java.util.Date getReceiveDate() {	    return this.receiveDate;	}	public void setReceiveDate(java.util.Date receiveDate) {	    this.receiveDate=receiveDate;	}	public java.lang.String getSrc() {	    return this.src;	}	public void setSrc(java.lang.String src) {	    this.src=src;	}	public java.lang.String getWorkContent() {	    return this.workContent;	}	public void setWorkContent(java.lang.String workContent) {	    this.workContent=workContent;	}	public java.lang.String getPartyDraftName() {	    return this.partyDraftName;	}	public void setPartyDraftName(java.lang.String partyDraftName) {	    this.partyDraftName=partyDraftName;	}	public java.lang.String getContractParty() {	    return this.contractParty;	}	public void setContractParty(java.lang.String contractParty) {	    this.contractParty=contractParty;	}	public java.util.Date getRespDate() {	    return this.respDate;	}	public void setRespDate(java.util.Date respDate) {	    this.respDate=respDate;	}	public java.lang.String getRespFileName() {	    return this.respFileName;	}	public void setRespFileName(java.lang.String respFileName) {	    this.respFileName=respFileName;	}	public java.lang.String getAccountTime() {	    return this.accountTime;	}	public void setAccountTime(java.lang.String accountTime) {	    this.accountTime=accountTime;	}	public java.lang.String getRemark() {	    return this.remark;	}	public void setRemark(java.lang.String remark) {	    this.remark=remark;	}
	public java.lang.String getCustDelFlag() {
		return custDelFlag;
	}
	public void setCustDelFlag(java.lang.String custDelFlag) {
		this.custDelFlag = custDelFlag;
	}
	public java.lang.String getClient() {
		return client;
	}
	public void setClient(java.lang.String client) {
		this.client = client;
	}
	public java.lang.String getPrincipal() {
		return principal;
	}
	public void setPrincipal(java.lang.String principal) {
		this.principal = principal;
	}
	public java.util.Date getCommissionSdate() {
		return commissionSdate;
	}
	public void setCommissionSdate(java.util.Date commissionSdate) {
		this.commissionSdate = commissionSdate;
	}
	public java.util.Date getCommissionEdate() {
		return commissionEdate;
	}
	public void setCommissionEdate(java.util.Date commissionEdate) {
		this.commissionEdate = commissionEdate;
	}
}