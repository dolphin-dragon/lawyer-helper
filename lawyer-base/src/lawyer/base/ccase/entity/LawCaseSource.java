package lawyer.base.ccase.entity;

import com.base.entity.BaseEntity;
/**
 * <b>功能：</b>LawCaseSourceEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2018-07-16 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class LawCaseSource extends BaseEntity {
	
		private java.lang.Integer id;//   案源ID	private java.lang.String code;//   案源编码	private java.lang.String title;//   案源名称	private java.lang.String cDesc;//   案源描述	private java.util.Date recordDate;//   案源接收日期	private java.util.Date closeDate;//   结案日期	private java.util.Date receiveDate;//   回款日期	private java.lang.String mLawyer;//   主办律师	private java.lang.String provider;//   案源提供者	private java.lang.String status;//   处理状态	private java.lang.String createBy;//   创建者ID	private java.lang.String createName;//   创建人	private java.util.Date createDate;//   创建时间	private java.lang.String updateBy;//   修改人ID	private java.lang.String updateName;//   修改人	private java.util.Date updateDate;//   修改时间	private java.lang.String remarks;//   备注信息	private java.lang.String delFlag;//   删除标记	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getCode() {	    return this.code;	}	public void setCode(java.lang.String code) {	    this.code=code;	}	public java.lang.String getTitle() {	    return this.title;	}	public void setTitle(java.lang.String title) {	    this.title=title;	}	public java.lang.String getCDesc() {	    return this.cDesc;	}	public void setCDesc(java.lang.String cDesc) {	    this.cDesc=cDesc;	}	public java.util.Date getRecordDate() {	    return this.recordDate;	}	public void setRecordDate(java.util.Date recordDate) {	    this.recordDate=recordDate;	}	public java.util.Date getCloseDate() {	    return this.closeDate;	}	public void setCloseDate(java.util.Date closeDate) {	    this.closeDate=closeDate;	}	public java.util.Date getReceiveDate() {	    return this.receiveDate;	}	public void setReceiveDate(java.util.Date receiveDate) {	    this.receiveDate=receiveDate;	}	public java.lang.String getMLawyer() {	    return this.mLawyer;	}	public void setMLawyer(java.lang.String mLawyer) {	    this.mLawyer=mLawyer;	}	public java.lang.String getProvider() {	    return this.provider;	}	public void setProvider(java.lang.String provider) {	    this.provider=provider;	}	public java.lang.String getStatus() {	    return this.status;	}	public void setStatus(java.lang.String status) {	    this.status=status;	}	public java.lang.String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(java.lang.String createBy) {	    this.createBy=createBy;	}	public java.lang.String getCreateName() {	    return this.createName;	}	public void setCreateName(java.lang.String createName) {	    this.createName=createName;	}	public java.util.Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(java.util.Date createDate) {	    this.createDate=createDate;	}	public java.lang.String getUpdateBy() {	    return this.updateBy;	}	public void setUpdateBy(java.lang.String updateBy) {	    this.updateBy=updateBy;	}	public java.lang.String getUpdateName() {	    return this.updateName;	}	public void setUpdateName(java.lang.String updateName) {	    this.updateName=updateName;	}	public java.util.Date getUpdateDate() {	    return this.updateDate;	}	public void setUpdateDate(java.util.Date updateDate) {	    this.updateDate=updateDate;	}	public java.lang.String getRemarks() {	    return this.remarks;	}	public void setRemarks(java.lang.String remarks) {	    this.remarks=remarks;	}	public java.lang.String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(java.lang.String delFlag) {	    this.delFlag=delFlag;	}
}