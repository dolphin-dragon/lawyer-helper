package lawyer.base.ccase.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * <b>功能：</b>CriminalCaseEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-04-28 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class CriminalCase extends BaseEntity {
	private java.lang.Integer status;//   状态	private java.lang.String delFlag;//   删除标记	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人
	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人
	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer id;//   案件序号	private java.lang.String src;//   案件来源	private java.lang.String supply;//   案源人
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date commissionDate;//   签署委托日期	private java.lang.String client;//   委托人	private java.lang.String lawyer;//   代理律师	private java.lang.String litigant;//   当事人	private java.lang.String suspectedCharges;//   涉嫌罪名	private java.lang.String actionStage;//   诉讼阶段
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date judgmentDate;//   判决日期	private java.lang.String isClose;//   是否结案
	
	private java.lang.String supplyName;
	private java.lang.String lawyerName;	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(java.lang.String delFlag) {	    this.delFlag=delFlag;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getSrc() {	    return this.src;	}	public void setSrc(java.lang.String src) {	    this.src=src;	}	public java.lang.String getSupply() {	    return this.supply;	}	public void setSupply(java.lang.String supply) {	    this.supply=supply;	}	public java.util.Date getCommissionDate() {	    return this.commissionDate;	}	public void setCommissionDate(java.util.Date commissionDate) {	    this.commissionDate=commissionDate;	}	public java.lang.String getClient() {	    return this.client;	}	public void setClient(java.lang.String client) {	    this.client=client;	}	public java.lang.String getLawyer() {	    return this.lawyer;	}	public void setLawyer(java.lang.String lawyer) {	    this.lawyer=lawyer;	}	public java.lang.String getLitigant() {	    return this.litigant;	}	public void setLitigant(java.lang.String litigant) {	    this.litigant=litigant;	}	public java.lang.String getSuspectedCharges() {	    return this.suspectedCharges;	}	public void setSuspectedCharges(java.lang.String suspectedCharges) {	    this.suspectedCharges=suspectedCharges;	}	public java.lang.String getActionStage() {	    return this.actionStage;	}	public void setActionStage(java.lang.String actionStage) {	    this.actionStage=actionStage;	}	public java.util.Date getJudgmentDate() {	    return this.judgmentDate;	}	public void setJudgmentDate(java.util.Date judgmentDate) {	    this.judgmentDate=judgmentDate;	}	public java.lang.String getIsClose() {	    return this.isClose;	}	public void setIsClose(java.lang.String isClose) {	    this.isClose=isClose;	}
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