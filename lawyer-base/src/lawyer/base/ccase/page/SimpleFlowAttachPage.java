package lawyer.base.ccase.page;

import com.base.page.BasePage;

/**
 * <b>功能：</b>SimpleFlowAttachPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-06 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class SimpleFlowAttachPage extends BasePage {
	private java.lang.Integer sflowId;//   流程id	private java.lang.Integer sfileAttachId;//   附件id
	
	private java.lang.String filename;//   文件名
	private java.lang.String filepath;//   文件路径
	private java.lang.String ext;//   扩展名
	private java.lang.String filetype;//   fileType
	private java.lang.String note;//   说明
	private java.lang.String size;//   文件大小
	private java.lang.String url;//   url请求地址	public java.lang.Integer getSflowId() {	    return this.sflowId;	}	public void setSflowId(java.lang.Integer sflowId) {	    this.sflowId=sflowId;	}	public java.lang.Integer getSfileAttachId() {	    return this.sfileAttachId;	}	public void setSfileAttachId(java.lang.Integer sfileAttachId) {	    this.sfileAttachId=sfileAttachId;	}
	public java.lang.String getFilename() {
		return filename;
	}
	public void setFilename(java.lang.String filename) {
		this.filename = filename;
	}
	public java.lang.String getFilepath() {
		return filepath;
	}
	public void setFilepath(java.lang.String filepath) {
		this.filepath = filepath;
	}
	public java.lang.String getExt() {
		return ext;
	}
	public void setExt(java.lang.String ext) {
		this.ext = ext;
	}
	public java.lang.String getFiletype() {
		return filetype;
	}
	public void setFiletype(java.lang.String filetype) {
		this.filetype = filetype;
	}
	public java.lang.String getNote() {
		return note;
	}
	public void setNote(java.lang.String note) {
		this.note = note;
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