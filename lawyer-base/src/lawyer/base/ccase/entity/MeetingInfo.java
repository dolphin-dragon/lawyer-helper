package lawyer.base.ccase.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * <b>功能：</b>MeetingInfoEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-12-27 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class MeetingInfo extends BaseEntity {
	private java.lang.Integer status;//   状态	private java.lang.String delFlag;//   删除标记	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer id;//   序号	private java.lang.String mtName;//   会议名称	private java.lang.String mtSponsor;//   会议发起人	private java.lang.String mtMembers;//   会议参会人列表	private java.lang.String mtTopics;//   会议议题	private java.lang.Integer mtrId;//   会议室
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")	private java.util.Date mtStartTime;//   会议预定开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")	private java.util.Date mtEndTime;//   会议预定结束时间	private java.lang.String mtResolution;//   会议决议内容
	
	private java.util.List<SysUserExt> members;//会议参会人列表,根据mtMembers进行数据处理
	
	private java.lang.String mtSponsorName;
	private java.lang.String mtrName;
		public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(java.lang.String delFlag) {	    this.delFlag=delFlag;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getMtName() {	    return this.mtName;	}	public void setMtName(java.lang.String mtName) {	    this.mtName=mtName;	}	public java.lang.String getMtSponsor() {	    return this.mtSponsor;	}	public void setMtSponsor(java.lang.String mtSponsor) {	    this.mtSponsor=mtSponsor;	}	public java.lang.String getMtMembers() {	    return this.mtMembers;	}	public void setMtMembers(java.lang.String mtMembers) {	    this.mtMembers=mtMembers;	}	public java.lang.String getMtTopics() {	    return this.mtTopics;	}	public void setMtTopics(java.lang.String mtTopics) {	    this.mtTopics=mtTopics;	}	public java.lang.Integer getMtrId() {	    return this.mtrId;	}	public void setMtrId(java.lang.Integer mtrId) {	    this.mtrId=mtrId;	}	public java.util.Date getMtStartTime() {	    return this.mtStartTime;	}	public void setMtStartTime(java.util.Date mtStartTime) {	    this.mtStartTime=mtStartTime;	}	public java.util.Date getMtEndTime() {	    return this.mtEndTime;	}	public void setMtEndTime(java.util.Date mtEndTime) {	    this.mtEndTime=mtEndTime;	}	public java.lang.String getMtResolution() {	    return this.mtResolution;	}	public void setMtResolution(java.lang.String mtResolution) {	    this.mtResolution=mtResolution;	}
	public java.util.List<SysUserExt> getMembers() {
		return members;
	}
	public void setMembers(java.util.List<SysUserExt> members) {
		this.members = members;
	}
	public java.lang.String getMtSponsorName() {
		return mtSponsorName;
	}
	public void setMtSponsorName(java.lang.String mtSponsorName) {
		this.mtSponsorName = mtSponsorName;
	}
	public java.lang.String getMtrName() {
		return mtrName;
	}
	public void setMtrName(java.lang.String mtrName) {
		this.mtrName = mtrName;
	}
}