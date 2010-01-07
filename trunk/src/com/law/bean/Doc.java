package com.law.bean;

import java.util.Date;

/**
 * 说明：文档类描述，对一个文档进行基本的描述
 *
 */
public class Doc {
	//文档标识
	private String ID="";
	//文档名称
	private String name = "";
	//文档的短名称
	private String sname = "";
	//文档的描述，文档的备注
	private String remarks = "";
	//文档文件名称
	private String fileName = "";
	//文档的类型，主要标明文的应用类型，一般包括普通文档、附件文档、系统公文
	private String type = "";
	//文档的内容
	private Object content = null;
	//文档的大小
	private int size = 0;
	//文档存储的目录标识	
	private String catalogID="";
	//文档存储的空间标识
	private String spaceID = "";
	//文档创建者	
	private String creator="";
	//文档路径
	private String filePath = "";
	//文档后缀
	private String suffix = "";
	//文档文件类型
	private String fileType = "";
	//文档可见性，文档可见性一般有私有、部门共享、系统共享三类
	private String visible = "";
	//创建文档日期
	private Date cdate = null;
	//文档编辑标识
	private String modify="";
	//文档编辑时间
	private Date mdate = null;
	//系统标识
	private String sysid= "";
	
	public Doc(String system,String id, String name){
		this.sysid = system;
		this.ID = id;
		this.name = name;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}
	public String getCatalogID() {
		return catalogID;
	}

	public void setCatalogID(String catalogID) {
		this.catalogID = catalogID;
	}

	public String getSpaceID() {
		return spaceID;
	}

	public void setSpaceID(String spaceID) {
		this.spaceID = spaceID;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getModify() {
		return modify;
	}

	public void setModify(String modify) {
		this.modify = modify;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public String getSysid() {
		return sysid;
	}	
}