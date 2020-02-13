package lawyer.base.ccase.entity;

import com.base.entity.BaseEntity;
/**
 * <b>功能：</b>CaseApplyEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class CaseApply extends BaseEntity {
	private java.lang.Integer status;//   状态
	
	private java.lang.String litigant;//   当事人
	private java.lang.String defendantName;//   被告名称
	private java.lang.String defendantRegCapital;//   被告注册资本
	private java.lang.String defendantArea;//   被告所在地
	private java.lang.String delFlag;//   删除标记

	public java.lang.String getLitigant() {
		return litigant;
	}
	public void setLitigant(java.lang.String litigant) {
		this.litigant = litigant;
	}
	public java.lang.String getDefendantName() {
		return defendantName;
	}
	public void setDefendantName(java.lang.String defendantName) {
		this.defendantName = defendantName;
	}
	public java.lang.String getDefendantRegCapital() {
		return defendantRegCapital;
	}
	public void setDefendantRegCapital(java.lang.String defendantRegCapital) {
		this.defendantRegCapital = defendantRegCapital;
	}
	public java.lang.String getDefendantArea() {
		return defendantArea;
	}
	public void setDefendantArea(java.lang.String defendantArea) {
		this.defendantArea = defendantArea;
	}
	public java.lang.String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(java.lang.String delFlag) {
		this.delFlag = delFlag;
	}
}