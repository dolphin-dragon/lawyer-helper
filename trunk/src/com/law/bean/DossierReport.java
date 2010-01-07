package com.law.bean;

import java.util.Date;
import java.util.List;
/**
 * ˵��������������
 *
 */
public class DossierReport {
	//�����ʶ
	private String reportID="";
	//������ʶ
	private String dossierID="";
	//�����׶�
	private String stage = "";
	//��������
	private Date reportDate = null;
	//������
	private String reportor = "";
	//�������
	private String title="";
	//��������
	private String content = "";
	
	//������ʹ�õ��ĸ����б���Ҫ��¼������ID��
	private List<String> attachements=null;
	
	public DossierReport(String reportid) {
		reportID = reportid;
	}

	public String getDossierID() {
		return dossierID;
	}

	public void setDossierID(String dossierID) {
		this.dossierID = dossierID;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportor() {
		return reportor;
	}

	public void setReportor(String reportor) {
		this.reportor = reportor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getAttachements() {
		return attachements;
	}

	public void setAttachements(List<String> attachements) {
		this.attachements = attachements;
	}

	public String getReportID() {
		return reportID;
	}	
}
