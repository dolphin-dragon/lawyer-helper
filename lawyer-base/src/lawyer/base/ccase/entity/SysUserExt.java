package lawyer.base.ccase.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * <b>功能：</b>SysUserExtEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class SysUserExt extends BaseEntity {
	private java.lang.Integer status;//   状态	private java.lang.String org;//   机构编码	private java.lang.String createdBy;//   创建人	private java.util.Date createdTime;//   创建时间	private java.lang.String updatedBy;//   更新人	private java.util.Date updatedTime;//   更新时间	private java.lang.Integer uid;//   用户id	private java.lang.String name;//   姓名	private java.lang.String sex;//   性别	private java.lang.String phone;//   手机号	private java.lang.String tel;//   联系电话	private java.lang.String qq;//   qq号码	private java.lang.String position;//   职位类别
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date entryDate;//   入职时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")	private java.util.Date birt;//   出生日期	private java.lang.String remark;//   备注	private java.lang.String delFlag;//   删除标记
	
	private java.lang.String email;
	private java.lang.String findPwdUrl;
	private java.lang.String findPwdCode;
	private java.lang.String pwd;
		public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getOrg() {	    return this.org;	}	public void setOrg(java.lang.String org) {	    this.org=org;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}	public java.lang.Integer getUid() {	    return this.uid;	}	public void setUid(java.lang.Integer uid) {	    this.uid=uid;	}	public java.lang.String getName() {	    return this.name;	}	public void setName(java.lang.String name) {	    this.name=name;	}	public java.lang.String getSex() {	    return this.sex;	}	public void setSex(java.lang.String sex) {	    this.sex=sex;	}	public java.lang.String getPhone() {	    return this.phone;	}	public void setPhone(java.lang.String phone) {	    this.phone=phone;	}	public java.lang.String getTel() {	    return this.tel;	}	public void setTel(java.lang.String tel) {	    this.tel=tel;	}	public java.lang.String getQq() {	    return this.qq;	}	public void setQq(java.lang.String qq) {	    this.qq=qq;	}	public java.lang.String getPosition() {	    return this.position;	}	public void setPosition(java.lang.String position) {	    this.position=position;	}	public java.util.Date getEntryDate() {	    return this.entryDate;	}	public void setEntryDate(java.util.Date entryDate) {	    this.entryDate=entryDate;	}	public java.util.Date getBirt() {	    return this.birt;	}	public void setBirt(java.util.Date birt) {	    this.birt=birt;	}	public java.lang.String getRemark() {	    return this.remark;	}	public void setRemark(java.lang.String remark) {	    this.remark=remark;	}	public java.lang.String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(java.lang.String delFlag) {
		this.delFlag = delFlag;
	}
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	public java.lang.String getFindPwdUrl() {
		return findPwdUrl;
	}
	public void setFindPwdUrl(java.lang.String findPwdUrl) {
		this.findPwdUrl = findPwdUrl;
	}
	public java.lang.String getFindPwdCode() {
		return findPwdCode;
	}
	public void setFindPwdCode(java.lang.String findPwdCode) {
		this.findPwdCode = findPwdCode;
	}
	public java.lang.String getPwd() {
		return pwd;
	}
	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}
}