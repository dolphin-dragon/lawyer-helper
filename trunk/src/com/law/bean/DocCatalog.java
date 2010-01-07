package com.law.bean;

import java.util.Date;

/**
 * 说明：Doc目录类
 * 
 *
 */
public class DocCatalog {
	//目录的类型
	private String type = "";
	//目录标识
	private String id = "";
	//目录名称
	private String name = "";
	//目录使用大小，包括本目录下所有文件的大小和
	private int usesize = 0;
	//目录的创建者
	private String creator = "";
	//目录创建时间
	private Date cdate = null;
	//目录删除时间
	private Date edate = null;
	//父目录标识
	private String superCatalogID="";
	//目录存储空间组标识
	private String spaceid="";

	public DocCatalog(String catalogID,String catalogName) {
		id = catalogID;
		name = catalogName;
	}
	
	public DocCatalog(String superCataID,String catalogID,String catalogName) {
		superCatalogID = superCataID;
		id = catalogID;
		name = catalogName;
	}
	
	public DocCatalog(String superCataID,String catalogID,String catalogName,String spaceID) {
		superCatalogID = superCataID;
		id = catalogID;
		name = catalogName;
		spaceid = spaceID;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUsesize() {
		return usesize;
	}
	public void setUsesize(int usesize) {
		this.usesize = usesize;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getId() {
		return id;
	}
	public String getSuperCatalogID() {
		return superCatalogID;
	}

	public String getSpaceid() {
		return spaceid;
	}
	
	

	public void setSuperCatalogID(String superCatalogID) {
		this.superCatalogID = superCatalogID;
	}

	public void setSpaceid(String spaceid) {
		this.spaceid = spaceid;
	}	
}