package lawyer.base.ccase.entity;

import com.base.entity.BaseEntity;
/**
 * <b>功能：</b>SysFileAttachEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-06 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class SysFileAttach extends BaseEntity {
	private java.lang.Integer id;//   id	private java.lang.String filename;//   文件名	private java.lang.String filepath;//   文件路径	private java.lang.String ext;//   扩展名	private java.lang.String filetype;//   fileType
	private java.lang.String url;//   url请求地址	private java.lang.String note;//   说明	private java.util.Date createdTime;//   创建时间	private java.lang.String createdBy;//   上传者
	
	private java.lang.String size;//   文件大小
	private java.lang.String createdName;//   上传者名称
	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getFilename() {	    return this.filename;	}	public void setFilename(java.lang.String filename) {	    this.filename=filename;	}	public java.lang.String getFilepath() {	    return this.filepath;	}	public void setFilepath(java.lang.String filepath) {	    this.filepath=filepath;	}	public java.lang.String getExt() {	    return this.ext;	}	public void setExt(java.lang.String ext) {	    this.ext=ext;	}	public java.lang.String getFiletype() {	    return this.filetype;	}	public void setFiletype(java.lang.String filetype) {	    this.filetype=filetype;	}	public java.lang.String getNote() {	    return this.note;	}	public void setNote(java.lang.String note) {	    this.note=note;	}	public java.util.Date getCreatedTime() {	    return this.createdTime;	}	public void setCreatedTime(java.util.Date createdTime) {	    this.createdTime=createdTime;	}	public java.lang.String getCreatedBy() {	    return this.createdBy;	}	public void setCreatedBy(java.lang.String createdBy) {	    this.createdBy=createdBy;	}
	public java.lang.String getCreatedName() {
		return createdName;
	}
	public void setCreatedName(java.lang.String createdName) {
		this.createdName = createdName;
	}
	public java.lang.String getSize() {
		return size;
	}
	public void setSize(java.lang.String size) {
		this.size = size;
	}
	public java.lang.String getUrl() {
		return url;
	}
	public void setUrl(java.lang.String url) {
		this.url = url;
	}
}