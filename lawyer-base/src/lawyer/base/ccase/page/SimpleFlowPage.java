package lawyer.base.ccase.page;

import com.base.page.BasePage;

/**
 * <b>功能：</b>SimpleFlowPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-06 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class SimpleFlowPage extends BasePage {
	private java.lang.Integer id;//   id	private java.lang.String title;//   流程标题	private java.lang.String note;//   流程说明	private java.lang.String ftype;//   流程业务类型	private java.util.Date createdTime;//   创建时间	private java.lang.String createdBy;//   发起人	private java.lang.String delFlag;//   删除标记 1删除 0正常	private java.lang.String status;//   状态（0草稿 1待审批 2审批通过 9驳回）	private java.lang.String remark;//   备注	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.String approver;//   审批人
	
	private java.lang.String createdName;
	private java.lang.String approverName;

	private java.lang.String fileAckImg;
	private java.lang.String bizAckImg;
	private java.lang.String ftypeName;
	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getTitle() {	    return this.title;	}	public void setTitle(java.lang.String title) {	    this.title=title;	}	public java.lang.String getNote() {	    return this.note;	}	public void setNote(java.lang.String note) {	    this.note=note;	}	public java.lang.String getFtype() {	    return this.ftype;	}	public void setFtype(java.lang.String ftype) {	    this.ftype=ftype;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.lang.String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(java.lang.String delFlag) {	    this.delFlag=delFlag;	}	public java.lang.String getStatus() {	    return this.status;	}	public void setStatus(java.lang.String status) {	    this.status=status;	}	public java.lang.String getRemark() {	    return this.remark;	}	public void setRemark(java.lang.String remark) {	    this.remark=remark;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.String getApprover() {	    return this.approver;	}	public void setApprover(java.lang.String approver) {	    this.approver=approver;	}
	public java.lang.String getCreatedName() {
		return createdName;
	}
	public void setCreatedName(java.lang.String createdName) {
		this.createdName = createdName;
	}
	public java.lang.String getApproverName() {
		return approverName;
	}
	public void setApproverName(java.lang.String approverName) {
		this.approverName = approverName;
	}
	public java.lang.String getFileAckImg() {
		return fileAckImg;
	}
	public void setFileAckImg(java.lang.String fileAckImg) {
		this.fileAckImg = fileAckImg;
	}
	public java.lang.String getBizAckImg() {
		return bizAckImg;
	}
	public void setBizAckImg(java.lang.String bizAckImg) {
		this.bizAckImg = bizAckImg;
	}
	public java.lang.String getFtypeName() {
		return ftypeName;
	}
	public void setFtypeName(java.lang.String ftypeName) {
		this.ftypeName = ftypeName;
	}
}