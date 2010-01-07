package com.law.bean;

import java.util.Date;

/**
 * ˵�����ĵ�����������һ���ĵ����л���������
 *
 */
public class Doc {
	//�ĵ���ʶ
	private String ID="";
	//�ĵ�����
	private String name = "";
	//�ĵ��Ķ�����
	private String sname = "";
	//�ĵ����������ĵ��ı�ע
	private String remarks = "";
	//�ĵ��ļ�����
	private String fileName = "";
	//�ĵ������ͣ���Ҫ�����ĵ�Ӧ�����ͣ�һ�������ͨ�ĵ��������ĵ���ϵͳ����
	private String type = "";
	//�ĵ�������
	private Object content = null;
	//�ĵ��Ĵ�С
	private int size = 0;
	//�ĵ��洢��Ŀ¼��ʶ	
	private String catalogID="";
	//�ĵ��洢�Ŀռ��ʶ
	private String spaceID = "";
	//�ĵ�������	
	private String creator="";
	//�ĵ�·��
	private String filePath = "";
	//�ĵ���׺
	private String suffix = "";
	//�ĵ��ļ�����
	private String fileType = "";
	//�ĵ��ɼ��ԣ��ĵ��ɼ���һ����˽�С����Ź���ϵͳ��������
	private String visible = "";
	//�����ĵ�����
	private Date cdate = null;
	//�ĵ��༭��ʶ
	private String modify="";
	//�ĵ��༭ʱ��
	private Date mdate = null;
	//ϵͳ��ʶ
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