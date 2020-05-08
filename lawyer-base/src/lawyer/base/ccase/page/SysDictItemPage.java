package lawyer.base.ccase.page;

import com.base.page.BasePage;

/**
 * <b>功能：</b>SysDictItemPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-06 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class SysDictItemPage extends BasePage {
		private java.lang.Integer id;//   字典项id	private java.lang.Integer dictId;//   字典id	private java.lang.String itemText;//   字典项文本	private java.lang.String itemValue;//   字典项值	private java.lang.String description;//   描述	private java.lang.Integer sortOrder;//   排序	private java.lang.Integer status;//   状态（1启用 0不启用）	private java.lang.String delFlag;//   删除标记 1删除 0正常	private java.lang.String createdBy;//   created_by	private java.util.Date createdTime;//   created_time	private java.lang.String updatedBy;//   updated_by	private java.util.Date updatedTime;//   updated_time
	
	private java.lang.String dictName;
	private java.lang.String dictCode;
	private java.lang.String dictDescription;
	private java.lang.String dictDelFlag;
		public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.Integer getDictId() {	    return this.dictId;	}	public void setDictId(java.lang.Integer dictId) {	    this.dictId=dictId;	}	public java.lang.String getItemText() {	    return this.itemText;	}	public void setItemText(java.lang.String itemText) {	    this.itemText=itemText;	}	public java.lang.String getItemValue() {	    return this.itemValue;	}	public void setItemValue(java.lang.String itemValue) {	    this.itemValue=itemValue;	}	public java.lang.String getDescription() {	    return this.description;	}	public void setDescription(java.lang.String description) {	    this.description=description;	}	public java.lang.Integer getSortOrder() {	    return this.sortOrder;	}	public void setSortOrder(java.lang.Integer sortOrder) {	    this.sortOrder=sortOrder;	}	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}	public java.lang.String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(java.lang.String delFlag) {	    this.delFlag=delFlag;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getUpdatedBy() {	    return this.updatedBy;	}	public void setUpdatedBy(java.lang.String updatedBy) {	    this.updatedBy=updatedBy;	}	public java.util.Date getUpdatedTime() {	    return this.updatedTime;	}	public void setUpdatedTime(java.util.Date updatedTime) {	    this.updatedTime=updatedTime;	}
	public java.lang.String getDictName() {
		return dictName;
	}
	public void setDictName(java.lang.String dictName) {
		this.dictName = dictName;
	}
	public java.lang.String getDictCode() {
		return dictCode;
	}
	public void setDictCode(java.lang.String dictCode) {
		this.dictCode = dictCode;
	}
	public java.lang.String getDictDescription() {
		return dictDescription;
	}
	public void setDictDescription(java.lang.String dictDescription) {
		this.dictDescription = dictDescription;
	}
	public java.lang.String getDictDelFlag() {
		return dictDelFlag;
	}
	public void setDictDelFlag(java.lang.String dictDelFlag) {
		this.dictDelFlag = dictDelFlag;
	}
}