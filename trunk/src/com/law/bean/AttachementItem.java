package com.law.bean;
/**
 * ˵����������Ŀ�࣬�Ը����е�ÿ�����м�¼
 *
 */
public class AttachementItem {
	//������Ŀ���ļ���ʶ
	private String docID= "";
	//������Ŀ���ļ�����
	private String docDesc = "";
	//������Ŀ�����
	private Integer index= null;
	//���������������ʶ
	private String subjectID="";
	//�����ļ������ƣ�Ŀǰ��¼�ļ���ȫ����
	private String fileName ="";
	//�����ļ��Ĵ�С
	private int fileSize = 0;
	//�����ļ����ļ����ͣ���Ҫ���ļ��ĺ�׺����
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