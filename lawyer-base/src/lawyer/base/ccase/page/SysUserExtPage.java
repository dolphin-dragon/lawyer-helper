package lawyer.base.ccase.page;

import com.base.page.BasePage;

/**
 * <b>功能：</b>SysUserExtPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2018-07-13 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class SysUserExtPage extends BasePage {
		private java.lang.Integer uid;//   关联用户ID	private java.lang.String phone;//   手机号码	private java.lang.String tel;//   联系电话	private java.lang.String qq;//   QQ号码	private java.lang.String position;//   职位类别	private java.util.Date birt;//   出生日期	private java.util.Date entrydate;//   入职时间	private java.lang.String createBy;//   创建者	private java.util.Date createDate;//   创建时间	private java.lang.String updateBy;//   更新者	private java.util.Date updateDate;//   更新时间	private java.lang.String remarks;//   备注信息	private java.lang.String delFlag;//   删除标记
	
	private java.lang.Integer id;//用户ID
	private java.lang.String email;//用户注册使用的email
		public java.lang.Integer getUid() {	    return this.uid;	}	public void setUid(java.lang.Integer uid) {	    this.uid=uid;	}	public java.lang.String getPhone() {	    return this.phone;	}	public void setPhone(java.lang.String phone) {	    this.phone=phone;	}	public java.lang.String getTel() {	    return this.tel;	}	public void setTel(java.lang.String tel) {	    this.tel=tel;	}	public java.lang.String getQq() {	    return this.qq;	}	public void setQq(java.lang.String qq) {	    this.qq=qq;	}	public java.lang.String getPosition() {	    return this.position;	}	public void setPosition(java.lang.String position) {	    this.position=position;	}	public java.util.Date getBirt() {	    return this.birt;	}	public void setBirt(java.util.Date birt) {	    this.birt=birt;	}	public java.util.Date getEntrydate() {	    return this.entrydate;	}	public void setEntrydate(java.util.Date entrydate) {	    this.entrydate=entrydate;	}	public java.lang.String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(java.lang.String createBy) {	    this.createBy=createBy;	}	public java.util.Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(java.util.Date createDate) {	    this.createDate=createDate;	}	public java.lang.String getUpdateBy() {	    return this.updateBy;	}	public void setUpdateBy(java.lang.String updateBy) {	    this.updateBy=updateBy;	}	public java.util.Date getUpdateDate() {	    return this.updateDate;	}	public void setUpdateDate(java.util.Date updateDate) {	    this.updateDate=updateDate;	}	public java.lang.String getRemarks() {	    return this.remarks;	}	public void setRemarks(java.lang.String remarks) {	    this.remarks=remarks;	}	public java.lang.String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(java.lang.String delFlag) {	    this.delFlag=delFlag;	}
}