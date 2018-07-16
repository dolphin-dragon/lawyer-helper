package lawyer.base.ccase.entity;

import com.base.entity.BaseEntity;
/**
 * <b>功能：</b>SysUserExtEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2018-07-13 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class SysUserExt extends BaseEntity {
	
	
	
	private java.lang.Integer id;//用户ID
	private java.lang.String email;//用户注册使用的email
	
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
}