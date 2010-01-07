package com.law.bean;

import java.util.Date;

/**
 * ˵����DocĿ¼��
 * 
 *
 */
public class DocCatalog {
	//Ŀ¼������
	private String type = "";
	//Ŀ¼��ʶ
	private String id = "";
	//Ŀ¼����
	private String name = "";
	//Ŀ¼ʹ�ô�С��������Ŀ¼�������ļ��Ĵ�С��
	private int usesize = 0;
	//Ŀ¼�Ĵ�����
	private String creator = "";
	//Ŀ¼����ʱ��
	private Date cdate = null;
	//Ŀ¼ɾ��ʱ��
	private Date edate = null;
	//��Ŀ¼��ʶ
	private String superCatalogID="";
	//Ŀ¼�洢�ռ����ʶ
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