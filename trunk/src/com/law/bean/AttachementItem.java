package com.law.bean;
/**
 * 说明：附件条目类，对附件中的每条进行记录
 *
 */
public class AttachementItem {
	//附件条目的文件标识
	private String docID= "";
	//附件条目的文件描述
	private String docDesc = "";
	//附件条目的序号
	private Integer index= null;
	//附件依赖的主体标识
	private String subjectID="";
	//附件文件的名称，目前记录文件的全名称
	private String fileName ="";
	//附件文件的大小
	private int fileSize = 0;
	//附件文件的文件类型，主要是文件的后缀名称
	private String fileType="";
	
	public AttachementItem(String subject,String docid) {
		subjectID = subject;
		docID = docid;
		index = Integer.valueOf(0);
	}

	public String getDocDesc() {
		return docDesc;
	}

	public void setDocDesc(String docDesc) {
		this.docDesc = docDesc;
	}

	public String getDocID() {
		return docID;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}