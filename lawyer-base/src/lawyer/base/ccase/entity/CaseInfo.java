package lawyer.base.ccase.entity;

import com.base.entity.BaseEntity;
/**
 * <b>功能：</b>CaseInfoEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class CaseInfo extends BaseEntity {
	private java.lang.Integer status;//   状态	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer id;//   序号	private java.lang.String litigant;//   当事人	private java.lang.String defendantName;//   被告名称	private java.lang.String defendantRegCapital;//   被告注册资本	private java.lang.String defendantArea;//   被告所在地
	private java.lang.String delFlag;//   删除标记
	
	private java.lang.String createName;
	private java.lang.String updateName;	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getLitigant() {	    return this.litigant;	}	public void setLitigant(java.lang.String litigant) {	    this.litigant=litigant;	}	public java.lang.String getDefendantName() {	    return this.defendantName;	}	public void setDefendantName(java.lang.String defendantName) {	    this.defendantName=defendantName;	}	public java.lang.String getDefendantRegCapital() {	    return this.defendantRegCapital;	}	public void setDefendantRegCapital(java.lang.String defendantRegCapital) {	    this.defendantRegCapital=defendantRegCapital;	}	public java.lang.String getDefendantArea() {	    return this.defendantArea;	}	public void setDefendantArea(java.lang.String defendantArea) {	    this.defendantArea=defendantArea;	}
	public java.lang.String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(java.lang.String delFlag) {
		this.delFlag = delFlag;
	}
	public java.lang.String getCreateName() {
		return createName;
	}
	public void setCreateName(java.lang.String createName) {
		this.createName = createName;
	}
	public java.lang.String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(java.lang.String updateName) {
		this.updateName = updateName;
	}
}