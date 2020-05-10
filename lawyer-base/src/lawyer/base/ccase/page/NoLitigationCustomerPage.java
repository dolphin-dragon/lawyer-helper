package lawyer.base.ccase.page;

import org.springframework.format.annotation.DateTimeFormat;

import com.base.page.BasePage;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <b>功能：</b>NoLitigationCustomerPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-10 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class NoLitigationCustomerPage extends BasePage {
	private java.lang.Integer status;//   状态	private java.lang.String delFlag;//   删除标记	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer id;//   客户ID	private java.lang.String client;//   委托人	private java.lang.String principal;//   被委托人
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date commissionSdate;//   委托开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")	private java.util.Date commissionEdate;//   委托结束时间	private java.lang.String billingModel;//   计费模式	private java.lang.String billingStandard;//   计费标准	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(java.lang.String delFlag) {	    this.delFlag=delFlag;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getClient() {	    return this.client;	}	public void setClient(java.lang.String client) {	    this.client=client;	}	public java.lang.String getPrincipal() {	    return this.principal;	}	public void setPrincipal(java.lang.String principal) {	    this.principal=principal;	}	public java.util.Date getCommissionSdate() {	    return this.commissionSdate;	}	public void setCommissionSdate(java.util.Date commissionSdate) {	    this.commissionSdate=commissionSdate;	}	public java.util.Date getCommissionEdate() {	    return this.commissionEdate;	}	public void setCommissionEdate(java.util.Date commissionEdate) {	    this.commissionEdate=commissionEdate;	}	public java.lang.String getBillingModel() {	    return this.billingModel;	}	public void setBillingModel(java.lang.String billingModel) {	    this.billingModel=billingModel;	}	public java.lang.String getBillingStandard() {	    return this.billingStandard;	}	public void setBillingStandard(java.lang.String billingStandard) {	    this.billingStandard=billingStandard;	}
}